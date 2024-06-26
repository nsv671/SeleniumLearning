import java.util.Set;
import java.util.List;
import java.util.Iterator;
import java.util.stream.Collectors;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LiveDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String URL = "https://rahulshettyacademy.com/seleniumPractise/";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(URL);
		
		driver.findElement(By.cssSelector(".cart-header-navlink[href='#/offers']")).click();
		
		Set<String> window = driver.getWindowHandles();
		
		Iterator<String> iterator = window.iterator();
		//parent window
		iterator.next();
		
		driver.switchTo().window(iterator.next());
		
		driver.findElement(By.xpath("//table/thead/tr/th[1]")).click();
		
		List<WebElement> fruitAndVegitableWebElementList = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
		
		List<String> vegitableAndFruitName = fruitAndVegitableWebElementList.stream().map(webelement -> webelement.getText()).collect(Collectors.toList());
		
		List<String> sortedVegitableAndFruitName = vegitableAndFruitName.stream().sorted().collect(Collectors.toList());
		
		Assert.assertTrue(vegitableAndFruitName.equals(sortedVegitableAndFruitName));
		
		//Finding the price from the table for the vegitable
		List<String> price;
		
		do {
			List<WebElement> row = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
			
			price = row.stream().filter(vegitable -> vegitable.getText().contains("Rice")).map(vegitable -> getPrice(vegitable)).collect(Collectors.toList());
				price.stream().forEach(item -> System.out.println(item));
			if(price.size()<1) {
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}
		}while(price.size()<1);
		
		String searchItem = "Rice";
		driver.findElement(By.id("search-field")).sendKeys(searchItem);
		List<WebElement> searchList = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
		List<WebElement> newSearchList = searchList.stream().filter(vegitableName -> vegitableName.getText().contains("Rice")).collect(Collectors.toList());
		System.out.println(searchList.size());
		System.out.println(newSearchList.size());
		Assert.assertEquals(searchList.size(), newSearchList.size());
		
		driver.quit();
	}
	
	public static String getPrice(WebElement vegitable) {
		String price = vegitable.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}

}
