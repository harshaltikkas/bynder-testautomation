package com.byndr.steps;

import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import com.byndr.pageobjects.HomePage;
import com.google.common.base.Verify;
import com.byndr.util.IWait;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserLoginSteps {

	public static WebDriver driver = null;

	@Given("User is on Byndr portal's login screen")
	public void user_is_on_Byndr_portal_s_login_screen() {
		try {
			/* Initialising Browser and property */
			String os = System.getProperty("os.name");
			System.out.println(os);
			if (!os.equalsIgnoreCase("Mac OS X")) {
				System.setProperty("webdriver.chrome.driver",
						"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
			}
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-extensions");
			options.addArguments("start-maximized");
			driver = new ChromeDriver(options);
			/*
			 * if (os.equalsIgnoreCase("Mac OS X")) { ((JavascriptExecutor)
			 * driver).executeScript("alert('Test')"); driver.switchTo().alert().accept(); }
			 */

			HomePage homePage = PageFactory.initElements(driver, HomePage.class);

			driver.get("https://app.byndr.com/login/");
			if (os.equalsIgnoreCase("Mac OS X")) {
				driver.manage().window().setPosition(new Point(0, 0));
				driver.manage().window().setSize(new Dimension(1440, 900));
				driver.switchTo().window(driver.getWindowHandle());
			} else {
				driver.manage().window().maximize();
			}
			// wait for 10 seconds explicitly for the webelement
			IWait.explicit_wait(driver, homePage.byndrLogoOnLogin);
			Assert.assertTrue("User is on consumer portal's login screen", homePage.byndrLogoOnLogin.isDisplayed());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@When("User enters valid username \"([^\"]*)\" and password \"([^\"]*)\"")
	public void user_enters_valid_username_and_password(String userName, String passWord) {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		try {
			homePage.username.sendKeys(userName);
			homePage.password.sendKeys(passWord);
			homePage.logInBtn.click();
			// Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Then("User is taken to Home page")
	public void user_is_taken_to_Home_page() {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		try {
			IWait.explicit_wait(driver, homePage.newsFeedTab);
			Verify.verify(homePage.newsFeedTab.isDisplayed());
			Thread.sleep(3000);
			homePage.logOutMenu.click();
			IWait.explicit_wait(driver, homePage.signOutBtn);
			homePage.signOutBtn.click();
			IWait.explicit_wait(driver, homePage.byndrLogoOnLogin);
			Assert.assertTrue("User is on Byndr portal's login screen", homePage.byndrLogoOnLogin.isDisplayed());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		driver.quit();
	}

}
