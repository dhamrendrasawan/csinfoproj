package genweb.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import genweb.model.AfterLoginForm;
import genweb.model.ViewCenterForm;

@Service
public interface ViewCenterService {

	public String getCenterDetails(AfterLoginForm afterLoginForm,HttpServletRequest request,HttpServletResponse response,HttpSession session,BindingResult result);
	
	public String editCenterDetail(AfterLoginForm afterLoginForm,HttpServletRequest request,HttpServletResponse response,HttpSession session,BindingResult result);
	
	public String deleteCenter(AfterLoginForm afterLoginForm,HttpServletRequest request,HttpServletResponse response,HttpSession session,BindingResult result);
}
