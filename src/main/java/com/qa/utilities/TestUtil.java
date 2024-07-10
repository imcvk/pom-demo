package com.qa.utilities;

import com.qa.base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class TestUtil extends TestBase {
  public static long PAGE_LOAD_TIMEOUT = 50;
  public static long IMPLICIT_WAIT = 50;
  public static String LOGIN_PAGE_TITLE = "Free CRM software for customer relationship management, sales, and support.";
  public static String HOME_PAGE_TITLE = "CRMPRO";
  public static String USERNAME_LABEL = "Gagan Khanna";
  public static String TEST_DATA_PATH = "src/main/java/com/qa/testdata/testData.xlsx";

  public void switchToFrame () {
    driver.switchTo ().frame ("mainpanel");
  }

  public void takeScreenshot () throws IOException {
    TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
    File scrFi1e = takesScreenshot.getScreenshotAs (OutputType.FILE);
    String currentDir = System.getProperty ("user.dir");
    FileUtils.copyFile (scrFi1e, new File (currentDir + "/screenshots/" + System.currentTimeMillis () + ".png"));
  }
}
