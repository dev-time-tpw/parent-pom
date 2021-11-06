# Checkstyle parent-pom #

Currently under development...

## How it works

### Requirements

All requirements for this module were elicited using the behavior-driven-development (BDD) approach and written down in 
the form of scenarios using Gherkin.<br />
Click here to see <a class="none" href="../parent-pom-acceptancetests/serenity/4d343bac90baca5f36310f7896bee3460f964b8ee6a6efe0bb1b6de74e35bfc0.html">all scenarios</a>.

### Implementation

```xml
	<properties>
		<checkstyle-config.version>1.0.0-SNAPSHOT</checkstyle-config.version>
		<checkstyle_configuration_file>${project.build.directory}/generated-resources/devtime_checks.xml</checkstyle_configuration_file>
	</properties>
```