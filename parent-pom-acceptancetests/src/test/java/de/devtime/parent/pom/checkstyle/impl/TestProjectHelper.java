package de.devtime.parent.pom.checkstyle.impl;

import static com.pivovarit.function.ThrowingBiFunction.unchecked;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;

public class TestProjectHelper {

  private static final File BUILD_MODULE_POM_FILE;
  private static final File BUILD_MODULE_CS_CONFIG_FILE;
  private static final File BUILD_MODULE_CS_RESULT_FILE;
  private static final File BUILD_MODULE_SITE_FILE;
  private static final File BUILD_MODULE_SITE_CS_FILE;
  private static final File BUILD_MODULE_SITE_CS_AGGREGATE_FILE;
  private static final File MODULE_A_POM_FILE;
  private static final File MODULE_A_CS_CONFIG_FILE;
  private static final File MODULE_A_CS_RESULT_FILE;
  private static final File MODULE_A_SITE_FILE;
  private static final File MODULE_A_SITE_CS_FILE;
  private static final File MODULE_A_IGNORE_CHECKSTYLE_FILE;
  private static final File MODULE_B_POM_FILE;
  private static final File MODULE_B_CS_CONFIG_FILE;
  private static final File MODULE_B_CS_RESULT_FILE;
  private static final File MODULE_B_SITE_FILE;
  private static final File MODULE_B_SITE_CS_FILE;

  private static final Map<File, String> FILE_CONTENTS;

  static {
    BUILD_MODULE_POM_FILE = new File("test-build/pom.xml");
    BUILD_MODULE_CS_CONFIG_FILE = new File("test-build/target/generated-resources/devtime_checks.xml");
    BUILD_MODULE_CS_RESULT_FILE = new File("test-build/target/checkstyle-result.xml");
    BUILD_MODULE_SITE_FILE = new File("test-build/target/site/index.html");
    BUILD_MODULE_SITE_CS_FILE = new File("test-build/target/site/checkstyle.html");
    BUILD_MODULE_SITE_CS_AGGREGATE_FILE = new File("test-build/target/site/checkstyle-aggregate.html");
    MODULE_A_POM_FILE = new File("test-build/test-module-a/pom.xml");
    MODULE_A_CS_CONFIG_FILE = new File("test-build/test-module-a/target/generated-resources/devtime_checks.xml");
    MODULE_A_CS_RESULT_FILE = new File("test-build/test-module-a/target/checkstyle-result.xml");
    MODULE_A_SITE_FILE = new File("test-build/test-module-a/target/site/index.html");
    MODULE_A_SITE_CS_FILE = new File("test-build/test-module-a/target/site/checkstyle.html");
    MODULE_A_IGNORE_CHECKSTYLE_FILE = new File("test-build/test-module-a/ignore_checkstyle");
    MODULE_B_POM_FILE = new File("test-build/test-module-b/pom.xml");
    MODULE_B_CS_CONFIG_FILE = new File("test-build/test-module-b/target/generated-resources/devtime_checks.xml");
    MODULE_B_CS_RESULT_FILE = new File("test-build/test-module-b/target/checkstyle-result.xml");
    MODULE_B_SITE_FILE = new File("test-build/test-module-b/target/site/index.html");
    MODULE_B_SITE_CS_FILE = new File("test-build/test-module-b/target/site/checkstyle.html");
    FILE_CONTENTS = new HashMap<>();
  }

  private TestProjectHelper() {
    super();
  }

  public static final boolean executeCommand(String directory, String command)
      throws IOException, InterruptedException {
    return executeCommand(directory, command, 60);
  }

  public static final boolean executeCommand(String directory, String command, int timeout)
      throws IOException, InterruptedException {
    ProcessBuilder mvnExecutor = new ProcessBuilder();
    if (SystemUtils.IS_OS_LINUX) {
      mvnExecutor.command("bash", "-c", command);
    } else if (SystemUtils.IS_OS_MAC) {
      mvnExecutor.command("bash", "-c", command);
    } else if (SystemUtils.IS_OS_WINDOWS) {
      mvnExecutor.command("cmd.exe", "/c", command);
    } else {
      throw new UnsupportedOperationException(
          "The current operating system is not supported for this test cases. Feel free to add the command line client call for your ssystem ;-)");
    }
    File workingDir = new File(directory);
    File consoleLog = new File(StringUtils.join(directory, "/console.log"));
    Process process = mvnExecutor.directory(workingDir)
        .redirectOutput(consoleLog)
        .redirectError(Redirect.INHERIT)
        .start();
    process.waitFor(timeout, TimeUnit.SECONDS);
    boolean exitValueSuccess = process.exitValue() == 0;
    boolean logSuccess = FileUtils.readFileToString(consoleLog, StandardCharsets.UTF_8).contains("BUILD SUCCESS");
    return exitValueSuccess && logSuccess;
  }

  public static File buildModulePomFile() {
    return BUILD_MODULE_POM_FILE;
  }

  public static String buildModulePomFileContent() throws IOException {
    return FILE_CONTENTS.compute(BUILD_MODULE_POM_FILE,
        unchecked((file, content) -> FileUtils.readFileToString(file, StandardCharsets.UTF_8)));
  }

  public static File buildModuleCsConfigFile() {
    return BUILD_MODULE_CS_CONFIG_FILE;
  }

  public static File buildModuleCsResultFile() {
    return BUILD_MODULE_CS_RESULT_FILE;
  }

  public static File buildModuleSiteFile() {
    return BUILD_MODULE_SITE_FILE;
  }

  public static File buildModuleSiteCsFile() {
    return BUILD_MODULE_SITE_CS_FILE;
  }

  public static File buildModuleSiteCsAggregateFile() {
    return BUILD_MODULE_SITE_CS_AGGREGATE_FILE;
  }

  public static File moduleAPomFile() {
    return MODULE_A_POM_FILE;
  }

  public static String moduleAPomFileContent() throws IOException {
    return FILE_CONTENTS.compute(MODULE_A_POM_FILE,
        unchecked((file, content) -> FileUtils.readFileToString(file, StandardCharsets.UTF_8)));
  }

  public static File moduleACsConfigFile() {
    return MODULE_A_CS_CONFIG_FILE;
  }

  public static File moduleACsResultFile() {
    return MODULE_A_CS_RESULT_FILE;
  }

  public static String moduleACsResultFileContent() {
    return FILE_CONTENTS.compute(MODULE_A_CS_RESULT_FILE,
        unchecked((file, content) -> FileUtils.readFileToString(file, StandardCharsets.UTF_8)));
  }

  public static File moduleAIgnoreCheckstyleFile() {
    return MODULE_A_IGNORE_CHECKSTYLE_FILE;
  }

  public static File moduleASiteFile() {
    return MODULE_A_SITE_FILE;
  }

  public static File moduleASiteCsFile() {
    return MODULE_A_SITE_CS_FILE;
  }

  public static File moduleBPomFile() {
    return MODULE_B_POM_FILE;
  }

  public static String moduleBPomFileContent() throws IOException {
    return FILE_CONTENTS.compute(MODULE_B_POM_FILE,
        unchecked((file, content) -> FileUtils.readFileToString(file, StandardCharsets.UTF_8)));
  }

  public static File moduleBCsConfigFile() {
    return MODULE_B_CS_CONFIG_FILE;
  }

  public static File moduleBCsResultFile() {
    return MODULE_B_CS_RESULT_FILE;
  }

  public static String moduleBCsResultFileContent() {
    return FILE_CONTENTS.compute(MODULE_B_CS_RESULT_FILE,
        unchecked((file, content) -> FileUtils.readFileToString(file, StandardCharsets.UTF_8)));
  }

  public static File moduleBSiteFile() {
    return MODULE_B_SITE_FILE;
  }

  public static File moduleBSiteCsFile() {
    return MODULE_B_SITE_CS_FILE;
  }
}