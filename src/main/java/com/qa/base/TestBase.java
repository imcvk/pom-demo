package com.qa.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.pages.LoginPage;
import com.qa.utilities.TestUtil;
import com.qa.utilities.WebEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.EventListener;
import java.util.Properties;

public class TestBase {
  public static WebDriver driver;
  public static Properties properties;
  public static EventFiringDecorator e_driver;
  public static WebEventListener eventListener;
  public ExtentSparkReporter htmlReporter;
  public ExtentReports extentReports;
  public ExtentTest extentTest;
  public String methodName;

  public TestBase () {
    try {
      properties = new Properties ();
      FileInputStream inputStream = new FileInputStream ("src/main/java/com/qa/config/config.properties");
      properties.load (inputStream);
    } catch (Exception e) {
      e.printStackTrace ();
    }
  }

  public void init () {
    String browser = properties.getProperty ("browser");
    switch(browser) {
      case "chrome":
        driver = new ChromeDriver ();
        break;
      case "IE":
        driver = new InternetExplorerDriver ();
        break;
      case "FF":
        driver = new FirefoxDriver ();
        break;
      default:
        break;
    }
//    e_driver = new EventFiringDecorator ();
//    eventListener = new WebEventListener ();
//    e_driver.getDecoratedDriver ().getDecorator ().

    driver.manage ().window ().maximize ();
    driver.manage ().deleteAllCookies ();
    driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (TestUtil.IMPLICIT_WAIT));
    driver.manage ().timeouts ().pageLoadTimeout (Duration.ofSeconds (TestUtil.PAGE_LOAD_TIMEOUT));
    driver.get (properties.getProperty ("url"));

    //

  }
}
