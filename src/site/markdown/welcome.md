<p align="center">
  <img src="https://raw.githubusercontent.com/dev-time-tpw/parent-pom/main/images/Parent-POM.png" />
</p>

<p align="center">
<a class="none" href="https://github.com/dev-time-tpw/parent-pom/actions/workflows/build-job.yml" title="Build Job">
  <img src="https://img.shields.io/github/workflow/status/dev-time-tpw/parent-pom/Run%20snapshot%20build-job?logo&#61;GitHub&#38;style&#61;plastic" />
</a>
<a class="none" href="https://github.com/dev-time-tpw/parent-pom/actions/workflows/quality-job.yml" title="Quality Job">
  <img src="https://img.shields.io/github/workflow/status/dev-time-tpw/parent-pom/Run%20quality%20build-job?label&#61;nightly-build&#38;logo&#61;GitHub&#38;style&#61;plastic" />
</a>
<a class="none" href="https://github.com/dev-time-tpw/parent-pom/blob/main/LICENSE" title="License">
  <img src="https://img.shields.io/github/license/dev-time-tpw/parent-pom?logo&#61;GitHub&#38;style&#61;plastic" />
</a>
<a class="none" href="https://github.com/dev-time-tpw/parent-pom" title="Last Commit">
  <img src="https://img.shields.io/github/last-commit/dev-time-tpw/parent-pom?logo&#61;GitHub&#38;style&#61;plastic" />
</a>
<a class="none" href="https://github.com/dev-time-tpw/parent-pom" title="Lines of code">
  <img alt="Lines of code" src="https://img.shields.io/tokei/lines/github/dev-time-tpw/parent-pom?logo&#61;GitHub&#38;style&#61;plastic" />
</a>
<br />
<a class="none" href="https://sonarcloud.io/dashboard?id=devtime_parent-pom" title="Quality Gate">
  <img src="https://img.shields.io/sonar/quality_gate/devtime_parent-pom?logo&#61;SonarCloud&#38;server&#61;https%3A%2F%2Fsonarcloud.io&#38;style&#61;plastic" />
</a>
</p>

<hr />
<p align="center">
    <a class="none" href="#about-this-account">About this account</a> • 
    <a class="none" href="#documentation">Documentation</a> • 
    <a class="none" href="#contribute">Contribute</a> • 
    <a class="none" href="#about-the-parent-pom">About the parent-pom</a> • 
    <a class="none" href="#licensing">Licensing</a>
</p>
<hr />

# Welcome to dev|time

&nbsp;

<a name="about-this-account"></a>

## About this account

On this account you will find projects on various topics from the fields of testing, current frameworks and libraries 
in the Java and Maven context. Great emphasis is placed on comprehensibility and quality, so that everyone is able to 
understand and use the examples and projects well.<br />
To achieve this, an open source platform was chosen. Free quality tools like [SonarCloud](https://sonarcloud.io/) but also 
Checkstyle are used to ensure the highest possible quality. Using the GitHub Actions and Maven, as well as the JUnit 
tests, a continuous integration approach is used.

Currently, the following projects have been published on this account:

* **<a class="none" href="https://github.com/dev-time-tpw/parent-pom">parent-pom</a>**<br />
There are several common configurations in this project that are used by many projects here. This includes a Maven 
parent-pom that contains all the important configurations for the Maven projects on this account. This parent-pom is 
constantly being maintained.<br />
In addition to the parent-pom, there is also a checkstyle-parent-pom in this project that is specifically for Java-only 
projects and is used to automatically distribute the checkstyle rules contained in the checkstyle-config module to all 
inheriting Maven projects during the build process. All Maven projects that inherit from this checkstyle-parent-pom will 
have a checkstyle check performed in addition to the SonarCloud checks.
* **<a class="none" href="https://github.com/dev-time-tpw/java-utils">java-utils</a>**<br />
In this project there are many different utility, logging, resources and swing classes in different modules. These 
utilities are used by different projects on this account.
* **<a class="none" href="https://github.com/dev-time-tpw/muphin-framework">muphin-framework</a>**<br />
The **mu**pltiple **ph**ase **in**tegrationtest framework is a small test framework based on JUnit, which can be used 
to define and test any kind of workflow. Single workflows consist of phases that can trigger various actions. With the 
help of annotations JUnit test methods can be executed before and after a certain phase.

<a name="documentation"></a>

## Documentation

Modern software development includes not only the source code itself, but also automated tests, quality analysis and 
documentation. Therefore, Maven sites are created and maintained for all projects. The great advantage of this approach 
is that all important documents are versioned and located close to the actual source code, so that changes to the 
source code always result in adjustments to the tests and documentation.
Another advantage is that the associated documentation and test results are also generated for a release.

The Maven sites can be found at the following URL: <a class="none" href="http://dev-time.de/javadoc/welcome.html">http://dev-time.de/javadoc/welcome.html</a>

All projects are structured hierarchically, so that it is possible to navigate through the maven sites across different 
projects. The upper navigation bar can always be used to jump back to the start page above.

<a name="contribute"></a>

## Contribute

If you would like to participate in the project or if you would like to run the projects yourself, you need to fulfill the following requirements:

### Use Java 8

Currently all projects are based on Java 8, so you need an <a class="none" href="https://www.oracle.com/java/technologies/javase/javase8u211-later-archive-downloads.html">Oracle Java 8 JDK</a> or <a class="none" href="https://openjdk.java.net/projects/jdk8/">OpenSDK 8</a> version on your system.

However, there are already plans to support Java 11+ in the future (see https://github.com/dev-time-tpw/parent-pom/issues/2).

### Create a settings.xml

Since an Artifactory is used to manage all snapshots and releases, a `settings.xml` is required for the initial installation, which contains the connection information to the JFrog Artifactory.

To do this, create a `settings.xml` file in your `.m2` directory, which is located in your user directory and copy the following content into this file.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<settings xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.2.0 http://maven.apache.org/xsd/settings-1.2.0.xsd" xmlns="http://maven.apache.org/SETTINGS/1.2.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
  <profiles>
    <profile>
      <id>devtime-artifactory</id>
      <repositories>
        <repository>
          <snapshots>
            <enabled>false</enabled>
          </snapshots>
          <id>devtime-releases-repo</id>
          <name>devtime-release-repo</name>
          <url>https://devtime.jfrog.io/artifactory/devtime-release</url>
        </repository>
        <repository>
          <snapshots />
          <id>devtime-snapshots-repo</id>
          <name>devtime-snapshot-repo</name>
          <url>https://devtime.jfrog.io/artifactory/devtime-snapshot</url>
        </repository>
      </repositories>
      <pluginRepositories>
        <pluginRepository>
          <snapshots>
            <enabled>false</enabled>
          </snapshots>
          <id>devtime-releases-repo</id>
          <name>devtime-release-repo</name>
          <url>https://devtime.jfrog.io/artifactory/devtime-release</url>
        </pluginRepository>
        <pluginRepository>
          <snapshots />
          <id>devtime-snapshots-repo</id>
          <name>devtime-snapshot-repo</name>
          <url>https://devtime.jfrog.io/artifactory/devtime-snapshot</url>
        </pluginRepository>
      </pluginRepositories>
    </profile>
  </profiles>
  <activeProfiles>
    <activeProfile>devtime-artifactory</activeProfile>
  </activeProfiles>
</settings>
```

<a name="about-the-parent-pom"></a>

## About the parent pom

The parent-pom contains many common dependencies and plugins in the latest tested version. However, the individual 
projects are responsible to use the dependencies as needed. Here only a few dependencies are activated, which should 
also be used by all projects.

These include three domains:

**Common dependencies**

* <a class="none" href="https://commons.apache.org/proper/commons-lang/">org.apache.commons:commons-lang3</a>
* <a class="none" href="https://github.com/google/guava">com.google.guava:guava</a>

**Testing dependencies**

* <a class="none" href="http://hamcrest.org/JavaHamcrest/distributables">org.hamcrest:hamcrest-all</a>
* <a class="none" href="https://github.com/eXparity/hamcrest-date">org.exparity:hamcrest-date</a>
* <a class="none" href="https://github.com/spotify/java-hamcrest">com.spotify:hamcrest-jackson</a>
* <a class="none" href="https://github.com/spotify/java-hamcrest">com.spotify:hamcrest-pojo</a>
* <a class="none" href="https://github.com/spotify/java-hamcrest">com.spotify:hamcrest-optional</a>
* <a class="none" href="https://junit.org/junit4/">junit:junit</a>
* <a class="none" href="https://site.mockito.org/">org.mockito:mockito-all</a>

**Logging dependencies**

* <a class="none" href="https://logging.apache.org/log4j/2.x/">org.apache.logging.log4j:log4j-api</a>
* <a class="none" href="https://logging.apache.org/log4j/2.x/">org.apache.logging.log4j:log4j-core</a>
* <a class="none" href="https://logging.apache.org/log4j/2.x/">org.apache.logging.log4j:log4j-slf4j-impl</a>
* <a class="none" href="http://www.slf4j.org/">org.slf4j:slf4j-api</a>

Furthermore, a continuous integration pipeline is defined for all projects based on the following technologies:

* <a class="none" href="https://maven.apache.org/">Maven</a> (as a build & dependency tool)
* <a class="none" href="https://github.com/dev-time-tpw">GitHub</a> (as source code management tool)
* <a class="none" href="https://docs.github.com/en/free-pro-team@latest/actions">GitHub actions</a> (as CI/CD pipeline)
* <a class="none" href="https://sonarcloud.io/organizations/devtime/projects">Sonarcloud.io</a> (as quality tool)
* <a class="none" href="https://devtime.jfrog.io/ui/packages">JFrog Artifactory</a> (as artefact repository)

<a name="licensing"></a>

## Licensing

Copyright (c) 2021 <img src="https://raw.githubusercontent.com/dev-time-tpw/parent-pom/main/images/dev-time-86x15.png" />.

Licensed under the **Apache License, Version 2.0** (the "License"). You may not use this file except in compliance with 
the License.

You may obtain a copy of the License at https://www.apache.org/licenses/LICENSE-2.0.

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an 
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific 
language governing permissions and limitations under the <a class="none" href="https://raw.githubusercontent.com/dev-time-tpw/parent-pom/main/LICENSE">LICENSE</a>.