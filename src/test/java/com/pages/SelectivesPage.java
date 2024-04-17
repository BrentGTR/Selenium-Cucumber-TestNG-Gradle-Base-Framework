package com.pages;
import com.buildSettings.TestEnvironment;
import com.pages.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SelectivesPage extends BasePage<SelectivesPage> {

    public SelectivesPage() {
        super(TestEnvironment.HOME_URL);
    }

    //Elements
    @FindBy(how = How.XPATH, using = "//iframe[starts-with(@id,'sp_message_iframe_')]")
    public WebElement iframeElement;
    @FindBy(how = How.XPATH, using = "//button[contains(@class, 'pg-accept-button')]")
    public WebElement acceptAllCookiesButton;
    @FindBy(xpath = "//*[contains(@class,'app-header-home__position--desktop')]" +
            "//a[starts-with(@class,'pexi-tm') and " +
            "contains(@class,'__secondary-button-top')]")
    public WebElement abonnerenButton;
}
