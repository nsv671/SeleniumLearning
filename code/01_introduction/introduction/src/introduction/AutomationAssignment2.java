package introduction;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AutomationAssignment2 {
	public static void main(String[] age) throws InterruptedException  {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.findElement(By.name("name")).sendKeys("nsv");
		driver.findElement(By.name("email")).sendKeys("automation@test.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("automation@test");
		driver.findElement(By.cssSelector("input[type='checkbox']")).click();
		
		WebElement dropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		
		Select options = new Select(dropdown);
		options.selectByVisibleText("Female");
//		driver.findElement(By.xpath("//*[@id=\"exampleFormControlSelect1\"]/option[2]")).click();
		
		driver.findElement(By.id("inlineRadio1")).click();
		
		driver.findElement(By.cssSelector("input[type='date']")).sendKeys("12-34-2056");
		
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		
//		System.out.println(driver.findElement(By.xpath("(/html/body/app-root/form-comp/div/div[2]/div)[1]")).getText());
		System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());	
		
		Thread.sleep(4000);
		driver.close();
	}
}
