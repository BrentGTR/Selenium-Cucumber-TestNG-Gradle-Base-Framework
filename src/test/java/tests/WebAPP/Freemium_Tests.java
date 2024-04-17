package tests.WebAPP;

import com.buildListeners.TestNGListener;
import com.buildSettings.ExcelEnvironment;
import com.pages.AbonnementPage;
import com.pages.FreemiumPage;
import com.steps.AbonnementSteps;
import com.steps.FreemiumPageSteps;
import com.steps.hooks.WEB_Hooks;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.jetbrains.annotations.NotNull;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

@Epic("DPG Automation POC")
@Feature("Freemium Tests")
@Owner("Brent Singh")
@Listeners({TestNGListener.class})
public class Freemium_Tests extends WEB_Hooks {

    @Story("HAPPY PATH")
    @Test(description = "Subscribe to Newsletter on Freemium Websites", priority = 0)
    @Parameters("website")
    public void SubscribeToNewsletter(String website) throws InterruptedException {
        System.out.println("Website parameter value: " + website);
        //ARRANGE
        final FreemiumPageSteps freemiumPageSteps = new FreemiumPageSteps();
        final AbonnementSteps abonnementSteps = new AbonnementSteps();
        final FreemiumPage freemiumPage = new FreemiumPage();
        final AbonnementPage abonnementPage = new AbonnementPage();

        Map<String, String> formData = getStringStringMap(website);

        //ACT
        freemiumPageSteps.iOpenHomePage(website);
        freemiumPageSteps.iClickOnTheButton("Abonneren");
        abonnementSteps.iChooseTheSubscriptionOption("Compleet");
        abonnementSteps.iSelectTheDiscountPeriod("24 maanden");
        abonnementSteps.fillSubscriptionForm(formData);
        abonnementSteps.iAcceptTheTermsAndConditions();
        abonnementSteps.iCompleteTheSubscriptionProcess();

        //ASSERT
        abonnementSteps.iShouldSeeTheThankYouPageConfirmingMySubscription();
    }

    @NotNull
    private static Map<String, String> getStringStringMap(String website) {
        Map<String, String> formData = new HashMap<>();
        String postCode = "";
        String huisNummer = "";
        String toevoeging = "";

        // Fill the Map with the provided data
        formData.put("Voornaam", faker.name().firstName());
        formData.put("Achternaam", faker.name().lastName());
        switch (website) {
            case "www.bd.nl":
                postCode = "5232JL";
                huisNummer = "7";
                toevoeging = "";
                break;
            case "www.tubantia.nl", "www.ed.nl":
                postCode = "7541AZ";
                huisNummer = "376";
                toevoeging = "";
                break;
            case "www.ad.nl":
                postCode = "1431HM";
                huisNummer = "102";
                toevoeging = "";
                break;
        }
        formData.put("Postcode", postCode);
        formData.put("Huisnummer", huisNummer);
        formData.put("Toevoeging", toevoeging);
        formData.put("Telefoonnummer", "0648642540");
        formData.put("E-mailadres", "<emailAddress>");
        formData.put("Wachtwoord", "wachtwoord");
        formData.put("Wachtwoordcontrole", "wachtwoord");
        formData.put("IBAN bankrekeningnummer", "NL38RABO1628106735");
        return formData;
    }
}
