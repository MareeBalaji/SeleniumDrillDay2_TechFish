$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("feature/TransferBetweenAccounts_Vimal.feature");
formatter.feature({
  "line": 2,
  "name": "Title of your feature",
  "description": "I want to use this template for my feature file",
  "id": "title-of-your-feature",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@All"
    }
  ]
});
formatter.scenarioOutline({
  "comments": [
    {
      "line": 34,
      "value": "#|         7 |"
    }
  ],
  "line": 37,
  "name": "Fund Tranfer Between Primary Account to Savings Account with a invalid amount",
  "description": "",
  "id": "title-of-your-feature;fund-tranfer-between-primary-account-to-savings-account-with-a-invalid-amount",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 36,
      "name": "@tag3"
    }
  ]
});
formatter.step({
  "line": 38,
  "name": "User enters the credentials and login to the application\"\u003cuserdata2\u003e\"_Vimal",
  "keyword": "Given "
});
formatter.step({
  "line": 39,
  "name": "Navigate to transfer between own accounts page_Vimal",
  "keyword": "When "
});
formatter.step({
  "line": 40,
  "name": "User selects Primary to Savings transfer and enters a invalid amount_Vimal",
  "keyword": "And "
});
formatter.step({
  "line": 41,
  "name": "Fund Transfer is should be rejected_Vimal",
  "keyword": "Then "
});
formatter.examples({
  "line": 43,
  "name": "",
  "description": "",
  "id": "title-of-your-feature;fund-tranfer-between-primary-account-to-savings-account-with-a-invalid-amount;",
  "rows": [
    {
      "cells": [
        "userdata2"
      ],
      "line": 44,
      "id": "title-of-your-feature;fund-tranfer-between-primary-account-to-savings-account-with-a-invalid-amount;;1"
    },
    {
      "cells": [
        "8"
      ],
      "line": 45,
      "id": "title-of-your-feature;fund-tranfer-between-primary-account-to-savings-account-with-a-invalid-amount;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.background({
  "line": 5,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 6,
  "name": "Launch the browser_Vimal",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Navigate to the URL_Vimal",
  "keyword": "When "
});
formatter.match({
  "location": "TransferBetweenAccounts_Vimal.launch_the_browser_Vimal()"
});
formatter.result({
  "duration": 9850757600,
  "status": "passed"
});
formatter.match({
  "location": "TransferBetweenAccounts_Vimal.navigate_to_the_URL_Vimal()"
});
formatter.result({
  "duration": 4007981300,
  "status": "passed"
});
formatter.scenario({
  "line": 45,
  "name": "Fund Tranfer Between Primary Account to Savings Account with a invalid amount",
  "description": "",
  "id": "title-of-your-feature;fund-tranfer-between-primary-account-to-savings-account-with-a-invalid-amount;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 36,
      "name": "@tag3"
    },
    {
      "line": 1,
      "name": "@All"
    }
  ]
});
formatter.step({
  "line": 38,
  "name": "User enters the credentials and login to the application\"8\"_Vimal",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 39,
  "name": "Navigate to transfer between own accounts page_Vimal",
  "keyword": "When "
});
formatter.step({
  "line": 40,
  "name": "User selects Primary to Savings transfer and enters a invalid amount_Vimal",
  "keyword": "And "
});
formatter.step({
  "line": 41,
  "name": "Fund Transfer is should be rejected_Vimal",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "8",
      "offset": 57
    }
  ],
  "location": "TransferBetweenAccounts_Vimal.user_enters_the_credentials_and_login_to_the_application__Vimal(String)"
});
formatter.result({
  "duration": 20258872700,
  "status": "passed"
});
formatter.match({
  "location": "TransferBetweenAccounts_Vimal.navigate_to_transfer_between_own_accounts_page_Vimal()"
});
formatter.result({
  "duration": 3359712100,
  "status": "passed"
});
formatter.match({
  "location": "TransferBetweenAccounts_Vimal.user_selects_Primary_to_Savings_transfer_and_enters_a_invalid_amount_Vimal()"
});
formatter.result({
  "duration": 9920806700,
  "status": "passed"
});
formatter.match({
  "location": "TransferBetweenAccounts_Vimal.fund_Transfer_is_should_be_rejected_Vimal()"
});
formatter.result({
  "duration": 130935800,
  "status": "passed"
});
});