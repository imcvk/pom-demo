package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends TestBase {
  public ContactsPage () {
    PageFactory.initElements (driver, this);
  }

  @FindBy(xpath = "//td[contains(text(),'Contacts')]")
  public WebElement ContactLabel;

  public boolean verifyContactLabelDisplayed () {
    return ContactLabel.isDisplayed ();
  }

  public void selectContact (String name) {
    String xpath = "//*[@_name='" + name + "']//parent::td//parent::tr//input";
    WebElement checkbox = driver.findElement (By.xpath (xpath));
    checkbox.click ();
  }
}
