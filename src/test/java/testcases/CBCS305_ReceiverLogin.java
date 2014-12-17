package testcases;

import java.io.IOException;

import jxl.read.biff.BiffException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ts.commons.DataSourceXls;

import pages.DashboardReceiverPage;
import utils.TestCaseCBCS;
import utils.UI;

public class CBCS305_ReceiverLogin extends TestCaseCBCS {
	
	private DashboardReceiverPage dashboardPage;
	
	@DataProvider
	public Object[][] data() throws BiffException, IOException {
	return new DataSourceXls("Parameters.xls").getData(0, 2);
	}	
	
	@Test(dataProvider = "data")
	public void receiverLoginTest (String userName, String password, String enviroment, String invoiceNumber,String qytComics, String tier, String comicNumber, String grade, String pageQuality,String orderStatus, String role) {
		
		using(
				dashboardPage=(DashboardReceiverPage) UI.goToAdminLoginPage(getWebDriver())
				.fillFieldsForLogin(userName , password)
				.and()
				.signInButtonClick(getWebDriver(),enviroment)
				
			  )
			
		 .check(
					
				dashboardPage
				.dashboardLabelMustBePresent()
				
			   );
	}

}
