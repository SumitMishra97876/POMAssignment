package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.ElementUtilities;

public class ReviewPage {
	
	public WebDriver driver;
	
	ElementUtilities util;
	
	
	public ReviewPage(WebDriver driver)
	{
		this.driver=driver;
		util=new ElementUtilities(this.driver);
	}
	
	By rateElement=By.id("bubble_rating");
	
	By rateText=By.xpath("//em[@id='overallRatingFlagText']");
	
	By reviewTitle=By.id("ReviewTitle");
	
	By reviewtext=By.id("ReviewText");
	By tripSort=By.xpath("//div[@id='trip_type_table']//div[3]");
	By dateOftravel=By.id("trip_date_month_year");
	
	By service=By.id("qid12_bubbles");
	
	By sleep_quality=By.id("qid190_bubbles");
	
	By rooms=By.id("qid11_bubbles");
	
	By certifyCheck=By.id("noFraud");
	
	By submitReview=By.xpath("//div[@id='SUBMIT']/span");
	
	
	
	
	
	
	
	public WebElement getRating()
	{
		return util.visibilityOfElement(rateElement, 20);
		//return driver.findElement(rateElement);
	}
	
	public String getRatingText()
	{
		String text=driver.findElement(rateText).getText();
		
		return text;
	}
	
	public WebElement getReviewtitle()
	{
		return driver.findElement(reviewTitle);
		
		
	}
	
	public WebElement getReviewText()
	{
		return driver.findElement(reviewtext);
	}
	
	public void getSortOfTrip()
	{
		driver.findElement(tripSort).click();
	}
	
	public WebElement getDateOfTravel()
	{
		return driver.findElement(dateOftravel);
	}
	
	public WebElement getService()
	{
		return driver.findElement(service);
	}
	public WebElement getSleepQuality()
	{
		return driver.findElement(sleep_quality);
	}
	public WebElement getRooms()
	{
		return driver.findElement(rooms);
	}
	
	public WebElement getCertifycheck()
	{
		//return driver.findElement(certifyCheck);
		
		return util.waitForElementPresent(certifyCheck, 20);
	}
	
	public void submitReview()
	{
		driver.findElement(submitReview).click();
	}
	
	

}
