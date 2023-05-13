package SDET_Assessment.SDET_Assessment;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlightBookingAssessment {
	static WebDriver driver;
	static WebDriverWait wait;
	
	
	@BeforeMethod
	public void setUp() {
		
		// Setting system property for ChromeDriver
				//System.setProperty("webdriver.chrome.driver", "path to chrome driver");
		WebDriverManager.chromedriver().setup();

		// Creating an instance of the Chrome driver
				driver = new ChromeDriver();

				driver.manage().window().maximize();

				wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Navigating to MakeMyTrip website
				driver.get("https://www.makemytrip.com/");
		
	}
	
	@Test
	public void VerifyLogo() {
		WebElement logo = driver.findElement(By.xpath("//img[@alt='Make My Trip']"));
		if (logo.isDisplayed()) {
			System.out.println("MakeMyTrip logo is present on the page.");
		} else {
			System.out.println("MakeMyTrip logo is not present on the page.");
		}
	}
	
	@Test
	
	public void verifyFlightBooking() {
		
		// Clicking on the Flights tab
				clickOnElement("//li[@data-cy='menu_Flights']", "Flights tab");

		// Clicking on the OneWay option
				clickOnElement("//li[@data-cy='oneWayTrip']", "OneWay option");

		// Entering the FROM location
				enterText("//input[@id='fromCity']", "Pune", "FROM location");

		// Selecting the first option from the FROM location dropdown
				clickOnElement("//*[@id='react-autowhatever-1-section-0-item-0']", "First option in FROM location dropdown");

		// Entering the TO location
				enterText("//input[@id='toCity']", "Delhi", "TO location");

		// Selecting the first option from the TO location dropdown
				clickOnElement("//*[@id='react-autowhatever-1-section-0-item-0']", "First option in TO location dropdown");
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


// Function to click on an element using its XPath attribute value
	public static void clickOnElement(String xpath, String elementName) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		element.click();
		System.out.println(elementName + " is clicked.");
	}

// Function to enter text into an element using its XPath attribute value
	public static void enterText(String xpath, String text, String elementName) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		element.sendKeys(text);
		System.out.println("Text '" + text + "' is entered in " + elementName + ".");
	}
}