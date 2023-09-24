package introduction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.manage().window().maximize();
		
		
		driver.get("https://www.saucedemo.com/");
//		Thread.sleep(1000);
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
//		Thread.sleep(1000);
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		
//		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		
		Thread.sleep(5000);

		driver.close();
	}

}
