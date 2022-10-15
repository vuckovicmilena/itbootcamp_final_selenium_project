package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage {

	private WebDriver driver;

	public CitiesPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getNewItemButton() {
		return driver.findElement(By.className("btnNewItem"));
	}

	public WebElement getSearchInput() {
		return driver.findElement(By.id("search"));
	}
	public WebElement getCityName() {
		return driver.findElement(By.id("name"));
	}
	public WebElement getSaveNewCityButton() {
		return driver.findElement(By.className("btnSave"));
	}
	

	public void waitForEditDialogueToBeVisible() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dlgNewEditItem")));
	}

	public void waitForDeleteDialogueToBeVisible() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("body-1")));
	}


	public WebElement getDeleteButton() {
		return driver.findElement(By.xpath("//div[contains(@class, 'v-card__actions')]/button[2]"));
	}
	 public void waitForNumberOfRows(int rowNumber) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.numberOfElementsToBe(
	                       By.xpath("//tbody/tr"), rowNumber));
	    }
	 public WebElement getCell(int rowNumber, int columnNumber) {
	        return driver
	                .findElement(By.xpath(
	                        "//tbody/tr[" + rowNumber + "]/td[" + columnNumber + "]"));
	    }
	 public WebElement getEditButtonFromRow(int rowNumber) {
	        return driver.findElement(
	                By.xpath("//tbody/tr[" + rowNumber + "]//button[@id='edit']"));
	    }
	 public WebElement getDeleteButtonFromRow(int rowNumber) {
	        return this.driver.findElement(By.xpath("//tbody/tr[" + rowNumber + "]//div/button[2]"));
	    }
	 
	 public void waitForMessageSuccessfullySaveCity() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("success")));
	    }
	 public WebElement getMessageTextSuccessfullySaveCity() {
	        return driver.findElement(By.className("success"));
	    }
	 
}
