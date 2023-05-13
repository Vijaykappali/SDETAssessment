package SDET_Assessment.SDET_Assessment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Assessment {
	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "firefoxdriverpath");


		WebDriver driver = new FirefoxDriver();


		driver.get("https://www.makemytrip.com/");


		WebElement logo = driver.findElement(By.xpath("//img[@alt='Make My Trip']"));
		if (logo.isDisplayed()) {
			System.out.println("MakeMyTrip logo is present on the page.");
		} else {
			System.out.println("MakeMyTrip logo is not present on the page.");
		}

		driver.quit();
	}
}
