package SeleniumFrameworkDesign.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import SeleniumFrameworkDesign.locator.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public LandingPage landingPage;

	public void initilizedDriver() throws IOException {
		Properties properties = new Properties();
		FileInputStream fileInputStream = new FileInputStream(
				"C:\\Users\\nites\\Desktop\\SELENIUM\\code\\11_Framework_Part3\\SeleniumFrameworkDesign\\src\\main\\resources\\GlobalData.properties");
//		FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"SeleniumFrameworkDesign\\src\\main\\resources\\GlobalData.properties");
		properties.load(fileInputStream);
		String browserName = properties.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		String jsonString = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		ObjectMapper objectMapper = new ObjectMapper();
		List<HashMap<String, String>> data = objectMapper.readValue(jsonString,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

	public String takeScreenShot(String testCaseName, WebDriver driver) throws IOException {
		String path = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(path));

		return path;
	}

	@BeforeMethod(alwaysRun = true)
	public LandingPage lanchApplication() throws IOException {
		initilizedDriver();
		landingPage = new LandingPage(driver);
		landingPage.goTo();

		return landingPage;
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.close();
	}
}
