package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Orders {
	
	WebDriver driver;
	
	By ordersButton = By.id("orders");
	
	public Orders(WebDriver driver){
		this.driver = driver;
	}
	
	public void ordersButton() {
		driver.findElement(ordersButton).click();
	}
}
