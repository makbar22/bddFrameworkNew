package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinition {
	WebDriver driver;

	@Given("^the user is on Test Environment Page$")
	public void the_user_is_on_Test_Environment_Page() throws Throwable {
		System.setProperty("webdriver..chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://tek-school.com/retail/");
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);

	}

	@When("^user click on MyAccount$")
	public void user_click_on_MyAccount() throws Throwable {
		WebElement myAccount = driver.findElement(By.xpath("//span[text()='My Account']"));
		myAccount.click();

	}

	@When("^user click on Login$")
	public void user_click_on_Login() throws Throwable {
		WebElement login = driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
		login.click();

	}

	@When("^user enters username 'sdet@tekschool\\.us' and password 'sdet'$")
	public void user_enters_username_sdet_tekschool_us_and_password_sdet() throws Throwable {
		WebElement userName = driver.findElement(By.id("input-email"));
		userName.sendKeys("sdet@tekschool.us");
		WebElement password = driver.findElement(By.id("input-password"));
		password.sendKeys("sdet");

	}

	@When("^user click on Login button$")
	public void user_click_on_Login_button() throws Throwable {
		WebElement loginButton = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
		loginButton.click();

	}

	@Then("^user should be on user dashboard$")
	public void user_should_be_on_user_dashboard() throws Throwable {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("My Account", title);
		driver.quit();
	}

}
