package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import base.BaseTest;
import pageObjects.HomePage;

public class HomePageSearchTest extends BaseTest {
	
	
	
	
	
	@Test
	
	public void searchTest()
	{
		//setup();
		
		
		
		hp.doSearch();
		
		
		//hp.getSearchRes();
	}
	
	
	
	

}
