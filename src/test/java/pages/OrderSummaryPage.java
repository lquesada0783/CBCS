package pages;

import org.testng.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ts.commons.Page;
import com.ts.commons.Validator;

public class OrderSummaryPage extends Page {
	
	@FindBy(xpath="//h2[contains(.,'Order Summary')]")
    private WebElement orderSummaryLabel;
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement iGreeTermsAndConditionsCheckbox;
	
	@FindBy(xpath="//button[@id='btnNext']")
	private WebElement nextButton;
	
	@Override
	public OrderSummaryPage and() {		
		return this;
	}

	@Override
	public OrderSummaryPage then() {
		return this;
	}
	
	
	public  OrderSummaryPage clickIGreeTermsAndConditionsCheckbox(WebDriver driver ){
		utils.Utils.iselementPresent(driver,By.xpath("//label[text()='Title of Comic: ']"));
		iGreeTermsAndConditionsCheckbox.click();		
		return this;		 
	}
	
	public  AddressesInformationPage clickNextButton(WebDriver driver){
		nextButton.click();
		AddressesInformationPage addressesInformationPage = PageFactory.initElements(driver, AddressesInformationPage.class);
		return addressesInformationPage;		 
	}
	
	 public Validator orderSummaryLabelMustBePresent(){
			return new Validator()
			{
				@Override
				public void Validate(){				
					
					boolean thereIsAnOrderSummaryLabel = orderSummaryLabel !=null;
					Assert.assertTrue(thereIsAnOrderSummaryLabel);
					
				}
			};
		}
	 
}
