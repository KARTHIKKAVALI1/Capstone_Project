package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Favourites {
	
	WebDriver driver;
	By addItemIntoFavourites = By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > main:nth-child(2) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1) > span:nth-child(1) > svg:nth-child(1)");
	By favourtiesButton = By.id("favourites");
	
	public Favourites(WebDriver driver) {
		this.driver = driver;
	}
	
	public void addItemIntoFav() {
		driver.findElement(addItemIntoFavourites).click();
	}
	
	public void favouritesPage() {
		driver.findElement(favourtiesButton).click();
	}
	
}
