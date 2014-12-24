package testcases;

import java.io.File;
import java.io.IOException;

import jxl.read.biff.BiffException;
import object.OrderDataInfo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ts.commons.DataSourceXls;

import pages.DashboardReceiverPage;
import pages.ProcessOrderReceiverPage;
import utils.TestCaseCBCS;
import utils.UI;

public class CBCS105_AsReiverSearchOneOrderUsingOrderNumber extends TestCaseCBCS {
	
private DashboardReceiverPage dashboardPage;
private ProcessOrderReceiverPage processOrderPage;
private OrderDataInfo order;

	@DataProvider
	public Object[][] data() throws BiffException, IOException {
		File file = new File(".\\src\\test\\resources\\Parameters.xls");
	return new DataSourceXls(file).getData(0, 2);
	}	

	@Test(dataProvider = "data",dependsOnGroups={"CreateOrder"})
	public void asReiverSearchOneOrderUsingOrderNumberTest (String userName, String password, String enviroment, String invoiceNumber,String qytComics, String tier, String comicNumber, String grade, String pageQuality,String orderStatus, String role) {
		
		order = new OrderDataInfo();
		order.fillDataCustomer(order);
		
		using(
				dashboardPage=(DashboardReceiverPage) UI.goToAdminLoginPage(getWebDriver())
				.fillFieldsForLogin(userName , password)
				.and()
				.signInButtonClick(getWebDriver(),enviroment)
				
			)
			
		 .check(
				 dashboardPage
				 .dashboardLabelMustBePresent()
				 
				  )
		
		   .andUsing(
				   
				   processOrderPage=dashboardPage
				   .processOrderLabelClick(getWebDriver())
				   .then()
				   .fillInvoiceOrOrderNumberField(invoiceNumber)
				   .and()
				   .clickSearchButton()
				   
				   )
				   
		    .check(
		    		
		    		processOrderPage
		    		.orderNumberLabelMustBePresent(invoiceNumber, getWebDriver())
		    		
		    	   );	
		
		  	}
	
}
