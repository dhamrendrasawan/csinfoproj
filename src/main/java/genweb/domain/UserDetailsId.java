package genweb.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class UserDetailsId implements Serializable {
	
	public static final long serialVersionUID=1L;	
	 private BigDecimal id;
	 private String areaCode;
	
	 public UserDetailsId()
	 {
		 
	 }
	 
	 public BigDecimal getId() {
			return id;
		}

		public void setId(BigDecimal id) {
			this.id = id;
		}

		public String getAreaCode() {
			return areaCode;
		}

		public void setAreaCode(String areaCode) {
			this.areaCode = areaCode;
		}		
	 
	 public static long getSerialversionuid() {
			return serialVersionUID;
		}

	public UserDetailsId(BigDecimal id,String areaCode)
	 {
		 this.id=id;
		 this.areaCode=areaCode;
	 }
	 
	 @Override
	  public boolean equals(Object o) {
	      if (this == o)
	    	  return true;
	      if (o == null || getClass() != o.getClass()) 
	    	  return false;
	      
	      UserDetailsId userDetailsId = (UserDetailsId) o;
	      if (id != userDetailsId.id) 
	    	  return false;	     
	        return areaCode == userDetailsId.areaCode;
	      
	  }
	
	@Override
	  public int hashCode() {
	      return Objects.hash(id, areaCode);
	  }
}
