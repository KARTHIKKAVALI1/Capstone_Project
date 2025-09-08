package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Offers {

	WebDriver driver;
	
	By offers = By.partialLinkText("Offers");
	
	public Offers(WebDriver driver) {
		this.driver = driver;
	}
	
	public void offers() {
		driver.findElement(offers).click();
	}
	
}
