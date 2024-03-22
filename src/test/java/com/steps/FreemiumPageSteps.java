package com.steps;

import com.DriverFactory;
import com.buildSettings.ContextInjection;
import com.buildSettings.TestCommons;
import com.buildSettings.TestEnvironment;
import com.pages.AbonnementPage;
import com.pages.FreemiumPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.Map;

import static com.buildSettings.TestCommons.isPageReady;

public class FreemiumPageSteps extends TestEnvironment {

    private final WebDriver driver = DriverFactory.getDriver();
    private final FreemiumPage freemiumPage = new FreemiumPage();
    private final TestCommons testCommons = new TestCommons();



    @Step("I open home page of {string}")
    @Given("I open home page of {string}")
    public void iOpenHomePage(String website) throws InterruptedException {
        //ARRANGE
        final String expectedPageURL = freemiumPage.getWebsiteURL(website);

        //ACT
        DriverFactory.getDriver().get("https://" + website);
        testCommons.waitForAndClickShadowDomElement(freemiumPage.acceptAllCookiesButton);

        //ASSERT
        Thread.sleep(2000); //Wait for page to load completely
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(DriverFactory.getDriver().getCurrentUrl(), expectedPageURL, "Current URL doesn't match expected URL");
        softAssert.assertAll();
    }

    @Step("I click on the {string} button")
    @When("I click on the {string} button")
    public void iClickOnTheButton(String arg0) {
        testCommons.customClick(freemiumPage.abonnerenButton);
    }








}
