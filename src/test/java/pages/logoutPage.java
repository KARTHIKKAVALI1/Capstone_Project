package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class logoutPage {
	
	WebDriver driver;
	
	By signout = By.id("signin");
	
	
	public logoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void logout() {
		driver.findElement(signout).click();
	}
}
