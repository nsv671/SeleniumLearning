import java.util.List;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginpagePractise {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		login(driver, wait);
		
		wait.until(ExpectedConditions.urlMatches("https://rahulshettyacademy.com/angularpractice/shop"));
		
		addToCart(driver);
		
		checkout(driver, wait);
		
		Thread.sleep(5000);
		
		driver.close();
	}
	
	public static void login(WebDriver driver,  WebDriverWait wait) {
		driver.manage().window().maximize();
		//hitting the URL
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		//giving user name and password
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");

		//changing the user type to user and accepting the alert
		driver.findElement(By.cssSelector("input[value='user']")).click();
//		driver.switchTo().alert().accept();
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		
		//selecting consultant drop down
		WebElement dropdown = driver.findElement(By.cssSelector("select.form-control"));
		Select option = new Select(dropdown);
		option.selectByVisibleText("Consultant");
		
		//accepting term and conditions
		driver.findElement(By.id("terms")).click();
		
		//clicking login btn
		driver.findElement(By.id("signInBtn")).click();
		
		//explicit waiting for 5 second after sign in button click
//		wait.until(ExpectedConditions.urlMatches("https://rahulshettyacademy.com/angularpractice/shop"));
	}
	
	public static void addToCart(WebDriver driver) {
		List<WebElement> addProduct = driver.findElements(By.cssSelector("button.btn-info"));
		
		for(WebElement add : addProduct) {
			add.click();
		}
	}
	
	public static void checkout(WebDriver driver, WebDriverWait wait) throws InterruptedException{
		driver.findElement(By.cssSelector("a.btn-primary")).click();
		driver.findElement(By.cssSelector("button.btn-success")).click();
		
		driver.findElement(By.id("country")).sendKeys("ind");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.suggestions")));
		List<WebElement> countryList = driver.findElements(By.cssSelector("ul li a"));
		
		for(WebElement country : countryList) {
			if(country.getText().equalsIgnoreCase("india")) {
				country.click();
				break;
			}
		}
		
		driver.findElement(By.cssSelector("label[for='checkbox2']")).click();
		
		driver.findElement(By.cssSelector("input.btn-success")).click();
	}

}
