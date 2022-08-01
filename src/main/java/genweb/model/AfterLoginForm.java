package genweb.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AfterLoginForm {

	private String centerName;
    private String flag="N";
    private String centerCode;
    private String  flag1="N";
    private String flag4="N";
    private String flag2="N";
    
    List<ViewCenterForm> datalist=new ArrayList<ViewCenterForm>();
    
    
	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getCenterCode() {
		return centerCode;
	}

	public void setCenterCode(String centerCode) {
		this.centerCode = centerCode;
	}
	public String getFlag1() {
		return flag1;
	}

	public void setFlag1(String flag1) {
		this.flag1 = flag1;
	}

	public List<ViewCenterForm> getDatalist() {
		return datalist;
	}

	public void setDatalist(List<ViewCenterForm> datalist) {
		this.datalist = datalist;
	}

	public String getFlag4() {
		return flag4;
	}
	public void setFlag4(String flag4) {
		this.flag4 = flag4;
	}
	
	public String getFlag2() {
		return flag2;
	}
	public void setFlag2(String flag2) {
		this.flag2 = flag2;
	}
}
