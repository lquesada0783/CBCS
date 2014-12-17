package pages;

import org.testng.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ts.commons.Page;
import com.ts.commons.Validator;

public class TierDetailsSlabPage extends Page {
	
	@FindBy(xpath="//h1[contains(.,'Tier Details')]")
	private WebElement tierDetailsLabel;
	
	@FindBy(xpath="//button[contains(., 'Print All Labels')]")
	private WebElement printAllLabelsButton; 
	
	@FindBy(xpath="//a[@id='lnkBack']")
	private WebElement backToOrderButton;	

	@Override
	public TierDetailsSlabPage and() {
		return this;
	}

	@Override
	public TierDetailsSlabPage then() {
		return this;
	}
	
	public TierDetailsSlabPage clickPrinAllLabelsButton(){
		printAllLabelsButton.click();
		return this;
	}
	
	public ProcessOrderSlabPage clickBackToOrderButton(WebDriver driver){
		backToOrderButton.click();
		ProcessOrderSlabPage processOrderSlabPage= PageFactory.initElements(driver, ProcessOrderSlabPage.class);
		return processOrderSlabPage;
	}
	
	/*public TierDetailsSlabPage clickCancelButton (){
		
		Robot robot;
		try {
			robot = new Robot();
			robot.delay(1000);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.delay(500);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.delay(500);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.delay(500);
			robot.keyPress(KeyEvent.VK_ENTER);		
		
		} catch (AWTException e) {
			
			throw  new RuntimeException(e.getMessage());
		}		
		
		return this;	
	}*/
	
	public Validator tierDetailsLabelMustBePresent(){
		return new Validator()
		{
			@Override
			public void Validate(){
				
				WebElement tierDetailsLabelBePresent = tierDetailsLabel;
				
				boolean thereIsATierDetailsLabel = tierDetailsLabelBePresent !=null;
				Assert.assertTrue(thereIsATierDetailsLabel);
				
			}
		};
	}	

}
