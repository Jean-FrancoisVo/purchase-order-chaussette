Feature: Purchase order

  Scenario: Carrot salad persona
    Given a carrot salad
    Then the ingredients should be
      | name   | quantity |
      | carrot | 1        |

  Scenario: For a simple dish
    Given a carrot salad
    And 2 person orders it
    Then the purchase order should be
      | product | quantity |
      | carrot  | 2        |

