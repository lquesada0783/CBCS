package testcases;

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

public class CBCS_105AsReiverSearchOneOrderUsingOrderNumber extends TestCaseCBCS {
	
private DashboardReceiverPage dashboardPage;
private ProcessOrderReceiverPage processOrderPage;
private OrderDataInfo order;

	@DataProvider
	public Object[][] data() throws BiffException, IOException {
       return new DataSourceXls ("Parameters.xls" ).getData(0,2);
      
	}  

	@Test(dataProvider = "data",dependsOnGroups={"CreateOrder"})
	public void asReiverSearchOneOrderUsingOrderNumberTest (String userName, String password, String enviroment, String invoiceNumber,String qytComics, String tier, String comicNumber, String grade, String pageQuality,String orderStatus, String role) {
		
		order = new OrderDataInfo();
		order.fillOrderData(order);
		
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
				   .fillInvoiceOrOrderNumberField(CBCS_316AsCustomerICanCreateAOrder.orderNumber)
				   .and()
				   .clickSearchButton()
				   
				   )
				   
		    .check(
		    		
		    		processOrderPage
		    		.orderNumberLabelMustBePresent(CBCS_316AsCustomerICanCreateAOrder.orderNumber, getWebDriver())
		    		
		    	   );	
		
		  	}
	
}
