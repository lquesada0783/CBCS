package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.ts.commons.Page;
import com.ts.commons.Validator;

public class VariantsPage extends Page {
	
	@FindBy(xpath="//h1[contains(.,'Variant')]")
	private WebElement variantLabel;
	
	@FindBy(xpath="//a[@class='btn btn-small']")
	private WebElement newButton;
	
	@FindBy(xpath="//input[@name='name']")
	private WebElement nameField;
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement saveButton;
	
	@FindBy(xpath="//div[@id='operationResult' and contains(.,'Variant added successfully.') and @style='display: block;']")
	private WebElement addedVariantSuccessfullyMessage;
	
	@FindBy(xpath=".//*[@id='searchingInput']")
	private WebElement searchField;
	
	@FindBy(xpath="//button[@name='Search']")
	private WebElement searchButton;
	
	@FindBy(xpath="//button[contains(.,'Yes')]")
	private WebElement yesButton;
	
	@FindBy(xpath="//div[@id='operationResult' and contains(.,'Variant deleted successfully.') and @style='display: block;']")
	private WebElement deletedVariantSuccessfullyMessage;
	
	@Override
	public VariantsPage and() {
	
		return this;
	}

	@Override
	public VariantsPage then() {
		
		return this;
	}
	
	public VariantsPage clickNewButton(WebDriver driver){
		newButton.click();		
		return this;		 
	}
	
	public VariantsPage fillFieldsAddVariantModal(String variantName){
		nameField.clear();
		nameField.sendKeys(variantName);	
		return this;
	}
	
	public VariantsPage clickSaveButton(WebDriver driver){
		saveButton.click();		
		return this;		 
	}
		
	public VariantsPage fillSearchField(String variantName){
		searchField.clear();
		searchField.sendKeys(variantName);	
		return this;
	}
	
	public VariantsPage clickSearchButton(){
		searchButton.click();		
		return this;		 
	}
	
	public VariantsPage clickDeleteButton(WebDriver driver, String variantName){
		
		final WebElement deleteButtonWebElement = driver.findElement(By.xpath("//span[contains(.,'"+variantName+"')]//../..//a[contains(.,'Delete')]"));
		deleteButtonWebElement.click();		
		return this;		 
	}
	
	public VariantsPage clickYesButton(WebDriver driver){
		utils.Utils.waitForElemets(2);
		yesButton.click();		
		return this;		 
	}


	public Validator VariantLabelMustBePresent(){
		return new Validator()
		{
			@Override
			public void Validate(){				
				
				boolean thereIsAnVariantLabel = variantLabel !=null;
				Assert.assertTrue(thereIsAnVariantLabel);
				
			}
		};
	}
	
	public Validator addedVariantSuccessfullyMessageMustBePresent(){
		return new Validator()
		{
			@Override
			public void Validate(){				
					
				boolean thereIsAnAddedVariantSuccessfullyMessage = addedVariantSuccessfullyMessage !=null;
				Assert.assertTrue(thereIsAnAddedVariantSuccessfullyMessage);			
				
			}
		};
	}
	
	public Validator ValidateIfVariantExist(final WebDriver driver, final String variantName){
		
		final WebElement variantWebElement;
		
		variantWebElement = driver.findElement(By.xpath("//span[contains(.,'"+variantName+"')]"));
		
		return new Validator()
		{
			@Override
			public void Validate(){				
					
			Assert.assertTrue(variantWebElement.getText().equals(variantName));			
				
			}
		};
	}
	
	public Validator deletedVariantSuccessfullyMessageMustBePresent(){
		return new Validator()
		{
			@Override
			public void Validate(){				
					
				boolean thereIsAnDeletedVariantSuccessfullyMessage = deletedVariantSuccessfullyMessage !=null;
				Assert.assertTrue(thereIsAnDeletedVariantSuccessfullyMessage);			
				
			}
		};
	}
	
}
