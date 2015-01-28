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
	private WebElement trakingSuccessfullyMessageLabel;	
	
	/*@FindBy(xpath="//div[@id='operationResult' and contains(.,'A notification was successfully sended to the client.') and @style='display: block;']")
	private WebElement notificationSuccessfullyMessageLabel;*/	
	
	@FindBy(xpath="//div[text()='You already send a notification to this client.']")
	private WebElement sendNotificationMessageLabel;
	
	@FindBy(xpath="//a[@id='lnkBack']")
	private WebElement backToOrderButton;			
	
	@FindBy(xpath="//a[@id='lnkBack']")
	private WebElement backButton;

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
	
	public  TierDetailsShippingPage clicknotifyClientButton(){ 
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
		
	public Validator trakingSuccessfullyMessageLabelMustBePresent(){
			return new Validator()
			{
				@Override
				public void Validate(){	
						
					boolean thereIsAMessageLabel = trakingSuccessfullyMessageLabel !=null;
					Assert.assertTrue(thereIsAMessageLabel);
					
				}
			};
		}	
		
		/*public Validator notificationSuccessfullyMessageLabelMustBePresent(){
			return new Validator()
			{
				@Override
				public void Validate(){	
						
					boolean thereIsAnMessageLabel = notificationSuccessfullyMessageLabel !=null;
					Assert.assertTrue(thereIsAnMessageLabel);
					
				}
			};
		}*/
		
	public Validator sendNotificationMessageLabelMustBePresent(){
			return new Validator()
			{
				@Override
				public void Validate(){	
						
					boolean thereIsAnMessageLabel = sendNotificationMessageLabel !=null;
					Assert.assertTrue(thereIsAnMessageLabel);
					
				}
			};
		}
		
}
