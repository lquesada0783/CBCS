package object;

public class AdminDataInfo {

	private String userName;
	private String password;
	private String role;
	private String email;		
	private String firstName;
	private String lastName;
	private String phone;	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public AdminDataInfo (){}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}		
	
	public AdminDataInfo fillDataReceiverRole(AdminDataInfo receiverUser, String password, String role){
		
		receiverUser.setUserName(generateUserName());		
		receiverUser.setEmail(generateAdminEmail());	
		receiverUser.setPassword(password);
		receiverUser.setFirstName(generateFirstName()); 
		receiverUser.setLastName(generateLastName());
		receiverUser.setPhone(generatePhoneNumber());
		receiverUser.setRole(role);
		
		return  receiverUser;
	}
	
	
	public String generateUserName(){
		 String UserName="Test+";
	     String value = "";
	     for(int a=0; a<3; a++){
	    	value+=(int) (Math.random() *9)+1;
	      
	     }
	     return UserName+=value;
	 }
	
	public String generateAdminEmail(){
	     String email="qaadmin+";
	     String value = "";
	     for(int a=0; a<3; a++){
	    	value+=(int) (Math.random() *9)+1;
	      
	     }
	     return email+=value+"@cecropiasolutions.com";
	 }
	
	public String generateReceiverEmail(){
	     String email="qareceiver+";
	     String value = "";
	     for(int a=0; a<2; a++){
	    	value+=(int) (Math.random() *9)+1;
	      
	     }
	     return email+=value+"@cecropiasolutions.com";
	 }
	
	public String generateGraderEmail(){
	     String email="qagrader+";
	     String value = "";
	     for(int a=0; a<2; a++){
	    	value+=(int) (Math.random() *9)+1;
	      
	     }
	     return email+=value+"@cecropiasolutions.com";
	 }
	
	public String generateFinalizerEmail(){
	     String email="qafinalizer+";
	     String value = "";
	     for(int a=0; a<2; a++){
	    	value+=(int) (Math.random() *9)+1;
	      
	     }
	     return email+=value+"@cecropiasolutions.com";
	 }
	
	public String generateShippingEmail(){
	     String email="qashipping+";
	     String value = "";
	     for(int a=0; a<2; a++){
	    	value+=(int) (Math.random() *9)+1;
	      
	     }
	     return email+=value+"@cecropiasolutions.com";
	 }
	
	public  String generatePhoneNumber(){
	     String value = "";
	     for(int a=0; a<8; a++){
	    	 value+=(int) (Math.random() *9)+1;      
	     }
	     return value;
	 }
	
	public String generateFirstName(){
	     String firstName="Test+";
	     String value = "";
	     for(int a=0; a<3; a++){
	    	value+=(int) (Math.random() *9)+1;
	      
	     }
	     return firstName+=value;
	 }
	
	public String generateLastName(){
	     String lastName="QA+";
	     String value = "";
	     for(int a=0; a<3; a++){
	    	value+=(int) (Math.random() *9)+1;
	      
	     }
	     return lastName+=value;
	 }
	
}
