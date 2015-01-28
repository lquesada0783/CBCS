package testcases;

import java.io.IOException;

import jxl.read.biff.BiffException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.DashboardAdminPage;
import pages.PedigreesPage;

import com.ts.commons.DataSourceXls;

import utils.TestCaseCBCS;
import utils.UI;

public class CBCS_324AsAdminICanDeleteAPedigree extends TestCaseCBCS {
	
	 private DashboardAdminPage dashboardPage;
	 private PedigreesPage pedigreesPage;
	 
	 @DataProvider
	 public Object[][] data() throws BiffException, IOException {
		return new DataSourceXls("Parameters.xls").getData(18, 2);
	 }	
	 
	 @Test(dataProvider = "data")
	 public void asAdminICanDeleteAPedigreeTest(String userName, String password, String enviroment, String catalogsPedigree, String pedigreeName, String newPedigreeName){
			
						
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
						
			pedigreesPage=dashboardPage
			.selectOneOptionCatalogMenue(catalogsPedigree, getWebDriver(),PedigreesPage.class)  					
						
				)
						
		.check(
					
			pedigreesPage.PedigreesLabelMustBePresent()
						
				)
				
		 .andUsing(
					
				pedigreesPage.clickNewButton(getWebDriver())
			    .and()
				.fillFieldsAddPedigreeModal(pedigreeName)
				.then()
				.clickSaveButton(getWebDriver())					
					
				)
					
		  .check(
				
				pedigreesPage.addedPedigreesSuccessfullyMessageMustBePresent()
					
				)
					
		.andUsing(
					
			pedigreesPage.fillSearchField(pedigreeName)
			.and()
			.clickSearchButton(getWebDriver())
					
			 )
					
		.check(					

			pedigreesPage.ValidateIfPedigreeExist(getWebDriver(), pedigreeName)
					
			)		
			
		.andUsing(
				
			pedigreesPage.clickDeleteButton(getWebDriver(), pedigreeName)
			.and()
			.clickYesButton(getWebDriver())
			
			)
		
		.check(
			
			pedigreesPage.deletedPedigreeSuccessfullyMessageMustBePresent()	
			
			);
		}
}
