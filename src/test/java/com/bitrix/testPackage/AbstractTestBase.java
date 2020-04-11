package com.bitrix.testPackage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.bitrix.utilities.BrowserUtilities;
import com.bitrix.utilities.ConfigurationReader;
import com.bitrix.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;

public class AbstractTestBase {

    // will be visible in the subclass, regarless of subclass location (same package or no)
    protected WebDriverWait wait;
    protected Actions actions;
    protected WebDriver driver;
    protected JavascriptExecutor js;

    protected ExtentReports reports;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest test;

    /**
     * ExtentReports extent = new ExtentReports();
     * extent.attachReporter(reporterType);
     */

    //@Optional - to make parameter optional
    //if you don't specify it, testng will require to specify this parameter for every test, in xml runner
    @BeforeTest
    @Parameters("reportName")
    public void setupTest(@Optional String reportName) {
        System.out.println("Report: " + reportName);
        reportName = reportName == null ? "report.html" : reportName + ".html";

        reports = new ExtentReports();

        String reportPath = "";
        // location of report file
        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            reportPath = System.getProperty("user.dir") + "/test-output/" + reportName;
        } else {
            reportPath = System.getProperty("user.dir") + "\\test-output\\" + reportName;
        }

        //is a HTML report itself
        htmlReporter = new ExtentHtmlReporter(reportPath);
        // add it to the reporter
        reports.attachReporter(htmlReporter);
        htmlReporter.config().setReportName("VyTrack Test Automation Results");
    }

    @AfterTest
    public void afterTest() {
        reports.flush(); //to release a report
    }

    @BeforeMethod
    public void setup() {
        driver = Driver.getDriver();
        driver.manage().deleteAllCookies();
        String URL = ConfigurationReader.getProperty("bitrix");
        driver.get(URL);
        driver.manage().window().maximize();
        wait = new WebDriverWait(Driver.getDriver(), 25);
        actions = new Actions(Driver.getDriver());
        js = (JavascriptExecutor) driver;

    }

    @AfterMethod
    public void teardown(ITestResult iTestResult) throws IOException {
        //ItestResult class describes the result of a test.
        // if test failed, take a screenshot
        // no failure - no  screenshot
        if (iTestResult.getStatus() == ITestResult.FAILURE) {
            // screenshot will have a name of the test
            String screenshotPath = BrowserUtilities.getScreenshot(iTestResult.getName());
            test.fail(iTestResult.getName()); // attach test name that failed
            BrowserUtilities.wait(2);
            test.addScreenCaptureFromPath(screenshotPath, "Failed"); // attach screenshot
            test.fail(iTestResult.getThrowable()); // attach console output
        }

        BrowserUtilities.wait(2);

        Driver.closeDriver();
    }
}
