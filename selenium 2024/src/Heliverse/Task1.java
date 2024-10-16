package Heliverse;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task1 {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
         driver.findElement(By.xpath("//input[@placeholder='Search for Vegetables and Fruits']")).sendKeys("pista");
         Thread.sleep(5000);
        WebElement cartItem=driver.findElement(By.xpath("//button[contains(.,'ADD TO CART')]"));
        cartItem.click();
        if(cartItem.isDisplayed())
        {
        	System.out.println("pista is added to cart");
        }
        else
        {
        	System.out.println("pista is not added to cart");
        }
         driver.findElement(By.xpath("//img[@alt='Cart']")).click();
         driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
         driver.findElement(By.xpath("//button[text()='Place Order']")).click();
         Thread.sleep(5000);
        WebElement choose = driver.findElement(By.xpath("//div[@class='wrapperTwo']//div//select"));
                  Select pick = new Select(choose);
                  pick.selectByVisibleText("India");
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
       driver.findElement(By.xpath("//button[.='Proceed']")).click();
     WebElement SuccesMessage = driver.findElement(By.xpath("//*[contains(text(),'Thank you, your order has been placed successfully')]"));
      if(SuccesMessage.isDisplayed())
      {
    	  System.out.println("checkout process is passed");
      }
      else
      {
    	  System.out.println("checkout process is failed");
      }
	}

}
