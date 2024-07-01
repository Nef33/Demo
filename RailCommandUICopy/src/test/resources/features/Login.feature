
Feature: RailCommand Login

  Login validations with various accounts


  Scenario: Login with valid credentials

    Given Open Rail Command application
    When user enters valid credentials
    Then user is able to login


  Scenario: Login with invalid username

    Given Open Rail Command application
    When user enters invalid  username
    Then user is not able to login

  Scenario: Login with invalid password

    Given Open Rail Command application
    When user enters invalid  password
    Then user is not able to login
