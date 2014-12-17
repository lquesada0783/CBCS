package pages;

import org.testng.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ts.commons.Page;
import com.ts.commons.Validator;

public class PaymentMethodCustomerPage extends Page {
	
	@FindBy(xpath="//h1[contains(.,'Payment Method')]")
	private WebElement paymentMethodLabel;
	
	@FindBy(xpath="//button[@id='btnNext']")
	private WebElement nextButton;

	@Override
	public PaymentMethodCustomerPage and() {
		return this;
	}

	@Override
	public PaymentMethodCustomerPage then() {
		return this;
	}
	
	 public PaymentMethodCustomerPage clickOneOptionPaymentMethodCheckbox(String option, WebDriver driver){	
		 while(utils.Utils.iselementPresent(driver, By.xpath("//button[@id='btnNext' and @disabled='disabled']"))){
				utils.Utils.waitForElemets(1);
		}
		
		 return utils.Utils.clickPaymentMethodCheckbox(option,driver,PaymentMethodCustomerPage.class);

	}
	 
	public  ReviewOrderCustomerPage clickNextButton(WebDriver driver){
		while(utils.Utils.iselementPresent(driver, By.xpath("//button[@id='btnNext' and @disabled='disabled']"))){
			utils.Utils.waitForElemets(1);
		}
		nextButton.click();
		ReviewOrderCustomerPage reviewOrderCustomerPage = PageFactory.initElements(driver, ReviewOrderCustomerPage.class);
		return reviewOrderCustomerPage;		 
	}
	
	public Validator paymentMethodLabelMustBePresent(){
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
