package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class e2e {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nites\\Desktop\\SELENIUM\\code\\introduction\\introduction\\src\\resource\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		String URL = "https://rahulshettyacademy.com/dropdownsPractise/";
		
		//hit the URL
		driver.get(URL);
		
		//Trip type i.e. - one way, round trip or multiplicity
		//we are selecting one way
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		
		//Adding From and To location
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		
		//selecting date i.e. - current date for this test
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-hover")).click();
		
		//Checking return calendar if it is enable or not
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
			System.out.println("Return calender is desible");
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
		//selecting Senior citizen check box and checking if it is successfully selected or not
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		if(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected()) {
			System.out.println("SeniorCitizenDiscount check box selected successfully");
		}
		
		
		//Adding 5 Adult passenger
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		for(int i=1; i<5; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
			Thread.sleep(500);
		}
		
		//Selecting USD currency type from currency
		WebElement selectDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(selectDropdown);
		Thread.sleep(1000);
		dropdown.selectByValue("USD");
		
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		System.out.println("Search button click successfully");
		
		Thread.sleep(5000);
		driver.close();
	}

}
