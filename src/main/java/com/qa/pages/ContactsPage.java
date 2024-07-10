package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class ContactsPage extends TestBase {
  public ContactsPage () {
    PageFactory.initElements (driver, this);
  }

  @FindBy(xpath = "//td[contains(text(),'Contacts')]")
  public WebElement ContactLabel;
  @FindBy(xpath = "//select[@name='title']")
  public WebElement selectTitle;
  @FindBy(xpath = "//*[@name='first_name']")
  public WebElement first_name;
  @FindBy(xpath = "//*[@name='middle_initial']")
  public WebElement middle_initial;
  @FindBy(xpath = "//*[@name='surname']")
  public WebElement surname;
  @FindBy(xpath = "//*[@name='suffix']")
  public WebElement suffix;
  @FindBy(xpath = "//*[@name='nickname']")
  public WebElement nickname;
  @FindBy(xpath = "//*[@name='client_lookup']")
  public WebElement client_lookup;
  @FindBy(xpath = "//*[@name='company_position']")
  public WebElement company_position;
  @FindBy(xpath = "//*[@name='department']")
  public WebElement department;
  @FindBy(xpath = "//*[@id=\"contactForm\"]//*[@value=\"Save\"]")
  public WebElement save;

  public boolean verifyContactLabelDisplayed () {
    return ContactLabel.isDisplayed ();
  }

  public void selectContact (String name) {
    String xpath = "//*[@_name='" + name + "']//parent::td//parent::tr//input";
    WebElement checkbox = driver.findElement (By.xpath (xpath));
    checkbox.click ();
  }

  public void createNewContact (String title, String fname, String mname, String lname) {
    Select s = new Select (selectTitle);
    s.selectByIndex (1);
//    first_name.sendKeys (fname);
//    surname.sendKeys (lname);
    save.click ();
    String xpath = "(//*[@class=\"tabs_header\"])[1]";
    Assert.assertTrue (driver.findElement (By.xpath (xpath)).isDisplayed ());
  }

}
