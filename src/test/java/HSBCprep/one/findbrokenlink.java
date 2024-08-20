package HSBCprep.one;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class findbrokenlink {
@Test
    public void brokenlinktets01(){

        WebDriverManager.chromedriver().setup();

         WebDriver driver=new ChromeDriver();

         driver.get("https://www.amazon.in/");

         int brokenlink =0;

        List<WebElement> link=driver.findElements(By.tagName("a"));

        for(int i=0;i<link.size();i++) {

            String links = link.get(i).getAttribute("href");

            //System.out.println(links);
            if (links == null) {
                int num = link.size();
                System.out.println(num);

            }


            driver.quit();

        }
    }
}
