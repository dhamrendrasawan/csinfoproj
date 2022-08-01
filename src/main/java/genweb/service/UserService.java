package genweb.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import genweb.model.ViewCenterUserForm;

@Service
public interface UserService {

	public String viewCenterUser(String areaCode,ViewCenterUserForm viewCenterUserForm,HttpServletRequest request,HttpServletResponse response,HttpSession session,BindingResult result);
	
	public String createUserDetails(String areaCode,ViewCenterUserForm viewCenterUserForm,HttpServletRequest request,HttpServletResponse response,HttpSession session,BindingResult result);
	
	public String getUserDetails(String areaCode,ViewCenterUserForm viewCenterUserForm,HttpServletRequest request,HttpServletResponse response,HttpSession session,BindingResult result);
	
}
