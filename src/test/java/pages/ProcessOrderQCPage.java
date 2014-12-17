package pages;

import org.testng.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ts.commons.Page;
import com.ts.commons.Validator;

public class ProcessOrderQCPage extends Page {
	
	@FindBy(xpath="//h1[contains(.,'Process Order')]")
	private WebElement processOrderLabel;
	
	@FindBy(xpath="//input[@name='txtInvoiceSubmissionNumber']")
	private WebElement invoiceOrOrderNumberField;
	
	@FindBy(xpath="//button[@name='Search']")
	private WebElement searchButton;	

	@Override
	public ProcessOrderQCPage and() {
		return this;
	}

	@Override
	public ProcessOrderQCPage then() {
		return this;
	}
	
	public ProcessOrderQCPage clearFields(){
		invoiceOrOrderNumberField.clear();
		return this;
	}
	
	public ProcessOrderQCPage fillInvoiceOrOrderNumberField(String orderNumber){
		clearFields();
		invoiceOrOrderNumberField.sendKeys(utils.Utils.substringOrderNumber(orderNumber));
		return this;
	}
	
	public ProcessOrderQCPage clickSearchButton(){
		searchButton.click();
		return this;
	}	
	
	public TierDetailsQCPage clickDetailsLink(String option, WebDriver driver){
			
			WebElement element = driver.findElement(By.xpath("(//td[contains(.,'Details')])["+option+"]/a"));	
			element.click();
			TierDetailsQCPage tierDetailsQCPage = PageFactory.initElements(driver, TierDetailsQCPage.class);
			return tierDetailsQCPage;		
		
	}	
	
	
	public Validator validateOrderNumber(String orderNumber, WebDriver driver){
		
		return utils.Utils.validateOrderNumber(utils.Utils.substringOrderNumber(orderNumber), driver);
	
	}
	
	public Validator checkTierStatus(String invoiceNumber, String orderStatus, WebDriver driver){
		
		return utils.Utils.validateTierStatus(invoiceNumber, orderStatus, driver);
	
	}
	
	public Validator processOrderLabelMustBePresent(){
		return new Validator()
		{
			@Override
			public void Validate(){			
				
				boolean thereIsAProcessOrderLabel = processOrderLabel !=null;
				Assert.assertTrue(thereIsAProcessOrderLabel);
				
			}
		};
	}	

}
