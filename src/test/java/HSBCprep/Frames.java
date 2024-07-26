package HSBCprep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {
	@Test
	public void checkframe() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demoqa.com/frames");
		
		driver.switchTo().frame("frame1");
		
		
	WebElement str=driver.findElement(By.xpath("(//*[@id='sampleHeading'])"));
		System.out.println(str.getText());
		
		
		
		
		
	}

}
