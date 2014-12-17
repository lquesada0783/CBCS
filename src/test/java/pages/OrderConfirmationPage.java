package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.ts.commons.Page;
import com.ts.commons.Validator;

public class OrderConfirmationPage extends Page {
	
	@FindBy(xpath="//h2[contains(.,'Order Confirmation')]")
	private WebElement orderConfirmationLabel;
	
	@FindBy(xpath="//div[@class='bootstrap-dialog-footer-buttons']//button[contains(.,'OK')]")
	private WebElement okButton;
	
	@FindBy(xpath="//button[@id='btnNext']")
	private WebElement printReceiptButton;
	
	@FindBy(xpath="//div[@id='operationResult' and contains(.,'The pdf file was created successfully.') and @style='display: block;']")
	private WebElement successfullyMessage;
	
	@Override
	public OrderConfirmationPage and() {
		return this;
	}

	@Override
	public OrderConfirmationPage then() {
		return this;
	}
	
	public  OrderConfirmationPage clickOkButton(WebDriver driver){
		utils.Utils.iselementPresent(driver, By.xpath("//tr/td[contains(.,'AA')]"));
		okButton.click();		
		return this;		 
    }
	
	public  OrderConfirmationPage clickPrintReceiptButton(WebDriver driver){
		printReceiptButton.click();		
		return this;		 
    }

	
	public Validator orderConfirmationLabelMustBePresent(){
		return new Validator()
		{
			@Override
			public void Validate(){				
				
				boolean thereIsAnOrderConfirmationLabel = orderConfirmationLabel !=null;
				Assert.assertTrue(thereIsAnOrderConfirmationLabel);
				
			}
		};
	}
	
	public Validator successfullyMessageMustBePresent(){
		return new Validator()
		{
			@Override
			public void Validate(){	
					
				boolean thereIsAsuccessfullyMessage = successfullyMessage !=null;
				Assert.assertTrue(thereIsAsuccessfullyMessage);
				
			}
		};
	}	

}
