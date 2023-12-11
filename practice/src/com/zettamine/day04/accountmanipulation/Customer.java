package com.zettamine.day04.accountmanipulation;

/**
 * <h1> customer POJO class</h1>
 * @author Kota Sai Kumar
 * @version java-11
 * @since 11-12-2023
 * 
 */

public class Customer {

	
  private  int  customerId;	
    private String customerName;
    private String emailId;
	
    
    /**
     * it is a constructor of Customer class having three arguments
     * @param customerId 
     * @param customerName
     * @param emailId
     */
    
    public Customer(int customerId, String customerName, String emailId) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.emailId = emailId;
	}
    
    /** 
     * this method is used to retrieve customer id of an object
     * @return Id of a customer
     */
   
	public int getCustomerId() {
		return customerId;
	}
	/**
	 * this method is used to assign or update costumer Id of an object
	 * @param customerId
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	/**
	 * this method is used to retrieve customer Name 
	 * @return Name of a customer
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * this method is used to assign or update customer name of an object
	 * @param customerName 
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * this method is used to retrieve the email id of a customer
	 * @return
	 */
	public String getEmailId() {
		return emailId;
	}
	/**
	 * this method is used to assign or update customer email ID 
	 * @param emailId
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
    
    

}
