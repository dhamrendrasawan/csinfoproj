package genweb.serviceImpl;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import genweb.domain.CenterTable;
import genweb.model.AfterLoginForm;
import genweb.service.AddCenterService;
import genweb.springdatajpa.CenterTableSpringDataJpa;

@Service("addCenterServiceImpl")
public class AddCenterServiceImpl implements AddCenterService {

	@Autowired
	CenterTableSpringDataJpa centerTableSpringDataJpa;
	
	@Override
	public String addUser(AfterLoginForm afterLoginForm,HttpSession session,HttpServletRequest request,HttpServletResponse response,BindingResult result)
	{
		 String flag1="N";
		try
		{
		   CenterTable centerTable=new CenterTable();	
		   centerTable.setAreaCode(new BigDecimal(afterLoginForm.getCenterCode()));		 
		   centerTable.setCenterName(afterLoginForm.getCenterName());
		    centerTableSpringDataJpa.save(centerTable);
		   System.out.println("center="+afterLoginForm.getCenterName()+"code="+afterLoginForm.getCenterCode());
		   flag1="Y";
		   String flag="N";
		   afterLoginForm.setFlag1(flag1);
		   afterLoginForm.setFlag(flag);
		   return "AfterLogin/HomePage";
		   
		}catch(Exception e)
		{    
			flag1="N";
			e.printStackTrace();
			result.rejectValue("Exception", "Exception","Error in insertion");
			return "AfterLogin/HomePage";
		}
	}
}
