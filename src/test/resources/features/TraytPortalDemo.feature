@TraytLoginDemo
Feature: Trayt portal Automation framework demo

  Scenario Outline: User logs into Trayt clinical portal and navigate to homepage.
    Given User opens clinical portal
    And Sign into portal as <userType>
    Then User validate that Login is Successful
    Examples:
      | userType     |
      | "AUTO_ADMIN" |
