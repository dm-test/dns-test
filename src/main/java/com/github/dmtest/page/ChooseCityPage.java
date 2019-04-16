package com.github.dmtest.page;

import com.github.dmtest.support.driver.DriverSupport;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class ChooseCityPage extends AnyPage {

    @FindBy(xpath = "//div[@class='select-lists state-city-select']//input[@data-role='search-city']")
    private TextInput searchCityInput;

    public ChooseCityPage() {
        new WebDriverWait(DriverSupport.getDriver(), 20)
                .withMessage(() -> "Не смог инициализировать страницу " + ItemPage.class.getSimpleName())
                .until(webDriver -> searchCityInput.isDisplayed());
    }

    public void chooseCity(String city) {
        searchCityInput.sendKeys(city + Keys.ENTER);
    }

}