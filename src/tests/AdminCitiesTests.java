package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest {

	@Test(priority = 10)
    public void visitsTheAdminCitiesPageAndListCities() {

        nav.getLoginButton().click();
        login.getEmailInput().sendKeys("admin@admin.com");
        login.getPasswordInput().sendKeys("12345");
        login.getLoginButton().click();

        nav.getAdminButton().click();
        nav.getCitiesButton().click();

        Assert.assertTrue(driver.getCurrentUrl()
                        .contains("/admin/cities"),
                "ERROR: URL does not contain '/admin/cities'");
    }
	
	@Test(priority = 20)
    public void checksInputTypesForCreateOrEditNewCity() {
        nav.getAdminButton().click();
        nav.getCitiesButton().click();

        cities.getNewItemButton().click();
        cities.waitForEditDialogueToBeVisible();

        Assert.assertEquals(cities.getCityName()
                        .getAttribute("type"),
                "text",
                "ERROR: New item name is not type 'text'");
    }
	
	 @Test(priority = 30)
	    public void createNewCity() {

	        nav.getAdminButton().click();
	        nav.getCitiesButton().click();

	        cities.getNewItemButton().click();
	        cities.waitForEditDialogueToBeVisible();

	        cities.getCityName().sendKeys("Aleksinac");
	        cities.getSaveNewCityButton().click();

	        cities.waitForMessageSuccessfullySaveCity();
	        
	        Assert.assertTrue(cities.getMessageTextSuccessfullySaveCity()
	                        .getText().contains("Saved successfully"),
	                "ERROR: The message does not contain 'Saved successfully'");
	    }
	 @Test(priority = 40)
	    public void editCity() {


	        nav.getAdminButton().click();
	        nav.getCitiesButton().click();

	        cities.getSearchInput().sendKeys("Aleksinac");
	        cities.waitForNumberOfRows(1);
	        cities.getEditButtonFromRow(1).click();


	        cities.getCityName().sendKeys(Keys.CONTROL,"a");
	        cities.getCityName().sendKeys("Sjenica");
	        cities.getSaveNewCityButton().click();

	        cities.waitForMessageSuccessfullySaveCity();
	        Assert.assertTrue(cities.getMessageTextSuccessfullySaveCity()
	                        .getText().contains("Saved successfully"),
	                "ERROR: The message from pop-up does not contain 'Saved successfully'");
	    }



	    @Test(priority = 50)
	    public void searchCity(){

	        nav.getAdminButton().click();
	        nav.getCitiesButton().click();

	        cities.getSearchInput().sendKeys("Sjenica");
	        cities.waitForNumberOfRows(1);

	        Assert.assertEquals(cities.getCell(1, 2).getText(),
	                "Duga Poljana",
	                "ERROR: City with that name does not exist.");
	    }


	    @Test(priority = 60)
	    public void deleteCity(){

	        nav.getAdminButton().click();
	        nav.getCitiesButton().click();

	        cities.getSearchInput().sendKeys("Sjenica");
	        cities.waitForNumberOfRows(1);

	        Assert.assertEquals(cities.getCell(1, 2).getText(),
	                "Duga Poljana",
	                "ERROR: City with that name does not exist.");

	        cities.getDeleteButtonFromRow(1).click();
	        cities.waitForDeleteDialogueToBeVisible();
	        cities.getDeleteButton().click();

	        cities.waitForMessageSuccessfullySaveCity();
	        Assert.assertTrue(cities.getMessageTextSuccessfullySaveCity()
	                        .getText().contains("Deleted successfully"),
	                "ERROR: The message does not contain 'Deleted successfully'");
	    }

}
