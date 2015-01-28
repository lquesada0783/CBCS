package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.ts.commons.Page;
import com.ts.commons.Validator;

public class PedigreesPage extends Page {
	
	@FindBy(xpath="//h1[contains(.,'Pedigrees')]")
	private WebElement pedigreesLabel;
	
	@FindBy(xpath="//a[@class='btn btn-small']")
	private WebElement newButton;
	
	@FindBy(xpath="//input[@name='description']")
	private WebElement descriptionField;
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement saveButton;
	
	@FindBy(xpath="//div[@id='operationResult' and contains(.,'Pedigrees added successfully.') and @style='display: block;']")
	private WebElement addedPedigreesSuccessfullyMessage;
	
	@FindBy(xpath=".//*[@id='searchingInput']")
	private WebElement searchField;
	
	@FindBy(xpath="//button[@name='Search']")
	private WebElement searchButton;
	
	@FindBy(xpath="//button[contains(.,'Yes')]")
	private WebElement yesButton;
	
	@FindBy(xpath="//div[@id='operationResult' and contains(.,'Pedigrees deleted successfully.') and @style='display: block;']")
	private WebElement deletedPedigreeSuccessfullyMessage;

	@Override
	public PedigreesPage and() {		
		return this;
	}

	@Override
	public PedigreesPage then() {		
		return this;
	}
	
	public PedigreesPage clickNewButton(WebDriver driver){
		newButton.click();		
		return this;		 
	}
	
	public PedigreesPage fillFieldsAddPedigreeModal(String pedigreeName){
		utils.Utils.waitForElemets(2);
		descriptionField.clear();
		descriptionField.sendKeys(pedigreeName);	
		return this;
	}
	
	public PedigreesPage clickSaveButton(WebDriver driver){
		saveButton.click();		
		return this;		 
	}
		
	public PedigreesPage fillSearchField(String pedigreeName){
		searchField.clear();
		searchField.sendKeys(pedigreeName);	
		return this;
	}
	
	public PedigreesPage clickSearchButton(WebDriver driver){
		searchButton.click();		
		return this;		 
	}
	
	public PedigreesPage clickDeleteButton(WebDriver driver, String pedigreeName){
		
		final WebElement deleteButtonWebElement = driver.findElement(By.xpath("//span[contains(.,'"+pedigreeName+"')]//../..//a[contains(.,'Delete')]"));
		deleteButtonWebElement.click();		
		return this;		 
	}
	
	public PedigreesPage clickYesButton(WebDriver driver){
		utils.Utils.waitForElemets(2);
		yesButton.click();		
		return this;		 
	}


	public Validator PedigreesLabelMustBePresent(){
		return new Validator()
		{
			@Override
			public void Validate(){				
				
				boolean thereIsAnPedigreesLabel = pedigreesLabel !=null;
				Assert.assertTrue(thereIsAnPedigreesLabel);
				
			}
		};
	}
	
	public Validator addedPedigreesSuccessfullyMessageMustBePresent(){
		return new Validator()
		{
			@Override
			public void Validate(){				
					
				boolean thereIsAnAddedPedigreesSuccessfullyMessage = addedPedigreesSuccessfullyMessage !=null;
				Assert.assertTrue(thereIsAnAddedPedigreesSuccessfullyMessage);			
				
			}
		};
	}
	
	public Validator ValidateIfPedigreeExist(final WebDriver driver, final String pedigreeName){
		
		final WebElement pedigreeWebElement;
		
		pedigreeWebElement = driver.findElement(By.xpath("//span[contains(.,'"+pedigreeName+"')]"));
		
		return new Validator()
		{
			@Override
			public void Validate(){				
					
			Assert.assertTrue(pedigreeWebElement.getText().equals(pedigreeName));			
				
			}
		};
	}
	
	public Validator deletedPedigreeSuccessfullyMessageMustBePresent(){
		return new Validator()
		{
			@Override
			public void Validate(){				
					
				boolean thereIsAnDeletedPedigreeSuccessfullyMessage = deletedPedigreeSuccessfullyMessage !=null;
				Assert.assertTrue(thereIsAnDeletedPedigreeSuccessfullyMessage);			
				
			}
		};
	}

}
