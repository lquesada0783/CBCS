package testcases;

import java.io.IOException;

import jxl.read.biff.BiffException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ts.commons.DataSourceXls;

import pages.DashboardAdminPage;
import utils.TestCaseCBCS;
import utils.UI;

public class CBCS77_AdminLogin extends TestCaseCBCS {
	
	private DashboardAdminPage dashboardPage;
	
	@DataProvider
	public Object[][] data() throws BiffException, IOException {
	return new DataSourceXls("Parameters.xls").getData(12, 2);
	}	
	
	@Test(dataProvider = "data")
	public void adminLoginTest(String userName, String password, String enviroment){	
		
		
		using(
				dashboardPage=(DashboardAdminPage) UI.goToAdminLoginPage(getWebDriver())
				.fillFieldsForLogin(userName ,password)
				.and()
				.signInButtonClick(getWebDriver(), enviroment)
				
				)
				
		 .check(
			
				dashboardPage
				.dashboardLabelMustBePresent()
						
			  );					
	}

}
