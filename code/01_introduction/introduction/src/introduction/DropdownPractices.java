package introduction;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DropdownPractices {
	public static void main(String[] age) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\nites\\Desktop\\SELENIUM\\code\\introduction\\introduction\\src\\resource\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		WebElement selectDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

		Select dropdown = new Select(selectDropdown);
		Thread.sleep(1000);
		dropdown.selectByIndex(2);
		System.out.println(dropdown.getFirstSelectedOption().getText());

		Thread.sleep(1000);
		dropdown.selectByValue("USD");
		System.out.println(dropdown.getFirstSelectedOption().getText());

		Thread.sleep(1000);
		dropdown.selectByVisibleText("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());

		////////////////////////////////////////////////////////////////////////////////////////////////
//		check box handling
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
//		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
//		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

//		counting number of check box
		System.out.println(driver.findElements(By.cssSelector("inpunt[type='checkbox']")).size());

		////////////////////////////////////////////////////////////////////////////////////////////////
//		adding Passenger 
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000L);

		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		for (int i = 1; i < 5; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
			Thread.sleep(500);
		}

		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");

		////////////////////////////////////////////////////////////////////////////////////////////////
//		Adding from and to location
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
//		driver.findElement(By.xpath("//a[@value='BLR']")).click();
//		Alternate way
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']"))
				.click();

		Thread.sleep(2000);

//		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
//		Alternate way
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']"))
				.click();

		////////////////////////////////////////////////////////////////////////////////////////////////
//		Calendar handling
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-hover")).click();

		////////////////////////////////////////////////////////////////////////////////////////////////
//		disable and enable checking
//		selenium check if that web elemenţis clickable or not so some time it did not work
//		driver.findElement(By.id("Div1")).isEnabled();
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"));

		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			System.out.println("Is Enable");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		////////////////////////////////////////////////////////////////////////////////////////////////
//		auto suggestions drop down
		driver.findElement(By.id("autosuggest")).sendKeys("Ind");
		Thread.sleep(2000);

		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("India")) {
				System.out.println(option.getText());
				option.click();
				break;
			}
		}

		Thread.sleep(500);
		driver.close();
	}
}
