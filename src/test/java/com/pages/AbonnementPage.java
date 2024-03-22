package com.pages;

import com.buildSettings.TestEnvironment;
import com.pages.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AbonnementPage extends BasePage<AbonnementPage> {

    public AbonnementPage() {
        super(TestEnvironment.HOME_URL);
    }

    @FindBy(how = How.CSS, using = "[data-test-id='product-card-compleet-button']")
    public WebElement compleetButton;

    @FindBy(how = How.CSS, using = "[data-test-id='24 maanden']")
    public WebElement maanden24Button;

    @FindBy(how = How.CSS, using = "[data-test-id='Voornaam']")
    public WebElement voornaamField;

    @FindBy(how = How.CSS, using = "[data-test-id='Achternaam']")
    public WebElement achternaamField;

    @FindBy(how = How.CSS, using = "[data-test-id='Postcode']")
    public WebElement postcodeField;

    @FindBy(how = How.CSS, using = "[data-test-id='Huisnummer']")
    public WebElement huisnummerField;

    @FindBy(how = How.CSS, using = "[data-test-id='Toevoeging']")
    public WebElement toevoegingField;

    @FindBy(how = How.CSS, using = "[data-test-id='Telefoonnummer']")
    public WebElement telefoonnummerField;

    @FindBy(how = How.CSS, using = "[data-test-id='E-mailadres']")
    public WebElement emailadresField;

    @FindBy(how = How.ID, using = "checkmark")
    public WebElement emailCheckMark;

    @FindBy(how = How.CSS, using = "[data-test-id='Wachtwoord']")
    public WebElement wachtwoordField;

    @FindBy(how = How.CSS, using = "[data-test-id='Wachtwoordcontrole']")
    public WebElement WachtwoordcontroleField;

    @FindBy(how = How.CSS, using = "[data-test-id='IBAN bankrekeningnummer']")
    public WebElement ibanField;

    @FindBy(how = How.CSS, using = "[data-test-id='app-checkbox-input'][name='disclaimer']")
    public WebElement disclaimerTermsAndConditionsCheckbox;

    @FindBy(how = How.CSS, using = "[data-test-id='app-checkbox-input'][name='disclaimer_test_18_years_old']")
    public WebElement disclamer18YearsOldCheckbox;

    @FindBy(how = How.CSS, using = "[data-test-id='submit-checkout-desktop']")
    public WebElement submitButton;

    @FindBy(how = How.ID, using = "page-bedankt-bevestiging")
    public WebElement thankYouMessage;
}
