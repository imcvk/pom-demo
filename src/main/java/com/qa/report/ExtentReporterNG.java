package com.qa.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.base.TestBase;




public class ExtentReporterNG extends TestBase  {

  public void reportConfig () {
    //
    htmlReporter = new ExtentSparkReporter (System.getProperty ("user.dir") + "\\extentReport\\Report.html");
    extentReports = new ExtentReports ();
    extentReports.setSystemInfo ("OS", "Windows 10");
    extentReports.setSystemInfo ("Browser", "Chrome");
    extentReports.setSystemInfo ("Java Version", "1.8");

    htmlReporter.config ().setTheme (Theme.STANDARD);
    htmlReporter.config ().setDocumentTitle ("Automation Report");
    htmlReporter.config ().setReportName ("Extent Report Example");
    extentReports.attachReporter (htmlReporter);
  }
}
