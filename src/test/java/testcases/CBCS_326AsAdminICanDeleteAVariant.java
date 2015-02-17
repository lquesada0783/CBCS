package testcases;

import java.io.IOException;

import jxl.read.biff.BiffException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ts.commons.DataSourceXls;

import pages.DashboardAdminPage;
import pages.VariantsPage;
import utils.TestCaseCBCS;
import utils.UI;

public class CBCS_326AsAdminICanDeleteAVariant extends TestCaseCBCS {
	
	 private DashboardAdminPage dashboardPage;
	 private VariantsPage variantPage;
	 
	 @DataProvider
	 public Object[][] data() throws BiffException, IOException {
		return new DataSourceXls("Parameters.xls").getData(16, 2);
	 }	
	 
    @Test(dataProvider = "data")
    public void asAdminICanDeleteAVariantTest(String userName, String password, String enviroment, String catalogsVariant, String variantName, String newVariantName){
									
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
						
			variantPage=dashboardPage
			.selectOneOptionCatalogMenue(catalogsVariant, getWebDriver(),VariantsPage.class) 					
						
			    )
						
		.check(
					
			variantPage.VariantLabelMustBePresent()
						
			)
				
		.andUsing(
					
			variantPage.clickNewButton(getWebDriver())
			.and()
			.fillFieldsAddVariantModal(variantName)
			.then()
			.clickSaveButton()					
					
			)
					
		.check(
					
			variantPage.addedVariantSuccessfullyMessageMustBePresent()
					
			)
					
		.andUsing(
					
			variantPage.fillSearchField(variantName)
			.and()
			.clickSearchButton()
					
			 )
					
		.check(					

			variantPage.ValidateIfVariantExist(getWebDriver(), variantName)
					
			)		
			
		.andUsing(
				
			variantPage.clickDeleteButton(getWebDriver(), variantName)
			.and()
			.clickYesButton(getWebDriver())
			
			)
		
		.check(
			
			variantPage.deletedVariantSuccessfullyMessageMustBePresent()		
			
			);
		}
}
