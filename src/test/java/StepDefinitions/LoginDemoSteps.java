package StepDefinitions;

import io.cucumber.java.en.*;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginDemoSteps {
  WebDriver driver = null;

  @Given("browser is open")
  public void browser_is_open() {
    System.out.println("browser_is_open");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
  }

  @And("user is on login page")
  public void user_is_on_login_page() {
    driver.navigate().to("https://example.testproject.io/web/");
  }
  @When("^user enters (.*) and (.*)$")
  public void user_enters_username_and_password(String username, String password) {
    driver.findElement(By.id("name")).sendKeys(username);
    driver.findElement(By.id("password")).sendKeys(password);
  }
  @And("user clicks on login")
  public void user_clicks_on_login() {
    driver.findElement(By.id("login")).click();
  }
  @Then("user is navigated to home page")
  public void user_is_navigated_to_home_page() throws InterruptedException {
    driver.findElement(By.id("logout")).isDisplayed();
    Thread.sleep(2000);
    driver.close();
    driver.quit();
  }

}
