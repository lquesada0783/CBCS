package pages;

import org.testng.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ts.commons.Page;
import com.ts.commons.Validator;

public class ProcessOrderShippingPage extends Page {
	
	@FindBy(xpath="//h1[contains(.,'Process Order')]")
	private WebElement processOrderLabel;
	
	@FindBy(xpath="//input[@name='txtInvoiceSubmissionNumber']")
	private WebElement invoiceOrOrderNumberField;
	
	@FindBy(xpath="//button[@name='Search']")
	private WebElement searchButton;	
	
	@Override
	public ProcessOrderShippingPage and() {
		return this;
	}

	@Override
	public ProcessOrderShippingPage then() {
			return this;
	}
	
	public ProcessOrderShippingPage clearFields(){
		invoiceOrOrderNumberField.clear();
		return this;
	}
	
	public ProcessOrderShippingPage fillInvoiceOrOrderNumberField(String orderNumber){
		clearFields();
		invoiceOrOrderNumberField.sendKeys(utils.Utils.substringOrderNumber(orderNumber));
		return this;
	}
	
	public ProcessOrderShippingPage clickSearchButton(){
		searchButton.click();
		return this;
	}	
	
	public TierDetailsShippingPage clickDetailsLink(String invoiceNumber, WebDriver driver){
			
		    WebElement element = driver.findElement(By.xpath("//span[text()='"+invoiceNumber+"']/../../td/a[text()='Details']"));
			element.click();
			TierDetailsShippingPage tierDetailsShippingPage = PageFactory.initElements(driver, TierDetailsShippingPage.class);
			return tierDetailsShippingPage;		
		
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
