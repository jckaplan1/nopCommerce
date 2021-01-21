package com.testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.pageObjects.CustomersPage;

public class SearchCustomer extends BaseClass {
	public LoginTest test;
	public CustomersPage Cp;

	@Test
	public void Searchcustomer() throws InterruptedException {
		test = new LoginTest();
		test.Logintest();
		SoftAssert sfasrt = new SoftAssert();
		sfasrt.assertEquals(driver.getTitle(), "Dashboard / nopCommerce administration");
		logger.info("Search customer search test start");

		Cp = new CustomersPage(driver);
		Cp.Customermain();
		Cp.customerRole();
//		Cp.searcByFistName("Victoria");
		Cp.searcByLastName("Pan");

//		Cp.selectDay(30);
//		Cp.selectMonth(12);
		Cp.clicksearcBtn();
		Cp.logoutBtn();
	}

}
