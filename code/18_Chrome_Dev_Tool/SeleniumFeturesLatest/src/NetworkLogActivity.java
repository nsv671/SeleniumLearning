import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v116.network.Network;
import org.openqa.selenium.devtools.v116.network.model.Response;
import org.openqa.selenium.devtools.v116.network.model.Request;

public class NetworkLogActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		//get send request log
		devTools.addListener(Network.requestWillBeSent(), request -> {
			Request req =request.getRequest();
			System.out.println("Request URL --->"+req.getUrl());
			System.out.println("Request Header --->"+req.getHeaders());
		});
		
		//get response log
		devTools.addListener(Network.responseReceived(), response ->{
			Response res = response.getResponse();
			if(res.getStatus().toString().startsWith("4")) {				
			System.out.println("Response URL --->"+res.getUrl());
			System.out.println("Response Header --->"+res.getHeaders());
			}
		});
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
		
		driver.close();
	}

}
