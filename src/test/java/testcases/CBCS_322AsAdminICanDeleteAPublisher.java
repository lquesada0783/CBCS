package testcases;

import java.io.IOException;

import jxl.read.biff.BiffException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ts.commons.DataSourceXls;

import pages.DashboardAdminPage;
import pages.PublisherPage;
import utils.TestCaseCBCS;
import utils.UI;

public class CBCS_322AsAdminICanDeleteAPublisher extends TestCaseCBCS {
	
	private DashboardAdminPage dashboardPage;
	private PublisherPage publisherPage;
	 
	 @DataProvider
	 public Object[][] data() throws BiffException, IOException {
		return new DataSourceXls("Parameters.xls").getData(17, 2);
	 }	
	 
	 @Test(dataProvider = "data")
	 public void asAdminICanDeleteAPublisherTest(String userName, String password, String enviroment, String catalogsPublisher, String publisherName, String newPublisherName){
			
						
		using(
				dashboardPage=(DashboardAdminPage) UI.goToAdminLoginPage(getWebDriver())
				.fillFieldsForLogin(userName , password)
				.and()
				.signInButtonClick(getWebDriver(), enviroment)
					
				)
					
		.check(
				
				dashboardPage
				.dashboardLabelMustBePresent()
							
				 )
			
		.andUsing(
						
				publisherPage=dashboardPage
				.selectOneOptionCatalogMenue(catalogsPublisher, getWebDriver(),PublisherPage.class)  					
						
				)
						
		.check(
					
			publisherPage.PublisherLabelMustBePresent()
						
				)
		.andUsing(
						
				publisherPage.clickNewButton(getWebDriver())
				.and()
				.fillFieldsAddPublisherModal(publisherName)
				.then()
				.clickSaveButton()
				
				)
						
		 .check(
				
			publisherPage.addedPublisherSuccessfullyMessageMustBePresent()
						
			  )
					
		 .andUsing(
					
			publisherPage.fillSearchField(publisherName)
			.and()
			.clickSearchButton(getWebDriver())
					
			 )
					
		 .check(					

			publisherPage.ValidateIfPublisherExist(getWebDriver(), publisherName)
					
			)		
			
		.andUsing(
				
			publisherPage.clickDeleteButton(getWebDriver(), publisherName)
			.and()
			.clickYesButton(getWebDriver())
			
			)
		
		.check(
			
			publisherPage.deletedPublisherSuccessfullyMessageMustBePresent()	
			
			);
		}

}
