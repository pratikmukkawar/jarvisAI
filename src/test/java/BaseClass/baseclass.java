package BaseClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

public class baseclass {
	
	public static WebDriver driver;
	public static String baseURI;
	@Test
	public static void chromelaunch() {
		 
		System.setProperty("webdriver.chrom.driver", "C:\\Users\\prati\\OneDrive\\Desktop\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
	}

}
