package introduction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.testng.*;

public class RahulshettyAcademyAutomation  {
	public static void main(String args[]) throws InterruptedException {
//		System.setProperty("webdriver.chrome.driver", "..\\resource\\chromedriver.exe");
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nites\\Desktop\\SELENIUM\\code\\introduction\\introduction\\src\\resource\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\EdgeDriver\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		String namé = "nitesh";
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/form/input[1]")).sendKeys("nitesh");
		driver.findElement(By.xpath("//*[@id='container']/div[2]/form/input[2]")).sendKeys("password");
		driver.findElement(By.cssSelector("#container > div.form-container.sign-in-container > form > button")).click();
		
//		driver.findElement(By.linkText("Forgot your password?")).click();
		String password = getPassword(driver);
		driver.findElement(By.className("go-to-login-btn")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[@id='container']/div[2]/form/input[1]")).sendKeys(namé);
		driver.findElement(By.xpath("//*[@id='container']/div[2]/form/input[2]")).sendKeys(password);
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.id("chkboxTwo")).click();
		
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(), "Hello "+namé+",");
		Thread.sleep(2000);
		driver.findElement(By.className("logout-btn")).click();

		Thread.sleep(3000);
		driver.close();
	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[@id=\"container\"]/div[1]/form/input[1]")).sendKeys("nitesh");
		driver.findElement(By.xpath("//*[@id=\"container\"]/div[1]/form/input[2]")).sendKeys("test123@test.com");
		driver.findElement(By.xpath("//*[@id=\"container\"]/div[1]/form/input[3]")).sendKeys("9876543210");
		
		driver.findElement(By.className("reset-pwd-btn")).click();
		String resetPasswordMessage = driver.findElement(By.className("infoMsg")).getText();
		String password[] =resetPasswordMessage.split("'");
		return password[1];
	}
}