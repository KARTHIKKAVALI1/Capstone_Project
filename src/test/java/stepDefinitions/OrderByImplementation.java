package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.OrderBy;
import pages.login;

public class OrderByImplementation {

	WebDriver driver;
	login loginpage;
	OrderBy orderby;
	
	@Given("first login")
	public void first_login() {
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://bstackdemo.com/");
        driver.manage().window().maximize();
        loginpage = new login(driver);
        orderby = new OrderBy(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
        loginpage.singin();
	    loginpage.username();
	    loginpage.password();
	    loginpage.loginButton();
	}

	@Then("then in home page sort orderby using orderBy filters")
	public void then_in_home_page_sort_orderby_using_order_by_filters() throws InterruptedException {
	    Thread.sleep(3000);
		orderby.lowestToHighest();
	    Thread.sleep(3000);
	    orderby.highestToLowest();
	}

	@Then("exit window")
	public void exit_window() {
	    driver.close();
	}
}
