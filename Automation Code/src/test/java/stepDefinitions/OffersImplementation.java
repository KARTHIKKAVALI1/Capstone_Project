package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Offers;
import pages.login;

public class OffersImplementation {

	WebDriver driver;
	login loginpage;
	Offers offers;
	@Given("first open the bstack url")
	public void first_open_the_bstack_url() {
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://bstackdemo.com/");
        driver.manage().window().maximize();
        loginpage = new login(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
	}

	@When("give crediantial and login")
	public void give_crediantial_and_login() {
		loginpage.singin();
	    loginpage.username();
	    loginpage.password();
	    loginpage.loginButton();
	    offers = new Offers(driver);
	}

	@Then("goto offers page")
	public void goto_offers_page() {
	    offers.offers();
	}
	@Then("finally exit")
	public void finally_exit() {
		driver.close();
	}
}
