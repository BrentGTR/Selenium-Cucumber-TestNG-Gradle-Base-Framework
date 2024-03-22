package com.steps;

import com.DriverFactory;
import com.buildSettings.TestCommons;
import com.buildSettings.TestEnvironment;
import com.pages.AbonnementPage;
import com.pages.FreemiumPage;
import com.pages.SelectivesPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class SelectivesPageSteps extends TestEnvironment {

    private final WebDriver driver = DriverFactory.getDriver();
    private final SelectivesPage selectivesPage = new SelectivesPage();
    private final TestCommons testCommons = new TestCommons();



    @Step("I open the Selectives home page of {string}")
    @Given("I open the Selectives home page of {string}")
    public void iOpenTheSelectivesHomePage(String website) throws InterruptedException {
        //ARRANGE
        final String expectedPageURL = selectivesPage.getWebsiteURL(website);

        //ACT
        DriverFactory.getDriver().get("https://" + website);
        testCommons.customClick(selectivesPage.acceptAllCookiesButton); //TODO: Fix this

        //ASSERT
        Thread.sleep(2000); //Wait for page to load completely
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(DriverFactory.getDriver().getCurrentUrl(), expectedPageURL, "Current URL doesn't match expected URL");
        softAssert.assertAll();
    }

    @Step("I click on the Selectives abonneren {string} button")
    @When("I click on the Selectives abonneren {string} button")
    public void iClickOnTheSelctivesAbonnerenButton(String arg0) {
        testCommons.customClick(selectivesPage.abonnerenButton);
    }








}
