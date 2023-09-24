import java.util.List;
import java.util.Arrays;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class DeepDiveIntoDunctionalTesting {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// below property setting is
//		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Google\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");

		String[] itemNeeded = { "Cucumber", "Tomato", "Pumpkin" };
//		String[] itemNeeded = {"Cucumber", "Brocolli", "Cauliflower","Beetroot"};
		WebDriver driver = new ChromeDriver();
		
//		Implicit wait
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
//		explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		addItem(driver, itemNeeded);
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(), 'PROCEED TO CHECKOUT')]")).click();
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();	
//		driver.findElement(By.cssSelector("span.promoInfo"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")));

		Thread.sleep(2000);

		driver.quit();
	}
	
	public static void addItem(WebDriver driver, String[] itemNeeded) {
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/seleniumPractise");

		List<WebElement> productList = driver.findElements(By.cssSelector("h4[class='product-name']"));
		List<String> itemNeededList = Arrays.asList(itemNeeded);
		int clickCount = 0;

		for (int i = 0; i < productList.size(); i++) {
			String vegitableName[] = productList.get(i).getText().split("-");

			if (itemNeededList.contains(vegitableName[0].trim())) {
//				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
//				Thread.sleep(5000);
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				System.out.println(vegitableName[0].trim()+ " -- added to CART");
				clickCount++;

				if (clickCount == itemNeeded.length) {
					System.out.println("All Item added to cart");
					break;
				}
			}
		}
	}

}
