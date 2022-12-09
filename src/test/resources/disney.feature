@mobile
  Feature: Disney app functionality

    @mobile @mapScreen
    Scenario: user can interact with elements in the Map screen
      Given  user is on the dashboard
      When user taps on the Map button
      And  user taps on the Category list
      Then Hotels option is available in the list

    @mobile @privacyAndLegalScreen
    Scenario: user can see the Privacy & Legal screen
      Given  user is on the dashboard
      When user taps on the Menu button
      And  user taps on Privacy & legal option
      Then a list of options is displayed

    @mobile @reserveDiningOption
    Scenario: user can find the Reserve Dining Option
      Given  user is on the dashboard
      When user taps on Add Plans Button
      Then the Reserve Dining Option is in the list



