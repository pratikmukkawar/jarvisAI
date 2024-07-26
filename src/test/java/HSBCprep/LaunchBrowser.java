package HSBCprep;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {
	@Test
	public void init() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");
		Thread.sleep(3000);
		WebElement dropele = driver.findElement(By.xpath("//select[@id='first']"));
		
		Select dropdown = new Select(dropele);
		
		//dropdown.selectByVisibleText("Google");
		
		List<WebElement> alloption=dropdown.getOptions();
		for(WebElement opption:alloption) {
			if(opption.getText().equals("Yahoo")) {
				opption.click();
				break;
			}
		}
				
	}

}
