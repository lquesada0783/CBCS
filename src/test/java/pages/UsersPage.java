package pages;

import org.testng.Assert;

import object.AdminDataInfo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ts.commons.Page;
import com.ts.commons.Validator;

public class UsersPage extends Page {	
	
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
	
	@FindBy(xpath=".//*[@id='searchingInput']")
	private WebElement searchField;
	
	@FindBy(xpath="//button[@name='Search']")
	private WebElement searchButton;
	
	@FindBy(xpath="//button[contains(.,'Yes')]")
	private WebElement yesButton;
	
	@Override
	public UsersPage and() {
		return this;
	}

	@Override
	public UsersPage then() {
		return this;
	}
	
	public UsersPage clickNewButton(WebDriver driver){
		newButton.click();		
		return this;		 
	}
	
	public UsersPage clearFieldsAddUserModal(){
		userNameField.clear();
		emailField.clear();
		passwordField.clear();
		firstNameField.clear();
		lastNameField.clear();
		phoneField.clear();
		return this;
	}
	
	public UsersPage fillFieldsAddUserModal(AdminDataInfo user, String role, WebDriver driver){
		clearFieldsAddUserModal();
		userNameField.sendKeys(user.getUserName());
		emailField.sendKeys(user.getEmail());
		passwordField.sendKeys(user.getPassword());
		firstNameField.sendKeys(user.getFirstName());
		lastNameField.sendKeys(user.getLastName());
		phoneField.sendKeys(user.getPhone());
		selectOneOptionRoleDropdown(role,driver);
		return this;
	}
	
	public UsersPage clicksaveButton(WebDriver driver){
		saveButton.click();		
		return this;		 
	}
	
	public UsersPage fillSearchField(AdminDataInfo receiverUser){
		searchField.clear();
		searchField.sendKeys(receiverUser.getUserName());	
		return this;
	}
	
	public UsersPage clickSearchButton(){
		searchButton.click();		
		return this;		 
	}
	
  public UsersPage clickDeleteButton(WebDriver driver, AdminDataInfo user){
		
		final WebElement deleteButtonWebElement = driver.findElement(By.xpath("//span[contains(.,'"+user.getUserName()+"')]//../..//a[contains(.,'Delete')]"));
		deleteButtonWebElement.click();		
		return this;		 
	}
  
  public UsersPage clickYesButton(WebDriver driver){
		utils.Utils.waitForElemets(2);
		yesButton.click();		
		return this;		 
	}
	
	public GradingFinalizerPage selectOneOptionRoleDropdown(String option, WebDriver driver){	
	    	
		return utils.Utils.selectDropDownOption(By.xpath("(//select[contains(.,'')])[1]"),option,driver,GradingFinalizerPage.class);

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
	
  public Validator ValidateIfUserExist(final WebDriver driver, final AdminDataInfo user){
		
		final WebElement userNameWebElement;
		
		userNameWebElement = driver.findElement(By.xpath("//span[contains(.,'"+user.getUserName()+"')]"));
		
		return new Validator()
		{
			@Override
			public void Validate(){				
					
			Assert.assertTrue(userNameWebElement.getText().equals(user.getUserName()));			
				
			}
		};
	}	

}
