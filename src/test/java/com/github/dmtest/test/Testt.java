package com.github.dmtest.test;

import com.github.dmtest.page.MainPage;
import com.github.dmtest.support.driver.DriverSupport;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class Testt {

    @Test
    public void test1() {
        WebDriver driver = DriverSupport.getDriver();
        driver.get("https://www.dns-shop.ru//");
        MainPage mainPage = new MainPage();
    }

    @Test
    public void test2() {
        WebDriver driver = DriverSupport.getDriver();
        driver.get("https://www.dns-shop.ru//");
        MainPage mainPage = new MainPage();
        mainPage.getHeaderSearch().getSearchInput().sendKeys("1149364");
        mainPage.getHeaderSearch().getSearchButton().click();

    }

    @AfterEach
    public void tearDown() {
        DriverSupport.getDriver().quit();
    }

}
