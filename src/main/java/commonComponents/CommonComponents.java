package commonComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonComponents {

	WebDriver driver;

	// Constructor
	public CommonComponents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	// writing just a generic utility of wait
		public void waitForElementToAppear(By findBy) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		}
		
		public void waitForWebElementToAppear(WebElement findBy) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(findBy));
}
		public void waitForElementToDisappear(WebElement ele) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.invisibilityOf(ele));
		
}
		
		public void waitForPageToScroll(WebElement findBy)
		{
			  WebElement element =(findBy);
			  JavascriptExecutor js = (JavascriptExecutor) driver;
			  js.executeScript("arguments[0].click()", element);
			
		}
}	
