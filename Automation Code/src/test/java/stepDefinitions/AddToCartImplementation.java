package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.AddToCart;
import pages.login;

public class AddToCartImplementation {
    WebDriver driver;
    login loginpage;
    AddToCart addcart;

    @Given("open the bstack site")
    public void open_the_bstack_site() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://bstackdemo.com/");
        driver.manage().window().maximize();
        loginpage = new login(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Then("login to account")
    public void login_to_account() {
        loginpage.singin();
        loginpage.username();
        loginpage.password();
        loginpage.loginButton();
        addcart = new AddToCart(driver);
    }

    @Then("add to cart")
    public void add_to_cart() throws InterruptedException {
        addcart.addProduct1();
        addcart.addProduct2();
        Thread.sleep(3000);
    }

    @Then("logout from that")
    public void logout_from_that() {
        driver.close();
    }
}
