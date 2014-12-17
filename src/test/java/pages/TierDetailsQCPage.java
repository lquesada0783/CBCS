package pages;

import org.testng.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ts.commons.Page;
import com.ts.commons.Validator;

public class TierDetailsQCPage extends Page {
	
	@FindBy(xpath="//h1[contains(.,'Tier Details')]")
	private WebElement tierDetailsLabel;
	
	@FindBy(xpath="//input[@id='chkQCFinished']")
	private WebElement qcFinishedCheckbox;	
	
	@FindBy(xpath="//div[@id='operationResult' and contains(.,'Comic updated successfully.') and @style='display: block;']")
	private WebElement messageLabel;		

	@FindBy(xpath="//a[@id='lnkBack']")
	private WebElement backToOrderButton;	
	
		
	@Override
	public TierDetailsQCPage and() {
		return this;
	}

	@Override
	public TierDetailsQCPage then() {
		return this;
	}
	
	public  TierDetailsQCPage clickQCFinishedCheckbox(WebDriver driver){ 
	utils.Utils.iselementPresent(driver, By.xpath("(//td/a[contains(.,'View')])[1]"));
		qcFinishedCheckbox.click();
		return this;
	}
	
	public ProcessOrderQCPage clickBackToOrderButton(WebDriver driver){
		backToOrderButton.click();
		ProcessOrderQCPage processOrderQCPage= PageFactory.initElements(driver, ProcessOrderQCPage.class);
		return processOrderQCPage;
	}
	
	public Validator tierDetailsLabelMustBePresent(){
		return new Validator()
		{
			@Override
			public void Validate(){			
				
				boolean thereIsAnTierDetailsLabel = tierDetailsLabel !=null;
				Assert.assertTrue(thereIsAnTierDetailsLabel);
				
			}
		};
	}	
	
	public Validator messageLabelMustBePresent(){
		return new Validator()
		{
			@Override
			public void Validate(){	
					
				boolean thereIsAMessageLabel = messageLabel !=null;
				Assert.assertTrue(thereIsAMessageLabel);
				
			}
		};
	}	

}
