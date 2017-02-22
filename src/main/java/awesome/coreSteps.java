package awesome;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import io.github.bonigarcia.wdm.PhantomJsDriverManager;

public class coreSteps {

WebDriver driver;

@Given("^I open the website \"([^\"]*)\"$")

public void i_open_the_website(String webSiteToNavigateTo) throws Throwable {

// Write code here that turns the phrase above into concrete actions

// Optional, if not specified, WebDriver will search your path for chromedriver.

//System.setProperty("webdriver.chrome.driver", "C:/Users/kellyr/.m2/repository/org/seleniumhq/selenium/selenium-chrome-driver/2.47.1");

//ChromeDriverManager.getInstance().setup();


ChromeDriverManager.getInstance().setup();
//InternetExplorerDriverManager.getInstance().setup();
//OperaDriverManager.getInstance().setup();
//EdgeDriverManager.getInstance().setup();
//PhantomJsDriverManager.getInstance().setup();
//FirefoxDriverManager.getInstance().setup();

//driver = new EdgeDriver();
//driver = new InternetExplorerDriver();
//driver = new FirefoxDriver();
driver = new ChromeDriver();

driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

driver.get("http://" + webSiteToNavigateTo);

}

@Given("^I enter \"([^\"]*)\" into the search box$")

public void i_enter_into_the_search_box(String textToSearchFor) throws Throwable {

// Write code here that turns the phrase above into concrete actions

WebElement searchBox = driver.findElement(By.xpath("//*[@id='lst-ib']"));

searchBox.sendKeys(textToSearchFor);

}

@Given("^I click Search$")
public void i_click_search() throws Throwable {

// Write code here that turns the phrase above into concrete actions
	//*[@id="_fZl"]/span/svg/path
WebElement searchButton = driver.findElement(By.xpath("//*[@id='_fZl']/span/svg/path"));

searchButton.click();

}

@Given("^I select the top search$")

public void i_select_the_top_search() throws Throwable {

// Write code here that turns the phrase above into concrete actions

List<WebElement> findElements = driver.findElements(By.xpath("//*[@id='rso']//h3/a"));

findElements.get(0).click();

}


@Then("^I should be on \"([^\"]*)\"$")

public void i_should_be_on(String expectedWebSite) throws Throwable {

// Write code here that turns the phrase above into concrete actions

Thread.sleep(1000); //this is really bad - we should not put systsem to sleep , instead check if page is laoded

String actualWebsite = driver.getCurrentUrl();

System.out.println(actualWebsite);

assertTrue("Not on correct webpage Expected webpage:" + expectedWebSite + " Actual webpage: " + actualWebsite, actualWebsite.toLowerCase().contains(expectedWebSite.toLowerCase()));


}
}


