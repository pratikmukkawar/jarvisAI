package PageClass;

import static BaseClass.baseclass.driver;

import org.testng.annotations.Test;

import BaseClass.baseclass;

public class navigationcheck extends baseclass {
	@Test
	public static void googleops() {
		
		chromelaunch();
		driver.get("https://www.facebook.com/");
		
		
}

}
