package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonComponents.CommonComponents;

public class AddToCart extends CommonComponents{

	WebDriver driver;
	public AddToCart(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy (xpath="//a[@class='btn btn-success btn-lg']")
	WebElement addToCart;
	
	//By addCartButton =By.cssSelector("a.btn.btn-success.btn-lg");
	
	public WebElement waitforElem()
	{
		waitForWebElementToAppear(addToCart);
		return addToCart;
		
	}
	public void addToCart()
	{
		addToCart.click();	
		
	}
}
