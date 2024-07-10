package org.qa.tests;

import com.aventstack.extentreports.Status;
import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.utilities.TestUtil;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

public class ContactsPageTest extends TestBase {
  public LoginPage loginPage;
  public HomePage homePage;
  public TestUtil testUtil;
  public ContactsPage contactsPage;

  public ContactsPageTest () {
    super ();
  }

  @BeforeMethod
  public void setup (Method method) {
    init ();
    methodName = method.getName ();
    extentTest = extentReports.createTest (methodName);
    loginPage = new LoginPage ();
    testUtil = new TestUtil ();
    contactsPage = new ContactsPage ();
    homePage = loginPage.login (properties.getProperty ("username"), properties.getProperty ("password"));
  }

  @Test
  public void validateContactLabel () {
    testUtil.switchToFrame ();
    homePage.clickOnContactLink ();
    Assert.assertTrue (contactsPage.verifyContactLabelDisplayed ());
  }

  @Test
  public void selectContact () {
    testUtil.switchToFrame ();
    homePage.clickOnContactLink ();
    contactsPage.selectContact ("Apple Malvia");
    contactsPage.selectContact ("Bawish Kjham");
  }

  @Test
  public void validateCreateNewContactPage () {
    testUtil.switchToFrame ();
    homePage.clickOnNewContactLink ();
    contactsPage.createNewContact ("mr", "tom", "spidy", "parker");
  }

  @AfterMethod
  public void teardown (ITestResult result, Method method) {

    if (result.getStatus () == ITestResult.SUCCESS) {
      extentTest.log (Status.PASS, methodName + "  Test has been passed");
      extentTest.log (Status.INFO, "  Page title is correct");

    } else if (result.getStatus () == ITestResult.FAILURE) {
      extentTest.log (Status.FAIL, methodName + "  Test has been failed");
      extentTest.log (Status.INFO, "  Page title is not correct");
    }

    driver.quit ();

  }

  @AfterTest
  public void flushReport () {
    extentReports.flush ();
  }

}
