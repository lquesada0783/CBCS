package testcases;

import java.io.IOException;

import jxl.read.biff.BiffException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.DashboardCustomerPage;
import pages.ManageYourCreditCardPage;
import pages.MyAccountPage;

import com.ts.commons.DataSourceXls;

import utils.TestCaseCBCS;
import utils.UI;

public class CBCS_328AsCustomerICanDeleteACreditCard extends TestCaseCBCS {
	
	private DashboardCustomerPage dashboardCustomerPage;
	private MyAccountPage myAccountPage;
	private ManageYourCreditCardPage manageYourCreditCardPage;
			
	@DataProvider
	public Object[][] data() throws BiffException, IOException {
	return new DataSourceXls("Parameters.xls").getData(19, 2);
	}	
	
	@Test(dataProvider = "data")
	public void asCustomerICanDeleteACreditCardTest(String email, String password, String creditCardNumber, String name, String cvv2, String monthOption, String yearOption, String creditCardEncrypted){
		
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
				
				manageYourCreditCardPage=myAccountPage
				.clickManageYourCreditCardTab(getWebDriver())
				
				)
				
		.check(
				manageYourCreditCardPage.creditCardLabelMustBePresent()
				
				)
				
		.andUsing(		
				
				manageYourCreditCardPage
				.clickAddNewButton()
				
				)
				
		.check(
				manageYourCreditCardPage
				.addCreditCardlabelMustBePresent()
				
				)
				
		.andUsing(
				
				manageYourCreditCardPage
				.fillFieldsForNewCreditCard(creditCardNumber, name, cvv2)
				.and()
				.selectOneOptionMonthDropdown(monthOption, getWebDriver())
				.then()
				.selectOneOptionYearDropdown(yearOption, getWebDriver())
				.and()
				.clickSaveButton()			
				
				)
		
		.check(
				
			  manageYourCreditCardPage
			  .validateExistsCreditCard(creditCardNumber, getWebDriver())
			  
			  )
			  
		.andUsing(
				
				manageYourCreditCardPage
				.clickDeleteButton(creditCardEncrypted, getWebDriver())
				.and()
				.clickYesButton()				
				)
				
		.check(
				
			manageYourCreditCardPage
			.deletedCreditCardlabelMustBePresent()
			
			);
	}	
	

}