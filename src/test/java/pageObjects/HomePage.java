package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.ElementUtilities;

public class HomePage {
	public ElementUtilities util;
	
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		util=new ElementUtilities(this.driver);
	}
	
	By search=By.xpath("//input[@placeholder='Where to?']");
	
	By searchRes=By.xpath("(//div[@id='typeahead_results']//a/div[1]/img)[1]");
	
	public SearchResPage doSearch()
	{
	 //driver.findElement(search).sendKeys("Club Mahindra");
		util.waitForElementPresent(search, 20).sendKeys("Club Mahindra");
	 
	 //driver.findElement(searchRes).click();
	 util.waitForElementPresent(searchRes, 20).click();
	 return new SearchResPage(driver);
	}
	
	

}
