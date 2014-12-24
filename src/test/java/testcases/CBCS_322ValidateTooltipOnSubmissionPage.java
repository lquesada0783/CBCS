package testcases;

import java.io.IOException;

import jxl.read.biff.BiffException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ts.commons.DataSourceXls;

import pages.DashboardCustomerPage;
import pages.SubmitYourComicPage;
import utils.TestCaseCBCS;
import utils.UI;

public class CBCS_322ValidateTooltipOnSubmissionPage extends TestCaseCBCS {
	
	private DashboardCustomerPage dashboardCustomerPage;
	private SubmitYourComicPage submitYourComicPage;
		
	@DataProvider
	 public Object[][] data() throws BiffException, IOException {
	        return new DataSourceXls ("Parameters.xls" ).getData(15,2);
	       
	   }  
	
	@Test(dataProvider = "data")
	public void asCustomerICanCreateAOrderTest(String email,String password,String titleText, String issueText, String yearText, String publisherText,  String variantText,  String pedigreeText,  String tierText,  String quantityText, String insuredValueText,  String gradeScreeningText, String fastPassText,  String slideshowText,  String imagenText,  String verifiedSignatureText,  String authenticatedSignatureText){
		
	
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
				
				submitYourComicPage=dashboardCustomerPage
				.clickSubmitYourComicTab(getWebDriver())
				
				)
				
		.check(
				
				submitYourComicPage.validateTooltip(getWebDriver(), titleText, issueText,yearText, publisherText, variantText, pedigreeText, tierText, quantityText, insuredValueText, gradeScreeningText, fastPassText,  slideshowText, imagenText, verifiedSignatureText, authenticatedSignatureText)
				);
		}


}
