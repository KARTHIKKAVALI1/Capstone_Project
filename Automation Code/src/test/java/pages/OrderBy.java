package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderBy {

	WebDriver driver;
	
	By orderBy = By.xpath("//*[@id=\"__next\"]/div/div/main/div[2]/div[1]/div[1]/select");
	By lowestToHighest= By.cssSelector("option[value='lowestprice']");
	By highestToLowest= By.cssSelector("option[value='highestprice']");
	
	public OrderBy(WebDriver driver) {
		this.driver = driver;
	}
	
	public void lowestToHighest() throws InterruptedException {
		driver.findElement(orderBy).click();
		driver.findElement(lowestToHighest).click();
		Thread.sleep(3000);
	}
	public void highestToLowest() throws InterruptedException {
		driver.findElement(orderBy).click();
		driver.findElement(highestToLowest).click();
		Thread.sleep(3000);
	}
	
}
