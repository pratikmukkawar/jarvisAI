 package HSBCprep;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class prepartion1 {
	

	@Test(enabled=false)
	public void links() {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver =new ChromeDriver();
		
		driver.get("https://demoqa.com/links");
		
		
		List<WebElement> element =driver.findElements(By.tagName("a"));
		
		for(int i=0;i<element.size();i++) {
			System.out.println(element.get(2).getAttribute("href"));
			break;
		
		}}
	@Test(enabled = false)
		public void checkbox() throws InterruptedException, AWTException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		
		driver.get("https://demoqa.com/alerts");
		
		driver.findElement(By.xpath("//button[@id='alertButton']")).click();
		
		Alert aleart = driver.switchTo().alert();
		
		String message = driver.switchTo().alert().getText();
		
		System.out.println(message);
		
		aleart.accept();
		
		}
	@Test
	public void selectopions() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		
		driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
		
		WebElement droppable = driver.findElement(By.tagName("select"));
		
		Select select = new Select(droppable);
		
		select.selectByValue("ATA");
		System.out.println(droppable.isDisplayed());
		
		select.selectByVisibleText("Barbados");
		
		System.out.println(droppable.getText());
		
	}
	
		
		
		
	}

