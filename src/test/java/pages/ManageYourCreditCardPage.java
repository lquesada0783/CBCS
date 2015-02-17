package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.ts.commons.Page;
import com.ts.commons.Validator;

public class ManageYourCreditCardPage extends Page {
	
	@FindBy(xpath="//th[contains(.,'Credit Card')]")
    private WebElement creditCardLabel;
	
	@FindBy(xpath="//a[@class='btn btn-primary btnTitle' and contains(.,'Add New')]")
	private WebElement addNewButton;
	
	@FindBy(xpath="//h4[@class='modal-title ng-binding' and text()='Add Credit Card']")
	private WebElement addCreditCardlabel;
	
	@FindBy(xpath="//input[@name='txtCreditCardNumber']")
	private WebElement creditCardNumberField;
	
	@FindBy(xpath="//input[@name='txtCreditCardHolderFirstName']")
	private WebElement fullNameField;
	
	@FindBy(xpath="//input[@name='txtCreditCardcvv2']")
	private WebElement cvv2Field;	
	
	@FindBy(xpath="//h4[text()='Add Credit Card'] /../..//button[@class='btn btn-primary' and contains(.,'Save')]")
	private WebElement saveButton;	
	
	@FindBy(xpath="//div[@id='operationResult' and contains(.,'Credit Card added successfully.') and @style='display: block;']")
	private WebElement addCreditCardSuccessfullyMessage;
	
	@FindBy(xpath="//div[@id='operationResult' and contains(.,'Credit Card deleted successfully.') and @style='display: block;']")
	private WebElement deletedCreditCardSuccessfullyMessage;
	
	@FindBy(xpath="//button[@class='btn btn-primary' and text()='Yes']")
	private WebElement yesButton;
	
	
	@Override
	public ManageYourCreditCardPage and() {
		
		return this;
	}

	@Override
	public ManageYourCreditCardPage then() {
		
		return this;
	}
	
	public ManageYourCreditCardPage clickAddNewButton(){
		addNewButton.click();
		return this;
	}
	
	public ManageYourCreditCardPage clickSaveButton(){
		saveButton.click();
		return this;
	}
	
	public ManageYourCreditCardPage fillFieldsForNewCreditCard(String creditCardNumber, String name, String cvv2){
		creditCardNumberField.sendKeys(creditCardNumber);
		fullNameField.sendKeys(name);
		cvv2Field.sendKeys(cvv2);
		return this;
	}
	
	public ManageYourCreditCardPage clickYesButton(){
		utils.Utils.waitForElemets(1);
		yesButton.click();
		return this;
	}
	
	
	public ManageYourCreditCardPage clickDeleteButton(String creditCardNumber, WebDriver driver){
		utils.Utils.waitForElemets(2);
		driver.findElement(By.xpath("//span[@class='ng-binding' and text()='"+creditCardNumber+"']/../..//a[text()='Delete']")).click();
		return this;
	}	
	
	public ManageYourCreditCardPage selectOneOptionMonthDropdown(String monthOption, WebDriver driver){		
    	
		return utils.Utils.selectDropDownOption(By.xpath("//select[@name='cmbCreditCardDateMonth']"), monthOption ,driver,ManageYourCreditCardPage.class);
	
	
	}	
	
	public ManageYourCreditCardPage selectOneOptionYearDropdown(String yearOption, WebDriver driver){		
    	
		return utils.Utils.selectDropDownOption(By.xpath("//select[@name='cmbCreditCardDateYear']"), yearOption ,driver,ManageYourCreditCardPage.class);

	}	
	
	public boolean  existsCreditCard (String creditCardNumber, WebDriver driver) {
		
		utils.Utils.waitForElemets(2);		    
		while(utils.Utils.iselementPresent(driver, By.xpath("//span[@class='ng-binding' and text()='"+creditCardNumber+"']"))){
			
			return false;		
		} 
		return true;
		
	}
	
	public Validator validateExistsCreditCard(final String creditCardNumber, final WebDriver driver ){			

		return new Validator()
		{
			@Override
			public void Validate(){				
				
			Assert.assertTrue(existsCreditCard(creditCardNumber,driver));
				
			}
		};
	}
	
	public Validator creditCardLabelMustBePresent(){
		return new Validator()
		{
			@Override
			public void Validate(){				
				
				boolean thereIsACreditCardLabel = creditCardLabel !=null;
				Assert.assertTrue(thereIsACreditCardLabel);
				
			}
		};
	}
	
	public Validator addCreditCardlabelMustBePresent(){
		return new Validator()
		{
			@Override
			public void Validate(){				
				
				boolean thereIsAnAddCreditCardlabel = addCreditCardlabel !=null;
				Assert.assertTrue(thereIsAnAddCreditCardlabel);
				
			}
		};
	}
	
	public Validator deletedCreditCardlabelMustBePresent(){
		return new Validator()
		{
			@Override
			public void Validate(){				
				
				boolean thereIsADeletedCreditCardSuccessfullyMessage = deletedCreditCardSuccessfullyMessage !=null;
				Assert.assertTrue(thereIsADeletedCreditCardSuccessfullyMessage);
				
			}
		};
	}

}
