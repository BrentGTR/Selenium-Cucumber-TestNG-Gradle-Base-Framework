package com.pages.base;

import com.DriverFactory;
import com.buildSettings.TestCommons;
import com.buildSettings.TestEnvironment;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;



public abstract class BasePage<T extends LoadableComponent<T>> extends LoadableComponent<T> {

    private final String pageURL;

    protected BasePage(String pageURL) {
        this.pageURL = pageURL;
        //PageFactory.initElements(new AjaxElementLocatorFactory(DriverFactory.getDriver(), TIMEOUT), this);
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public String getWebsiteURL(String website) {
        return switch (website) {
            case "www.bndestem.nl" -> "https://www.bndestem.nl/";
            case "www.tubantia.nl" -> "https://www.tubantia.nl/";
            case "www.bd.nl" -> "https://www.bd.nl/";
            case "www.volkskrant.nl" -> "https://www.volkskrant.nl/";
            default -> throw new IllegalArgumentException("Unsupported website: " + website);
        };
    }

    @Override
    public void load() {
        if (pageURL.startsWith("http://") || pageURL.startsWith("https://")) {
            DriverFactory.getDriver().get(pageURL);
        } else {
            DriverFactory.getDriver().get(TestEnvironment.HOME_URL + pageURL);
        }
    }

    @Override
    public void isLoaded() throws Error {
        if (!DriverFactory.getDriver().getCurrentUrl().contains(pageURL) && TestCommons.isPageReady()) {
            throw new Error("Automationpractice website isn't correctly loaded!");
        }
    }
}