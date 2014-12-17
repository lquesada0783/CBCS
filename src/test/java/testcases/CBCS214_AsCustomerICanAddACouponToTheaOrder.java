package testcases;

import java.io.IOException;

import jxl.read.biff.BiffException;
import object.OrderDataInfo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ts.commons.DataSourceXls;

import pages.AddressesInformationCustomerPage;
import pages.DashboardCustomerPage;
import pages.OrderConfirmationCustomerPage;
import pages.OrderSummaryCustomerPage;
import pages.PaymentMethodCustomerPage;
import pages.ReviewOrderCustomerPage;
import pages.SubmitYourComicPage;
import utils.TestCaseCBCS;
import utils.UI;

public class CBCS214_AsCustomerICanAddACouponToTheaOrder extends TestCaseCBCS{
	
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
	return new DataSourceXls("Parameters.xls").getData(8, 2);
	}	
	
	@Test(dataProvider = "data")
	public void asCustomerICanAddACouponToTheaOrderTest(String email, String password, String qtyComics, String amountCoupon, String pedigree, String tier,String billing, String shipping, String provider, String paymentMethod){
		
		order = new OrderDataInfo();
		order.fillDataCustomer(order);
		
		using(
				dashboardCustomerPage=(DashboardCustomerPage) UI.goToCustomerLoginPage(getWebDriver())
				.clickLoginLink(getWebDriver())
				.then()
				.fillFieldsForLogin(email ,password)
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
				
				orderSummaryCustomerPage=submitYourComicPage
				.fillAllFields(order, pedigree,tier, getWebDriver())
				.then()
				.clickNextButton(getWebDriver())
				
				)
				
		.check(
				orderSummaryCustomerPage.orderSummaryLabelMustBePresent()
				
				)
				
		.andUsing(
				
				orderSummaryCustomerPage
				.fillCuponField(amountCoupon,getWebDriver())
				.then()
				.clickApplyButton()
				.and()
				.clickAcceptButton()
				
				)
				
		.check(
				orderSummaryCustomerPage
				.couponLabelMustBePresent()
				
				)
				
		.andUsing(
				
				addressesInformationCustomerPage=
				orderSummaryCustomerPage.clickIGreeTermsAndConditionsCheckbox(getWebDriver())
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
				
				orderConfirmationCustomerPage=
				reviewOrderCustomerPage
				.clickNextButton(getWebDriver())
				
				)
				
		.check(
				
				orderConfirmationCustomerPage.orderConfirmationLabelMustBePresent()
				
				)
				
		.andUsing(
				
				orderConfirmationCustomerPage
				.writeOnderNumber(getWebDriver(),order)				
				.clickOkButton(getWebDriver())
				
				)
				
		.check(
				
			orderConfirmationCustomerPage.warningMessageMustBePresent()
				
			);
		
	  }
	

}

