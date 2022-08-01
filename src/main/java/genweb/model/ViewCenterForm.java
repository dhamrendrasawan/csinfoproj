package genweb.model;

import org.springframework.stereotype.Component;

@Component
public class ViewCenterForm {
	
	private String centerName;      
    private String centerCode;
    private String delete="Delete";
    private String Edit="Edit";
    private String viewCenter="ViewCenter";
    
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
	public String getDelete() {
		return delete;
	}
	public void setDelete(String delete) {
		this.delete = delete;
	}
	public String getEdit() {
		return Edit;
	}
	public void setEdit(String edit) {
		Edit = edit;
	}
	public String getViewCenter() {
		return viewCenter;
	}
	public void setViewCenter(String viewCenter) {
		this.viewCenter = viewCenter;
	}
	
}
