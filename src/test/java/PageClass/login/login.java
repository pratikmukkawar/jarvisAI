package PageClass.login;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageClass.navigationcheck;

public class login extends navigationcheck {
	
	@Test(priority = 2)
	public void userdetails() {
		driver.manage().window().maximize();
		driver.findElement(By.id("spree_user_email")).sendKeys("pratikm@spree.com");
		driver.findElement(By.id("spree_user_password")).sendKeys("Test#123");
		driver.findElement(By.xpath("//*[@name='commit']")).click();
		
		
		String details = driver.getTitle();
		System.out.println(details);
		
		String currenturl=driver.getCurrentUrl();
		
		if(driver.getCurrentUrl().equals(currenturl)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		
		
	}

}
