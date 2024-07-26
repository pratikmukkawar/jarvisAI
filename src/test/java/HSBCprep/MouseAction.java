package HSBCprep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseAction {
	
	@Test
	public void mouseact() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demo.guru99.com/test/drag_drop.html");
		
		//WebElement element = driver.findElement(By.xpath("//*[text()='right click me']"));
		//WebElement element = driver.findElement(By.xpath("//*[text()='Double-Click Me To See Alert']"));
		
		WebElement source = driver.findElement(By.xpath("(//li[@data-id=\"2\"])[1]"));	
		WebElement target = driver.findElement(By.xpath("(//*[@class='placeholder'])[2]"));
		Actions actions = new Actions(driver);
		
		//*[@class='placeholder'])[2]
		//1//actions.contextClick(element).perform();//it is right click
		//2//actions.doubleClick(element).perform();//double click
		
		actions.dragAndDrop(source, target).perform();
		
		
		
		
	}

}
