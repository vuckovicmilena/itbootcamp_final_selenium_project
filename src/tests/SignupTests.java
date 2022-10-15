import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest {

	@Test(priority = 10)
	public void visitsTheSignupPage() {
		nav.getSignUpButton().click();

		Assert.assertTrue(driver.getCurrentUrl().contains("/signup"), "ERROR: URL does not contain '/signup' route");
	}

	@Test(priority = 20)
	public void checksInputTypes() {
		nav.getSignUpButton().click();
		Assert.assertTrue(signUp.getEmailInput().getAttribute("type").equals("email"),
				"ERROR: Email is not type 'email'");

		Assert.assertTrue(signUp.getPasswordInput().getAttribute("type").equals("password"),
				"ERROR: Password is not type 'password'");

		Assert.assertTrue(signUp.getConfirmPasswordInput().getAttribute("type").equals("password"),
				"ERROR: Confirm password is not type 'password'");
	}
	 @Test(priority = 30)
	    public void displayErrorsWhenUsersAlreadyExists() {
	        nav.getSignUpButton().click();
	        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"), "ERROR: URL route does not contain '/signup'");
	        signUp.getNameInput().sendKeys("Another Use");
	        signUp.getEmailInput().sendKeys("admin@admin.com");
	        signUp.getPasswordInput().sendKeys("12345");
	        signUp.getConfirmPasswordInput().sendKeys("12345");
	        signUp.getSignMeUpButton().click();

	        messagePopUp.waitForPopUpToBeVisible();
	        Assert.assertEquals(messagePopUp.getTextMessage()
	                        .getText(),
	                "E-mail already exists",
	                "ERROR: In pop up message does not exist 'E-mail already exists'");
	        Assert.assertTrue(driver.getCurrentUrl()
	                        .contains("/signup"),
	                "ERROR: URL does not contain '/signup'");

	    }

	    @Test(priority = 40)
	    public void signup() {
	        nav.getSignUpButton().click();

	        signUp.getNameInput().sendKeys("Milena Vuckovic");
	        signUp.getEmailInput().sendKeys("mv1993@gmail.com");
	        signUp.getPasswordInput().sendKeys("12345");
	        signUp.getConfirmPasswordInput().sendKeys("12345");
	        signUp.getSignMeUpButton().click();


	        messagePopUp.waitForVerifyAccountPopUp();
	        Assert.assertEquals(messagePopUp.getTextMessageImportant().getText(),
	                "IMPORTANT: Verify your account",
	                "ERROR: The message from pop-up does not 'IMPORTANT: Verify your account'.");
	        
	        messagePopUp.getCloseButtonFromVerifyAccount().click();

	        nav.getLogoutButton().click();
	    }

}