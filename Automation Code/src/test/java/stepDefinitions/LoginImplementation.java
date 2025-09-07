package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.login;

public class LoginImplementation {
	
	WebDriver driver;
	login loginpage;
	
	@Given("Open BStackDemo website")
	public void open_b_stack_demo_website() {
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://bstackdemo.com/");
        driver.manage().window().maximize();
        loginpage = new login(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("Enter username and password")
	public void enter_username_and_password() throws InterruptedException {
	    loginpage.singin();
	    loginpage.username();
	    loginpage.password();
	    loginpage.loginButton();
	    Thread.sleep(3000);
	}

	@Then("Close the window")
	public void close_the_window() {
	   driver.close();
	}
}
