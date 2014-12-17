package testcases;

import java.io.File;
import java.io.IOException;

import jxl.read.biff.BiffException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ts.commons.DataSourceXls;

import object.CustomerDataInfo;
import pages.AddressesInformationCustomerPage;
import pages.DashboardCustomerPage;
import pages.MyAccountPage;
import utils.TestCaseCBCS;
import utils.UI;

public class CBCS_318AsCustomerICanDeleteABillingAddress extends TestCaseCBCS {
	
	private DashboardCustomerPage dashboardCustomerPage;
	private MyAccountPage myAccountPage;
	private AddressesInformationCustomerPage addressesInformationCustomerPage;
	CustomerDataInfo customer;
	
	@DataProvider
	public Object[][] data() throws BiffException, IOException {
		File file = new File(".\\src\\test\\resources\\Parameters.xls");
	 return new DataSourceXls(file).getData(7,2);
	 
	}	
	
	@Test(dataProvider = "data")
	public void asCustomerICanDeleteABillingAddressTest(String email, String password){
		
		customer=new CustomerDataInfo();
		customer.fillCustomerDataInfo(customer);
		
		
		using(
				dashboardCustomerPage=(DashboardCustomerPage) UI.goToCustomerLoginPage(getWebDriver())
				.clickLoginLink(getWebDriver())
				.then()
				.fillFieldsForLogin(email ,password)
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
				
				)
			.andUsing(
					
				addressesInformationCustomerPage
				.deleteBillingAddress(customer, getWebDriver())
					
			       )
			
			.check(					
					
				addressesInformationCustomerPage
				.validateBillingAddressDoesNotExist(customer, getWebDriver())
				
				 );  
		}

}
