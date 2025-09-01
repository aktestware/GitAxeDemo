package axeFirst.testComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    
	WebDriver driver;
	Properties prop = new Properties();
	
	public WebDriver initializeBrowser() throws IOException {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\axeFirst\\resources\\GlobalData.properties");
		prop.load(fis);
		
		//Here we try to read the browser choice from Maven command
		//If there is no browser choice given in Maven command, 
		//then the browser will be read from GlobalData.propeerties file. 
		String browserName = System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");  
		//String browserName=prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		
		else if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
        else if(browserName.equalsIgnoreCase("edge")) {
        	driver = new EdgeDriver();
        	driver.manage().window().maximize();
		}
		return driver;
	}
	
	public String getCareerURL() throws IOException {
        
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\axeFirst\\resources\\GlobalData.properties");
		prop.load(fis);
		String urlPortal = prop.getProperty("urlCareer");
		return urlPortal; 
	}
	
    public String getCorporateURL() throws IOException {
        
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\axeFirst\\resources\\GlobalData.properties");
		prop.load(fis);
		String urlCorporate = prop.getProperty("urlCorporate");
		return urlCorporate; 
	}
}
