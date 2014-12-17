package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ts.commons.Page;
import com.ts.commons.Validator;

public class AddressesInformationPage extends Page {
	
	@FindBy(xpath="//h2[contains(.,'Addresses Information')]")
    private WebElement addressesInformationLabel;
	
	@FindBy(xpath="//button[@id='btnNext']")	
	private WebElement nextButton;
	
	@Override
	public AddressesInformationPage and() {
		return this;
	}

	@Override
	public AddressesInformationPage then() {
		return this;
	}
	
	public AddressesInformationPage selectBillingAddress(String option, WebDriver driver){		
		utils.Utils.iselementPresent(driver, By.xpath( "(//div[text()='SubTotal']/../..//div[contains(.,'USD ')])[1]" ));
		return utils.Utils.selectBillingAddressOption(option,driver,AddressesInformationPage.class);		
	
	}
	
	public AddressesInformationPage selectShippingAddress(String option, WebDriver driver){		
		
		return utils.Utils.selectShippingAddressOption(option,driver,AddressesInformationPage.class);		
	
	}
	
	 public AddressesInformationPage selectOneOptionShippingProviderDropdown(String option, WebDriver driver){	
	    	
			return utils.Utils.selectDropDownOption(By.xpath("(//select[contains(.,'Shipping Provider')])[1]"),option,driver,AddressesInformationPage.class);

	}
	 
	public  PaymentMethodPage clickNextButton(WebDriver driver){
			utils.Utils.iselementPresent(driver, By.xpath("(//div[text()='Shipping']/../..//div[text()='USD $20.00'])[1]"));
			nextButton.click();
			PaymentMethodPage paymentMethodPage= PageFactory.initElements(driver, PaymentMethodPage.class);
			return paymentMethodPage;		 
	}
	    
	
	public Validator addressesInformationLabelMustBePresent(){
		return new Validator()
		{
			@Override
			public void Validate(){				
				
				boolean thereIsAnAddressesInformationLabel = addressesInformationLabel !=null;
				Assert.assertTrue(thereIsAnAddressesInformationLabel);
				
			}
		};
	}	

}
