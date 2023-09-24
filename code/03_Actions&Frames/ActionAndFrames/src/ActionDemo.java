import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionDemo {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		Actions actions = new Actions(driver);
		
		WebElement move =  driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
		WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		
		//search a item
		actions.moveToElement(search).click().keyDown(Keys.SHIFT).sendKeys("umbrella").doubleClick().build().perform();
		
		//move to an element
		actions.moveToElement(move).build().perform();
		
		Thread.sleep(5000);
		driver.close();
	}

}
