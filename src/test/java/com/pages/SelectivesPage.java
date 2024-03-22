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
    @FindBy(how = How.XPATH, using = "//button[contains(@class, 'pg-accept-button')]")
    public WebElement acceptAllCookiesButton;

    @FindBy(xpath = "//*[starts-with(@id,'pexi-tm') and contains(@id,'__secondary-button-top')]")
    public WebElement abonnerenButton;
}
