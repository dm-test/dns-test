package com.github.dmtest.pages;

import com.github.dmtest.support.driver.DriverSupport;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.TextBlock;

@Name("Главная")
public class MainPage extends AnyPage {

    @FindBy(xpath = "//h2[text()='Лучшие предложения']")
    private TextBlock bestOffersTextBlock;

    public MainPage() {
        new WebDriverWait(DriverSupport.getDriver(), 20)
                .withMessage(() -> "Не смог инициализировать страницу " + MainPage.class.getSimpleName())
                .until(webDriver -> bestOffersTextBlock.isDisplayed());
    }

    public TextBlock getBestOffersTextBlock() {
        return bestOffersTextBlock;
    }
}
