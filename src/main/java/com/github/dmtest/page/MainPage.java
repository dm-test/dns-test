package com.github.dmtest.page;

import com.github.dmtest.element.HeaderSearch;
import com.github.dmtest.support.driver.DriverSupport;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.TextBlock;

public class MainPage extends AnyPage {

    @FindBy(xpath = "//nav[@id='header-search']")
    private HeaderSearch headerSearch;

    @FindBy(xpath = "//h2[text()='Лучшие предложения']")
    private TextBlock bestOffersTextBlock;

    public MainPage() {
        new WebDriverWait(DriverSupport.getDriver(), 10)
                .withMessage(() -> "Не смог инициализировать страницу " + MainPage.class.getSimpleName())
                .until(webDriver -> bestOffersTextBlock.isDisplayed());
    }

    public HeaderSearch getHeaderSearch() {
        return headerSearch;
    }

    public TextBlock getBestOffersTextBlock() {
        return bestOffersTextBlock;
    }
}
