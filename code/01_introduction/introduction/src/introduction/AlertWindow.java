package introduction;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AlertWindow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("name")).sendKeys("NSV");
		
		driver.findElement(By.id("alertbtn")).click();
		
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		Thread.sleep(2000);
		driver.findElement(By.id("confirmbtn")).click(); 	
		
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		
		driver.close();
	}

}
