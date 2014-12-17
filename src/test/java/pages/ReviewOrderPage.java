package pages;

import org.testng.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ts.commons.Page;
import com.ts.commons.Validator;

public class ReviewOrderPage extends Page {
	
	@FindBy(xpath="//h1[contains(.,'Review Order')]")
	private WebElement reviewOrderLabel;
	
	@FindBy(xpath="//button[@id='btnNext']")
	private WebElement nextButton;


	@Override
	public ReviewOrderPage and() {
		return this;
	}

	@Override
	public ReviewOrderPage then() {
		return this;
	}
		 
	public  OrderConfirmationPage clickNextButton(WebDriver driver){
		    utils.Utils.iselementPresent(driver, By.xpath("//tr/td[contains(.,'AA')]"));
			nextButton.click();
			OrderConfirmationPage orderConfirmationPage = PageFactory.initElements(driver, OrderConfirmationPage.class);
			return orderConfirmationPage;		 
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
