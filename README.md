<p align="center">
  <img src="https://raw.githubusercontent.com/dev-time-tpw/parent-pom/main/images/Parent-POM.png" />
</p>

<p align="center">
<a href="https://github.com/dev-time-tpw/parent-pom/actions/workflows/build-job.yml" title="Build Job">
  <img src="https://img.shields.io/github/workflow/status/dev-time-tpw/parent-pom/Run%20snapshot%20build-job?logo=GitHub&style=plastic" />
</a>
<a href="https://github.com/dev-time-tpw/parent-pom/actions/workflows/quality-job.yml" title="Quality Job">
  <img src="https://img.shields.io/github/workflow/status/dev-time-tpw/parent-pom/Run%20quality%20build-job?label=quality-build&logo=GitHub&style=plastic" />
</a>
<a href="https://github.com/dev-time-tpw/parent-pom/blob/main/LICENSE" title="License">
  <img src="https://img.shields.io/github/license/dev-time-tpw/parent-pom?logo=GitHub&style=plastic" />
</a>
<a href="https://github.com/dev-time-tpw/parent-pom" title="Last Commit">
  <img src="https://img.shields.io/github/last-commit/dev-time-tpw/parent-pom?logo=GitHub&style=plastic" />
</a>
<br />
<a href="https://sonarcloud.io/dashboard?id=devtime_parent-pom" title="Quality Gate">
  <img src="https://img.shields.io/sonar/quality_gate/devtime_parent-pom?logo=SonarCloud&server=https%3A%2F%2Fsonarcloud.io&style=plastic" />
</a>
</p>

<hr />
<p align="center">
    <a href="#about-this-account">About this account</a> • 
    <a href="#about-the-parent-pom">About the parent-pom</a> • 
    <a href="#licensing">Licensing</a>
</p>
<hr />

## About this account

On this account you will find projects on various topics from the fields of testing, current frameworks and libraries 
in the Java and Maven context. Great emphasis is placed on comprehensibility and quality, so that everyone is able to 
understand and use the examples and projects well.<br />
To achieve this, an open source platform was chosen. Free quality tools like [SonarCloud](Sonarcloud.io) but also 
Checkstyle are used to ensure the highest possible quality. Using the GitHub Actions and Maven, as well as the JUnit 
tests, a continuous integration approach is used.

Currently, the following projects have been published on this account:

* **<a href="https://github.com/dev-time-tpw/parent-pom">parent-pom</a>**<br />
There are several common configurations in this project that are used by many projects here. This includes a Maven 
parent-pom that contains all the important configurations for the Maven projects on this account. This parent-pom is 
constantly being maintained.<br />
In addition to the parent-pom, there is also a checkstyle-parent-pom in this project that is specifically for Java-only 
projects and is used to automatically distribute the checkstyle rules contained in the checkstyle-config module to all 
inheriting Maven projects during the build process. All Maven projects that inherit from this checkstyle-parent-pom will 
have a checkstyle check performed in addition to the SonarCloud checks.
* **<a href="https://github.com/dev-time-tpw/java-utils">java-utils</a>**<br />
In this project there are many different utility, logging, resources and swing classes in different modules. These 
utilities are used by different projects on this account.
* **<a href="https://github.com/dev-time-tpw/muphin-framework">muphin-framework</a>**<br />
The **mu**pltiple **ph**ase **in**tegrationtest framework is a small test framework based on JUnit, which can be used 
to define and test any kind of workflow. Single workflows consist of phases that can trigger various actions. With the 
help of annotations JUnit test methods can be executed before and after a certain phase.

## About the parent pom

The parent-pom contains many common dependencies and plugins in the latest tested version. However, the individual 
projects are responsible to use the dependencies as needed. Here only a few dependencies are activated, which should 
also be used by all projects.

These include three domains:

**Common dependencies**

* <a href="https://commons.apache.org/proper/commons-lang/">org.apache.commons:commons-lang3</a>
* <a href="https://github.com/google/guava">com.google.guava:guava</a>

**Testing dependencies**

* <a href="http://hamcrest.org/JavaHamcrest/distributables">org.hamcrest:hamcrest-all</a>
* <a href="https://github.com/eXparity/hamcrest-date">org.exparity:hamcrest-date</a>
* <a href="https://github.com/spotify/java-hamcrest">com.spotify:hamcrest-jackson</a>
* <a href="https://github.com/spotify/java-hamcrest">com.spotify:hamcrest-pojo</a>
* <a href="https://github.com/spotify/java-hamcrest">com.spotify:hamcrest-optional</a>
* <a href="https://junit.org/junit4/">junit:junit</a>
* <a href="https://site.mockito.org/">org.mockito:mockito-all</a>

**Logging dependencies**

* <a href="https://logging.apache.org/log4j/2.x/">org.apache.logging.log4j:log4j-api</a>
* <a href="https://logging.apache.org/log4j/2.x/">org.apache.logging.log4j:log4j-core</a>
* <a href="https://logging.apache.org/log4j/2.x/">org.apache.logging.log4j:log4j-slf4j-impl</a>
* <a href="http://www.slf4j.org/">org.slf4j:slf4j-api</a>

Furthermore, a continuous integration pipeline is defined for all projects based on the following technologies:

* <a href="https://maven.apache.org/">Maven (as a build & dependency tool)</a>
* <a href="https://github.com/dev-time-tpw">GitHub (as source code management tool)</a>
* <a href="https://docs.github.com/en/free-pro-team@latest/actions">GitHub actions (as CI/CD pipeline)</a>
* <a href="https://sonarcloud.io/organizations/devtime/projects">Sonarcloud.io (as quality tool)</a>
* <a href="https://devtime.jfrog.io/ui/packages">JFrog Artifactory (as artefact repository)</a>

## Licensing

Copyright (c) 2021 <img src="https://raw.githubusercontent.com/dev-time-tpw/parent-pom/main/images/dev-time-86x15.png" />.

Licensed under the **Apache License, Version 2.0** (the "License"). You may not use this file except in compliance with 
the License.

You may obtain a copy of the License at <a href="https://www.apache.org/licenses/LICENSE-2.0">https://www.apache.org/licenses/LICENSE-2.0</a>.

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an 
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific 
language governing permissions and limitations under the [LIZENZ](LICENSE).