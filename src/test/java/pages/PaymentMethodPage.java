package pages;

import org.testng.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ts.commons.Page;
import com.ts.commons.Validator;

public class PaymentMethodPage extends Page {
	
	@FindBy(xpath="//h1[contains(.,'Payment Method')]")
	private WebElement paymentMethodLabel;
	
	@FindBy(xpath="//button[@id='btnNext']")
	private WebElement nextButton;

	@Override
	public PaymentMethodPage and() {
		return this;
	}

	@Override
	public PaymentMethodPage then() {
		return this;
	}
	
	 public PaymentMethodPage clickOneOptionPaymentMethodCheckbox(String option, WebDriver driver){		
		 	utils.Utils.iselementPresent(driver, By.xpath("//span[@class='bold-label' and contains(.,'Cash')]"));
			return utils.Utils.clickPaymentMethodCheckbox(option,driver,PaymentMethodPage.class);

	}
	 
	public  ReviewOrderPage clickNextButton(WebDriver driver){			   
			nextButton.click();
			ReviewOrderPage reviewOrderPage = PageFactory.initElements(driver, ReviewOrderPage.class);
			return reviewOrderPage;		 
	}
	
	 public Validator paymentMethodLabelMustBePresent(){
		   // utils.Utils.iselementPresent(driver, By.xpath("//div/input[@name='txtCreditCardHolderFirstName' and @disabled='disabled']"));
			return new Validator()
			{
				@Override
				public void Validate(){				
					
					boolean thereIsAPaymentMethodLabel = paymentMethodLabel !=null;
					Assert.assertTrue(thereIsAPaymentMethodLabel);
					
				}
			};
		}	

}
