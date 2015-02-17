package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.AdminHomePage;
import pages.CustomerHomePage;

import com.ts.commons.Page;

public class UI extends Page {
	
	public static AdminHomePage goToAdminLoginPage (WebDriver driver){
		
		driver.get(Constant.ADMIN_lOGIN_URL);
		
		AdminHomePage goToAdminLoginPage = PageFactory.initElements(driver, AdminHomePage.class);
		return goToAdminLoginPage;
	} 
	
	public static CustomerHomePage goToCustomerLoginPage (WebDriver driver){
		
		driver.get(Constant.CUSTOMER_LOGIN_URL);
		
		CustomerHomePage goToCustomerLoginPage = PageFactory.initElements(driver, CustomerHomePage.class);
		return goToCustomerLoginPage;
	} 

	@Override
	public UI and() {		
		return this;
	}

	@Override
	public UI then() {		
		return this;
	}

}
