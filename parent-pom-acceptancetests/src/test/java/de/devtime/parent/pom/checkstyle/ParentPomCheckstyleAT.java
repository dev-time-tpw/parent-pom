package de.devtime.parent.pom.checkstyle;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = "de.devtime.parent.pom.checkstyle.steps", plugin = {
    "pretty"
}, stepNotifications = true, monochrome = true)
public class ParentPomCheckstyleAT {

}
