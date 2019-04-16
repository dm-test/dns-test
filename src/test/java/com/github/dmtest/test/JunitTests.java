package com.github.dmtest.test;

import com.github.dmtest.page.ChooseCityPage;
import com.github.dmtest.page.ItemPage;
import com.github.dmtest.page.MainPage;
import com.github.dmtest.support.driver.DriverSupport;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class JunitTests {

    @Test
    public void test1() {
        WebDriver driver = DriverSupport.getDriver();
        driver.get("https://www.dns-shop.ru");
        MainPage mainPage = new MainPage();
        mainPage.getHeaderTop().getCityButton().click();
        ChooseCityPage chooseCityPage = new ChooseCityPage();
        chooseCityPage.chooseCity("Казань");
        mainPage = new MainPage();
        mainPage.getHeaderSearch().getSearchInput().sendKeys("1249062");
        mainPage.getHeaderSearch().getSearchButton().click();
        ItemPage itemPage = new ItemPage();
        itemPage.buyItem();
    }

    @Test
    public void test2() {
        WebDriver driver = DriverSupport.getDriver();
        driver.get("https://www.dns-shop.ru");
        MainPage mainPage = new MainPage();
        mainPage.getHeaderTop().getCityButton().click();
        ChooseCityPage chooseCityPage = new ChooseCityPage();
        chooseCityPage.chooseCity("Москва");
        mainPage = new MainPage();
        mainPage.getHeaderSearch().getSearchInput().sendKeys("1149364");
        mainPage.getHeaderSearch().getSearchButton().click();
        ItemPage itemPage = new ItemPage();
        itemPage.buyItem();
    }

    @AfterEach
    public void tearDown() {
        DriverSupport.getDriver().quit();
    }

}
