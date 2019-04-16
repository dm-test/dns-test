package com.github.dmtest.page;

import com.github.dmtest.element.HeaderSearch;
import com.github.dmtest.element.HeaderTop;
import com.github.dmtest.support.driver.DriverSupport;
import com.github.dmtest.support.page.CustomHtmlElementDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public abstract class AnyPage {

    @FindBy(xpath = "//div[@class='header-top']")
    private HeaderTop headerTop;

    @FindBy(xpath = "//nav[@id='header-search']")
    private HeaderSearch headerSearch;

    AnyPage() {
        WebDriver driver = DriverSupport.getDriver();
        PageFactory.initElements(new CustomHtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }

    public HeaderSearch getHeaderSearch() {
        return headerSearch;
    }

    public HeaderTop getHeaderTop() {
        return headerTop;
    }
}
