package com.github.dmtest.pages;

import com.github.dmtest.elements.HeaderSearch;
import com.github.dmtest.elements.HeaderTop;
import com.github.dmtest.support.driver.DriverSupport;
import com.github.dmtest.support.element.CustomHtmlElementDecorator;
import com.github.dmtest.support.page.PageSupport;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.element.Named;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public abstract class AnyPage implements Named {

    @FindBy(xpath = "//div[@class='header-top']")
    private HeaderTop headerTop;

    @FindBy(xpath = "//nav[@id='header-search']")
    private HeaderSearch headerSearch;

    AnyPage() {
        WebDriver driver = DriverSupport.getDriver();
        PageFactory.initElements(new CustomHtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }

    @Override
    public String getName() {
        return PageSupport.getAnnotationNameValue(this.getClass());
    }

    public HeaderSearch getHeaderSearch() {
        return headerSearch;
    }

    public HeaderTop getHeaderTop() {
        return headerTop;
    }
}
