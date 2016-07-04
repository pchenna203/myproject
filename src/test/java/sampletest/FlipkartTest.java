package sampletest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class FlipkartTest {
	public WebDriver driver=null;
	public String url="http://www.flipkart.com/";
	private By login_Link=By.linkText("Log In");
	private By username=By.xpath("//div[@id='fk-mainbody-id']//div[2]/input");
	private By password=By.xpath("//*[@id='fk-mainbody-id']/div/div/div[1]/div/div[4]/div[4]/input");
	private By signIn=By.xpath("//*[@id='fk-mainbody-id']/div/div/div[1]/div/div[4]/div[7]/input");
  @Test
  public void Login() throws InterruptedException {
	  driver.findElement(login_Link).click();
	  driver.findElement(username).sendKeys("peddineni.chenna@gmail.com");
	  driver.findElement(password).sendKeys("chenna123");
	  driver.findElement(signIn).click();
	  Thread.sleep(1000L);
	  String ele=driver.getTitle();
	  System.out.println("Current page title"+ele);
	  Assert.assertEquals(ele,"Online Shopping India | Buy Mobiles, Electronics, Appliances, Clothing and More Online at Flipkart.com");
      Reporter.log("LogIn Successful");
  }
  @BeforeMethod
  public void beforeMethod() {
	 System.out.println("Before Test"); 
	  
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("After method");
  }

  @BeforeClass
  public void beforeClass() {
	  driver=new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.get(url);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
