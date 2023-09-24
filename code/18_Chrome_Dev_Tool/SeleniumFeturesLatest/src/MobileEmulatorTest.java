import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v116.emulation.Emulation;

public class MobileEmulatorTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		//send command to CDP methods -> 
		devTools.send(Emulation.setDeviceMetricsOverride(400, 1000, 50, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
		
		driver.get("https://rahulshettyacademy.com/practice-project");
		
		driver.findElement(By.cssSelector("button[class='navbar-toggle']")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Courses")).click();
		
		Thread.sleep(2000);
		driver.close();
	}

}
