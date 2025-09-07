package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCart {

	WebDriver driver;
	
	By item1 = By.xpath("//*[@id=\"1\"]/div[4]");
	By item2 = By.xpath("//*[@id=\"2\"]/div[4]");
	
	public AddToCart(WebDriver driver) {
		this.driver = driver;
	}
	public void addProduct1() {
		driver.findElement(item1).click();
	}
	public void addProduct2() {
		driver.findElement(item2).click();
	}
}
