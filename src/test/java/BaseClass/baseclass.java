package BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class baseclass {
	
	
	
	public static WebDriver driver;
	@BeforeClass
	public static void chromesetup() {
		 
		System.setProperty("webdriver.chrom.driver", "C:\\Users\\prati\\OneDrive\\Desktop\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
	}
	@AfterClass()
	public static void close() {
		
		//driver.quit();
	}

}
