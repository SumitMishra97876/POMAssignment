package base;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import pageObjects.HomePage;
import pageObjects.ReviewPage;
import pageObjects.SearchResPage;

public class BaseTest {
	
	
	
	public  WebDriver driver;
	public Properties prop;
	BaseClass bs;
	
	public SearchResPage sr;
	
	public HomePage hp;
	
	public ReviewPage rp;
	@BeforeTest
	//@Parameters({"browser"})
	public void setup()
	{
		bs=new BaseClass();
		prop=bs.initProperties();
		
		String browsername=prop.getProperty("browser");
		
		driver=bs.init_driver(browsername);
		
		
		
		
		driver.get(prop.getProperty("url"));
		
		hp=new HomePage(driver);
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
