package de.devtime.parent.pom.checkstyle.steps;

import static de.devtime.parent.pom.checkstyle.impl.TestProjectHelper.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

import java.io.IOException;

import io.cucumber.java.en.*;

public class ParentPomCheckstyleSteps {

  @Given("we have a Maven project with multiple modules")
  public void we_have_a_maven_project_with_multiple_modules() throws IOException {
    assertThat(buildModulePomFile().exists(), is(true));
    assertThat(moduleAPomFile().exists(), is(true));
    assertThat(moduleBPomFile().exists(), is(true));
    assertThat(buildModulePomFileContent(), containsString("<module>test-module-a</module>"));
    assertThat(buildModulePomFileContent(), containsString("<module>test-module-b</module>"));
    assertThat(moduleAPomFileContent(), containsString("<artifactId>test-build</artifactId>"));
    assertThat(moduleBPomFileContent(), containsString("<artifactId>test-build</artifactId>"));
  }

  @Given("the parent module of this project inherits from the checkstyle-parent-pom")
  public void the_parent_module_of_this_project_inherits_from_the_checkstyle_parent_pom() throws IOException {
    assertThat(buildModulePomFileContent(), containsString("<artifactId>checkstyle-parent-pom</artifactId>"));
  }

  @Given("a custom devtime_checks.xml configuration file is provided")
  public void a_custom_devtime_checks_xml_configuration_file_is_provided() {
    assertThat(buildModuleCsConfigFile().exists(), is(true));
    assertThat(moduleACsConfigFile().exists(), is(false)); // will be skipped
    assertThat(moduleBCsConfigFile().exists(), is(true));
  }

  @Given("a Maven module configuration inherits from the checkstyle-parent-pom")
  public void a_maven_module_configuration_inherits_from_the_checkstyle_parent_pom() throws IOException {
    assertThat(moduleAPomFileContent(), containsString("<artifactId>test-build</artifactId>"));
    assertThat(moduleBPomFileContent(), containsString("<artifactId>test-build</artifactId>"));
    assertThat(buildModulePomFileContent(), containsString("<module>test-module-a</module>"));
    assertThat(buildModulePomFileContent(), containsString("<artifactId>checkstyle-parent-pom</artifactId>"));
  }

  @When("a checkstyle check is executed")
  public void a_checkstyle_check_is_executed() throws IOException, InterruptedException {
    assertThat(executeCommand("test-build", "mvn -B clean verify"), is(true));
  }

  @When("a checkstyle check is executed with maven sites")
  public void a_checkstyle_check_is_executed_with_maven_sites() throws IOException, InterruptedException {
    assertThat(executeCommand("test-build", "mvn -B clean verify site", 180), is(true));
  }

  @When("an exception has been defined for this module")
  public void an_exception_has_been_defined_for_this_module() {
    assertThat(moduleAIgnoreCheckstyleFile().exists(), is(true));
  }

  @When("maven sites are generated")
  public void maven_sites_are_generated() {
    assertThat(buildModuleSiteFile().exists(), is(true));
    assertThat(moduleASiteFile().exists(), is(true));
    assertThat(moduleBSiteFile().exists(), is(true));
  }

  @When("all the required resources are created by the maven build process")
  public void all_the_required_resources_are_created_by_the_maven_build_process()
      throws IOException, InterruptedException {
    assertThat(executeCommand("test-build", "mvn -B clean generate-resources"), is(true));
  }

  @Then("we want a checkstyle check to be performed in all modules")
  public void we_want_a_checkstyle_check_to_be_performed_in_all_modules() {
    assertThat(buildModuleCsResultFile().exists(), is(true));
    assertThat(moduleACsResultFile().exists(), is(false)); // will be skipped
    assertThat(moduleBCsResultFile().exists(), is(true));
  }

  @Then("the rules from the devtime_checks.xml are applied")
  public void the_rules_from_the_devtime_checks_xml_are_applied() throws IOException {
    assertThat(moduleBCsResultFileContent(), containsString(
        "parent-pom-acceptancetests/test-build/test-module-b/src/main/java/TestMain.java\">"));
    assertThat(moduleBCsResultFileContent(),
        containsString("com.puppycrawl.tools.checkstyle.checks.javadoc.WriteTagCheck"));
    assertThat(moduleBCsResultFileContent(),
        containsString("@since"));
    assertThat(moduleBCsResultFileContent(),
        containsString("com.puppycrawl.tools.checkstyle.checks.javadoc.MissingJavadocTypeCheck"));
    assertThat(moduleBCsResultFileContent(),
        containsString("Javadoc"));
  }

  @Then("the checkstyle check for that module is skipped")
  public void the_checkstyle_check_for_that_module_is_skipped() {
    assertThat(moduleACsResultFile().exists(), is(false));
    assertThat(moduleACsConfigFile().exists(), is(false));
  }

  @Then("the checkstyle check result is added as a separate report to the maven sites")
  public void the_checkstyle_check_result_is_added_as_a_separate_report_to_the_maven_sites() {
    assertThat(buildModuleSiteCsFile().exists(), is(true));
    assertThat(buildModuleSiteCsAggregateFile().exists(), is(true));
    assertThat(moduleASiteCsFile().exists(), is(false)); // will be skipped
    assertThat(moduleBSiteFile().exists(), is(true));
  }

  @Then("the XML configuration file must be available in the target\\/generated-resources directory")
  public void the_checkstyle_config_must_be_unpacked() {
    assertThat(buildModuleCsConfigFile().exists(), is(true));
    assertThat(moduleACsConfigFile().exists(), is(false)); // will be skipped
    assertThat(moduleBCsConfigFile().exists(), is(true));
  }
}
