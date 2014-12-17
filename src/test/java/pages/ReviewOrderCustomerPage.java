package pages;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ts.commons.Page;
import com.ts.commons.Validator;

public class ReviewOrderCustomerPage extends Page {
	
	@FindBy(xpath="//h1[contains(.,'Review Order')]")
	private WebElement reviewOrderLabel;
	
	@FindBy(xpath="//button[@id='btnNext']")
	private WebElement nextButton;

	@Override
	public ReviewOrderCustomerPage and() {
		return this;
	}

	@Override
	public ReviewOrderCustomerPage then() {
		return this;
	}
	
	public  OrderConfirmationCustomerPage clickNextButton(WebDriver driver){
	    utils.Utils.iselementPresent(driver, By.xpath("//tr/td[contains(.,'AA')]"));
	    while(utils.Utils.iselementPresent(driver, By.xpath("//button[@id='btnNext' and @disabled='disabled']"))){
			utils.Utils.waitForElemets(1);
		}
		nextButton.click();
		OrderConfirmationCustomerPage orderConfirmationCustomerPage = PageFactory.initElements(driver, OrderConfirmationCustomerPage.class);
		return orderConfirmationCustomerPage;		 
	}
	
	public boolean  shippingInformationLabel( String shipping, WebDriver driver) {		
				    
		while(utils.Utils.iselementPresent(driver, By.xpath("//span[text()='"+shipping+ "']"))){
			
			return false;		
		} 
		return true;
		
	}
	
	
	
	public  Validator validateShippingInformation(final String shipping,final WebDriver driver){
		return new Validator()
		{
			@Override
			public void Validate(){
				
			Assert.assertTrue(shippingInformationLabel(shipping,driver));
				
			}
		};  
				 
	}

	public Validator reviewOrderLabelMustBePresent(WebDriver driver){
	utils.Utils.iselementPresent(driver, By.xpath("//tr/td[contains(.,'AA')]"));
	return new Validator()
	{
		@Override
		public void Validate(){				
			
			boolean thereIsAReviewOrderLabel = reviewOrderLabel !=null;
			Assert.assertTrue(thereIsAReviewOrderLabel);
			
		}
	};
	
	}	

}
