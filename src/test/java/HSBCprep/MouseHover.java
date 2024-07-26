package HSBCprep;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover {
	@Test
	public void mouseaction() throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		WebElement element = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
		WebElement element1 = driver.findElement(By.xpath("(//*[text()='Your Account'])[1]"));
		
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		act.moveToElement(element).moveToElement(element1).click().perform();
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File F=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(".\\TakeSS\\demo.JPEG");
		
		FileUtils.copyFile(F, target);
		
		
		
		
	}

}
