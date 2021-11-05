# Checkstyle parent-pom #

Currently under development...

## How it works

### Requirements

**Business Scenarios**

```gherkin
Scenario: Enabling a checkstyle check through inheritance
  Given we have a Maven project with multiple modules
  When the parent module of this project inherits from the checkstyle-parent-pom
  Then we want a checkstyle check to be performed in all modules

Scenario: Use of a custom checkstyle configuration
  Given a custom devtime_checks.xml configuration file is provided
  When a check is performed with checkstyle
  Then the rules from the devtime_checks.xml are applied

Scenario: Exception for checkstyle checks
  Given a Maven module configuration inherits from the checkstyle-parent-pom
  When a checkstyle check is executed
   But an exception has been defined for this module
  Then the checkstyle check for that module is skipped
  
Scenario: Creating a report in the maven sites
  Given a Maven module configuration inherits from the checkstyle-paren-pom
  When a checkstyle check is executed
   And maven sites are generated
  Then the checkstyle check result is added as a separate report to the maven sites  
```

**Technical Scenarios**

```gherkin
Scenario: Dropping a custom checkstyle configuration
  Given a Maven module configuration inherits from the checkstyle-parent-pom
    And a checkstyle-config dependency is available
  When all the required resources are created by the maven build process
  Then the checkstyle-config must be unpacked
   And the XML configuration file must be copied to the target/generated-resources directory
```

### Implementation

```xml
	<properties>
		<checkstyle-config.version>1.0.0-SNAPSHOT</checkstyle-config.version>
		<checkstyle_configuration_file>${project.build.directory}/generated-resources/devtime_checks.xml</checkstyle_configuration_file>
	</properties>
```