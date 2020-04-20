package com.javaautomation.test.tests;

import java.net.URL;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Capabilities;

import ru.stqa.selenium.factory.WebDriverPool;

/**
 * Base class for all the JUnit-based test classes
 */
public class JUnitTestBase {

  protected static URL gridHubUrl;
  protected static String baseUrl;
  protected static String apiUrl;
  protected static Capabilities capabilities;
  protected static String DirectorName;
  protected static String DirectorBirthDate;
  protected static String FilmName;
  protected static String FilmReleaseYear;
  protected WebDriver driver;

  @BeforeAll
  public static void loadConfig() throws Throwable {
    SuiteConfiguration config = new SuiteConfiguration();
    baseUrl = config.getProperty("site.url");
    apiUrl = config.getProperty("api.url");
    DirectorName = config.getProperty("director.name");
    DirectorBirthDate = config.getProperty("director.birthdate");
    FilmName = config.getProperty("film.name");
    FilmReleaseYear = config.getProperty("film.releaseyear");
    if (config.hasProperty("grid.url") && !"".equals(config.getProperty("grid.url"))) {
      gridHubUrl = new URL(config.getProperty("grid.url"));
    }
    capabilities = config.getCapabilities();
  };

  @BeforeEach
  public void initDriver() throws Throwable {
    driver = WebDriverPool.DEFAULT.getDriver(gridHubUrl, capabilities);
  }
}
