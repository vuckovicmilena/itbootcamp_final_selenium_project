package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePouUpPage {

	private WebDriver driver;

	public MessagePouUpPage(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForPopUpToBeVisible() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'v-snack__content')]")));
	}
	 public WebElement getTextMessage() {
	        return driver.findElement(By.xpath("//div[@role = 'status']//li"));
	    }
	 public WebElement getCloseButton() {
	        return driver.findElement(By.xpath("//div[@role = 'status']//button"));
	    }
	 public WebElement getTextMessageImportant() {
	        return driver.findElement(By.className("dlgVerifyAccount"));
	    }
	 public void waitForVerifyAccountPopUp() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	        wait.until(ExpectedConditions
	                .visibilityOfElementLocated(By.className("dlgVerifyAccount")));
	    }
	 public WebElement getCloseButtonFromVerifyAccount() {
	        return driver.findElement(By.className("btnClose"));
	    }

}
