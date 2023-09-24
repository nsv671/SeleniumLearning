import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GoogleTest {
	@Test
	public void homePageCheck() throws IOException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName("chrome");
//		capabilities.setPlatform(Platform.WIN11);
//		capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
//		capabilities.setCapability(CapabilityType.PLATFORM_NAME, "WIN11");
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.218:4444"), capabilities);
		driver.get("https://google.com");
		System.out.println(driver.getTitle());
		driver.findElement(By.className("name='q'")).sendKeys("github.com");
		driver.findElement(By.className("name='q'")).sendKeys(Keys.ENTER);
		System.out.println(driver.getTitle());
		driver.close();
	}
}
