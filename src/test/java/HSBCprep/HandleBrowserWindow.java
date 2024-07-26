package HSBCprep;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandleBrowserWindow {
	
	static WebDriver driver;
	@Test
	public static void test1() {
		
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\prati\\OneDrive\\Desktop\\ChromeDriver\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		driver.get("https://www.wikipedia.org/");
		//get window & get windowHandles
		/*String windowhandle =driver.getWindowHandle();
		System.out.println(windowhandle);//1BB24C9C1F4891D4FAD5D50F7407D17D */
		
		
		
		Set<String>windowhandles=driver.getWindowHandles();
		//first m
		
		/*Iterator<String> id =windowhandles.iterator();
		
		String parentid = id.next();
		
		String childid=id.next();
		
		System.out.println("parent id is =>"+parentid);
		System.out.println("child id is =>"+childid);
		//parent id is =>8C6F3E42C24E5C108F4F8870794EEEFB
        //child id is =>DA1D7B3EC40A32CE9403F5A078AAFF1F
		*/
		
		List<String> ids=new ArrayList<>(windowhandles);
		String parent =ids.get(0);
		String child = ids.get(1);
		System.out.println("parent id is =>"+parent);
		System.out.println("child id is =>"+child);
		//parent id is =>9DC83D91D8CEF8400FBC5F0ADCC1C523
		//child id is =>62CF8A36C1C8AC8B5C5662DD54684794
		
		//Switch windows
		driver.switchTo().window(parent);
		System.out.println(driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));
	}
}
