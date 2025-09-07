package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.AddToCart;
import pages.CheckoutPage;
import pages.login;

public class CheckoutPageImplementation {

	WebDriver driver;
	login loginpage;
	AddToCart addcart;
	CheckoutPage checkpage;
	
	@Given("first open the bstack site")
	public void first_open_the_bstack_site() {
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

	@Then("add items into cart")
	public void add_items_into_cart() throws InterruptedException {
		   addcart.addProduct1();
		   addcart.addProduct2();
		   Thread.sleep(3000);
		   checkpage = new CheckoutPage(driver);
	}

	@Then("goto checkout page")
	public void goto_checkout_page() throws InterruptedException {
	    checkpage.checkoutButton();
	    checkpage.firstName("karthik");
	    checkpage.lastName("kavali");
	    checkpage.Address("Visakhapatnam, Andhra Pradesh");
	    checkpage.State("AP");
	    checkpage.postalCode("530041");
	    checkpage.submit();
	    Thread.sleep(7000);
	    checkpage.continueShopping();
	    Thread.sleep(3000);
	}

	@Then("close the browser")
	public void close_the_browser() {
	    driver.close();
	}
}
