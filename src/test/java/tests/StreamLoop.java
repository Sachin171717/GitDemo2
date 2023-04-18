package tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StreamLoop {
     //public WebDriver driver;
     
     public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		
	driver.get("https://www.demoblaze.com/");
	driver.findElement(By.xpath("//a[@id='login2']")).click();
	driver.findElement(By.xpath("//input[@id='loginusername']")).sendKeys("SachinSri");
	driver.findElement(By.xpath("//input[@id='loginpassword']")).sendKeys("Sachin@123");
	driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
		
		String productname = "Iphone 6 32gb";
		List<WebElement> products = driver.findElements(By.cssSelector("h4.card-title"));
			WebElement prod = products.stream()
					.filter(product -> product.findElement(By.cssSelector("h4.card-title")).getText().equals(productname)).findFirst()
					.orElse(null);
		
			System.out.println(productname);
			System.out.println(prod);
		
			/*
			 * WebElement element = driver.findElement(By.cssSelector("a.hrefch"));
			 * JavascriptExecutor js = (JavascriptExecutor) driver;
			 * js.executeScript("arguments[0].click()", element);
			 * prod.findElement(By.cssSelector("a.hrefch")).click();
			 */
			
			
		
	}}

