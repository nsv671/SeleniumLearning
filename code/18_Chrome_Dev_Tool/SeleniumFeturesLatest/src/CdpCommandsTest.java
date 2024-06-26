import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class CdpCommandsTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files\\Google\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		DevTools devTools = driver.getDevTools();

		devTools.createSession();

		Map<String, Object> deviceMetrix = new HashMap<String, Object>();
		deviceMetrix.put("width", 400);
		deviceMetrix.put("height", 1000);
		deviceMetrix.put("deviceScaleFactor", 51);
		deviceMetrix.put("mobile", true);

		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrix);

		driver.get("https://rahulshettyacademy.com/practice-project");

		driver.findElement(By.cssSelector("button[class='navbar-toggle']")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Courses")).click();

		Thread.sleep(2000);
		driver.close();
	}

}
