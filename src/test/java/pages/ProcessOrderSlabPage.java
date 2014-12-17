package pages;

import java.util.List;

import org.testng.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ts.commons.Page;
import com.ts.commons.Validator;

public class ProcessOrderSlabPage extends Page {
	
	@FindBy(xpath="//h1[contains(.,'Process Order')]")
	private WebElement processOrderLabel;
	
	@FindBy(xpath="//input[@name='txtInvoiceSubmissionNumber']")
	private WebElement invoiceOrOrderNumberField;
	
	@FindBy(xpath="//button[@name='Search']")
	private WebElement searchButton;		
	
	@Override
	public ProcessOrderSlabPage and() {		
		return this;
	}

	@Override
	public ProcessOrderSlabPage then() {
		return this;
	}
	
	public ProcessOrderSlabPage clearFields(){
		invoiceOrOrderNumberField.clear();
		return this;
	}
	
	public ProcessOrderSlabPage fillInvoiceOrOrderNumberField(String orderNumber){
		clearFields();
		invoiceOrOrderNumberField.sendKeys(utils.Utils.substringOrderNumber(orderNumber));
		return this;
	}
	
	public ProcessOrderSlabPage clickSearchButton(){
		searchButton.click();
		return this;
	}	
	
	public TierDetailsSlabPage clickDetailsLink(String option, WebDriver driver){
			
			WebElement element = driver.findElement(By.xpath("(//td[contains(.,'Details')])["+option+"]/a"));	
			element.click();
			TierDetailsSlabPage tierDetailsSlabPage = PageFactory.initElements(driver, TierDetailsSlabPage.class);
			return tierDetailsSlabPage;		
		
	}
	
	public Validator checkTierStatus(String invoiceNumber, String orderStatus, WebDriver driver){
		
		return utils.Utils.validateTierStatus(invoiceNumber, orderStatus, driver);
	
	}
	
	
	public Validator processOrderLabelMustBePresent(){
		return new Validator()
		{
			@Override
			public void Validate(){				
				
				boolean thereIsAnProcessOrderLabel= processOrderLabel !=null;
				Assert.assertTrue(thereIsAnProcessOrderLabel);
				
			}
		};
	}
	
	public Validator orderNumberLabelMustBePresent(final String orderNumber,final WebDriver driver){
		return new Validator()
		{
			@Override
			public void Validate(){				
				
			Assert.assertTrue(isOrderNumberLabelPresent(orderNumber,driver));
				
			}
		};
	}
	
	public boolean  isOrderNumberLabelPresent( String invoiceNumber, WebDriver driver) {
		utils.Utils.waitForElemets(1);
		String orderNumber=utils.Utils.substringOrderNumber(invoiceNumber);
		List<WebElement> list = driver.findElements(By.xpath("//label[text()='"+orderNumber+"']"));

		for(WebElement element : list){
			if(element.getText().toString().equals(orderNumber))
			{
				return true;
			}
		}
		
		
		return false;
	}	
	
	
	public boolean  isOrderStatusLabelPresent( String orderStatus, WebDriver driver) {
		utils.Utils.waitForElemets(1);	
		List<WebElement> list = driver.findElements(By.xpath("//td/span[text()='"+orderStatus+"']"));

		for(WebElement element : list){
			if(element.getText().toString().equals(orderStatus))
			{
				return true;
			}
		}
		
		
		return false;
	}	
	

 public Validator orderStatusLabelMustBePresent(final String orderStatus,final WebDriver driver ){
		
		return new Validator()
		{
			@Override
			public void Validate(){				
				
			Assert.assertTrue(isOrderStatusLabelPresent(orderStatus,driver));
				
			}
		};
	}


}
