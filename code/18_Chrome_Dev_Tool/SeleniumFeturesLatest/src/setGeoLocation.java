import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v116.emulation.Emulation;

public class setGeoLocation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files\\Google\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		
		// Set up ChromeOptions to include geolocation data and set the language to Spanish  
		ChromeOptions options = new ChromeOptions();       
		options.addArguments("--enable-features=Geolocation");       
		options.addArguments("--lang=es");
		
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		Map<String, Object> geoLocation = new HashMap<String, Object>();
		//40 3
		geoLocation.put("latitude", 40);
		geoLocation.put("longitude", 3);
		geoLocation.put("accuracy", 1);
		
//		driver.executeCdpCommand("Emulation.setGeolocationOverride", geoLocation);
		devTools.send(Emulation.setGeolocationOverride(Optional.of(40),Optional.of(3),Optional.of(1))); 
		
		driver.get("https://google.com");
		
		driver.findElement(By.name("q")).sendKeys("netflix", Keys.ENTER);
		Thread.sleep(1000);
		driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
//		driver.findElement(By.cssSelector("select[name='LanguageSelect']")).click();
//		driver.findElement(By.cssSelector("option[label='日本語']")).click();
		Thread.sleep(3000);
		
		String heroTextTitle = driver.findElement(By.tagName("h1")).getText();
		
		System.out.println(driver.getTitle());
		System.out.println(heroTextTitle);

		Thread.sleep(3000);
		driver.close();
	}

}
