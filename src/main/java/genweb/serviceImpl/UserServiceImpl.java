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

import genweb.domain.UserDetails;
import genweb.model.ViewCenterUserForm;
import genweb.service.UserService;
import genweb.springdatajpa.CenterTableSpringDataJpa;
import genweb.springdatajpa.UserDetailsSpringDataJpa;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService{

	@Autowired
	CenterTableSpringDataJpa centerTableSpringDataJpa;
	@Autowired
	UserDetailsSpringDataJpa userDetailsSpringDataJpa;
	
	@Override
	public String viewCenterUser(String areaCode,ViewCenterUserForm viewCenterUserForm,HttpServletRequest request,HttpServletResponse response,HttpSession session,BindingResult result)
	{
		try
		{
		    String  userCount=userDetailsSpringDataJpa.getUserCountByAreadCode(areaCode).toString();
		    viewCenterUserForm.setUserCount(userCount);
			List<Object[]> list=centerTableSpringDataJpa.getCenterDetailAndUser(new BigDecimal(areaCode));
			if(!list.isEmpty())
			{
				for(Object[] object:list)
				{
					if(object[0]==null || object[0].equals(""))
					{
						viewCenterUserForm.setCenterCode("");
					}
					else
					{
						String centerCode=object[0].toString();
						viewCenterUserForm.setCenterCode(centerCode);
					}
					if(object[1]==null ||object[1].equals(""))
					{
						viewCenterUserForm.setCenterName("");
					}
					else
					{
				     	String centerName=object[1].toString();
				     	viewCenterUserForm.setCenterName(centerName);
					}
					
					
				}
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
			result.rejectValue("Exception", "Exception",e.getMessage());
			 return "AfterLogin/HomePage";
		}
		return "AfterLogin/ViewCenter_User";
	}
	
	@Override
	public String createUserDetails(String areaCode,ViewCenterUserForm viewCenterUserForm,HttpServletRequest request,HttpServletResponse response,HttpSession session,BindingResult result)
	{
	    try
	    {
	    	int c=0;
	    	
	    	UserDetails userDetails=new UserDetails();
	    	
	    	userDetails.setAreaCode(areaCode);
	    /*	userDetails.setId(new BigDecimal("10"));*/
	    	userDetails.setNameUser(viewCenterUserForm.getName());
	    	userDetails.setProductName(viewCenterUserForm.getProductName());
	    	userDetails.setPrice(viewCenterUserForm.getPrice());	    	
	    	userDetails.setRateOfInterest(viewCenterUserForm.getRateOfInterest());
	    	userDetails.setTenure(viewCenterUserForm.getTenure());
	    	userDetails.setAddress(viewCenterUserForm.getAddress());
	    	userDetailsSpringDataJpa.save(userDetails);
	    	c++;
	    	if(c>0)
	    	{
	    		 String  userCount=userDetailsSpringDataJpa.getUserCountByAreadCode(areaCode).toString();
	 		    viewCenterUserForm.setUserCount(userCount);
	    		viewCenterUserForm.setSucessMsg("User Created Sucessfully");
	    	}
	    	System.out.println("inseted user detils");
	   	    return "AfterLogin/ViewCenter_User";
	    	
	    	
	    }catch(Exception e)
	    {
	    	e.printStackTrace();
			result.rejectValue("Exception", "Exception",e.getMessage());
			 return "AfterLogin/ViewCenter_User";
	    }	 
		
	}
	
	@Override
	public String getUserDetails(String areaCode,ViewCenterUserForm viewCenterUserForm,HttpServletRequest request,HttpServletResponse response,HttpSession session,BindingResult result)
	{
		try
		{
			List<ViewCenterUserForm> userList=new ArrayList<ViewCenterUserForm>();
			
			List<Object[]> list=userDetailsSpringDataJpa.getUserDetails(areaCode);
			if(!list.isEmpty())
			{
				
				for(Object[] data:list)
				{
					ViewCenterUserForm viewCenterUserForm1=new ViewCenterUserForm();
					
					if(data[2]==null || data[2].equals(""))
					{
						viewCenterUserForm1.setName("");
					}
					else
					{
						String userName=data[2].toString();
						viewCenterUserForm1.setName(userName);
					}
					if(data[3]==null || data[3].equals(""))
					{
						viewCenterUserForm1.setProductName("");
					}
					else
					{
						String productName=data[3].toString();
						viewCenterUserForm1.setProductName(productName);
					}
					if(data[4]==null || data[4].equals(""))
					{
						viewCenterUserForm1.setPrice("");
					}
					else
					{
						String price=data[4].toString();
						viewCenterUserForm1.setPrice(price);
						viewCenterUserForm1.setTenureAmount(price);
						viewCenterUserForm1.setOutstandingAmount(price);
					}							
					if(data[5]==null || data[5].equals(""))
					{
						viewCenterUserForm1.setRateOfInterest("");
					}
					else
					{
						String interestRate=data[5].toString();
						viewCenterUserForm1.setRateOfInterest(interestRate);
					}
					if(data[6]==null || data[6].equals(""))
					{
						viewCenterUserForm1.setTenure("");
					}
					else
					{
						String tenure=data[6].toString();
						viewCenterUserForm1.setTenure(tenure);
						viewCenterUserForm1.setTenureRemaining(tenure);
					}
					if(data[7]==null || data[7].equals(""))
					{
						viewCenterUserForm1.setAddress("");
					}
					else
					{
						String address=data[7].toString();
						viewCenterUserForm1.setAddress(address);
					}	
					viewCenterUserForm1.setDelete("Delete");
					viewCenterUserForm1.setEdit("Edit");
					viewCenterUserForm1.setPayment("Payment");
				
					userList.add(viewCenterUserForm1);
					
				}
				viewCenterUserForm.setDataList(userList);
			}
			
			return "AfterLogin/ViewCenter_User"; 
			
		}catch(Exception e)
		{
			e.printStackTrace();
			result.rejectValue("Exception", "Exception",e.getMessage());
			return "AfterLogin/ViewCenter_User";
		}
	}
	
}
