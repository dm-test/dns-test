package com.github.dmtest.page;

import com.github.dmtest.support.driver.DriverSupport;
import com.github.dmtest.support.page.CustomHtmlElementDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public abstract class AnyPage {

    AnyPage() {
        WebDriver driver = DriverSupport.getDriver();
        PageFactory.initElements(new CustomHtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
    }
}
