package PRAPACK;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertEqualsDeep;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OneTest {
	WebDriver d;//while using it as global we can use anywhere
	
	@Test
	public void One() {
		
		WebDriverManager.firefoxdriver().setup();
	    d=new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.get("http://omayo.blogspot.com/");
		//String actualtext=d.findElement(By.id("pah")).getText();
		//System.out.println(actualtext);
		Assert.assertEquals(d.findElement(By.id("pah")).getText(), "PracticeAutomationHere");
		
		
	}

	@AfterMethod
	public void closure() {
		//test method pass or fail browser will close 
		
		d.close();
	}
}
