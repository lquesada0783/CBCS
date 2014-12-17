package signin_logout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.DashboardAdminPage;
import pages.DashboardFinalizerPage;
import pages.DashboardGraderPage;
import pages.DashboardQCPage;
import pages.DashboardReceiverPage;
import pages.DashboardShippingPage;
import pages.DashboardSlabPage;

import com.ts.commons.Page;

public class AdminLoginPage extends Page {
	
	@FindBy(xpath="//input[@placeholder='User Name']")
	private WebElement userNameField;	
	
	@FindBy(xpath="//input[@placeholder='Password']")
	private WebElement passwordField;
	
	@FindBy(xpath="//button[contains(.,'Sign in')]")
	private WebElement signInButton;

	@Override
	public AdminLoginPage and() {		
		return this;
	}

	@Override
	public AdminLoginPage then() {		
		return this;
	}
	
	
	public AdminLoginPage clearFields(){
		userNameField.clear();
		passwordField.clear();
		return this;
		
	}
	
	public AdminLoginPage fillFieldsForLogin (String userName, String password){
		clearFields();
		userNameField.sendKeys(userName);
		passwordField.sendKeys(password);
		return this;
		
	}
	
	public Page signInButtonClick (WebDriver driver, String enviroment){
		signInButton.click();		
		return goToDashboardPage(driver, enviroment);		
				
	}
	
	public static Page goToDashboardPage(WebDriver driver, String enviroment){
		Page element;		
		
		switch (enviroment) {
		
		  case "admin":
			DashboardAdminPage goToDashboardAdminPage= PageFactory.initElements(driver, DashboardAdminPage.class);	
			element = goToDashboardAdminPage;
		   break;
		   
		  case "receiver":			
			 DashboardReceiverPage goToDashboardReceiverPage= PageFactory.initElements(driver, DashboardReceiverPage.class);	
			 element = goToDashboardReceiverPage;
			 break;
			 
		  case "grader":			
			  	 DashboardGraderPage goToDashboardGraderPage= PageFactory.initElements(driver, DashboardGraderPage.class);	
				 element = goToDashboardGraderPage;
				 break;	
				 
		  case "finalizer":			
			  	 DashboardFinalizerPage goToDashboardFinalizerPage= PageFactory.initElements(driver, DashboardFinalizerPage.class);	
				 element = goToDashboardFinalizerPage;
				 break;	
				 
		  case "slab":			
			  	 DashboardSlabPage goToDashboardSlabPage= PageFactory.initElements(driver, DashboardSlabPage.class);	
				 element = goToDashboardSlabPage;
				 break;	
				 
		  case "qc":			
			  	 DashboardQCPage goToDashboardQCPage= PageFactory.initElements(driver, DashboardQCPage.class);	
				 element = goToDashboardQCPage;
				 break;	
				 
		  case "shipping":			
			  	 DashboardShippingPage goToDashboardShippingPage= PageFactory.initElements(driver, DashboardShippingPage.class);	
				 element = goToDashboardShippingPage;
				 break;	
		  default:
		   element = null;
		  }		
		  return element;		
	}

}
