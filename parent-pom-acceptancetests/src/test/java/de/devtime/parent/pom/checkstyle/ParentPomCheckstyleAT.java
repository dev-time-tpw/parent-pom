package de.devtime.parent.pom.checkstyle;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features", glue = "de.devtime.parent.pom.checkstyle.steps", plugin = {
    "pretty"
}, monochrome = true)
public class ParentPomCheckstyleAT {

}
