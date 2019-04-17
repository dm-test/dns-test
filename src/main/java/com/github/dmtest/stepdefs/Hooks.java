package com.github.dmtest.stepdefs;

import com.github.dmtest.support.driver.DriverSupport;
import cucumber.api.java.After;

public class Hooks {

    @After
    public void quitDriver() {
        DriverSupport.getDriver().quit();
    }
}
