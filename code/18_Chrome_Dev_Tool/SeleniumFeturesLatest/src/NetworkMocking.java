import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v116.fetch.Fetch;
import org.openqa.selenium.devtools.v116.network.model.Request;

public class NetworkMocking {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));
		
		devTools.addListener(Fetch.requestPaused(), request -> {
			Request req = request.getRequest();
			if(req.getUrl().contains("=shetty")) {
				String mockedUrl = req.getUrl().replace("=shetty", "=BadGuy");
				System.out.println(mockedUrl);
				
				devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(mockedUrl), Optional.of(req.getMethod()), Optional.empty(), Optional.empty(), Optional.empty()));
			}else {
				devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(req.getUrl()), Optional.of(req.getMethod()), Optional.empty(), Optional.empty(), Optional.empty()));
			}
		});
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
		Thread.sleep(1000);
		
		System.out.println(driver.findElement(By.cssSelector("p")).getText());
		
		driver.close();
	}

}
