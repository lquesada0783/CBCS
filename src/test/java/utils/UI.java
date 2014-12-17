package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import signin_logout.AdminLoginPage;
import signin_logout.CBCSHomePage;

import com.ts.commons.Page;

public class UI extends Page {
	
	public static AdminLoginPage goToAdminLoginPage (WebDriver driver){
		
		driver.get(Constant.ADMIN_lOGIN_URL);
		
		AdminLoginPage goToAdminLoginPage = PageFactory.initElements(driver, AdminLoginPage.class);
		return goToAdminLoginPage;
	} 
	
	public static CBCSHomePage goToCustomerLoginPage (WebDriver driver){
		
		driver.get(Constant.CUSTOMER_LOGIN_URL);
		
		CBCSHomePage goToCustomerLoginPage = PageFactory.initElements(driver, CBCSHomePage.class);
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
