package tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest {
	
	@Test(priority = 10)
	public void visitTheLoginPage() {
		nav.getLanguagesButton().click();
		nav.getEnglishButton().click();
		nav.getLoginButton().click();

		Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "ERROR: URL does not contain '/login' route");

	}

	@Test(priority = 20)
	public void checkInputTypes() {
		nav.getLoginButton().click();

		Assert.assertEquals(login.getEmailInput().getAttribute("type"), "email", "Email attribute is not 'email'");

		Assert.assertEquals(login.getPasswordInput().getAttribute("type"), "password",
				"Password attribute is not 'password'");
	}

	@Test(priority = 30)
	public void displayErrorsWhenUserDoesNotExist() {
		nav.getLoginButton().click();
		login.getEmailInput().sendKeys("non-existing-user@gmal.com");
		login.getPasswordInput().sendKeys("password123");
		login.getLoginButton().click();

		messagePopUp.waitForPopUpToBeVisible();

		Assert.assertEquals(messagePopUp.getTextMessage().getText(), "User does not exists",
				"ERROR: Pop up message does not contain 'User does not exists' text");

		Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "ERROR: Page URL does not contain '/login' route");
	}

	@Test(priority = 40)
	public void displaysErrorsWhenPasswordIsWrong() {
		nav.getLoginButton().click();

		login.getEmailInput().sendKeys("admin@admin.com");
		login.getPasswordInput().sendKeys("password123");
		login.getLoginButton().click();

		messagePopUp.waitForPopUpToBeVisible();

		Assert.assertEquals(messagePopUp.getTextMessage().getText(), "Wrong password",
				"ERROR: Message does not contain 'Wrong password' text");

		Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "ERROR: Page URL does not contain '/login' route");
	}

	@Test(priority = 50)
	public void Login() throws InterruptedException {

		nav.getLoginButton().click();

		login.getEmailInput().sendKeys("admin@admin.com");
		login.getPasswordInput().sendKeys("12345");
		login.getLoginButton().click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Assert.assertTrue(wait.until(ExpectedConditions.urlContains("/home")),
				"ERROR: Page URL does not contain '/home'");
	}

	@Test(priority = 60)
	public void Logout() {
		
		Assert.assertTrue(nav.getLogoutButton().isDisplayed(), "ERROR: Logout button in not visible");

		nav.getLogoutButton().click();
	}

}

	