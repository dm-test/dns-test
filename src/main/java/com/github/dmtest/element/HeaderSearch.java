package com.github.dmtest.element;

import com.github.dmtest.support.driver.DriverSupport;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class HeaderSearch extends TypifiedElement {

    @FindBy(xpath = ".//input[starts-with(@class,'main-search-form__input')]")
    private TextInput searchInput;

    @FindBy(xpath = ".//button[@class='main-search-form__button']")
    private Button searchButton;

    @FindBy(xpath = ".//a[starts-with(@class,'btn-compare-link')]")
    private Button compareButton;

    @FindBy(xpath = ".//a[starts-with(@class,'btn-wishlist-link')]")
    private Button favouritesButton;

    @FindBy(xpath = ".//a[starts-with(@class,'btn-cart-link')]")
    private Button cartButton;

    public HeaderSearch(WebElement wrappedElement) {
        super(wrappedElement);
        WebDriver driver = DriverSupport.getDriver();
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }

    public TextInput getSearchInput() {
        return searchInput;
    }

    public Button getSearchButton() {
        return searchButton;
    }

    public Button getCompareButton() {
        return compareButton;
    }

    public Button getFavouritesButton() {
        return favouritesButton;
    }

    public Button getCartButton() {
        return cartButton;
    }
}
