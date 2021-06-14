package testCases;

import org.testng.annotations.Test;

import base.BaseTest;

public class SearchResPageTest extends BaseTest{
	
	
	
	@Test
	
	public void writereviewClickTest()
	{
		sr=hp.doSearch();
		
		sr.clickOnwriteReview();
	}

}
