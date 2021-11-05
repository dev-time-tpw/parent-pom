# Author: morrigan
# Since: 0.0.1

Feature: Acceptance test for the module parent-pom-checkstyle
  
  These tests are used to define and test various requirements for the parent-pom-checkstyle.

  # Business scenarios

  Scenario: Enabling a checkstyle check through inheritance
    Given we have a Maven project with multiple modules
      And the parent module of this project inherits from the checkstyle-parent-pom
    When a checkstyle check is executed
    Then we want a checkstyle check to be performed in all modules

  Scenario: Use of a custom checkstyle configuration
    Given a custom devtime_checks.xml configuration file is provided
    When a checkstyle check is executed
    Then the rules from the devtime_checks.xml are applied

  Scenario: Exception for checkstyle checks
    Given a Maven module configuration inherits from the checkstyle-parent-pom
    When a checkstyle check is executed
     But an exception has been defined for this module
    Then the checkstyle check for that module is skipped
  
  Scenario: Creating a report in the maven sites
    Given a Maven module configuration inherits from the checkstyle-parent-pom
    When a checkstyle check is executed with maven sites
     And maven sites are generated
    Then the checkstyle check result is added as a separate report to the maven sites  

  # Technical scenarios

  Scenario: Dropping a custom checkstyle configuration
    Given a Maven module configuration inherits from the checkstyle-parent-pom
    When all the required resources are created by the maven build process
    Then the XML configuration file must be available in the target/generated-resources directory