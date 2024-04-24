Feature: Navigation bar
  To see the subpages
  Without loggin in
  I can click tha navigation bar links

  Background: I am on the Free Ranger Testers web without logging in.
    Given I navigate to free range testers

  @freerangetesters-01
  Scenario Outline: I can the subpages through the navigation bar
    When I go to <section> using the navigation bar
    Examples:
      | section  |
      | Cursos   |
      | Recursos |
      | Blog     |
      | Udemy    |
      | Discord  |

  @freerangetesters-02
  Scenario: Courses are presented correctly to potencial customers
    When I go to Cursos using the navigation bar
    And select Introducción al Testing

  @freerangetesters-03
  Scenario: Courses are presented correctly to potencial customers
    When I select Elegir Plan
    Then I can validate the options in the checkout page