import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class Selenium4o {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String URL = "https://rahulshettyacademy.com/angularpractice";
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		
		WebElement nameInput = driver.findElement(By.cssSelector("[name='name']"));
//		(RelativeLocator.with(By.tagName("label")).above(nameInput)).getText();
		String label = driver.findElement(with(By.tagName("label")).above(nameInput)).getText();
		System.out.println(label);
		Thread.sleep(2000);
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("window.scrollBy(0,500)");
		
		WebElement dateOfBirth = driver.findElement(By.cssSelector("label[for='dateofBirth']"));
		driver.findElement(By.cssSelector("[type='date']")).sendKeys("16102023");
		driver.findElement(with(By.tagName("input")).below(dateOfBirth)).click();
		Thread.sleep(2000);
		System.out.println(dateOfBirth.getText());
		System.out.println(driver.findElement(with(By.tagName("input")).below(dateOfBirth)).getAttribute("value"));
		System.out.println("---"+driver.findElement(By.cssSelector("[type='date']")).getText());
		Thread.sleep(2000);
		
		WebElement checkBoxRight = driver.findElement(By.xpath("//label[text() = 'Check me out if you Love IceCreams!']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(checkBoxRight)).click();
		
		WebElement rdb = driver.findElement(By.xpath("//input[@value='option1']"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(rdb)).getText());
		Thread.sleep(2000);
		driver.close();
	}

}
