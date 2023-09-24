import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentWebTable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String URL = "https://rahulshettyacademy.com/AutomationPractice/";
		
		WebDriver driver = new ChromeDriver();
		
		driver.get(URL);
		
		JavascriptExecutor javascripe = (JavascriptExecutor) driver;
		javascripe.executeScript("window.scrollBy(0, 550)");
		
		Thread.sleep(2000);
		
		List<WebElement> table = driver.findElements(By.cssSelector(".table-display tbody tr"));
		
		int row = table.size();
		System.out.println("number of rows in table = "+row);
		
		int column = table.get(0).findElements(By.tagName("th")).size();
		System.out.println("number of clumn in table = "+ column);
		
		List<WebElement> columnValue = table.get(2).findElements(By.tagName("td"));

		for(WebElement value : columnValue) {
			System.out.println(value.getText());
		}
		
		Thread.sleep(3000);
		
		driver.close();
	}

}
