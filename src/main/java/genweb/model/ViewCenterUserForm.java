package genweb.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ViewCenterUserForm 
{
	private String centerName;      
    private String centerCode;
    private String createUser="Create";
    private String delete="Delete";
    private String edit="Edit";
    private String payment="Payment";
 
    private String paymentAmount;
    private String tenurePayment;
    private String viewCenter="ViewCenter";
    private String flag1="N";  
    private String flag2="N";
    private String name;
    private String productName;
    private String price;
    private String rateOfInterest;
    private String tenure;
    private String tenureAmount;
    private String tenureRemaining;
    private String outstandingAmount;
    private String address;
    private String sucessMsg="";
    private String userCount;
    private String userId;
    
    List<ViewCenterUserForm> dataList=new ArrayList<ViewCenterUserForm>();
    
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public String getCenterCode() {
		return centerCode;
	}
	public void setCenterCode(String centerCode) {
		this.centerCode = centerCode;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getDelete() {
		return delete;
	}
	public void setDelete(String delete) {
		this.delete = delete;
	}
	
	public String getEdit() {
		return edit;
	}
	public void setEdit(String edit) {
		this.edit = edit;
	}
	public String getViewCenter() {
		return viewCenter;
	}
	public void setViewCenter(String viewCenter) {
		this.viewCenter = viewCenter;
	}
	public String getFlag1() {
		return flag1;
	}	
	
	public String getFlag2() {
		return flag2;
	}
	public void setFlag2(String flag2) {
		this.flag2 = flag2;
	}
	public void setFlag1(String flag1) {
		this.flag1 = flag1;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getRateOfInterest() {
		return rateOfInterest;
	}
	public void setRateOfInterest(String rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}
	public String getTenure() {
		return tenure;
	}
	public void setTenure(String tenure) {
		this.tenure = tenure;
	}
	public String getTenureAmount() {
		return tenureAmount;
	}
	public void setTenureAmount(String tenureAmount) {
		this.tenureAmount = tenureAmount;
	}
	public String getTenureRemaining() {
		return tenureRemaining;
	}
	public void setTenureRemaining(String tenureRemaining) {
		this.tenureRemaining = tenureRemaining;
	}
	public String getOutstandingAmount() {
		return outstandingAmount;
	}
	public void setOutstandingAmount(String outstandingAmount) {
		this.outstandingAmount = outstandingAmount;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSucessMsg() {
		return sucessMsg;
	}
	public void setSucessMsg(String sucessMsg) {
		this.sucessMsg = sucessMsg;
	}
	public String getUserCount() {
		return userCount;
	}
	public void setUserCount(String userCount) {
		this.userCount = userCount;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	
	public String getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(String paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public String getTenurePayment() {
		return tenurePayment;
	}
	public void setTenurePayment(String tenurePayment) {
		this.tenurePayment = tenurePayment;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<ViewCenterUserForm> getDataList() {
		return dataList;
	}
	public void setDataList(List<ViewCenterUserForm> dataList) {
		this.dataList = dataList;
	}		
	
}
