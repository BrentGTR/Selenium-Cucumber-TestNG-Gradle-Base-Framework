package tests.WebAPI;

import com.buildListeners.TestNGListener;
import com.buildSettings.ExcelEnvironment;
import com.steps.hooks.API_Hooks;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;



@Epic("API Tests")
@Feature("HTTP Statuses")
@Listeners({TestNGListener.class})
public class API_Tests extends API_Hooks {

    private String restHomeURL() {
        return RestAssured.baseURI = "https://abonnement.ed.nl/";
    }

    @Issue("TAP/API-0001")
    @TmsLink("JIRA-000")
    @Story("HTTP STATUSES")
    @Owner("Brent Singh")
    @Severity(SeverityLevel.BLOCKER)
    @Description("As a user I would like to check availability of my email address")
    @Test(description = "As a user I would like to check availability of my email address",
            priority = 0)
    public void login_url_check(String bearerToken) throws Throwable {
        //ARRANGE//
        ExcelEnvironment excelEnvironment = new ExcelEnvironment();

        excelEnvironment.saveTestResultsXLSX(45);

        String payload = "{\"email\":\"gideon.rolloniseo@fudmail.com\",\"dui\":[\"0\",\"2576bb91-d70e-4a9b-913e-d451008267b8\",\"1710926459\",\"2\",\"1711023588\",\"1710926536\",\"8f981c11-a06c-4f01-8a82-afb1fbd2d737\"]}";

        given()
                .body(payload)
                .header(new Header("Authorization", bearerToken))
                .contentType("application/json")
                .when()
                .post("/rest/v1/validate-email")
                .then()
                .statusCode(201);
    }

    public String getBearerToken() {
        String bearerToken = "";
        //TODO: Add code to get the bearer token from the API
        return bearerToken;
    }
}