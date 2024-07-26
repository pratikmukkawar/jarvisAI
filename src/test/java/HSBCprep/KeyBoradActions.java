package HSBCprep;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyBoradActions {
	@Test(enabled = false)
	public void keyborad() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/key_presses");
		
		Actions act= new Actions(driver);
		
		act.sendKeys(Keys.ENTER).perform();
		
		WebElement element = driver.findElement(By.xpath("//*[@id='result']"));
		
		System.out.println(element.getText());
		
	}
	@Test
	public void action2() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://text-compare.com/");
		driver.manage().window().maximize();
		
		
		WebElement input1= driver.findElement(By.xpath("//*[@name='text1']"));
		WebElement input2= driver.findElement(By.xpath("//*[@name='text2']"));
		
		input1.sendKeys("Hello Jarvis");
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		//ctrl+A
		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		//ctrl+c
		act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
		
		act.sendKeys(Keys.TAB).perform();
		
		Thread.sleep(1000);
		act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
		
		
	}

}
