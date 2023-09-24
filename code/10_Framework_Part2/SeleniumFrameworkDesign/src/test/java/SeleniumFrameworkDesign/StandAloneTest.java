package SeleniumFrameworkDesign;

import java.util.List;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import SeleniumFrameworkDesign.locator.CartPage;
import SeleniumFrameworkDesign.locator.CheckOutPage;
import SeleniumFrameworkDesign.locator.ConformationPage;
import SeleniumFrameworkDesign.locator.LandingPage;
import SeleniumFrameworkDesign.locator.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		String productName = "ADIDAS ORIGINAL";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo();
		ProductCatalogue productCatalogue = landingPage.loginInto("test671@test.com", "Zxcvbnm@671");
		
		List<WebElement> webElementListsOfProduct = productCatalogue.getProductList();
		
		CartPage cartPage = productCatalogue.addProductToCart(productName);
		boolean flag = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(flag);
		
		CheckOutPage checkOutPage = cartPage.goTOheckout();
		checkOutPage.selectCountry("India");
		ConformationPage conformationPage= checkOutPage.submitOrder();
		String conformationMessage = conformationPage.getConformationMessage();
		Assert.assertTrue(conformationMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		driver.findElement(By.className("fa-sign-out")).click();

		driver.close();
		
		// TODO Auto-generated method stub
//		String URL = "https://rahulshettyacademy.com/client/";
//		String productName = "ADIDAS ORIGINAL";

//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//		driver.get(URL);
//		driver.findElement(By.id("userEmail")).sendKeys("test671@test.com");
//		driver.findElement(By.id("userPassword")).sendKeys("Zxcvbnm@671");
//		driver.findElement(By.id("login")).click();
//		LandingPage landingPage = new LandingPage(driver);
//		landingPage.goTo();
//		ProductCatalogue productCatalogue = landingPage.loginInto("test671@test.com", "Zxcvbnm@671");
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("mb-3")));
//		List<WebElement> webElementListsOfProduct = driver.findElements(By.className("mb-3"));
//		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
//		List<WebElement> webElementListsOfProduct = productCatalogue.getProductList();


//		WebElement productNeedToSelect = webElementListsOfProduct.stream()
//				.filter(product -> product.findElement(By.tagName("b")).getText()
//						.equalsIgnoreCase(productName))
//				.findFirst().orElse(null);

//		productNeedToSelect.findElement(By.cssSelector(".card-body button:last-of-type")).click();

//		for(WebElement product : webElementListsOfProduct) {
//			String productTitle = product.findElement(By.tagName("b")).getText();
//			System.out.println(productTitle);
//			if(productTitle.equalsIgnoreCase("ADIDAS ORIGINAL")) {
//				product.findElement(By.className("w-10")).click();
//				System.out.println("Product added to cart");
//			}
//		}
		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
//		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
//		productCatalogue.waitForElementToAppear(By.cssSelector("#toast-container"));
//		productCatalogue.waitForElementToAppear(By.cssSelector(".ng-animating"));
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[routerlink*='cart']")));
		
//		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
//		CartPage cartPage = productCatalogue.addProductToCart(productName);
		
//		List<WebElement> cartList = driver.findElements(By.cssSelector(".cartSection h3"));
//		boolean flag = cartList.stream().anyMatch(item -> item.getText().equalsIgnoreCase(productName));
		
//		CartPage cartPage = new CartPage(driver);
//		boolean flag = cartPage.VerifyProductDisplay(productName);
//		Assert.assertTrue(flag);
//		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		
//		Actions actions = new Actions(driver);
//		actions.sendKeys(driver.findElement(By.cssSelector(".form-group input")),"India").build().perform();
//	driver.findElement(By.xpath("(//button[contains(@class, 'ta-item')])[2]")).click();
//	driver.findElement(By.className("action__submit"));
//		productCatalogue.checkout();
//		CheckOutPage checkOutPage = cartPage.goTOheckout();
//		checkOutPage.selectCountry("India");
//		ConformationPage conformationPage= checkOutPage.submitOrder();
//		String conformationMessage = conformationPage.getConformationMessage();
//		Assert.assertTrue(conformationMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
//		
//		driver.findElement(By.className("fa-sign-out")).click();
//
//		driver.close();
	}

}
