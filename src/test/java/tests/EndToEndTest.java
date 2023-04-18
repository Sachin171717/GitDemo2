package tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AddToCart;
import pageObjects.ProductPage;
import testComponents.BaseTest;

public class EndToEndTest extends BaseTest{

	//String Productname = "Nokia Lumia 510";
	
	@Test(dataProvider ="getData")
	public void submitOrder( HashMap<String,String>input)throws IOException, InterruptedException
	{
		ProductPage productPage = landingpage.loginApplication(input.get("userName"), input.get("password"));
		
		List<WebElement> products = productPage.getProductList();
		//Thread.sleep(10);
		
		 // WebElement element = driver.findElement(By.xpath("//a[@class='hrefch']"));
		  //JavascriptExecutor js = (JavascriptExecutor) driver;
		 // js.executeScript("arguments[0].click()", element);
		 // js.executeScript("window.scrollTo(0,750)");
		//productPage.getScrolledDown();
//		Actions act = new Actions(driver);
//        act.sendKeys(Keys.PAGE_DOWN).build().perform();
		productPage.addProductToCart(input.get("productname"));
		AddToCart addtocart = new AddToCart(driver);
		addtocart.addToCart();
	}
	
	
	@DataProvider 
	public Object[][] getData() throws IOException
	{
	   List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\dataUtility\\Order.json");	
	   return new Object[][] {{data.get(0)}};
	}
}
