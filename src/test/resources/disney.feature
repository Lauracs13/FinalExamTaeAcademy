@mobile
  Feature: Disney app functionality

    @mobile
    Scenario: user can interact with elements in the Map screen
      Given  user is on the dashboard
      When user taps on the Map button
      And  user taps on the Category list
      Then Hotels option is available in the list

    @mobile
    Scenario: user can find the Privacy & Legal screen
      Given  user is on the dashboard
      When user taps on Menu button
      And  user taps on Privacy & Legal option
      Then a list of options is displayed

