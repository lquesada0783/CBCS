package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ts.commons.Page;
import com.ts.commons.Validator;

public class ChangePasswordPage extends Page {
	
	@FindBy(xpath="//label[contains(.,'Current Password: ')]")
    private WebElement currentPasswordLabel;	
	
	@FindBy(xpath="//input[@id='currentPassword']")
	private WebElement currentPasswordField;
	
	@FindBy(xpath="//input[@id='pw1' and @name='password']")
	private WebElement passwordActualField;
	
	@FindBy(xpath="//input[@name='confirmpassword']")
	private WebElement confirmPasswordField;
	
	@FindBy(xpath="//button[text()='Change Password']")
	private WebElement changePasswordButton;
	
	@FindBy(xpath="//button[text()='Yes']")
	private WebElement yesButton;

	@Override
	public ChangePasswordPage and() {		
		return this;
	}

	@Override
	public ChangePasswordPage then() {		
		return this;
	}
	
	public ChangePasswordPage cleanFillFields(){
		currentPasswordField.clear();
		passwordActualField.clear();
		confirmPasswordField.clear();
		return this;		 
	}	
	
	public ChangePasswordPage fillFieldsForChangePassword(String actualPassword, String newPassword){
		cleanFillFields();
		currentPasswordField.sendKeys(actualPassword);
		passwordActualField.sendKeys(newPassword);
		confirmPasswordField.sendKeys(newPassword);
		return this;		 
	}		
	
	public ChangePasswordPage clickchangePasswordButton(){			
		changePasswordButton.click();		
		return this;		 
	}	
	
	public CustomerHomePage clickYesButton(WebDriver driver){			
		yesButton.click();	
		CustomerHomePage homePage= PageFactory.initElements(driver, CustomerHomePage.class);		
		return homePage;		 
	}	
	
	public Validator currentPasswordLabelMustBePresent(){
		return new Validator()
		{
			@Override
			public void Validate(){				
				
				boolean thereIsACurrentPasswordLabel = currentPasswordLabel !=null;
				Assert.assertTrue(thereIsACurrentPasswordLabel);
				
			}
		};
	}

}
