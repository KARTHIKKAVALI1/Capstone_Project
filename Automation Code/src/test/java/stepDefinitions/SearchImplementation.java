package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Search;
import pages.login;

public class SearchImplementation {

	WebDriver driver;
	login loginpage;
	Search search;
	@Given("first open stackdemo site")
	public void first_open_stackdemo_site() {
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://bstackdemo.com/");
        driver.manage().window().maximize();
        loginpage = new login(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
	}

	@Then("login into site")
	public void login_into_site() {
		loginpage.singin();
	    loginpage.username();
	    loginpage.password();
	    loginpage.loginButton();
	}

	@Then("goto search and search items")
	public void goto_search_and_search_items() throws InterruptedException {
	    search = new Search(driver);
	    search.search("iphones under 30");
	    search.searchButton();
	    Thread.sleep(4000);
	}

	@Then("exit")
	public void exit() {
	    driver.close();
	}
}
