package com.pkhomedecores.pojo;

public class Customer  {
		private int custId;
		private String custName,custEmail,custPass,custAddress,custContact;
        
		public Customer() {
		}
         public Customer(String custName, String custEmail, String custPass, String custContact, String custAddress) {
        	 this.custName = custName;
        	 this.custEmail = custEmail;
        	 this.custPass = custPass;
        	 this.custContact = custContact;
        	 this.custAddress = custAddress;
         }
         public int getCustId() {
        		return custId;
        	}

         public void setCustId(int custId) {
	     this.custId = custId;
            }
         public String getCustName() {
        		return custName;
        	}
        public void setCustName(String custName) {
        this.custName = custName;
        	}
        public String getCustEmail() {
        return custEmail;
        
           }
        public void setCustEmail(String custEmail) {
	    this.custEmail = custEmail;
           }
       public String getCustPass() {
	   return custPass;
          }
       public void setCustPass(String custPass) {
	   this.custPass = custPass;
          }
       public String getCustContact() {
	   return custContact;
          }
       public void setCustContact(String custContact) {
	   this.custContact = custContact;
          }
       public String getCustAddress() {
	   return custAddress;
          }
       public void setCustAddress(String custAddress) {
	   this.custAddress = custAddress;
          }
@Override
public String toString() {
	return "Customer [custId=" + custId + ", custContact=" + custContact + ", custName=" + custName + ", custEmail="
			+ custEmail + ", custPassword=" + custPass + ", custAddress=" + custAddress + "]";
 }

}
