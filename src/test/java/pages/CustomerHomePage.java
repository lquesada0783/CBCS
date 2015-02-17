package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ts.commons.Page;
import com.ts.commons.Validator;


public class CustomerHomePage extends Page {	
		
	@FindBy(xpath="//a[text()='Login' and @onmouseover='']")
	private WebElement loginLink;	
	
	@FindBy(xpath="(//input[@name='email'])[1]")
	private WebElement emailField;
	
	@FindBy(xpath="//input[@name='txtPassword']")
	private WebElement passwordField;
	
	@FindBy(xpath="//button[text()='Sign in']")
	private WebElement signInButton;
	
			
	@Override
	public CustomerHomePage and() {		
		return this;
	}

	@Override
	public CustomerHomePage then() {		
		return this;
	}
	
	public CustomerHomePage clickLoginLink(WebDriver driver){
		utils.Utils.waitForElemets(1);
		loginLink.click();
		return this;		 
	}
	
	
	public CustomerHomePage clearFields(){
		emailField.clear();
		passwordField.clear();
		return this;
		
	}
	
	public CustomerHomePage fillFieldsForLogin (String email, String password){
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
	
	public Validator loginLinkMustBePresent(){
		return new Validator()
		{
			@Override
			public void Validate(){				
				
				boolean thereIsALoginLink = loginLink !=null;
				Assert.assertTrue(thereIsALoginLink);
				
			}
		};
	}
	

}
