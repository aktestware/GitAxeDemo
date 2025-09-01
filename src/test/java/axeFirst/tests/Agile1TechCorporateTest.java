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
import org.testng.annotations.Test;

import com.deque.axe.AXE;

import axeFirst.pageObjects.AgileCorporate;
import axeFirst.testComponents.BaseTest;

public class Agile1TechCorporateTest extends BaseTest {
	
	WebDriver driver;
	
	private static final URL scriptURL = Agile1TechCorporateTest.class.getResource("/axe.min.js"); 
	
	@BeforeMethod
	public void setUp() throws IOException {
		driver = initializeBrowser();
	}
	
	//Testing if the about us link element of second web page corporate is accessible or not
		@Test
		public void testResultsOnAgile1TechElementLink() throws IOException {
			
			driver.get(getCorporateURL());
//			driver.get("https://www.agile1tech.com/");
//			JSONObject responseJson = new AXE.Builder(driver, scriptURL)
//					.analyze(driver.findElement(By.xpath("//a[contains(@href, 'about-us')]")));
			axeFirst.pageObjects.AgileCorporate ac = new AgileCorporate(driver);
			JSONObject responseJson = new AXE.Builder(driver, scriptURL)
					.analyze(ac.about_us());
	        JSONArray violations = responseJson.getJSONArray("violations");
			
			if (violations.length()==0) {
				System.out.println("There is no error on link about us of corporate web page.");
			}
			else {
				AXE.writeResults("LinkAboutUs", responseJson);
				Reporter.log("#AXE.report(violations)", true);
				Assert.assertTrue(false, AXE.report(violations));
				//Assert.assertTrue(true);
			}
		}
		
		@AfterMethod()
		public void tearDown() {
			driver.close();

		}
  }
