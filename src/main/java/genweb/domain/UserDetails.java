package genweb.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="user_Details")
@IdClass(UserDetailsId.class)
@NamedQuery(name="UserDetails.findAll",query="select u from UserDetails u")

public class UserDetails implements Serializable{
	
	public static final long serialVersionUID=1L;
	
	   @Id
	   @Column(name="area_Code") 
	   private String areaCode;  
	   
	   @Id
	   @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_Details_seq")
	   @SequenceGenerator(name="user_Details_seq", sequenceName="user_Details_seq", allocationSize=0)
	   private BigDecimal id;
	   
	   
	   
	    /*@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private BigDecimal id;*/
	   
	   @Column(name="name_user")
	    private String nameUser ;
	    
	    @Column(name="product_Name")
	    private String productName ;
	    
	    @Column(name="price")
	    private String price ;
	    
	    @Column(name="rate_Of_Interest")
	    private String rateOfInterest;
	    
	    @Column(name="tenure")
	    private String tenure ;
	    
	    @Column(name="address")
	    private String address;

		public String getAreaCode() {
			return areaCode;
		}

		public void setAreaCode(String areaCode) {
			this.areaCode = areaCode;
		}

		public BigDecimal getId() {
			return id;
		}

		public void setId(BigDecimal id) {
			this.id = id;
		}

		public String getNameUser() {
			return nameUser;
		}

		public void setNameUser(String nameUser) {
			this.nameUser = nameUser;
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

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}  
		public UserDetails()
		{
			
		}

}
