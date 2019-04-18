package com.github.dmtest.stepdefs;

import com.github.dmtest.support.driver.DriverSupport;
import cucumber.api.java.ru.Когда;

public class CommonSteps {

    @Когда("^Открывает URL \"([^\"]*)\"$")
    public void openUrl(String url) {
        DriverSupport.getDriver().get(url);
    }
}
