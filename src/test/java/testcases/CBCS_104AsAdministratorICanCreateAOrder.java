package testcases;

import java.io.IOException;

import jxl.read.biff.BiffException;
import object.OrderDataInfo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ts.commons.DataSourceXls;

import pages.AddressesInformationPage;
import pages.DashboardAdminPage;
import pages.OrderConfirmationPage;
import pages.OrderSummaryPage;
import pages.PaymentMethodPage;
import pages.ReviewOrderPage;
import pages.SubmissionPage;
import utils.TestCaseCBCS;
import utils.UI;

public class CBCS_104AsAdministratorICanCreateAOrder extends TestCaseCBCS {
	
private DashboardAdminPage dashboardPage;
private SubmissionPage submissionPage;
private OrderSummaryPage orderSummaryPage;
private AddressesInformationPage addressesInformationPage;
private PaymentMethodPage paymentMethodPage;
private ReviewOrderPage reviewOrderPage;
private OrderConfirmationPage orderConfirmationPage;
OrderDataInfo order;

	@DataProvider
	public Object[][] data() throws BiffException, IOException {
       return new DataSourceXls ("Parameters.xls" ).getData(6,2);
      
	}  
	
	@Test(dataProvider = "data")
	public void asAdministratorICanCreateAOrderTest (String userName, String password, String enviroment, String invoiceNumber,String qytComics, String tier, String comicNumber, String role, String pedigree, String billing, String shipping,String provider, String paymentMethod){
		
		order=new OrderDataInfo();
		order.fillOrderDatOnAdmin(order);
		
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
				
				submissionPage=dashboardPage
				.clickSubmitOrderTab(getWebDriver())
				
				)
				
		 .check(
				 
				submissionPage
				.submissionLabelMustBePresent()
				
				)
				
		  .andUsing(
				  
				  orderSummaryPage = submissionPage
				  .fillAllFields(order,pedigree,tier, getWebDriver())
				  .then()
				  .clickNextButton(getWebDriver())
				  				  
				  )
			
		 .check(
				 
				  orderSummaryPage
				  .orderSummaryLabelMustBePresent()
				   
				  )  
				  
		    .andUsing(
							
					addressesInformationPage=orderSummaryPage
					.clickIGreeTermsAndConditionsCheckbox(getWebDriver())
					.then()
					.clickNextButton(getWebDriver())
							
					)
							
			 .check(
							
					addressesInformationPage
					.addressesInformationLabelMustBePresent()
						
					 )
					
			  .andUsing(
							
					paymentMethodPage=addressesInformationPage
					.selectBillingAddress(billing, getWebDriver())
					.then()
					.selectShippingAddress(shipping, getWebDriver())
					.and()
					.selectOneOptionShippingProviderDropdown(provider, getWebDriver())
					.then()
					.clickNextButton(getWebDriver())					
							
					 )
							
				.check(
							
					paymentMethodPage
					.paymentMethodLabelMustBePresent()
						
					)
					
				.andUsing(
						
						reviewOrderPage=paymentMethodPage
						.clickOneOptionPaymentMethodCheckbox(paymentMethod, getWebDriver())
						.and()
						.clickNextButton(getWebDriver())
						
						)
						
				.check(
						
					reviewOrderPage
					.reviewOrderLabelMustBePresent(getWebDriver())
					
					)
					
			   .andUsing(
						
					   orderConfirmationPage=reviewOrderPage
					 .clickNextButton(getWebDriver())
					
					)
					
				.check(
						
					orderConfirmationPage
					.orderConfirmationLabelMustBePresent()
					
					)
					
				.andUsing(
						
						orderConfirmationPage
						.clickOkButton(getWebDriver())
						
						)
						
				.check(
						
					  orderConfirmationPage
					  .successfullyMessageMustBePresent()
					  
						);
		}

}
