package testcases;

import java.io.IOException;

import jxl.read.biff.BiffException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ts.commons.DataSourceXls;

import pages.DashboardCustomerPage;
import pages.NewsCustomerPage;
import utils.TestCaseCBCS;
import utils.UI;

public class CBCS_331AsCustomerICanSeeTheNewsPage extends TestCaseCBCS {
	
	private DashboardCustomerPage dashboardCustomerPage;
	private NewsCustomerPage newsPage;
	
	@DataProvider
	 public Object[][] data() throws BiffException, IOException {
	        return new DataSourceXls ("Parameters.xls" ).getData(7,2);
	       
	   }  
	
	
	@Test(dataProvider = "data")
	public void asCustomerICanSeeTheNewsPageTest(String email, String password){
		
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
				
				newsPage=dashboardCustomerPage
				.clickNewsTab(getWebDriver())
				
				)
				
		.check(
				
			newsPage.validateNewsIsDisplayed(getWebDriver())
			
			);
			  
		
	}

}
