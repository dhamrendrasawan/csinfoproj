package genweb.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="center_table")
@NamedQuery(name="CenterTable.findAll",query="select c from CenterTable c")
public class CenterTable implements Serializable{
	
	public static final long serialVersionUID=1L;	
	@Id
	@Column(name="area_code")
	private BigDecimal areaCode;	
	
	@Column(name="center_name")
    private String centerName;

	public BigDecimal getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(BigDecimal areaCode) {
		this.areaCode = areaCode;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
