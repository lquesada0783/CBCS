package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import object.OrderDataInfo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.ts.commons.Page;
import com.ts.commons.Validator;

public class OrderConfirmationCustomerPage extends Page {
	
	@FindBy(xpath="//h2[contains(.,'Order Confirmation')]")
	private WebElement orderConfirmationLabel;
	
	@FindBy(xpath="//button[text()='OK']")
	private WebElement okButton;
	
	@FindBy(xpath="//button[@id='btnNext']")
	private WebElement printReceiptButton;
	
	@FindBy(xpath="//p[text()='You must print a copy of the submission form receipt and include it with your submission.']")
	private WebElement warningMessage;	
	
	@FindBy(xpath="(//tr/td[@class='ng-binding'])[1]")
	private WebElement orderNumber;
	
	//@FindBy(xpath="//div[@id='operationResult' and contains(.,'The pdf file was created successfully.') and @style='display: block;']")
	//private WebElement successfullyMessage;

	@Override
	public OrderConfirmationCustomerPage and() {
		return this;
	}

	@Override
	public OrderConfirmationCustomerPage then() {
		return this;
	}
	
	public  OrderConfirmationCustomerPage clickOkButton(WebDriver driver){
		okButton.click();
		
		/*while(!utils.Utils.iselementPresent(driver, By.xpath("//button[@id='btnBack' and @ng-disabled='progress']"))){
			utils.Utils.waitForElemets(1);
		}	
		
		utils.Utils.refreshPage(driver);				
		okButton.click();*/
		
			Robot robot;
			try {
				robot = new Robot();				
				robot.keyPress(KeyEvent.VK_ENTER);				
			} catch (AWTException e) {
                
                throw  new RuntimeException(e.getMessage());
        } 			
		return this;		 
    }	
	
	public  OrderConfirmationCustomerPage clickPrintReceiptButton(WebDriver driver){
		printReceiptButton.click();		
		return this;		 
    }
	
	public  OrderConfirmationCustomerPage writeOnderNumber(WebDriver driver,OrderDataInfo order){
		utils.Utils.write(driver, saveOrederNumber(order));			
		return this;		 
    }	
		
   public String saveOrederNumber(OrderDataInfo order){
	   String value=orderNumber.getText();		
	   order.setOrderNumber(value.substring(0,10));	 
	   return order.getOrderNumber();
		
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
	
	public Validator warningMessageMustBePresent(){
		return new Validator()
		{
			@Override
			public void Validate(){	
					
				boolean thereIsAWarningMessage = warningMessage !=null;
				Assert.assertTrue(thereIsAWarningMessage);
				
			}
		};
	}

}
