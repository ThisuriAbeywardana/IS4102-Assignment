
Feature: As a user I should add a new user to the system


  @TC_001
  Scenario Outline: Successful new user creation in production department
    Given User logged into giving "<username>" and "<password>" the Actitime and visited Users Page
    When User click in New User button
    Then User Enter the First Name as "<name>"
    Then User Enter the Last Name as "<lastName>"
    Then User Enter the Email as "<email>"
    Then User Select Department as production
    Then User click in Save button
    Then User should be able to successfully add a new user with email as "<confirmEmail>"
    Examples:
      | name  | lastName | email | confirmEmail | username | password |
      | Anne | Cullen | annecullen@gmail.com | annecullen@gmail.com | thisuriabeywardana@gmail.com |W$T*9GqVeRZA4Hn |
