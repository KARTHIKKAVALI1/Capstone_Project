package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Orders;
import pages.login;

public class OrdersImplementation {

	WebDriver driver;
	login loginpage;
	Orders order;
	
	@Given("open bstack webstie")
	public void open_bstack_webstie() {
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://bstackdemo.com/");
        driver.manage().window().maximize();
        loginpage = new login(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  
	}

	@Then("login")
	public void login() {
		loginpage.singin();
	    loginpage.username();
	    loginpage.password();
	    loginpage.loginButton();
	    order = new Orders(driver);
	}

	@Then("goto orders page")
	public void goto_orders_page() throws InterruptedException {
		Thread.sleep(5000);
	   order.ordersButton();
	   Thread.sleep(3000);
	}

	@Then("simply exit")
	public void simply_exit() {
	   driver.close();
	}
}
