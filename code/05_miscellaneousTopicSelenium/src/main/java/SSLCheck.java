import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SSLCheck {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String URL = "https://expired.badssl.com/";
		
		//SSL Expire certificate
		ChromeOptions chromeOptions = new ChromeOptions();
		FirefoxOptions fireFoxOption = new FirefoxOptions();
		EdgeOptions edgeOptions = new EdgeOptions();
		System.out.println(fireFoxOption);
		System.out.println(edgeOptions);
		
		chromeOptions.setAcceptInsecureCerts(true);
		
		//Proxy additions
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("ipadress:8080");
		chromeOptions.setCapability("proxy", proxy);
		
		//default downloading location
		Map<String, Object> preference = new HashMap<String, Object>();
		preference.put("download.default_directory", "C:\\Users\\nites\\Desktop\\SELENIUM");
		chromeOptions.setExperimentalOption("pref", preference);
		
		//disable popups
		chromeOptions.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));
		
		WebDriver driver = new ChromeDriver(chromeOptions);
		
		driver.get(URL);
		
		Thread.sleep(3000);
		driver.close();
	}

}
