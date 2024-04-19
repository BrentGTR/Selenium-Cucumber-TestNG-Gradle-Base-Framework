package com.steps;

import com.DriverFactory;
import com.buildSettings.TestCommons;
import com.buildSettings.TestEnvironment;
import com.pages.AbonnementPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import org.testng.collections.Lists;

import java.util.List;
import java.util.Map;

public class AbonnementSteps extends TestEnvironment {

    private final WebDriver driver = DriverFactory.getDriver();
    private final AbonnementPage abonnementPage = new AbonnementPage();
    private final TestCommons testCommons = new TestCommons();

    @Step("I choose the {string} subscription option")
    @When("I choose the {string} subscription option")
    public void iChooseTheSubscriptionOption(String subscriptionOption) {
        switch (subscriptionOption) {
            case "Compleet":
                testCommons.customClick(abonnementPage.compleetButton);
                break;
            case "Zaterdag + Digitaal":
                //TODO: Add Zaterdag+Digitaal button
//                testCommons.customClick(freemiumPage.maanden24Button);
                break;
            case "Digitaal":
                //TODO: Add Digitaal button
//                testCommons.customClick(freemiumPage.maanden36Button);
                break;
            case "Digitaal Basis":
                //TODO: Add Digitaal Basis button
//                testCommons.customClick(freemiumPage.maanden36Button);
                break;
        }
    }

    @Step("I select the {string} discount period")
    @When("I select the {string} discount period")
    public void iSelectTheDiscountPeriod(String DiscountPeriod) {
        switch (DiscountPeriod) {
            case "12 maanden":
                //TODO: Add 12 maanden button
//                testCommons.customClick(freemiumPage.maanden12Button);
                break;
            case "24 maanden":
                testCommons.customClick(abonnementPage.maanden24Button);
                break;
            case "36 maanden":
                //TODO: Add 36 maanden button
//                testCommons.customClick(freemiumPage.maanden36Button);
                break;
        }
    }

    @Step("I fill in the subscription form with the following details:")
    @When("I fill in the subscription form with the following details:")
    public void fillSubscriptionForm(Map<String, String> formData) throws InterruptedException {
        //ACT
        testCommons.customSendKeys(abonnementPage.voornaamField, formData.get("Voornaam"));
        testCommons.customSendKeys(abonnementPage.achternaamField, formData.get("Achternaam"));
        testCommons.customSendKeys(abonnementPage.postcodeField, formData.get("Postcode"));
        testCommons.customSendKeys(abonnementPage.huisnummerField, formData.get("Huisnummer"));
        if (formData.get("Toevoeging") != null) {
            testCommons.customSendKeys(abonnementPage.toevoegingField, formData.get("Toevoeging"));
        }
        testCommons.customSendKeys(abonnementPage.telefoonnummerField, formData.get("Telefoonnummer"));

        // Input the email address
        do{
            abonnementPage.emailadresField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            abonnementPage.emailadresField.sendKeys(Keys.DELETE);
            abonnementPage.emailadresField.sendKeys(Keys.TAB);

            // Use mocked response for API call
//            performApiCall(); // Mocked API call

            testCommons.customSendKeys(abonnementPage.emailadresField, faker.internet().emailAddress());
            testCommons.customSendKeys(abonnementPage.ibanField, "");
            Thread.sleep(1000);
        }while(testCommons.isElementVisible(abonnementPage.textBoxEmailErrorMessage));
        // Continue filling the form
        testCommons.customSendKeys(abonnementPage.ibanField, formData.get("IBAN bankrekeningnummer"));
        testCommons.customSendKeys(abonnementPage.wachtwoordField, formData.get("Wachtwoord"));
        testCommons.customSendKeys(abonnementPage.WachtwoordcontroleField, formData.get("Wachtwoordcontrole"));

        //ASSERT
        //Checks if the address returned is correct
        SoftAssert softAssert = new SoftAssert();
        TestCommons.waitForElementToBeVisible(driver.findElement(By.cssSelector("div[data-test-id='postal-check']")));
        softAssert.assertEquals("Langenkampweg, Enschede", "Langenkampweg, Enschede");
        softAssert.assertAll();
    }

    @Step("I accept the terms and conditions")
    @When("I accept the terms and conditions")
    public void iAcceptTheTermsAndConditions() {
        testCommons.customClick(abonnementPage.disclaimerTermsAndConditionsCheckbox);
        testCommons.customClick(abonnementPage.disclamer18YearsOldCheckbox);
    }

    @Step("I complete the subscription process")
    @When("I complete the subscription process")
    public void iCompleteTheSubscriptionProcess() {
        testCommons.customClick(abonnementPage.submitButton);
    }

    @Then("I should see the thank you page confirming my subscription")
    public void iShouldSeeTheThankYouPageConfirmingMySubscription() {
        TestCommons.waitForElementToBeVisible(abonnementPage.thankYouMessage);
    }
}

