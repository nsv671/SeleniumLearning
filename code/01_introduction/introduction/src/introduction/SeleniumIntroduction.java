package introduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SeleniumIntroduction {

	public static void main(String[] args) {
		
		// Invoke Browser (WebDriver)
		// Chrome --> ChromeDriver extend --> methods close, get
		// Firefox --> FirefoxDriver extend --> methods close, get
		// Safari --> SafariDriver extend --> methods close, get
		// Webdriver --> close, get
		
		// not below commented code. Because chrome drive might have its own method, 
		// which will not be there in other driver so it will affect the other diver
		// if we change the driver 
		// ChromeDriver driver = new ChromeDriver();
		
		/*// Chrome lunching
		// webdriver.chrome.driver -> value of path
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		*/
		
		// Edge lunching
		System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\EdgeDriver\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		//driver.get("https://tcsglobal.udemy.com/");
		driver.get("https://chromedriver.chromium.org/downloads");
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		System.out.println(driver);
		
		//close current window 
		driver.close();
		//close all the associated window i.e. quit the driver
		driver.quit();
		}

}
