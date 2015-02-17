package pages;

import org.testng.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ts.commons.Page;
import com.ts.commons.Validator;

public class MyAccountPage extends Page {
	
	@FindBy(xpath="//a[text()='Address Information']")
	private WebElement addressInformationTab;
	
	@FindBy(xpath="//a[text()='Manage your Credit Card']")
	private WebElement manageyourCreditCardTab;
		
	@FindBy(xpath="//h3[text()='Order List Information']")
	private WebElement orderListInformationLabel;
	
	@FindBy(xpath="//a[text()='Orders']")
	private WebElement ordersTab;
	
	@FindBy(xpath="//a[@href='#changePasswordTab' and text()='Change Password']")
	private WebElement changePasswordTab;

	@Override
	public MyAccountPage and() {
		return this;
	}

	@Override
	public MyAccountPage then() {
		return this;
	}
	
	
	public AddressesInformationCustomerPage clickAddressInformationTab(WebDriver driver){			
		addressInformationTab.click();		
		AddressesInformationCustomerPage addressesInformationCustomerPage= PageFactory.initElements(driver, AddressesInformationCustomerPage.class);
		return addressesInformationCustomerPage;		 
	}	
	

	public ManageYourCreditCardPage clickManageYourCreditCardTab(WebDriver driver){			
		manageyourCreditCardTab.click();		
		ManageYourCreditCardPage manageYourCreditCardPage= PageFactory.initElements(driver, ManageYourCreditCardPage.class);
		return manageYourCreditCardPage;		 
	}	
	
	public ChangePasswordPage clickChangePasswordTab(WebDriver driver){			
		changePasswordTab.click();		
		ChangePasswordPage changePasswordPage= PageFactory.initElements(driver, ChangePasswordPage.class);
		return changePasswordPage;		 
	}	
	
	public Validator ordersTabMustBePresent(){
		return new Validator()
		{
			@Override
			public void Validate(){	
					
				boolean thereIsAnOrdersTab = ordersTab !=null;
				Assert.assertTrue(thereIsAnOrdersTab);
				
			}
		};
	}	
	
	public Validator orderListInformationLabelMustBePresent(){
		return new Validator()
		{
			@Override
			public void Validate(){	
					
				boolean thereIsAnOrderListInformationLabel = orderListInformationLabel !=null;
				Assert.assertTrue(thereIsAnOrderListInformationLabel);
				
			}
		};
	}	
	

}
