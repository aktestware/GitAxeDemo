package axeFirst.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AgileCorporate {
	
WebDriver driver;
	
	public AgileCorporate(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement about_us() {
		WebElement aboutUs = driver.findElement(By.xpath("//a[contains(@href, 'about-us')]"));
		return aboutUs;
	}


}
