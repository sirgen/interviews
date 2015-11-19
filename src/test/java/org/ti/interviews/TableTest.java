package org.ti.interviews;

import org.junit.BeforeClass;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@RunWith(Theories.class)
public class TableTest {

	@DataPoints
	public static String[] tableIds = { "table1", "table2" };
	private static WebDriver driver;

	@Theory
	public void HerokuTableTest(String tableId) {

		// step 1
		driver
			.get("http://the-internet.herokuapp.com/");
		
		// step 2
		driver
			.findElement(By.linkText("Sortable Data Tables"))
			.click();
		
		// step 3
		driver
			.findElement(By.id(tableId))
			.findElement(By.xpath(".//span[text()=\"Last Name\"]"))
			.click();	
	}
	
	@BeforeClass
	public static void init() {
		
		driver = WebDriverUtils.getWebDriver();
	}

}
