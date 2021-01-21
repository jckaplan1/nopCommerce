package com.testCases;

import java.util.Set;

import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.LoginPage;

public class LoginTest extends BaseClass {
	@Test
	public void Logintest() throws InterruptedException {
		logger.info("Started login test");

		LoginPage lP = new LoginPage(driver);
		lP.adminbtn();
		Thread.sleep(2000);
		Set<String> handlevalue = driver.getWindowHandles();

		for (String h : handlevalue) {
			String title = driver.switchTo().window(h).getTitle();
			if (title.contentEquals("Your store. Login")) {

				lP.sendEmail(username);
				lP.sendPassword(password);
				lP.loginbtn();

			}

		}

	}

}
