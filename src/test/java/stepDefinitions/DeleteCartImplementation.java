package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.AddToCart;
import pages.DeleteCart;
import pages.login;

public class DeleteCartImplementation {

	WebDriver driver;
	login loginpage;
	AddToCart addcart;
	DeleteCart delcart;
	@Given("open the stackdemo site")
	public void open_the_stackdemo_site() {
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://bstackdemo.com/");
        driver.manage().window().maximize();
        loginpage = new login(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginpage.singin();
	    loginpage.username();
	    loginpage.password();
	    loginpage.loginButton();
	    addcart = new AddToCart(driver);
	}

	@Then("first add item from the cart")
	public void first_add_item_from_the_cart() throws InterruptedException {
		
		Thread.sleep(3000);
		addcart.addProduct1();
		addcart.addProduct2();
		   
		delcart = new DeleteCart(driver);
	}

	@Then("delete item from the cart")
	public void delete_item_from_the_cart() throws InterruptedException {
		Thread.sleep(3000);
	    delcart.deleteCartItems();
	    Thread.sleep(3000);
	}

	@Then("close the current window")
	public void close_the_current_window() {
	    driver.close();
	}
}
