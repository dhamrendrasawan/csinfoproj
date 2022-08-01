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
import genweb.model.ViewCenterUserForm;
import genweb.service.UserService;

@SessionAttributes({"afterLoginForm","viewCenterUserForm"})
@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="viewCenter_User.sawan",method=RequestMethod.POST)
	String viewCenter_User(@RequestParam("areaCode") String areaCode, @ModelAttribute("viewCenterUserForm") ViewCenterUserForm viewCenterUserForm,
			HttpServletRequest request,HttpServletResponse response,HttpSession session,BindingResult result)
	{
		System.out.println("view user"+"areaCode="+areaCode);
		 String flag1="N";	
		 viewCenterUserForm.setFlag1(flag1);
		return userService.viewCenterUser(areaCode,viewCenterUserForm,request,response,session,result);
		
	}
	
	@RequestMapping(value="createUser",method=RequestMethod.POST)
	String createUser(@RequestParam("areaCode") String areaCode, @ModelAttribute("viewCenterUserForm") ViewCenterUserForm viewCenterUserForm,
			HttpServletRequest request,HttpServletResponse response,HttpSession session,BindingResult result)
	{
		  String flag1="Y";	
		  String flag2="N";
		  viewCenterUserForm.setFlag2(flag2);
		  String name=viewCenterUserForm.getName();			  
		  viewCenterUserForm.setCenterCode(areaCode);
		  viewCenterUserForm.setFlag1(flag1);
		  return "AfterLogin/ViewCenter_User"; 	
	}
	
	@RequestMapping(value="saveUser.sawan",method=RequestMethod.POST)
	String createUserSave(@RequestParam("areaCode") String areaCode, @ModelAttribute("viewCenterUserForm") ViewCenterUserForm viewCenterUserForm,
			HttpServletRequest request,HttpServletResponse response,HttpSession session,BindingResult result)
	{
		  try
		  {
		     viewCenterUserForm.setCenterCode(areaCode);
		    return userService.createUserDetails(areaCode, viewCenterUserForm, request, response, session, result);
		  }catch(Exception e)
		  {
			  e.printStackTrace();
			  result.rejectValue("Exception","Exception",e.getMessage());
			  return "AfterLogin/ViewCenter_User"; 
		  }		   
		   	
	}
	
	@RequestMapping(value="viewUserDetails.sawan",method=RequestMethod.POST)
	String viewUserDetails(@RequestParam("areaCode") String areaCode, @ModelAttribute("viewCenterUserForm") ViewCenterUserForm viewCenterUserForm,
			HttpServletRequest request,HttpServletResponse response,HttpSession session,BindingResult result)
	{
		try
		{
		   String flag2="Y";
		   String flag1="N";	
		   viewCenterUserForm.setFlag1(flag1);
		   viewCenterUserForm.setFlag2(flag2);
		   System.out.println("UserDetails");
		 
		   return userService.getUserDetails(areaCode, viewCenterUserForm, request, response, session, result);
		   
		}catch(Exception e)
		{
			e.printStackTrace();
			result.rejectValue("Exception", "Exception",e.getMessage());
			return "AfterLogin/ViewCenter_User";
		}
		 
	}
	@ModelAttribute("afterLoginForm")
	public AfterLoginForm afterLoginForm(HttpServletRequest request)
	{
		return new AfterLoginForm();
	}
	
	@ModelAttribute("viewCenterUserForm")
	public ViewCenterUserForm viewCenterUserForm(HttpServletRequest request)
	{
		return new ViewCenterUserForm();
	}
}
