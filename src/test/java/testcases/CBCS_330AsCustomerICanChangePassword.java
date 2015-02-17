package testcases;

import java.io.IOException;

import jxl.read.biff.BiffException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ts.commons.DataSourceXls;

import pages.ChangePasswordPage;
import pages.CustomerHomePage;
import pages.DashboardCustomerPage;
import pages.MyAccountPage;
import utils.TestCaseCBCS;
import utils.UI;

public class CBCS_330AsCustomerICanChangePassword extends TestCaseCBCS {

	private DashboardCustomerPage dashboardCustomerPage;
	private ChangePasswordPage changePasswordPage;
	private MyAccountPage myAccountPage;
	private CustomerHomePage homePage;
	public static String aPassword = "";
	public static String nPassword = "";
		
	@DataProvider
	public Object[][] data() throws BiffException, IOException {
	return new DataSourceXls("Parameters.xls").getData(20, 2);
	}	
	
	@Test(dataProvider = "data")
	public void asCustomerICanAddANewCreditCardTest(String email, String actualPassword, String newPassword){
		
		aPassword=newPassword;
		nPassword=actualPassword;
		
		using(
				dashboardCustomerPage=(DashboardCustomerPage) UI.goToCustomerLoginPage(getWebDriver())
				.clickLoginLink(getWebDriver())
				.then()
				.fillFieldsForLogin(email ,actualPassword)
				.and()
				.clickSignInButton(getWebDriver())
				
				)
				
		 .check(
			
				 dashboardCustomerPage.welcomeLabelMustBePresent()
						
			  )
			  
		.andUsing(
				
				myAccountPage=dashboardCustomerPage
				.clickMyAccountTab(getWebDriver())
				
				)
				
		
		.check(
			
				myAccountPage.ordersTabMustBePresent()
				
				)
				
				
		.andUsing(
				
				changePasswordPage=myAccountPage
				.clickChangePasswordTab(getWebDriver())
				
				)
				
		.check(
				changePasswordPage.currentPasswordLabelMustBePresent()
				
				)
		
		.andUsing(
				
				homePage=changePasswordPage
				.fillFieldsForChangePassword(actualPassword, newPassword)
				.and()
				.clickchangePasswordButton()
				.then()
				.clickYesButton(getWebDriver())	
				
				)
				
		.check(
				
				homePage.loginLinkMustBePresent()
			
			)
			
		.andUsing(
				
				dashboardCustomerPage=homePage
				.clickLoginLink(getWebDriver())
				.then()
				.fillFieldsForLogin(email ,newPassword)
				.and()
				.clickSignInButton(getWebDriver())
				
				)
		
		.check(
				dashboardCustomerPage.welcomeLabelMustBePresent()
				
				);
	}
	
	@Override
	@AfterMethod (alwaysRun=true)
	public void close(){
		myAccountPage=dashboardCustomerPage
		.clickMyAccountTab(getWebDriver());
		
		changePasswordPage=myAccountPage
		.clickChangePasswordTab(getWebDriver());
		
		homePage=changePasswordPage
		.fillFieldsForChangePassword(aPassword, nPassword)			
		.clickchangePasswordButton()				
		.clickYesButton(getWebDriver());		
		
		driver.close();
		driver.quit();
	}	 
	
		 
		
}
