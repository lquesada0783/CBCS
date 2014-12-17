package pages;

import org.testng.Assert;
import object.AdminDataInfo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ts.commons.Page;
import com.ts.commons.Validator;

public class Users extends Page {	
	
	@FindBy(xpath="//h1[contains(.,'User')]")
	private WebElement usersLabel;	
	
	@FindBy(xpath="//a[@type='submit']")
	private WebElement newButton;
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement userNameField;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement emailField;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@name='firstname']")	
	private WebElement firstNameField;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastNameField;
	
	@FindBy(xpath="//input[@name='phone']")
	private WebElement phoneField;
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement saveButton;
	
	@FindBy(xpath="//div[@id='operationResult' and contains(.,'User added successfully.') and @style='display: block;']")
	private WebElement addedUserSuccessfullyMessage;
	
	@FindBy(xpath="//div[@id='operationResult' and contains(.,'User deleted successfully.') and @style='display: block;']")
	private WebElement deletedUserSuccessfullyMessage;
	
	@Override
	public Users and() {
		return this;
	}

	@Override
	public Users then() {
		return this;
	}
	
	public Users clickNewButton(WebDriver driver){
		newButton.click();		
		return this;		 
	}
	
	public Users fillFieldsAddUserModal(AdminDataInfo user, String role, WebDriver driver){
		userNameField.sendKeys(user.getUserName());
		emailField.sendKeys(user.getEmail());
		passwordField.sendKeys(user.getPassword());
		firstNameField.sendKeys(user.getFirstName());
		lastNameField.sendKeys(user.getLastName());
		phoneField.sendKeys(user.getPhone());
		selectOneOptionRoleDropdown(role,driver);
		return this;
	}
	
	public Users clicksaveButton(WebDriver driver){
		saveButton.click();		
		return this;		 
	}
	
	public GradingFinalizerPage selectOneOptionRoleDropdown(String option, WebDriver driver){	
	    	
		return utils.Utils.selectDropDownOption(By.xpath("(//select[contains(.,'')])[1]"),option,driver,GradingFinalizerPage.class);

	}
	
	public Users deletedUser(AdminDataInfo user, WebDriver driver){	
    	
		 utils.Utils.deleteUser(user,driver);
		 return this;

	}
	
	public Validator UsersLabelMustBePresent(){
		return new Validator()
		{
			@Override
			public void Validate(){				
				
				boolean thereIsAnUsersLabel = usersLabel !=null;
				Assert.assertTrue(thereIsAnUsersLabel);
				
			}
		};
	}
	
	public Validator addedUserSuccessfullyMessageMustBePresent(){
		return new Validator()
		{
			@Override
			public void Validate(){				
					
				boolean thereIsAnAddedUserSuccessfullyMessage = addedUserSuccessfullyMessage !=null;
				Assert.assertTrue(thereIsAnAddedUserSuccessfullyMessage);			
				
			}
		};
	}	
	
	public Validator deletedUserSuccessfullyMessageMustBePresent(){
		return new Validator()
		{
			@Override
			public void Validate(){				
					
				boolean thereIsAnDeletedUserSuccessfullyMessage = deletedUserSuccessfullyMessage !=null;
				Assert.assertTrue(thereIsAnDeletedUserSuccessfullyMessage);			
				
			}
		};
	}	

}
