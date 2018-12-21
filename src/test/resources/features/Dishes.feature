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


  Scenario: Tomato Mozzarela persona
    Given a tomato mozarella salad
    Then the ingredients should be
      | name   | quantity |
      | tomato | 2        |
      | mozarella | 1     |


  Scenario: For a tomato mozarella dish
    Given a tomato mozarella salad
    And 4 person orders it
    Then the purchase order should be
        | product   | quantity |
        | tomato    | 8        |
        | mozarella | 4        |