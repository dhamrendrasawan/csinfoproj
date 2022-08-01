package genweb.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import genweb.model.AfterLoginForm;
import genweb.model.ViewCenterForm;
import genweb.model.ViewCenterUserForm;
import genweb.service.ViewCenterService;

@SessionAttributes({"afterLoginForm","viewCenterUserForm"})
@Controller
public class ViewCenterController {

	@Autowired
	AfterLoginForm afterLoginForm;
	@Autowired
	ViewCenterService viewCenterService;
	@Autowired 
	ViewCenterUserForm viewCenterUserForm;
	
	@RequestMapping(value="/viewCenter.sawan",method=RequestMethod.POST)
	String viewCenter(@ModelAttribute("afterLoginForm") AfterLoginForm afterLoginForm,HttpServletRequest request,HttpServletResponse response,HttpSession session,BindingResult result)
	{
		try
		{

		  System.out.print("view controller");
		  return viewCenterService.getCenterDetails(afterLoginForm, request, response, session,result);
		  
		}catch(Exception e)
		{
			e.printStackTrace();
			result.rejectValue("Exception", "Exception",e.getMessage());
			return "LoginPage";
		}
		
		
	}
	
	@RequestMapping(value="editCenter.sawan",method=RequestMethod.POST)
	String editCenter(@RequestParam("areaCode") String areaCode,@ModelAttribute("afterLoginForm") AfterLoginForm  afterLoginForm)	{
		
		     afterLoginForm.setFlag4("N");
	    	afterLoginForm.setCenterCode(areaCode);
	    	//return "AfterLogin/HomePage";
		   return "AfterLogin/EditPage";
	}
	
	
	@RequestMapping(value="updateCenter.sawan",method=RequestMethod.POST)
	public String editCenter(@RequestParam("areaCode") String areaCode,@ModelAttribute("afterLoginForm") AfterLoginForm afterLoginForm,HttpServletRequest request,HttpServletResponse response,HttpSession session,BindingResult result)
	{
		
		 try
		 {
			 System.out.println("edit center"+areaCode);
			 //String centerName=viewCenterForm.getCenterName();
			 String centerName=request.getParameter("centerName");
			 System.out.println("inputed Center name="+centerName);
			 
			 afterLoginForm.setCenterCode(areaCode);
			 afterLoginForm.setFlag4("Y");
			 viewCenterService.editCenterDetail(afterLoginForm, request, response, session, result);
			// return viewCenterService.getCenterDetails(afterLoginForm, request, response, session,result);
			 return "AfterLogin/EditPage";
			// return "AfterLogin/HomePage";
			 
		 }catch(Exception e)
		 {
			 e.printStackTrace();
			 result.rejectValue("Exception", "Exception",e.getMessage());
			 return "AfterLogin/HomePage";
		 }
	}
	@RequestMapping(value="deleteCenter.sawan",method=RequestMethod.POST)
	String deleteCenter(@RequestParam("areaCode") String areaCode,@ModelAttribute("afterLoginForm") AfterLoginForm afterLoginForm,HttpServletRequest request,HttpServletResponse response,HttpSession session,BindingResult result)
	{
		System.out.println("areacode="+areaCode);
		afterLoginForm.setCenterCode(areaCode);
		 viewCenterService.deleteCenter(afterLoginForm, request, response, session, result);
		return viewCenterService.getCenterDetails(afterLoginForm, request, response, session,result);
	}
	
	@ModelAttribute("viewCenterUserForm")
	public ViewCenterUserForm viewCenterUserForm(HttpServletRequest request)
	{
		return new ViewCenterUserForm();
	}
	
	@ModelAttribute("afterLoginForm")
	public AfterLoginForm afterLoginForm(HttpServletRequest request)
	{
		return new AfterLoginForm();
	}
}
