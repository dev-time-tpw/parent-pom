# Checkstyle configuration

In this module, a separate `devtime_checks.xml` is provided for checkstyle. This configuration file is automatically 
copied to the `target/generated-resources` directory of each module that inherits its configuration from the 
<a class="none" href="http://dev-time.de/javadoc/parent-pom-checkstyle/index.html">parent-pom-checkstyle</a>.

## Current configurations

TODO list all configuration from XML file.
TODO Link to eclipse configuration files.

## How it works

The configuration file is located at `src/main/resources` and is packaged into a jar artifact during the build 
process. Using deploy, this artifact is then available in the artifactory and can be included and unpacked by the 
different maven modules as a dependency.

For more information, see the **How it works** section in the <a class="none" href="http://dev-time.de/javadoc/parent-pom-checkstyle/index.html">parent-pom-checkstyle</a> module.

