package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.*;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage_PF;
import pages.LoginPage_PF;

public class LoginDemoSteps_PF {
  WebDriver driver = null;
  LoginPage_PF login;
  HomePage_PF home;

  @Before
  public void setup() {
    System.out.println("setup");
  }

  @After
  public void teardown() {
    System.out.println("teardown");
  }

  @BeforeStep
  public void BeforeStep() {
    System.out.println("BeforeStep");
  }

  @AfterStep
  public void AfterStep() {
    System.out.println("AfterStep");
  }

  @Given("browser is open")
  public void browser_is_open() {
    System.out.println("I am inside Page factory");
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
    login = new LoginPage_PF(driver);
    login.enterUsername(username);
    login.enterPassword(password);

//    driver.findElement(By.id("name")).sendKeys(username);
//    driver.findElement(By.id("password")).sendKeys(password);
  }
  @And("user clicks on login")
  public void user_clicks_on_login() {
    login.clickOnLogin();
//    driver.findElement(By.id("login")).click();
  }
  @Then("user is navigated to home page")
  public void user_is_navigated_to_home_page() throws InterruptedException {
    home = new HomePage_PF(driver);
    home.checkLogoutIsDispayed();
//    driver.findElement(By.id("logout")).isDisplayed();
    Thread.sleep(2000);
    driver.close();
    driver.quit();
  }

}
