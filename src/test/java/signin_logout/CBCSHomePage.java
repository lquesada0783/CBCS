package signin_logout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.DashboardCustomerPage;

import com.ts.commons.Page;


public class CBCSHomePage extends Page {	
		
	@FindBy(xpath="//a[text()='Login' and @onmouseover='']")
	private WebElement loginLink;	
	
	@FindBy(xpath="(//input[@name='email'])[1]")
	private WebElement emailField;
	
	@FindBy(xpath="//input[@name='txtPassword']")
	private WebElement passwordField;
	
	@FindBy(xpath="//button[text()='Sign in']")
	private WebElement signInButton;
	
			
	@Override
	public CBCSHomePage and() {		
		return this;
	}

	@Override
	public CBCSHomePage then() {		
		return this;
	}
	
	public CBCSHomePage clickLoginLink(WebDriver driver){
		loginLink.click();
		return this;		 
	}
	
	
	public CBCSHomePage clearFields(){
		emailField.clear();
		passwordField.clear();
		return this;
		
	}
	
	public CBCSHomePage fillFieldsForLogin (String email, String password){
		clearFields();
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		return this;
		
	}

	public DashboardCustomerPage clickSignInButton(WebDriver driver){
		signInButton.click();
		DashboardCustomerPage dashboardCustomerPage= PageFactory.initElements(driver, DashboardCustomerPage.class);
		return dashboardCustomerPage;		 
	}
	

}
