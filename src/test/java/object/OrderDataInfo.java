package object;

import utils.Constant;

public class OrderDataInfo {
	
	private String typeUser;
	private String comicTitle;
	private String issueNumber;
	private String year;
	private String publisher;
	private String variant;
	private String pedigree; 
	private String tier;
	private String qty;
	private String insuredValue;
	private String gradeScreening;
	private String fastPast;
	private String slideshow;
	private String image;
	private String verifiedSignature; 
	private String authenticatedSignature;
	private String orderNumber;
	
			
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getTypeUser() {
		return typeUser;
	}
	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}
	public String getComicTitle() {
		return comicTitle;
	}
	public void setComicTitle(String comicTitle) {
		this.comicTitle = comicTitle;
	}
	public String getIssueNumber() {
		return issueNumber;
	}
	public void setIssueNumber(String issueNumber) {
		this.issueNumber = issueNumber;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getVariant() {
		return variant;
	}
	public void setVariant(String variant) {
		this.variant = variant;
	}
	public String getPedigree() {
		return pedigree;
	}
	public void setPedigree(String pedigree) {
		this.pedigree = pedigree;
	}
	public String getTier() {
		return tier;
	}
	public void setTier(String tier) {
		this.tier = tier;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public String getInsuredValue() {
		return insuredValue;
	}
	public void setInsuredValue(String insuredValue) {
		this.insuredValue = insuredValue;
	}
	public String getGradeScreening() {
		return gradeScreening;
	}
	public void setGradeScreening(String gradeScreening) {
		this.gradeScreening = gradeScreening;
	}
	public String getFastPast() {
		return fastPast;
	}
	public void setFastPast(String fastPast) {
		this.fastPast = fastPast;
	}
	public String getSlideshow() {
		return slideshow;
	}
	public void setSlideshow(String slideshow) {
		this.slideshow = slideshow;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getVerifiedSignature() {
		return verifiedSignature;
	}
	public void setVerifiedSignature(String verifiedSignature) {
		this.verifiedSignature = verifiedSignature;
	}
	public String getAuthenticatedSignature() {
		return authenticatedSignature;
	}
	public void setAuthenticatedSignature(String authenticatedSignature) {
		this.authenticatedSignature = authenticatedSignature;
	}	
	
	public  OrderDataInfo fillOrderDatOnAdmin(OrderDataInfo order){
		
		order.setTypeUser(Constant.EMAIL_CLIENT);	
		order.setComicTitle(generateComicTitle());
		order.setIssueNumber(generateIssueNumber());
		order.setYear(Constant.YEAR);
		order.setPublisher(generatePublisher());
		order.setVariant(generateVariant());
		//order.setPedigree(getPedigree());
		//order.setTier(getTier());
		order.setQty(Constant.QTY);
		order.setInsuredValue(Constant.INSURE_VALUE);			
		return  order;
	}
	
	public  OrderDataInfo fillOrderData(OrderDataInfo order){
		
		order.setComicTitle(generateComicTitle());
		order.setIssueNumber(generateIssueNumber());
		order.setYear(Constant.YEAR);
		order.setPublisher(generatePublisher());
		order.setVariant(generateVariant());
		order.setQty(Constant.QTY);
		order.setInsuredValue(generateInsuredValue());			
		return  order;
	}	
	
	
	public  String generateComicTitle(){
	     String value = "Batman";
	     for(int a=0; a<3; a++){
	    	 value+=(int) (Math.random() *9)+1;      
	     }
	     return value;	     
	     
	 }
	
	public  String generateIssueNumber(){
	     String value = "1";
	     for(int a=0; a<6; a++){
	    	 value+=(int) (Math.random() *9)+1;      
	     }
	     return value;
	 }
	
	public  String generatePublisher(){
	     String value = "DC";
	     for(int a=0; a<3; a++){
	    	 value+=(int) (Math.random() *9)+1;      
	     }
	     return value;
	 }
	
	public  String generateVariant(){
	     String value = "Main Cover";
	     for(int a=0; a<3; a++){
	    	 value+=(int) (Math.random() *9)+1;      
	     }
	     return value;
	 }

	public  String generateQty(){
	     String value = "";
	     for(int a=1; a<2; a++){
	    	 value+=(int) (Math.random() *9)+1;      
	     }
	     return value;
	 }
	
	public  String generateInsuredValue(){
	     String value = "1";
	     for(int a=0; a<1; a++){
	    	 value+=(int) (Math.random() *9)+1;      
	     }
	     return value;
	 }
	
}
