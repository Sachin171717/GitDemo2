package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonComponents.CommonComponents;

public class ProductPage extends CommonComponents{

	WebDriver driver;
	String productname;
	public ProductPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy (xpath="//div[@class='card-block']")
	List<WebElement> products;
	
	@FindBy (css="a.hrefch")
	 List<WebElement> common;
	
	By productsBy = By.linkText("Iphone 6 32gb");
	//By productByName = By.xpath("//a[@class='hrefch']");
	
	
	  public List<WebElement> getProductList()
	 {
	  waitForElementToAppear(productsBy); 
	  return products;  
	  }
	 
//	public List<WebElement> getScrolledDown()
//	{
//		waitForPageToScroll(productByName);
//		return products;
//		
//	}
	
	public WebElement getProductByName(String productname)
	{
		/*
		 * WebElement prod = products.stream() .filter(product ->
		 * product.findElement(By.xpath(
		 * "//div[@id='tbodyid']//div[1]//div[1]//div[1]//h4[1]")).getText().equals(
		 * productname)).findFirst() .orElse(null); return prod;
		 */
		
//		WebElement prod = products.stream()
//				.filter(product -> product.findElement(By.xpath("//h4[@class='card-title']")).getText().equals(productname)).findAny()
//				.orElse(null);
		//List<WebElement> linkedlist = driver.findElements(By.linkText(Value))
		driver.navigate().refresh();
		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.xpath("//a[@class='hrefch']")).getText().equals(productname)).findFirst().orElse(null);
				//element.click();
				//driver.navigate().refresh();
		
		//WebElement prod = products.stream()
				//.filter(product -> product.findElement(By.xpath("//a[@class='hrefch']")).getText().equals(productname)).findFirst()
				//.orElse(null);
		//driver.navigate().refresh();
		return prod;
	}
	
	public AddToCart addProductToCart(String productname) throws InterruptedException 
	{
		WebElement prod = getProductByName(productname);
		//Thread.sleep(10);
		System.out.println(productname);
		System.out.println(prod);
		//prod.findElement(productByName).click();
		prod.click();
		driver.navigate().refresh();
		//driver.switchTo().alert().accept();
		AddToCart addtocart = new AddToCart(driver);
		return addtocart;	
	}
}
