package com.bitrix.testPackage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.bitrix.pages.LoginPage;
import com.bitrix.utilities.BrowserUtilities;
import com.bitrix.utilities.ConfigurationReader;
import com.bitrix.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;

public class AbstractTestBase {

    protected static WebDriverWait wait;
    protected static Actions actions;
    protected static WebDriver driver;
    protected JavascriptExecutor js;

    protected ExtentReports reports;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest test;
    protected LoginPage loginPage;

    @BeforeTest
    @Parameters("reportName")
    public void setupTest(@Optional String reportName) {
        System.out.println("Report: " + reportName);
        reportName = reportName == null ? "report.html" : reportName + ".html";

        reports = new ExtentReports();

        String reportPath;

        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            reportPath = System.getProperty("user.dir") + "/test-output/" + reportName;
        } else {
            reportPath = System.getProperty("user.dir") + "\\test-output\\" + reportName;
        }

        htmlReporter = new ExtentHtmlReporter(reportPath);
        reports.attachReporter(htmlReporter);
        htmlReporter.config().setReportName("Bitrix Test Automation Results");
    }

    @AfterTest
    public void afterTest() {
        reports.flush();
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
        loginPage = new LoginPage();
        test = reports.createTest("Verify Website logo");
        Assert.assertEquals(loginPage.getSiteLogoText(), "Authorization", "Website Logo did not match");

        test.info("Login as help desk");
        Assert.assertEquals(loginPage.getSiteLogoText(), "Authorization");

        test.pass("Website logo Authorization was verified");

    }

    @AfterMethod
    public void teardown(ITestResult iTestResult) throws IOException {

        if (iTestResult.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = BrowserUtilities.getScreenshot(iTestResult.getName());
            test.fail(iTestResult.getName());

            test.addScreenCaptureFromPath(screenshotPath, "Failed");
            test.fail(iTestResult.getThrowable());
        }

        Driver.closeDriver();
    }

    public static WebDriverWait getWait() {
        return wait;
    }

    public static Actions getActions() {
        return actions;
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
