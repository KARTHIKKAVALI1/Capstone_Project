package stepDefinitions;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.AddToCart;
import pages.CheckoutPage;
import pages.login;
import utils.ExcelData;

public class CheckoutPageImplementation {

    WebDriver driver;
    login loginpage;
    AddToCart addcart;
    CheckoutPage checkpage;

    @Given("first open the bstack site")
    public void first_open_the_bstack_site() throws IOException {
        // Load Excel
        ExcelData.loadExcel("src/test/resources/ExcelData/TestData.xlsx", "CheckoutData");
        System.out.println("Excel data loaded successfully");
    }

    @Then("add items into cart")
    public void add_items_into_cart() {
        System.out.println("Add items step initialized");
    }

    @Then("goto checkout page")
    public void goto_checkout_page() throws InterruptedException, IOException {

        // Loop through each row in Excel
        for (int i = 1; i < ExcelData.getRowCount(); i++) {

            System.out.println("\n=== Starting Session " + i + " ===");

            // 1. Start a fresh browser for each row
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://bstackdemo.com/");
            driver.manage().window().maximize();
            System.out.println("Browser launched for Session " + i);

            // 2. Login
            loginpage = new login(driver);
            loginpage.singin();
            loginpage.username();
            loginpage.password();
            loginpage.loginButton();
            System.out.println("Logged in successfully (Session " + i + ")");

            // 3. Add products
            addcart = new AddToCart(driver);
            addcart.addProduct1();
            addcart.addProduct2();
            System.out.println("Products added to cart (Session " + i + ")");

            // 4. Checkout with row data
            checkpage = new CheckoutPage(driver);

            String fName = ExcelData.getCellData(i, 0);
            String lName = ExcelData.getCellData(i, 1);
            String addr = ExcelData.getCellData(i, 2);
            String state = ExcelData.getCellData(i, 3);
            String code = ExcelData.getCellData(i, 4);

            System.out.println("Using Data => FirstName: " + fName + ", LastName: " + lName);

            checkpage.checkoutButton();
            checkpage.firstName(fName);
            checkpage.lastName(lName);
            checkpage.Address(addr);
            checkpage.State(state);
            checkpage.postalCode(code);
            checkpage.submit();

            Thread.sleep(3000);
            checkpage.continueShopping();

            // Close browser
            driver.quit();
            System.out.println("Completed Session " + i + "\n");
        }
    }

    @Then("close the browser")
    public void close_the_browser() {
        if (driver != null) {
            try {
                driver.quit();
                System.out.println("Browser closed successfully");
            } catch (Exception e) {
                System.out.println("Browser already closed");
            }
        }
    }
}
