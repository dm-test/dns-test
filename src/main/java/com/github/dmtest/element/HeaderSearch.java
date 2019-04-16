package com.github.dmtest.element;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

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
