@HdfcLogin
Feature: HDFC Login

  Scenario Outline: User logs into Hdfc portal and navigate to Dashboard.
    Given open Hdfc netbanking portal
    And enter the credentials of customer <customer>
    And enter the otp and click submit
    Then validate that Login to Hdfc netbanking portal is Successful and user redirect to Dashboard successfully
    Examples:
      | customer     |
      | "CUSTOMER_1" |
