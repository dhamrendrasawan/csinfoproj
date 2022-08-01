package genweb.Controller;

import java.math.BigDecimal;

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

import genweb.domain.CenterTable;
import genweb.model.AfterLoginForm;
import genweb.model.UserLoginForm;
import genweb.model.ViewCenterForm;
import genweb.service.AddCenterService;

@SessionAttributes({"afterLoginForm","userLoginForm"})
@Controller
public class AddCenterController {
	
	@Autowired
	AddCenterService addCenterService;

	
	
	String flag="N";
	 String flag1="N";
	@RequestMapping(value="addCenter.sawan",method=RequestMethod.POST)
	String addCenter(@ModelAttribute("afterLoginForm") AfterLoginForm  afterLoginForm)	{
		
		  flag="Y";
		  flag1="N";
		  afterLoginForm.setFlag1(flag1);
		  afterLoginForm.setFlag(flag);
		  return "AfterLogin/HomePage";
	}
	
	@RequestMapping(value="createCenter.sawan",method=RequestMethod.POST)
	String createCenter(@ModelAttribute("afterLoginForm") AfterLoginForm  afterLoginForm,HttpServletRequest request,HttpServletResponse response,
			HttpSession session,BindingResult result)
	   {		
			
		try
		{
			return addCenterService.addUser(afterLoginForm, session, request, response,result);
			
		}catch(Exception e)
		{
			e.printStackTrace();
			result.rejectValue("Exception","Exception",e.getMessage());
			return "AfterLogin/HomePage";
		}   		
		 
	  }
	
	@ModelAttribute("afterLoginForm")
	AfterLoginForm afterLoginForm()
	{
		return new AfterLoginForm();
	}
	
	@ModelAttribute("userLoginForm")
	UserLoginForm userLoginForm()
	{
		return new UserLoginForm();
	}
	
}
