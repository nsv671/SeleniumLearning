import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaScriptExecutor {
	public static void main(String[] args) throws InterruptedException{
		String URL = "https://rahulshettyacademy.com/AutomationPractice/";
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		
		driver.get(URL);
		
		Thread.sleep(500);
		
		javascript.executeScript("window.scrollBy(0, 500)");
		
		Thread.sleep(2000);
		
		javascript.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		Thread.sleep(2000);
		
		List<WebElement> listOfAmount = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)")); 
		
		int sum =0;
		
		for(WebElement amount : listOfAmount) {
			String price = amount.getText();
			sum += Integer.parseInt(price);
			System.out.println(sum);
		}
		
		String totalAmount = driver.findElement(By.className("totalAmount")).getText().split(":")[1].trim();
		
//		Assert.assertEquals(sum, Integer.parseInt(totalAmount));
		Assert.assertEquals(sum, Integer.parseInt(totalAmount));
		
		System.out.println(sum + "---" + totalAmount);
		Thread.sleep(2000);
		driver.close();
	}
}
