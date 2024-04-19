package com.steps;

import com.DriverFactory;
import com.buildSettings.TestCommons;
import com.buildSettings.TestEnvironment;
import com.pages.SelectivesPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import org.testng.collections.Lists;

import java.util.List;

public class SelectivesPageSteps extends TestEnvironment {

    private final WebDriver driver = DriverFactory.getDriver();
    private final SelectivesPage selectivesPage = new SelectivesPage();
    private final TestCommons testCommons = new TestCommons();



    @Step("I open the Selectives home page of {string}")
    @Given("I open the Selectives home page of {string}")
    public void iOpenTheSelectivesHomePage(String website) throws InterruptedException {
        //ARRANGE
        final String expectedPageURL = selectivesPage.getWebsiteURL(website);
        driver.get("https://" + website);

        //ACT
        testCommons.waitForElementToBeVisible(selectivesPage.iframeElement);
        driver.switchTo().frame(selectivesPage.iframeElement);
        testCommons.customClick(selectivesPage.acceptAllCookiesButton);
        // Switch back to the default content
        driver.switchTo().defaultContent();

        //ASSERT
        Thread.sleep(5000); //Wait for page to load completely
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(DriverFactory.getDriver().getCurrentUrl(), expectedPageURL, "Current URL doesn't match expected URL");
        softAssert.assertAll();
    }

    @Step("I click on the Selectives abonneren {string} button")
    @When("I click on the Selectives abonneren {string} button")
    public void iClickOnTheSelctivesAbonnerenButton(String arg0) {
        testCommons.customClick(selectivesPage.abonnerenButton);

        // Switch to second tab
        List<String> browserTabs = Lists.newArrayList(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(1));
    }








}
