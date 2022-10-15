package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavPage {

	private WebDriver driver;

    public NavPage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getHomeLink() {
        return driver.findElement(By.xpath("//div[contains(@class, 'v-toolbar__items')]/a[1]"));
    }
    public WebElement getAboutLink() {
        return driver.findElement(By.xpath("//div[contains(@class, 'v-toolbar__items')]/a[2]"));
    }
    public WebElement getMyProfileLink() {
        return driver.findElement(By.xpath("//div[contains(@class, 'v-toolbar__items')]/a[3]"));
    }
    public WebElement getAdminButton() {
        return driver.findElement(By.className("btnAdmin"));
    }
    public WebElement getCitiesButton() {
        return this.driver.findElement(By.className("btnAdminCities"));
    }
    public WebElement getUsersButton() {
        return this.driver.findElement(By.className("btnAdminUsers"));
    }
    public WebElement getSignUpButton() {
    	return driver.findElement(By.xpath("//div[@class = 'v-toolbar__items']/a[4]"));
    }
    public WebElement getHeader(){
        return driver.findElement(By.tagName("h1"));
    }
    public WebElement getLoginButton() {
        return driver.findElement(By.className("btnLogin"));
    }
    public WebElement getLogoutButton() {
        return driver.findElement(By.className("btnLogout"));
    }
    public WebElement getLanguagesButton() {
        return driver.findElement(By.className("btnLocaleActivation"));
    }
    public WebElement getEnglishButton() {
        return driver.findElement(By.className("btnEN"));
    }
    public WebElement getSpainButton() {
        return driver.findElement(By.className("btnES"));
    }
    public WebElement getFranceButton() {
        return driver.findElement(By.className("btnFR"));
    }
    public WebElement getChinaButton() {
        return driver.findElement(By.className("btnCN"));
    }
    public WebElement getUkrainaButton() {
        return driver.findElement(By.className("btnUA"));
    }
    
}
