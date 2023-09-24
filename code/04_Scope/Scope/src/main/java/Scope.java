import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		String URL ="https://rahulshettyacademy.com/AutomationPractice/";
		driver.get(URL);
		
		//count total number of links {a}
		int linkCount = driver.findElements(By.tagName("a")).size();
		
		System.out.println(linkCount);
		
		WebElement footerDriver = driver.findElement(By.className("gf-t"));
		
		int footerLinkCount = footerDriver.findElements(By.tagName("a")).size();
		System.out.println(footerLinkCount);
		
		WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td/ul"));
		
		int footerColumnLinkCount = columnDriver.findElements(By.tagName("a")).size();
		System.out.println(footerColumnLinkCount);
		
		int workingLinkCount = 0;

		for(int i=0; i< footerColumnLinkCount; i++) {
			String linkClickTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(linkClickTab);
		}
		Thread.sleep(10000);
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		iterator.next();

		while(iterator.hasNext()) {
			driver.switchTo().window(iterator.next());
			
			String currentURL = driver.getCurrentUrl();
			System.out.println(currentURL);
			
			if(!currentURL.equalsIgnoreCase(URL+"#")) {
				workingLinkCount++;
				System.out.println(driver.getTitle());
			}
		}
		
		System.out.println("working link count --->  " + workingLinkCount);
		
		driver.quit();
	}

}
