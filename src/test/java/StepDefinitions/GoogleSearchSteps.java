package StepDefinitions;

import io.cucumber.java.en.*;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchSteps {

  WebDriver driver = null;

  @Given("browser is open")
  public void browser_is_open() {
    System.out.println("browser_is_open");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    driver.manage().window().maximize();
  }

  @And("user is on google search page")
  public void user_is_on_google_search_page() {
    System.out.println("user_is_on_google_search_page");
    driver.navigate().to("https://google.com");
  }

  @When("user enters a text in search box")
  public void user_enters_a_text_in_search_box() throws InterruptedException {
    System.out.println("user_enters_a_text_in_search_box");
    driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
    Thread.sleep(2000);
  }

  @And("hits enter")
  public void hits_enter() throws InterruptedException {
    System.out.println("hits_enter");
    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    Thread.sleep(2000);
  }

  @Then("user is navigated to search results")
  public void user_is_navigated_to_search_results() {
    System.out.println("user_is_navigated_to_search_results");
    driver.getPageSource().contains("Online Courses");
    driver.close();
    driver.quit();
  }
}
