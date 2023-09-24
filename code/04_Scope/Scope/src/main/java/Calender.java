import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calender {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		String URL = "https://www.path2usa.com/travel-companion/";
		String URL = "https://demo.automationtesting.in/Datepicker.html";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(URL);
		
//		driver.findElement(By.id("challenge-stage"));
		
		driver.findElement(By.id("datepicker1")).click();
		
//		ui-datepicker-title
		while(!driver.findElement(By.className("ui-datepicker-title")).getText().contains("July")){
			driver.findElement(By.className("ui-datepicker-next")).click();
			Thread.sleep(500);
		}
		
		List<WebElement> days = driver.findElements(By.className("ui-state-default"));
		
		for(WebElement day : days) {
			if(day.getText().equalsIgnoreCase("27")) {
				day.click();
			}
		}
		
		Thread.sleep(8000);
		driver.close();
	}

}
