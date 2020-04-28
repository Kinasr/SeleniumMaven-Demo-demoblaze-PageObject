package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentLoggerReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class TestNGListener implements ITestListener {
    public ExtentLoggerReporter loggerReporter;
    public ExtentReports extentReports;
    public ExtentTest extentTest;

    @Override
    public void onStart(ITestContext context) {
        loggerReporter = new ExtentLoggerReporter("./TestReport/jjj.html");
        loggerReporter.config().setDocumentTitle("demoblaze-SandBox Test");
        loggerReporter.config().setTheme(Theme.DARK);

        extentReports = new ExtentReports();
        extentReports.attachReporter(loggerReporter);
        extentReports.setSystemInfo("Browser", PropertyReader.getProperty("BROWSER"));
    }

    @Override
    public void onTestStart(ITestResult result) {
        extentTest = extentReports.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.log(Status.PASS, "TestCase Passed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.log(Status.SKIP, "TestCase Skipped");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.log(Status.FAIL, "TestCase Failed");
        extentTest.log(Status.FAIL, result.getThrowable());

        String imgPath = "screenshots/" + Helper.takeScreenshot(result.getName());
        extentTest.log(Status.FAIL, "<a href='" + imgPath + "'> <img src='"
                + imgPath + "' style='width:900px;height:500px;'> </>");
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
    }

}
