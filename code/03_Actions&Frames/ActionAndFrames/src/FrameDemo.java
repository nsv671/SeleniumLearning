import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String URL = "https://jqueryui.com/droppable/";
		WebDriver driver = new ChromeDriver();
		
		driver.get(URL);
		driver.switchTo().frame((driver.findElement(By.cssSelector("iframe[class='demo-frame']"))));
		driver.findElement(By.id("draggable")).click();
		
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		Actions action = new Actions(driver);
		
		action.dragAndDrop(source, target).build().perform();
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(5000);
		driver.close();
	}

}
