package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.login;
import pages.logoutPage;

public class LogoutImplementation {

	WebDriver driver;
	login loginpage;
	logoutPage logout;
	
	@Given("first open bstack website")
	public void first_open_bstack_website() {
	    WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://bstackdemo.com/");
        driver.manage().window().maximize();
        loginpage = new login(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Then("login into account")
	public void login_into_account() {
		    loginpage.singin();
		    loginpage.username();
		    loginpage.password();
		    loginpage.loginButton();
		    logout = new logoutPage(driver);
	}

	@Then("logout")
	public void logout() throws InterruptedException {
	   Thread.sleep(3000);
	   logout.logout();
	   Thread.sleep(5000);
	}

	@Then("close that window")
	public void close_that_window() {
	   driver.close();
	}
	
}
