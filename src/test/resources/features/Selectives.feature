Feature: Subscription Process on Selectives Pages

  Scenario Outline: Subscribe to Newsletter on Selectives Websites
    Given I open the Selectives home page of "<website>"
    When I click on the Selectives abonneren "Abonneren" button
    And I choose the "<subscriptionOption>" subscription option
    And I select the "<discountPeriod>" discount period
    And I fill in the subscription form with the following details:
      | Field                   | Value               |
      | Voornaam                | <voornaam>          |
      | Achternaam              | <achternaam>        |
      | Postcode                | <postcode>          |
      | Huisnummer              | <huisnummer>        |
      | Toevoeging              | <toevoeging>        |
      | Telefoonnummer          | <telefoonnummer>    |
      | E-mailadres             | <emailAddress>      |
      | Wachtwoord              | <wachtwoord>        |
      | Wachtwoordcontrole      | <wachtwoordcontrole>|
      | IBAN bankrekeningnummer | <iban>              |
    And I accept the terms and conditions
    And I complete the subscription process
    Then I should see the thank you page confirming my subscription

    Examples:
      | website         | subscriptionOption | discountPeriod | voornaam  | achternaam | postcode | huisnummer | toevoeging | telefoonnummer  | emailAddress                | wachtwoord | wachtwoordcontrole | iban              |
      | www.volkskrant.nl      | Compleet           | 24 maanden     | Zachary   | Considine  | 5232JL   | 7          |            | 0648642540      | zachary.considine@gmail.com | wachtwoord | wachtwoord         | NL38RABO1628106735 |
#    Examples:
#      | website         | subscriptionOption | discountPeriod | firstName | lastName | postalCode | houseNumber | addition | phoneNumber | emailAddress         | iban              |
#      | www.bndestem.nl | Compleet           | 24 maanden     | John      | Doe      | 7522LM     | 119         |           | 1234567890  | john.doe@email.com  | NL91ABNA04171643 |
#      | www.tubantia.nl | Compleet           | 24 maanden     | Alice     | Smith    | 1234AB     | 55          | A         | 9876543210  | alice.smith@email.com | NL91ABNA04171643 |
#      | www.bd.nl       | Digitaal Basis     | 12 maanden     | Bob       | Johnson  | 5678CD     | 12          |           | 1357924680  | bob.johnson@email.com | NL91ABNA04171643 |