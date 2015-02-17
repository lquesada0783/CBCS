package pages;

import org.testng.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ts.commons.Page;
import com.ts.commons.Validator;

public class TierDetailsShippingPage extends Page {
	
	@FindBy(xpath="//h1[contains(.,'Tier Details')]")
	private WebElement tierDetailsLabel;
	
	@FindBy(xpath="//input[@id='txtTrackingNumber']")
	private WebElement trackingNumberField;	
	
	@FindBy(xpath="//button[@name='SaveTrackingNumber']")
	private WebElement saveTrackingNumberButton;
	
	@FindBy(xpath="//button[@name='notifyClient']")
	private WebElement notifyClientButton;
	
	@FindBy(xpath="//div[@id='operationResult' and contains(.,'Traking number added successfully.') and @style='display: block;']")
	private WebElement trakingSuccessfullyMessage;	
	
	@FindBy(xpath="//div[@id='operationResult' and contains(.,'A notification was successfully sended to the client.') and @style='display: block;']")
	private WebElement notificationSuccessfullyMessage;	
	
	@FindBy(xpath="//div[text()='You already send a notification to this client.']")
	private WebElement sendNotificationLabel;
	
	@FindBy(xpath="Tier status was changed successfully.")
	private WebElement changedTierStatusMessage;
	
	@FindBy(xpath="//a[@id='lnkBack']")
	private WebElement backToOrderButton;			
	
	@FindBy(xpath="//a[@id='lnkBack']")
	private WebElement backButton;

	@FindBy(xpath="//button[@name='btnChangeStatustoShipping' and text()='Send to Shipping']")
	private WebElement sendToShippingButton;
	
	@Override
	public TierDetailsShippingPage and() {		
		return this;
	}

	@Override
	public TierDetailsShippingPage then() {	
		return this;
	}
	
	public  TierDetailsShippingPage cleanFields(){ 
	    trackingNumberField.clear();
		return this;
	}
	
	public  TierDetailsShippingPage clickSendToShippingButton(){ 
		sendToShippingButton.click();
		return this;
	}	
	
	public  TierDetailsShippingPage fillTrackingNumberField(String trackingNumber, WebDriver driver){ 
	    utils.Utils.iselementPresent(driver, By.xpath("(//td/span[@class='ng-binding'])[1]"));
	    cleanFields();
	    trackingNumberField.sendKeys(trackingNumber);
		return this;
	}
	
	public  TierDetailsShippingPage clickSaveButton(){ 
		    saveTrackingNumberButton.click();
			return this;
	}
	
	public  TierDetailsShippingPage clickNotifyClientButton(){ 
		utils.Utils.waitForElemets(1);
		notifyClientButton.click();
		return this;
	}
	
	public  ProcessOrderShippingPage clickBackButton(WebDriver driver){ 
		backButton.click();
		ProcessOrderShippingPage processOrderShippingPage=PageFactory.initElements(driver, ProcessOrderShippingPage.class);
		return processOrderShippingPage;
	}
		
		
	public ProcessOrderShippingPage clickBackToOrderButton(WebDriver driver){
		backToOrderButton.click();
		ProcessOrderShippingPage processOrderShippingPage= PageFactory.initElements(driver, ProcessOrderShippingPage.class);
		return processOrderShippingPage;
	}		
		
	public Validator tierDetailsLabelMustBePresent(){
			return new Validator()
			{
				@Override
				public void Validate(){			
					
					boolean thereIsATierDetailsLabel = tierDetailsLabel !=null;
					Assert.assertTrue(thereIsATierDetailsLabel);
					
				}
			};
		}	
		
	public Validator trakingSuccessfullyMessageMustBePresent(){
			return new Validator()
			{
				@Override
				public void Validate(){	
						
					boolean thereIsAMessageLabel = trakingSuccessfullyMessage !=null;
					Assert.assertTrue(thereIsAMessageLabel);
					
				}
			};
		}	
		
	public Validator changedTierStatusMessageMustBePresent(){
			return new Validator()
			{
				@Override
				public void Validate(){	
						
					boolean thereIsAChangedTierStatusMessage = changedTierStatusMessage !=null;
					Assert.assertTrue(thereIsAChangedTierStatusMessage);
					
				}
			};
	}
		
	public Validator notificationMessageAndLabelMustBePresent(){
			return new Validator()
			{
				@Override
				public void Validate(){	
					
					boolean thereIsANotificationSuccessfullyMessage = notificationSuccessfullyMessage !=null;
					Assert.assertTrue(thereIsANotificationSuccessfullyMessage);
					
					boolean thereIsASendNotificationLabel = sendNotificationLabel !=null;
					Assert.assertTrue(thereIsASendNotificationLabel);
					
					
				}
			};
		}
	
		
}
