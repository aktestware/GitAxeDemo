package axeFirst.tests;

import java.io.IOException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.deque.axe.AXE;

import axeFirst.dataProviderObjects.DataProviding;
import axeFirst.testComponents.BaseTest;

public class Agile1TechTitleTest extends BaseTest {
	
	WebDriver driver;
	
	private static final URL scriptURL = Agile1TechEntireTest.class.getResource("/axe.min.js"); 
	
	@BeforeMethod
	public void setUp() throws IOException {
		driver = initializeBrowser();
	}
	
	@Test (dataProvider="getData")
	public void testResultsOnAgile1TechTitle(String url, String testName) {
		driver.get(url);
		JSONObject responseJson = new AXE.Builder(driver, scriptURL).include("title").analyze(); 
		JSONArray violations = responseJson.getJSONArray("violations");
		
		if (violations.length()==0) {
			System.out.println("There is no error on title.");
		}
		else {
			AXE.writeResults(testName, responseJson);
			Reporter.log("#AXE.report(violations)", true);
			Assert.assertTrue(false, AXE.report(violations));
			//Assert.assertTrue(true);
		}
	}
	
	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getData() {
		DataProviding dp = new DataProviding();
		return dp.dataObject(); 
	}

}
