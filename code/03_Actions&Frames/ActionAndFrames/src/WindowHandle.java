import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		String URL = "https://rahulshettyacademy.com/loginpagePractise/";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(URL);
		driver.findElement(By.cssSelector("a[class='blinkingText']")).click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		
		String parentWIndow = iterator.next();
		String childWindow = iterator.next();
		
		driver.switchTo().window(childWindow);
		
		String childWindowString = driver.findElement(By.cssSelector(".im-para.red")).getText();
		System.out.println(childWindowString);
		
		String email = childWindowString.split("at")[1].trim().split(" ")[0];
		System.out.println(email);
		
		driver.switchTo().window(parentWIndow);
		
		driver.findElement(By.id("username")).sendKeys(email);
		
		Thread.sleep(5000);
		driver.quit();
	}

}
