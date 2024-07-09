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

public class ContactsPageTest extends TestBase {
  public LoginPage loginPage;
  public HomePage homePage;
  public TestUtil testUtil;
  public ContactsPage contactsPage;

  public ContactsPageTest () {
    super ();
  }

  @BeforeMethod
  public void setup () {
    init ();
    loginPage = new LoginPage ();
    testUtil = new TestUtil ();
    contactsPage = new ContactsPage ();
    homePage = loginPage.login (properties.getProperty ("username"), properties.getProperty ("password"));
  }

//  @Test(priority = 1)
//  public void validateContactLabel () {
//    testUtil.switchToFrame ();
//    homePage.clickOnContactLink ();
//    Assert.assertTrue (contactsPage.verifyContactLabelDisplayed ());
//  }

  @Test(priority = 2)
  public void selectContact () {
    testUtil.switchToFrame ();
    homePage.clickOnContactLink ();
    contactsPage.selectContact ("Apple Malvia");
    contactsPage.selectContact ("Bawish Kjham");
  }

  @AfterMethod
  public void teardown () {
    driver.quit ();
  }
}
