package testCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.BaseClass;
import base.BaseTest;
import utils.Constants;

public class ReviewPageTest extends BaseTest {
	
	
	
	@Test
	
	public void ratingReviewTest()
	{
		
		sr=hp.doSearch();
		
		rp=sr.clickOnwriteReview();
		
		WebElement rate=rp.getRating();
		
		Actions a=new Actions(driver);
		
		a.moveToElement(rate, 50, 40).click().build().perform();
		
		
		String ratingResText=rp.getRatingText();
		System.out.println(ratingResText);
		
//          BaseClass b=new BaseClass();
//		
//		try {
//			b.captureScreen(driver, "ratingReviewTest");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		Assert.assertEquals(ratingResText, "Excellent");
		
		
		
		WebElement reviewTitle=rp.getReviewtitle();
		
		reviewTitle.sendKeys(Constants.reviewtitle);
		
		WebElement reviewText=rp.getReviewText();
		reviewText.sendKeys(Constants.reviewText);
		
		rp.getSortOfTrip();
		
		WebElement dateOfTravel=rp.getDateOfTravel();
		
		Select sel=new Select(dateOfTravel);
		
		sel.selectByVisibleText(Constants.dateOfTravel);
		
		WebElement service=rp.getService();
		
		WebElement sleepQuality=rp.getSleepQuality();
		
		WebElement rooms=rp.getRooms();
		
		
		a.moveToElement(service, -20, 0).click().build().perform();
		
//		a.moveToElement(sleepQuality, 30, 0).click().build().perform();
//		a.moveToElement(rooms, -40, 0).click().build().perform();
		
		
		rp.getCertifycheck().click();
		
	     rp.submitReview();
		
		
	}

}
