package com.github.dmtest.support.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Objects;

public class DriverSupport {
    private static ThreadLocal<WebDriver> driverContainer = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (Objects.isNull(driverContainer.get()) || hasQuit(driverContainer.get())) {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driverContainer.set(driver);
        }
        return driverContainer.get();
    }

    private static boolean hasQuit(WebDriver driver) {
        return Objects.isNull(((RemoteWebDriver) driver).getSessionId());
    }

}
