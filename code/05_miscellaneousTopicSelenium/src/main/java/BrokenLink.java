import java.net.URL;
import java.util.List;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLink {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		String url = "https://rahulshettyacademy.com/AutomationPractice/";
		
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		List<WebElement> footerLinks = driver.findElements(By.cssSelector(".gf-li a"));
		
//		System.out.println(footerLinks);
//		System.out.println(footerLinks.size());
		
		SoftAssert softAssert = new SoftAssert();
		
		for(WebElement footerLink : footerLinks) {
//			System.out.println(footerLink.getAttribute("href"));
			String link = footerLink.getAttribute("href");
			int responseCode = getResponseCode(link);
			
			softAssert.assertTrue(responseCode<400, "The link with Text -- " + footerLink.getText() + " Broken with response code -- " + responseCode);
			
//			if(responseCode > 399 && responseCode < 600) {
//				System.out.println("****************************"+"Link is broken -->" + link + "****************************");
//				System.out.println("The link with Text" + footerLink.getText() + " Broken with response code " + responseCode);
//				Assert.assertTrue(false);	
//			}
		}
		softAssert.assertAll();
		
		driver.close();
	}
	
	static int getResponseCode(String url) throws MalformedURLException, IOException {
		HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
		connection.setRequestMethod("HEAD");
		connection.connect();
		
		return connection.getResponseCode();
	}

}
