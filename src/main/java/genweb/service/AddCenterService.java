package genweb.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import genweb.model.AfterLoginForm;

@Service
public interface AddCenterService {

	public String addUser(AfterLoginForm afterLoginForm,HttpSession session,HttpServletRequest request,HttpServletResponse response,BindingResult result);
}
