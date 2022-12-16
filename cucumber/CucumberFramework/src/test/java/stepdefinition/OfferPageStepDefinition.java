package stepdefinition;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OfferPageStepDefinition {
	public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	


@Given("User is on GreenCart Landing Page")
public void user_is_on_greencart_landing_page() {
 System.setProperty("webdriver.chrome.driver","C:\\Users\\mbarbosa\\Downloads\\chromedriver_win32\\chromedriver.exe");
 driver = new ChromeDriver();
	 driver.get ("https://rahulshettyacademy.com/seleniumPractise/#/");
}


@When("User searched with Shortname {string} and extracted actual name of product")
public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) {
	driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
	String landingPageProductName = driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
	System.out.println(landingPageProductName+"is extracted from home page");
}

@Then("User searched for {string} shortname in offers page")
public void user_searches_for_same_shortname_in_offers_page_to_check_if_product_exists(String shortName) throws InterruptedException {
	driver. findElement(By.linkText("Top Deals")).click();
	Set<String> s1= driver.getWindowHandles();
	Iterator<String> i1 = s1.iterator();
	String parentWindow = i1.next();
	String childWindow = i1.next();
	driver.switchTo().window(childWindow);
	driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
	Thread.sleep(2000);
	String offerPageProductName =  driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
	System.out.println(offerPageProductName+"is extracted from home page");

	
	
}
@Then("validate product name in offers page matches with Landing Page")
public void user_validates_the_product_name_in_offers_page_matches_with_landing_page() {
Assert.assertEquals(offerPageProductName, landingPageProductName);
}
}
