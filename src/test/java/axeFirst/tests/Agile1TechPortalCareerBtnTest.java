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

import axeFirst.pageObjects.AgileCorporateCareer;
import axeFirst.testComponents.BaseTest;

public class Agile1TechPortalCareerBtnTest extends BaseTest  {

	WebDriver driver;
	
	private static final URL scriptURL = Agile1TechPortalCareerBtnTest.class.getResource("/axe.min.js"); 
	
	@BeforeMethod
	public void setUp() throws IOException {
		driver = initializeBrowser();
	}
	
	//Testing if the login button of first web page portal login is accessible or not
	@Test
	public void testResultsOnAgile1TechElementButton() throws IOException {
		
		driver.get(getCareerURL());
//		driver.get("https://agileteach.com/portal/login");
//		JSONObject responseJson = new AXE.Builder(driver, scriptURL)
//				.analyze(driver.findElement(By.xpath("//button[@type='submit']")));
		AgileCorporateCareer acc = new AgileCorporateCareer(driver);
		JSONObject responseJson = new AXE.Builder(driver, scriptURL).analyze(acc.careerButton());
        JSONArray violations = responseJson.getJSONArray("violations");
		
		if (violations.length()==0) {
			System.out.println("There is no error on button of Portal login.");
		}
		else {
			AXE.writeResults("ButtonLogin", responseJson);
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
