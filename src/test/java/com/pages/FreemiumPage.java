package com.pages;
import com.buildSettings.TestCommons;
import com.buildSettings.TestEnvironment;
import com.pages.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FreemiumPage extends BasePage<FreemiumPage> {

    public FreemiumPage() {
        super(TestEnvironment.HOME_URL);
    }

    //Elements
    @FindBy(how = How.ID, using = "pg-accept-btn")
    public WebElement acceptAllCookiesButton;

    @FindBy(xpath = "//*[starts-with(@id,'pexi-tm') and contains(@id,'__TEKSTLINK_HEADER')]")
    public WebElement abonnerenButton;
}
