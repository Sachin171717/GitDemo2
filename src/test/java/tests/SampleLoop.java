package tests;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String Value = "Sony vaio i7";
		 WebDriver driver;
		 WebDriverManager.chromedriver().setup();
		 ChromeOptions ops = new ChromeOptions();
		 ops.addArguments("--remote-allow-origins=*");
		 driver = new ChromeDriver(ops);
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		 driver.manage().window().maximize();
		 driver.get("https://www.demoblaze.com/");
		 driver.findElement(By.xpath("//a[@id='login2']")).click();
		 driver.findElement(By.xpath("//input[@id='loginusername']")).sendKeys("AbcdN");
		 driver.findElement(By.xpath("//input[@id='loginpassword']")).sendKeys("abc@1234");
		 driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
		 driver.navigate().refresh();
		 
		 List<WebElement> linkedlist = driver.findElements(By.xpath("//a[@class='hrefch']"));
		 
		 for (WebElement elem : linkedlist)
		 {
			 if (elem.getText().contains(Value))
			 {			 
				 System.out.println(elem);
				 elem.click();	 			 
				 //break;
			 }
			 else
			 {
				 System.out.println("value doesn't matched");
			 }
		 }
		 
		 driver.findElement(By.xpath("//a[contains(text(),'Add to cart')]")).click();
		 

		 try{

             WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
             wait.until(ExpectedConditions.alertIsPresent());

             Alert alert = driver.switchTo().alert();
             System.out.println("Alert box text" + alert.getText());
             alert.accept();

           } catch (NoAlertPresentException noAlert) {
             noAlert.getMessage();
           }
		 
		 //driver.switchTo().alert().accept();

	}

}
