package testcases;

import java.io.IOException;

import jxl.read.biff.BiffException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ts.commons.DataSourceXls;

import pages.DashboardSlabPage;
import pages.ProcessOrderSlabPage;
import pages.TierDetailsSlabPage;
import utils.TestCaseCBCS;
import utils.UI;

public class CBCS308_AsSlabICanPrintLabelsOfAllComicBooks extends TestCaseCBCS {
	
	private DashboardSlabPage dashboardSlabPage;
	private ProcessOrderSlabPage processOrderSlabPage;
	private TierDetailsSlabPage tierDetailsSlabPage;
	
	@DataProvider
	public Object[][] data() throws BiffException, IOException {
	 return new DataSourceXls("Parameters.xls").getData(3, 2);
	}	
	
	
	@Test(dataProvider = "data")
	public void asSlabICanPrintLabelsOfAllComicBooksTest (String userName, String password, String enviroment, String invoiceNumber,String qytComics, String tier, String comicNumber, String grade, String pageQuality,String orderStatus, String role) {
		
		using(
				dashboardSlabPage=(DashboardSlabPage) UI.goToAdminLoginPage(getWebDriver())
				.fillFieldsForLogin(userName , password)
				.and()
				.signInButtonClick(getWebDriver(),enviroment)
				
			  )
			
		 .check(
							
				 dashboardSlabPage
				.dashboardLabelMustBePresent()
				
			   )
			   
		 .andUsing(
				 
				 processOrderSlabPage=dashboardSlabPage
				 .processOrderLabelClick(getWebDriver())
				 .then()
				 .fillInvoiceOrOrderNumberField(invoiceNumber)
				 .and()
				 .clickSearchButton()				 
				 				 
				 )				 
				 
		  .check(
				  
				 processOrderSlabPage
				 .orderNumberLabelMustBePresent(invoiceNumber, getWebDriver())
				 
				 )
				 
		   .andUsing(
				   
				   tierDetailsSlabPage=processOrderSlabPage
				   .clickDetailsLink(tier, getWebDriver())
				   
				   )
				   
		   .check(
					
				 tierDetailsSlabPage
				 .tierDetailsLabelMustBePresent()
					
				)
					
			.andUsing(
					 
				   processOrderSlabPage =tierDetailsSlabPage
					.clickPrinAllLabelsButton()
					.and()
					.clickBackToOrderButton(getWebDriver())					 
					 
					 )
					 
			 .check(
					
					processOrderSlabPage
					.checkTierStatus(invoiceNumber, orderStatus, getWebDriver())
					
					);
	}

}
