package genweb.serviceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import genweb.model.AfterLoginForm;
import genweb.model.ViewCenterForm;
import genweb.service.ViewCenterService;
import genweb.springdatajpa.CenterTableSpringDataJpa;

@Service("viewCenterServiceImpl")
public class ViewCenterServiceImpl implements ViewCenterService
{
	@Autowired
	CenterTableSpringDataJpa centerTableSpringDataJpa;
	
	@Override
	public String getCenterDetails(AfterLoginForm afterLoginForm,HttpServletRequest request,HttpServletResponse response,HttpSession session,BindingResult result)
	{
		
		try
		{
		     
	     	 System.out.println("services");
		     List<Object[]> list=centerTableSpringDataJpa.getCenterDetails();
		     
		     List<ViewCenterForm> datalist=new ArrayList<ViewCenterForm>();
		     
		    if(!list.isEmpty()) 
		    {
			   for(Object[] value:list)
			   {
				   ViewCenterForm viewCenterForm1=new ViewCenterForm();   
				   
				   if(value[0]==null || value[0].equals(""))
				   {
					   viewCenterForm1.setCenterCode("");  
				   }
				   else
				   {
			          String areaCode=value[0].toString();
			          viewCenterForm1.setCenterCode(areaCode);
				   }
				   if(value[1]==null || value[1].equals(""))
				   {
					  
				       viewCenterForm1.setCenterName("");
					   
				   } 
				   else
				   {
					   String centerName=value[1].toString();
				       viewCenterForm1.setCenterName(centerName);
					   
				   }
				    viewCenterForm1.setViewCenter("View");
			        viewCenterForm1.setEdit("Edit");
			        viewCenterForm1.setDelete("Delete");
			        datalist.add(viewCenterForm1);
			     
			         //System.out.println("areaCode="+areaCode+"centerName "+centerName+" "+viewCenterForm.getViewCenter()+" "+viewCenterForm.getEdit()+" "+viewCenterForm.getDelete());
			    }
			   afterLoginForm.setFlag2("Y");
			  
		    }
		   
		    else
		    {
		    	System.out.println("no record");
		    	afterLoginForm.setFlag2("N");
		    }
		    afterLoginForm.setDatalist(datalist); 
		    //afterLoginForm.setFlag1("N");
		    
		}catch(Exception e)
		{
			e.printStackTrace();
			result.rejectValue("Exception", "Exception",e.getMessage());
			return "LoginPage";
		}
		
	     return "AfterLogin/HomePage";
	}

	@Override
	public String editCenterDetail(AfterLoginForm afterLoginForm,HttpServletRequest request,HttpServletResponse response,HttpSession session,BindingResult result)
	{
		int count=0;
		String flag4="N";
		try
		{
			String centerCode=afterLoginForm.getCenterCode();
			String centerName=afterLoginForm.getCenterName();
			centerTableSpringDataJpa.updateCenterName(new BigDecimal(centerCode),centerName);
			System.out.println("updated");
			count++;
			if(count>0)
			{
				flag4="Y";
			}
			afterLoginForm.setFlag4(flag4);
			return "AfterLogin/EditPage";
			
		}catch(Exception e)
		{
			e.printStackTrace();
			result.rejectValue("Exception","Exception",e.getMessage());
			return "AfterLogin/HomePage";
		}
		
	}
	@Override
	public String deleteCenter(AfterLoginForm afterLoginForm,HttpServletRequest request,HttpServletResponse response,HttpSession session,BindingResult result)
	{
		String areaCode=afterLoginForm.getCenterCode();
		System.out.println("areacode"+areaCode);
		centerTableSpringDataJpa.deleteCenter(new BigDecimal(areaCode));
		System.out.println("deleted");
		return null;
	}
}
