package tests;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleElementAddToCart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		String Value = "Iphone 6 32gb";
		String Value1 = "Sony vaio i7";
		WebDriver driver;
	    WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.demoblaze.com/");
		driver.findElement(By.xpath("//a[@id='login2']")).click();
		driver.findElement(By.xpath("//input[@id='loginusername']")).sendKeys("AbcdN");
		driver.findElement(By.xpath("//input[@id='loginpassword']")).sendKeys("abc@1234");
		driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("window.scrollTo(0,600)");
		List<WebElement> linkedlist = driver.findElements(By.linkText(Value));
		WebElement element = linkedlist.stream()
		.filter(product -> product.findElement(By.xpath("//a[contains(text(),"+"'"+Value +"'"+")]")).getText().equals(Value)).findFirst().orElse(null);
		System.out.println(element);
		element.click();
		driver.navigate().refresh();
		driver.findElement(By.xpath("//a[contains(text(),'Add to cart')]")).click();
		//driver.switchTo().alert().accept();
		driver.navigate().back();
		driver.navigate().back();
		//Thread.sleep(5);
		driver.navigate().refresh();
		List<WebElement> linkedlist1 = driver.findElements(By.linkText(Value1));
		WebElement element1 = linkedlist1.stream()
		.filter(product1 -> product1.findElement(By.xpath("//a[contains(text(),"+"'"+Value1+"'"+")]")).getText().equals(Value1)).findFirst().orElse(null);
		System.out.println(element1);
		element1.click();
		driver.navigate().refresh();
		driver.findElement(By.xpath("//a[normalize-space()='Sony vaio i7']")).click();
		 }
	}


