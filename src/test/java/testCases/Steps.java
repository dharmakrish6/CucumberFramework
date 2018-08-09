package testCases;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
	WebDriver driver;

	@Given("^Open browser and naviagte to site and click on signin button$")
	public void open_browser() throws Throwable {
		System.out.println("Browser launch");
		System.setProperty("webdriver.chrome.driver", "/Users/dharma/Documents/Softwares/chromedriver");
		driver=new ChromeDriver();
		driver.get("https://phptravels.org/clientarea.php");
		
	}

	@When("^Enter \"(.*)\" and \"(.*)\"$")
	public void enter_cridentials(String email,String password) throws Throwable {
		driver.findElement(By.id("inputEmail")).sendKeys(email);
		driver.findElement(By.id("inputPassword")).sendKeys(password);
		driver.findElement(By.id("login")).click();
	}

	@Then("^Validate the Username in the homepage$")
	public void validation() throws Throwable {
		System.out.println("validation step");
		String name=driver.findElement(By.cssSelector(".header-lined>h1")).getText().toString();
		Assert.assertTrue("fail:login failed", name.contains("Dharmalingam"));
	}
}