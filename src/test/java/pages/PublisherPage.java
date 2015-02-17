package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.ts.commons.Page;
import com.ts.commons.Validator;

public class PublisherPage extends Page {	
	
	@FindBy(xpath="//h1[contains(.,'Publisher')]")
	private WebElement publisherLabel;
	
	@FindBy(xpath="//a[@class='btn btn-small']")
	private WebElement newButton;
	
	@FindBy(xpath="//input[@name='name']")
	private WebElement nameField;
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement saveButton;
	
	@FindBy(xpath="//div[@id='operationResult' and contains(.,'Publisher added successfully.') and @style='display: block;']")
	private WebElement addedPublisherSuccessfullyMessage;
	
	@FindBy(xpath=".//*[@id='searchingInput']")
	private WebElement searchField;
	
	@FindBy(xpath="//button[@name='Search']")
	private WebElement searchButton;
	
	@FindBy(xpath="//button[contains(.,'Yes')]")
	private WebElement yesButton;
	
	@FindBy(xpath="//div[@id='operationResult' and contains(.,'Publisher deleted successfully.') and @style='display: block;']")
	private WebElement deletedPublisherSuccessfullyMessage;
	
	@FindBy(xpath="//div[@id='operationResult' and contains(.,'Publisher updated successfully.') and @style='display: block;']")
	private WebElement editPublisherSuccessfullyMessage;
	
	@FindBy(xpath="//input[@name='name']")
	private WebElement editPublisherNameField;

	@Override
	public PublisherPage and() {	
		return this;
	}

	@Override
	public PublisherPage then() {		
		return this;
	}
	
	public PublisherPage clickNewButton(WebDriver driver){
		newButton.click();		
		return this;		 
	}
	
	public PublisherPage fillFieldsAddPublisherModal(String publisherName){
		nameField.clear();
		nameField.sendKeys(publisherName);	
		return this;
	}
	
	public PublisherPage fillFieldsEditPublisherModal(String newPublisherName){
		utils.Utils.waitForElemets(1);
		editPublisherNameField.clear();
		editPublisherNameField.sendKeys(newPublisherName);	
		return this;
	}	
	
	public PublisherPage clickSaveButton( ){
		saveButton.click();		
		return this;		 
	}
		
	public PublisherPage fillSearchField(String publisherName){
		searchField.clear();
		searchField.sendKeys(publisherName);	
		return this;
	}
	
	public PublisherPage clickSearchButton(WebDriver driver){
		searchButton.click();		
		return this;		 
	}
	
	public PublisherPage clickDeleteButton(WebDriver driver, String publisherName){
		
		final WebElement deleteButtonWebElement = driver.findElement(By.xpath("//span[contains(.,'"+publisherName+"')]//../..//a[contains(.,'Delete')]"));
		deleteButtonWebElement.click();	
		
		return this;		 
	}
	
  public PublisherPage clickEditButton(WebDriver driver, String publisherName){
	    utils.Utils.waitForElemets(1);
		final WebElement editButtonWebElement = driver.findElement(By.xpath("//span[contains(.,'"+publisherName+"')]//../..//a[contains(.,'Edit')]"));
		editButtonWebElement.click();	
		
		return this;		 
	}
	
	public PublisherPage clickYesButton(WebDriver driver){
		utils.Utils.waitForElemets(2);
		yesButton.click();		
		return this;		 
	}


	public Validator PublisherLabelMustBePresent(){
		return new Validator()
		{
			@Override
			public void Validate(){				
				
				boolean thereIsAnPublisherLabel = publisherLabel !=null;
				Assert.assertTrue(thereIsAnPublisherLabel);
				
			}
		};
	}
	
	public Validator addedPublisherSuccessfullyMessageMustBePresent(){
		return new Validator()
		{
			@Override
			public void Validate(){				
					
				boolean thereIsAnAddedPublisherSuccessfullyMessage = addedPublisherSuccessfullyMessage !=null;
				Assert.assertTrue(thereIsAnAddedPublisherSuccessfullyMessage);			
				
			}
		};
	}
	
	public Validator ValidateIfPublisherExist(final WebDriver driver, final String publisherName){
		
		final WebElement publisherWebElement;
		
		publisherWebElement = driver.findElement(By.xpath("//span[contains(.,'"+publisherName+"')]"));
		
		return new Validator()
		{
			@Override
			public void Validate(){				
					
			Assert.assertTrue(publisherWebElement.getText().equals(publisherName));			
				
			}
		};
	}
	
	public Validator deletedPublisherSuccessfullyMessageMustBePresent(){
		return new Validator()
		{
			@Override
			public void Validate(){				
					
				boolean thereIsAnDeletedPublisherSuccessfullyMessage = deletedPublisherSuccessfullyMessage !=null;
				Assert.assertTrue(thereIsAnDeletedPublisherSuccessfullyMessage);			
				
			}
		};
	}
	
	public Validator editPublisherSuccessfullyMessageMustBePresent(){
		return new Validator()
		{
			@Override
			public void Validate(){				
					
				boolean thereIsAnEditPublisherSuccessfullyMessage = editPublisherSuccessfullyMessage !=null;
				Assert.assertTrue(thereIsAnEditPublisherSuccessfullyMessage);			
				
			}
		};
	}

}
