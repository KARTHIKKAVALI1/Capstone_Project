package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class login {
	WebDriver driver;
	
	// locators
	By signin  = By.id("signin");
	By username = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("login-btn");
	
	
	//constructor
	public login(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void singin() {
		driver.findElement(signin).click();
	}
	public void username() {
		driver.findElement(By.id("username")).click();
		driver.findElement(By.xpath("//div[text()='demouser']")).click();
	}
	public void password() {
		driver.findElement(password).click();
		driver.findElement(By.xpath("//div[text()='testingisfun99']")).click();
	}
	public void loginButton() {
		driver.findElement(loginButton).click();
	}
}
