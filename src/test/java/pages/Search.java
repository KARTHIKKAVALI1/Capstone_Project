package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Search {

	WebDriver driver;
	
	By Search = By.cssSelector("input[placeholder=\"Search\"]");
	By searchButton = By.cssSelector("button[class=\"px-4 py-1 bg-gray-100 border border-l-0 border-gray-300\"]");
	
	public Search(WebDriver driver) {
		this.driver = driver;
	}
	
	public void search(String searchItem) {
		driver.findElement(Search).click();
		driver.findElement(Search).sendKeys(searchItem);
	}
	public void searchButton() {
		driver.findElement(searchButton).click();
	}
}
