package HSBCprep;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Brokenlinksandlink {
@Test
	public void linkactions()  throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.techbeamers.com/selenium-webdriver-exercise-find-broken-links/");
		int brokenlinks=0;
		List<WebElement>link=driver.findElements(By.tagName("a"));
		
		for(int i=0;i<link.size();i++) {
			String urls=link.get(i).getAttribute("href");
			System.out.println(urls);
		
			System.out.println(link.size());
			
			/*if(urls==null||urls.isEmpty()) {
				System.out.println("url is empty");
				continue;
			}
			URL links=new URL(urls);
			HttpURLConnection httpconn=(HttpURLConnection) links.openConnection();
			httpconn.connect();
			if(httpconn.getResponseCode()>400) {
				System.out.println(httpconn.getResponseCode()+urls+"Broken link");
				brokenlinks++;
			}
			else {
				System.out.println(httpconn.getResponseCode()+urls+"Normal link");
			}*/
		}}
}
