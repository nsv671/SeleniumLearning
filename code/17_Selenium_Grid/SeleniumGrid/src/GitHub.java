import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GitHub {
	@Test
	public void homePageCheck() throws IOException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
//		capabilities.setBrowserName("chrome");
//		capabilities.setPlatform(Platform.WIN11);
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "edge");
//		capabilities.setCapability(CapabilityType.PLATFORM_NAME, "WIN11");
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.218:4444"), capabilities);
		driver.get("https://github.com");
		System.out.println(driver.getTitle());
		driver.close();
	}
}