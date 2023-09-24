import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentWindowHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String URL = "https://the-internet.herokuapp.com/windows";
//		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		
		driver.findElement(By.linkText("Click Here")).click();
		
		Set<String> window = driver.getWindowHandles();
		
		Iterator<String> iterator = window.iterator();
		
		String parentWindow = iterator.next();
		String chieldWindow = iterator.next();
		
		driver.switchTo().window(chieldWindow);
		String chieldWindowText = driver.findElement(By.tagName("h3")).getText();
		System.out.println(chieldWindowText);
		
		driver.switchTo().window(parentWindow);
		String parentWindowText = driver.findElement(By.tagName("h3")).getText();
		System.out.println(parentWindowText);
		
		driver.quit();
	}

}
