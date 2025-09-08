package stepDefinitions;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Favourites;
import pages.login;

public class FavouritesPageImplementation {

	WebDriver driver;
	login loginpage;
	Favourites fav;
	@Given("open the browserstack site")
	public void open_the_browserstack_site() {
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://bstackdemo.com/");
        driver.manage().window().maximize();
        loginpage = new login(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  
	}

	@Then("login with the crediantials")
	public void login_with_the_crediantials() {
		loginpage.singin();
	    loginpage.username();
	    loginpage.password();
	    loginpage.loginButton();
	    fav = new Favourites(driver);
	}

	@Then("goto favourites page")
	public void goto_favourites_page() throws InterruptedException {
		fav.addItemIntoFav();
		Thread.sleep(4000);
	    fav.favouritesPage();
	    Thread.sleep(3000);
	}

	@Then("exit from the browser")
	public void exit_from_the_browser() {
	    driver.close();
	}
}
