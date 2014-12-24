package testcases;

import java.io.IOException;

import jxl.read.biff.BiffException;
import object.OrderDataInfo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.AddressesInformationCustomerPage;
import pages.DashboardCustomerPage;
import pages.OrderConfirmationCustomerPage;
import pages.OrderSummaryCustomerPage;
import pages.PaymentMethodCustomerPage;
import pages.ReviewOrderCustomerPage;
import pages.SubmitYourComicPage;

import com.ts.commons.DataSourceXls;

import utils.TestCaseCBCS;
import utils.UI;

public class CBCS183_ValidateExpandedConsumerTierRulesCorrectly extends
		TestCaseCBCS {
	
	private DashboardCustomerPage dashboardCustomerPage;
	private SubmitYourComicPage submitYourComicPage;
	private OrderSummaryCustomerPage orderSummaryCustomerPage;
	private AddressesInformationCustomerPage addressesInformationCustomerPage;
	private PaymentMethodCustomerPage paymentMethodCustomerPage;
	private ReviewOrderCustomerPage reviewOrderCustomerPage;
	private OrderConfirmationCustomerPage orderConfirmationCustomerPage;
	private OrderDataInfo order;
	
	@DataProvider
	public Object[][] data() throws BiffException, IOException {
	 return new DataSourceXls("Parameters.xls").getData(14,2);
	 
	}	
	
	@Test(dataProvider = "data")
	public void validateExpandedConsumerTierRulesCorrectlyTest(String email, String password, String qtyComics, String amountCoupon, String pedigree, String tier,String issueNumber, String year, String gradeScreening, String isuredValue,String amountFastPass,String amountVideo, String amountImage, String amountSubTotal, String billing, String shipping, String provider, String paymentMethod){
		
		order = new OrderDataInfo();
		order.fillDataCustomer(order);
		
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
				
				submitYourComicPage.submitYourComicLabelMustBePresent()
				
				)
				
		.andUsing(
				
				submitYourComicPage
				.fillAllFieldsWithDataForTierRules(order, qtyComics,issueNumber, year, isuredValue, getWebDriver())
				.and()
				.selectOneOptionPedigreeDropdown(pedigree, getWebDriver())
				.then()
				.selectOneOptionTierDropdown(tier, getWebDriver())
				.and()
				.clickGradeScreeningCheckbox(getWebDriver())
				.then()
				.selectOneOptionGradeScreeningDropdown(gradeScreening, getWebDriver())
				.and()
				.clickFastPassCheckbox(getWebDriver())
				.then()
				.clickSlideshowCheckbox(getWebDriver())
				.and()
				.clickImageCheckbox(getWebDriver())
				
				
				)
				
		.check(
				submitYourComicPage.validateExpandedCustomerLabelsAreCorrect(getWebDriver(), amountFastPass, amountVideo, amountImage, amountSubTotal)
				
				)
				
	   .andUsing(
			   
			    orderSummaryCustomerPage=submitYourComicPage	
				.clickNextButton(getWebDriver())				
				
			)
				
		.check(
				orderSummaryCustomerPage
				.orderSummaryLabelMustBePresent()
				
				)
				
		.andUsing(
				
				addressesInformationCustomerPage=orderSummaryCustomerPage
				.clickIGreeTermsAndConditionsCheckbox(getWebDriver())
				.clickNextButton(getWebDriver())
				
				)
				
		.check(
				addressesInformationCustomerPage
				.addressesInformationLabelMustBePresent()
				
				)
				
		.andUsing(
				
				paymentMethodCustomerPage=addressesInformationCustomerPage
				.selectBillingAddress(billing, getWebDriver())
				.then()
				.selectShippingAddress(shipping, getWebDriver())
				.and()
				.selectOneOptionShippingProviderDropdown(provider, getWebDriver())
				.then()
				.clickNextButton(getWebDriver())
				
				)
				
				
		.check(					
				paymentMethodCustomerPage.paymentMethodLabelMustBePresent()
				
			)
			
	   .andUsing(
			   
			    reviewOrderCustomerPage=paymentMethodCustomerPage
			   .clickOneOptionPaymentMethodCheckbox(paymentMethod, getWebDriver())
			   .then()
			   .clickNextButton(getWebDriver())
			   
			   
			   )
			   
		.check(
				
				reviewOrderCustomerPage.reviewOrderLabelMustBePresent(getWebDriver())
				
				)
				
		.andUsing(
				
				orderConfirmationCustomerPage=reviewOrderCustomerPage
				.clickNextButton(getWebDriver())
				
				)
				
		.check(
				
				orderConfirmationCustomerPage.orderConfirmationLabelMustBePresent()
				
				)
				
		.andUsing(
				
				orderConfirmationCustomerPage
				//.writeOnderNumber(getWebDriver(),order)				
				.clickOkButton(getWebDriver())
				
				
				
				)
				
		.check(
				
			orderConfirmationCustomerPage.warningMessageMustBePresent()
				
			);
		
	  }
	


}
