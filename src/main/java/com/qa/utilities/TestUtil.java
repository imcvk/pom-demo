package com.qa.utilities;

import com.qa.base.TestBase;

public class TestUtil extends TestBase {
  public static long PAGE_LOAD_TIMEOUT = 50;
  public static long IMPLICIT_WAIT = 50;
  public static String LOGIN_PAGE_TITLE = "Free CRM software for customer relationship management, sales, and support.";
  public static String HOME_PAGE_TITLE = "CRMPRO";
  public static String USERNAME_LABEL = "Gagan Khanna";

  public void switchToFrame () {
    driver.switchTo ().frame ("mainpanel");
  }
}
