package object;


public class CustomerDataInfo {
	
	private String name;
	private String company;
	private String email;
	private String phoneNumber;
	private String address;
	private String apptOrUnit;
	private String city;
	private String zipCode;
	private String country;
	private String state;
	
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getApptOrUnit() {
		return apptOrUnit;
	}
	public void setApptOrUnit(String apptOrUnit) {
		this.apptOrUnit = apptOrUnit;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
   public CustomerDataInfo fillCustomerDataInfo(CustomerDataInfo customer ){
		
	   customer.setName(generateName());
	   customer.setEmail(generateEmail());
	   customer.setCompany(generateCompanyName());
	   customer.setPhoneNumber(generatePhoneNumber());
	   customer.setAddress(generateAddress());
	   customer.setApptOrUnit(generateApptOrUnit());
	   customer.setCity(generateCity());
	   customer.setZipCode(generatezipCode());
	   customer.setCountry(generateCountry());
	   customer.setState(generateState());
	   
	   return customer;
	}
   
   public CustomerDataInfo generateNewData(CustomerDataInfo customer ){
		
	   utils.Utils.waitForElemets(1);
	   customer.setName(generateName());
	   customer.setEmail(generateEmail());
	   customer.setCompany(generateCompanyName());
	   customer.setPhoneNumber(generatePhoneNumber());
	   customer.setAddress(generateAddress());
	   customer.setApptOrUnit(generateApptOrUnit());
	   customer.setCity(generateCity());
	   customer.setZipCode(generatezipCode());
	   customer.setCountry(generateCountry());
	   customer.setState(generateState());
	   
	   return customer;
	}
   
   
   public String generateName(){
		 String userName="Customer";
	     String value = "";
	     for(int a=0; a<3; a++){
	    	value+=(int) (Math.random() *9)+1;
	      
	     }
	     return userName+=value;
	 }
	
	public String generateEmail(){
	     String email="customer";
	     String value = "";
	     for(int a=0; a<3; a++){
	    	value+=(int) (Math.random() *9)+1;
	      
	     }
	     return email+=value+"@cecropiasolutions.com";
	 }
	
	 public String generateCompanyName(){
		 String companyName="Company";
	     String value = "";
	     for(int a=0; a<3; a++){
	    	value+=(int) (Math.random() *9)+1;
	      
	     }
	     return companyName+=value;
	 }
	 
	 public  String generatePhoneNumber(){
	     String value = "";
	     for(int a=0; a<8; a++){
	    	 value+=(int) (Math.random() *9)+1;      
	     }
	     return value;
	 }
	 
	 public String generateAddress(){
		 String address="Florida";
	     String value = "";
	     for(int a=0; a<3; a++){
	    	value+=(int) (Math.random() *9)+1;
	      
	     }
	     return address+=value;
	 }
	 
	 public String generateApptOrUnit(){
		 String apptOrUnit="506,Florida";
	     String value = "";
	     for(int a=0; a<2; a++){
	    	value+=(int) (Math.random() *9)+1;
	      
	     }
	     return apptOrUnit+=value;
	 }
	 
	 public String generateCity(){
		 String city="Florida";
	     String value = "";
	     for(int a=0; a<2; a++){
	    	value+=(int) (Math.random() *9)+1;
	      
	     }
	     return city+=value;
	 }
	 
	 public  String generatezipCode(){
	     String zipCode = "";
	     for(int a=0; a<4; a++){
	    	 zipCode+=(int) (Math.random() *9)+1;      
	     }
	     return zipCode;
	 }
	 
	 public String generateCountry(){
		/* String city="United States+";
	     String value = "";
	     for(int a=0; a<2; a++){
	    	value+=(int) (Math.random() *9)+1;
	      
	     }*/
	    // return city+=value;
		 return "United States";
	 }
	 
	 public String generateState(){
			/* String city="United States+";
		     String value = "";
		     for(int a=0; a<2; a++){
		    	value+=(int) (Math.random() *9)+1;
		      
		     }*/
		    // return city+=value;
			 return "Florida";
		 }
	
}
