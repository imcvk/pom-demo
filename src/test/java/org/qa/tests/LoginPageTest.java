package org.qa.tests;

import com.qa.base.TestBase;
import com.qa.pages.LoginPage;
import com.qa.utilities.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

  public LoginPage loginPage;

  public LoginPageTest () {
    super ();
  }

  @BeforeMethod
  public void setup () {
    init ();
    loginPage = new LoginPage ();
  }

  @Test(priority = 1)
  public void loginPageTitleTest () {
    String title = loginPage.getTitle ();
    Assert.assertEquals (title, TestUtil.LOGIN_PAGE_TITLE);
  }

  @Test(priority = 3)
  public void loginPageLoginTest () {
    loginPage.login (properties.getProperty ("username"), properties.getProperty ("password"));
  }

  @AfterMethod
  public void tearDown () {
    driver.quit ();
  }
}
