package axeFirst.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AgileCorporateCareer {
	
WebDriver driver;
	
	public AgileCorporateCareer(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement careerButton() {
		WebElement career = driver.findElement(By.xpath("//a[contains(@href, 'career')]"));
		return career;
	}


}
