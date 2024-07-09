package org.qa.tests;

import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.utilities.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
  public LoginPage loginPage;
  public HomePage homePage;
  public TestUtil testUtil;
  public ContactsPage contactsPage;

  public HomePageTest () {
    super ();
  }

  @BeforeMethod
  public void setup () {
    init ();
    loginPage = new LoginPage ();
    testUtil = new TestUtil ();
    homePage = loginPage.login (properties.getProperty ("username"), properties.getProperty ("password"));
  }
  @AfterMethod
  public void teardown () {
    driver.quit ();
  }
  @Test(enabled = false,priority = 1)
  public void verifyHomePageTitleTest () {
    homePage.verifyHomePageTitle ();
  }

  @Test(priority = 2)
  public void verifyUserNameTest () {
    testUtil.switchToFrame ();
    Assert.assertTrue (homePage.verifyUserName ());
  }

  @Test(enabled = false, priority = 3)
  public void verifyClickContactsLink () {
    testUtil.switchToFrame ();
    contactsPage = homePage.clickOnContactLink ();
  }


}
