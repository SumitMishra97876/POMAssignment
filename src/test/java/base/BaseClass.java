package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	
	public WebDriver driver;
	
	public static Properties prop;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	public WebDriver init_driver(String browsername)
	{
		
		if(browsername.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		//driver=new ChromeDriver();
		tlDriver.set(new ChromeDriver());
		
		}
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			//driver=new FirefoxDriver();
			tlDriver.set(new FirefoxDriver());
		}
		else if(browsername.equalsIgnoreCase("ie"))
		{
			WebDriverManager.iedriver().setup();
			//driver=new EdgeDriver();
			tlDriver.set(new EdgeDriver());
			
		}
		else
		{
			
				System.out.println("Please pass the correct browser");
			
		}
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().deleteAllCookies();
//		driver.manage().window().maximize();
//		return driver;
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		
		return getDriver();
		
		
	}
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
}

	
	
	public Properties initProperties()
	{
		prop=new Properties();
		
		try {
			FileInputStream fis=new FileInputStream("./src/test/java/config/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return prop;
	}
	
//	public void captureScreen(WebDriver driver, String tname) throws IOException {
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File source = ts.getScreenshotAs(OutputType.FILE);
//		File target = new File(System.getProperty("user.dir") + "\\screenshots\\" + tname + ".png");
//		FileUtils.copyFile(source, target);
//	}
	
	
	public String getScreenshot()
	{
		File src=((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		
		String path=System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		
		File destination=new File(path);
		
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
	
	

}
