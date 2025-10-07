package axeFirst.tests;

import java.io.IOException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.deque.axe.AXE;

import axeFirst.dataProviderObjects.DataProviding;
import axeFirst.pageObjects.AgileCorporate;
import axeFirst.pageObjects.AgileCorporateCareer;
import axeFirst.testComponents.BaseTest;


public class Agile1TechEntireTest extends BaseTest {
	
	WebDriver driver;
	
	private static final URL scriptURL = Agile1TechEntireTest.class.getResource("/axe.min.js"); 
	
	@BeforeMethod
	public void setUp() throws IOException {
		driver = initializeBrowser();
	}
	// Testing
	//Testing if entire web pages is accessible or not
	@Test (dataProvider="getData")
	//It is testing for GitHubHook
	public void testResultsOnAgile1Tech(String url, String testName) {
		driver.get(url);
		JSONObject responseJson = new AXE.Builder(driver, scriptURL).analyze(); 
		JSONArray violations = responseJson.getJSONArray("violations");
		
		if (violations.length()==0) {
			System.out.println("There is no error in webpage.");
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
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData() {
		DataProviding dp = new DataProviding();
		return dp.dataObject(); 
	}

}
