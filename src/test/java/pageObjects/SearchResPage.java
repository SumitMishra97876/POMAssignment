package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResPage {
	
	
	public WebDriver driver;
	
	public SearchResPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By writeReview=By.linkText("Write a review");
	
	
	public ReviewPage clickOnwriteReview()
	{
		driver.findElement(writeReview).click();
		return new ReviewPage(driver);
	}

}
