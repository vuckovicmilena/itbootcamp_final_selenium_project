package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pages.CitiesPage;
import pages.LoginPage;
import pages.MessagePouUpPage;
import pages.NavPage;
import pages.SignUpPage;

public class BasicTest {

	 protected WebDriver driver;
	    protected String baseUrl = "https://vue-demo.daniel-avellaneda.com";
	    protected LoginPage login;
	    protected NavPage nav;
	    protected SignUpPage signUp;
	    protected CitiesPage cities;
	    protected MessagePouUpPage messagePopUp;

	    
	    @BeforeClass
	    public void beforeClass() {
	        System.setProperty("webdriver.chrome.driver",
	                "drivers/chromedriver.exe");

	        driver = new ChromeDriver();

	        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.manage().window().maximize();

	        login = new LoginPage(driver);
	        nav = new NavPage(driver);
	        signUp = new SignUpPage(driver);
	        cities = new CitiesPage(driver);
	        messagePopUp = new MessagePouUpPage(driver);
	    }


	    @BeforeMethod
	    public void beforeMethod() {
	        this.driver.navigate().to(baseUrl);
	    }


	    @AfterMethod
	    public void afterMethod() {
	    }

	    @AfterClass
	    public void afterClass() {
	        driver.quit();
	    }
}
