package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonComponents.CommonComponents;

public class LandingPage extends CommonComponents {

	
	WebDriver driver;
    
    public LandingPage(WebDriver driver)
    {   super(driver);
    	// initialization
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
    
    @FindBy(id="login2")
    WebElement loginId;
    
    @FindBy(id="loginusername")
    WebElement UserName;
    
    @FindBy(id="loginpassword")
    WebElement Password;
    
    @FindBy(css="button[onclick='logIn()']")
    WebElement Login;
    
    
    
    public void goTo()
    {
    	driver.get("https://www.demoblaze.com/");
    	
    }
    
    public ProductPage loginApplication(String userName, String password)
    {
    	loginId.click();
    	UserName.sendKeys(userName);
    	Password.sendKeys(password); 
    	Login.click();
    	//driver.navigate().refresh();
    	ProductPage productPage = new ProductPage(driver);
    	return productPage;
    	
    }
}
