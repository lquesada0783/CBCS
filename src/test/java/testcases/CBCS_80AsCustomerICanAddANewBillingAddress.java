package testcases;

import java.io.IOException;

import jxl.read.biff.BiffException;
import object.CustomerDataInfo;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ts.commons.DataSourceXls;

import pages.AddressesInformationCustomerPage;
import pages.DashboardCustomerPage;
import pages.MyAccountPage;
import utils.TestCaseCBCS;
import utils.UI;

public class CBCS_80AsCustomerICanAddANewBillingAddress extends TestCaseCBCS {
	
	private DashboardCustomerPage dashboardCustomerPage;
	private MyAccountPage myAccountPage;
	private AddressesInformationCustomerPage addressesInformationCustomerPage;
	CustomerDataInfo customer;	
	
	@DataProvider
	public Object[][] data() throws BiffException, IOException {
	return new DataSourceXls("Parameters.xls").getData(7, 2);
	}	
	
	@Test(dataProvider = "data")
	public void asCustomerIMayAddANewBillingAddressTest(String email, String password){
		
		customer=new CustomerDataInfo();
		customer.fillCustomerDataInfo(customer);
		
		
		using(
				dashboardCustomerPage=(DashboardCustomerPage) UI.goToCustomerLoginPage(getWebDriver())
				.clickLoginLink(getWebDriver())
				.fillFieldsForLogin(email, password)
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
				
				addressesInformationCustomerPage=myAccountPage
				.clickAddressInformationTab(getWebDriver())
				
				)
				
		.check(
				addressesInformationCustomerPage
				.addressesInformationLabelMustBePresent()
				
				)
				
		.andUsing(
				
				addressesInformationCustomerPage
				.clickAddBillingAddressLink(getWebDriver())
				
				)
				
		.check(
				
				addressesInformationCustomerPage
				.newBillingLabelMustBePresent()
				
				)
	
		.andUsing(
				
				addressesInformationCustomerPage
				.fillFieldsOnAddNewBillingInformationModal(customer, email, getWebDriver())
				.then()
				.clickSaveButton()
				
				)
				
			.check(
				addressesInformationCustomerPage
				.userNameOnBillingAddressIsPressent(customer.getName(),getWebDriver())
				
				);
			  
	}	
	
	@Override
	@AfterMethod(alwaysRun = true)
	public void close(){
	utils.Utils.deleteBillingAddress(customer, getWebDriver());
    driver.close();
	driver.quit();
	
	}
}
