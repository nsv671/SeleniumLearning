package SeleniumFrameworkDesign.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {
	ExtentReports extent;
	
	@BeforeTest
	//ExtentReports, ExtentSparkReporter
	public void config() {
		String file = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(file);
		
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setReportName("Web Automation Test");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Nitesh Sah");
	}
	
	
	@Test
	public void initialDemo() {
		ExtentTest test = extent.createTest("Initial Demo");
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.driver.chromedriver", "C:\\Program Files\\Google\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		
		driver.get("https://github.com");
		System.out.println(driver.getTitle());
		
		driver.close();
		test.fail("Result did not match");
		extent.flush();
	}
}