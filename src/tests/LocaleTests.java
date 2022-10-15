package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest {

	@Test(priority = 10)
    public void setLocaleToES() {
        nav.getLanguagesButton().click();
        nav.getSpainButton().click();

        Assert.assertTrue(nav.getHeader().getText()
                        .contains("Página de aterrizaje"),
                "ERROR: Header does not contain text 'Página de aterrizaje' ");
    }

    @Test(priority = 20)
    public void setLocaleToEN() {
        nav.getLanguagesButton().click();
        nav.getEnglishButton().click();

        Assert.assertTrue(nav.getHeader().getText()
                        .contains("Landing"),
                "ERROR: Header does not contain text 'Landing' ");
    }


    @Test(priority = 30)
    public void setLocaleToCN() {
        nav.getLanguagesButton().click();
        nav.getChinaButton().click();

        Assert.assertTrue(nav.getHeader().getText()
                        .contains("首页"),
                "ERROR: Header does not contain text '首页' ");
    }

    @Test(priority = 40)
    public void setLocaleToFR() {
        nav.getLanguagesButton().click();
        nav.getFranceButton().click();

        Assert.assertTrue(nav.getHeader().getText()
                        .contains("Page d'atterrissage"),
                "ERROR: Header does not contain text 'Page d'atterrissage' ");
    }

}

