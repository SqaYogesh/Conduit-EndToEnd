package runner;

import java.io.File;

import managers.FileReaderManager;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue= {"stepDefinitions"},
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
		monochrome = true
		)

public class TestRunner {

	 @AfterClass
	 public static void writeExtentReport() {
	 Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
     Reporter.setSystemInfo("User Name", "Yogesh Kumar - +91-9899799130");
     Reporter.setSystemInfo("ExecutionReport", "Conduit EndToEnd Execution Report");
	 }
}
