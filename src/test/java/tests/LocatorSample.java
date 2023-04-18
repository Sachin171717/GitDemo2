package tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorSample {

	 public static void main(String[] args) throws InterruptedException 
	 {
		 String Value = "Iphone 6 32gb";
		 WebDriver driver;
		 WebDriverManager.chromedriver().setup();
		 ChromeOptions ops = new ChromeOptions();
		 ops.addArguments("--remote-allow-origins=*");
		 driver = new ChromeDriver(ops);
		 //System.setProperty("webdriver.chrome.driver", "E:\\chromedriver\\chromedriver.exe");
		 //WebDriver driver = new ChromeDriver();
		/*
		 * ChromeOptions option = new ChromeOptions();
		 * option.addArguments("--remote-allow-origins=*");
		 * WebDriverManager.chromedriver().setup(); driver = new ChromeDriver(option);
		 */
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		 driver.manage().window().maximize();
		 driver.get("https://www.demoblaze.com/");
		 driver.findElement(By.xpath("//a[@id='login2']")).click();
		 driver.findElement(By.xpath("//input[@id='loginusername']")).sendKeys("AbcdN");
		 driver.findElement(By.xpath("//input[@id='loginpassword']")).sendKeys("abc@1234");
		 driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
		 driver.navigate().refresh();
		 //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 //JavascriptExecutor js = (JavascriptExecutor)driver;
		 //js.executeScript("window.scrollTo(0,600)");
		 List<WebElement> linkedlist = driver.findElements(By.xpath("//a[@class='hrefch']"));
		 for (WebElement element : linkedlist) {
			 System.out.println(element.getText());
		 } 
		 WebElement element = linkedlist.stream()
				 .filter(product -> product.getText().contains(Value)).findFirst().orElseThrow();
		 System.out.println(element);
		 element.click();
		 driver.findElement(By.xpath("//a[contains(text(),'Add to cart')]")).click();
		 Thread.sleep(1000);
		 driver.switchTo().alert().accept();
		 driver.close();
		 }
	 }

