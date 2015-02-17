package testcases;

import java.io.IOException;

import jxl.read.biff.BiffException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.DashboardCustomerPage;
import pages.FAQPage;

import com.ts.commons.DataSourceXls;

import utils.TestCaseCBCS;
import utils.UI;

public class CBCS_260AsCustomerIcanSeeFAQPage extends TestCaseCBCS {
	
	private DashboardCustomerPage dashboardCustomerPage;
	private FAQPage faqPage;
	
	@DataProvider
	 public Object[][] data() throws BiffException, IOException {
	        return new DataSourceXls ("Parameters.xls" ).getData(7,2);
	       
	   }  
	
	
	@Test(dataProvider = "data")
	public void asCustomerIcanSeeFAQPage(String email, String password){
		
		using(
				dashboardCustomerPage=(DashboardCustomerPage) UI.goToCustomerLoginPage(getWebDriver())
				.clickLoginLink(getWebDriver())
				.then()
				.fillFieldsForLogin(email,password)
				.and()
				.clickSignInButton(getWebDriver())
				
				)
				
		 .check(
			
				 dashboardCustomerPage.welcomeLabelMustBePresent()
						
			  )
			  
		.andUsing(
				
				faqPage=dashboardCustomerPage
				.clickFAQTab(getWebDriver())
				
				)
				
		.check(
				
				faqPage.validateFAQPageIsDisplayed(getWebDriver())
			
			);
			  
		
	}
	
	

}
