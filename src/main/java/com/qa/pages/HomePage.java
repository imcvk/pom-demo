package com.qa.pages;

import com.qa.base.TestBase;
import com.qa.utilities.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends TestBase {
  public HomePage () {
    PageFactory.initElements (driver, this);
  }

  Actions action;
  @FindBy(xpath = "//td[contains(text(),'Gagan Khanna')]")
  public static WebElement userNameLabel;
  @FindBy(xpath = "//*[@title='Contacts']")
  public static WebElement ContactsLink;
  @FindBy(xpath = "//*[@title=\"Deals\"]")
  public static WebElement DealsLink;
  @FindBy(xpath = "title=\"Tasks\"")
  public static WebElement TasksLink;
  @FindBy(xpath = "//*[@title='New Contact']")
  public static WebElement New_Contact;

  public void verifyHomePageTitle () {
    String title = driver.getTitle ();
    Assert.assertTrue (title.equals (TestUtil.HOME_PAGE_TITLE));
  }

  public boolean verifyUserName () {
    String username = userNameLabel.getText ().trim ();
    return username.contains (TestUtil.USERNAME_LABEL);
  }

  public ContactsPage clickOnContactLink () {
    ContactsLink.click ();
    return new ContactsPage ();
  }

  public DealsPage clickOnDealsLink () {
    DealsLink.click ();
    return new DealsPage ();
  }

  public TaskPage clickOnTaskLink () {
    TasksLink.click ();
    return new TaskPage ();
  }

  public void clickOnNewContactLink () {
    action = new Actions (driver);
    action.moveToElement (ContactsLink).build ().perform ();
    New_Contact.click ();
    // return new ContactsPage ();
  }
}
