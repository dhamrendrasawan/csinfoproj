package genweb.Controller;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import genweb.model.AfterLoginForm;
import genweb.model.UserLoginForm;


@SessionAttributes({"userLoginForm","afterLoginForm"})
@Controller
public class LoginController {
	
	String flag="N";
	
	@RequestMapping("/welcome.sawan")
	public String welcome(@ModelAttribute("userLoginForm") UserLoginForm userLoginForm) {
		System.out.println("HIII");
		//ModelMap model=new ModelMap();
		//model.addAttribute("msg123", "shyamsundart");
		return "LoginPage";
	}	
	@RequestMapping(value="/login.sawan",method=RequestMethod.POST)
	public String login(@ModelAttribute("userLoginForm") UserLoginForm userLoginForm,BindingResult result,HttpSession session)
	{
		 
		
	    	String userId=userLoginForm.getUserId();
		    String password=userLoginForm.getPassword();

		    session.setAttribute("user",userLoginForm.getUserId());
		    String username="Admin";
		    String passwd="12345";
		   if(username.equalsIgnoreCase(userId) && passwd.equalsIgnoreCase(password))
		   {
			   return "AfterLogin/HomePage";
		   }
		   else
		   {
			   if(!username.equalsIgnoreCase(userId))
			   {
				   String errMsg="UserID is incorrect";
				   result.rejectValue("userId", "userId",errMsg);
					return "LoginPage";
			   }
			   else
			   {
				   String errMsg="Password is incorrect";
				   result.rejectValue("password", "password",errMsg);
					return "LoginPage";
			   }			  
			  		   
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
