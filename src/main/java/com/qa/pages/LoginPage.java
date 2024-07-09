package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
  public LoginPage () {
    PageFactory.initElements (driver, this);
  }

  @FindBy(name = "username")
  public static WebElement login_Username;
  @FindBy(name = "password")
  public static WebElement login_Password;
  @FindBy(xpath = "//input[@type='submit']")
  public static WebElement login_Submit;
  @FindBy(xpath = "//a[@class='navbar-brand']")
  public static WebElement login_Logo;

  public String getTitle () {
    return driver.getTitle ();
  }

  public HomePage login (String username,String password) {
    login_Username.sendKeys (username);
    login_Password.sendKeys (password);
    login_Submit.click ();
    return new HomePage ();
  }
}
