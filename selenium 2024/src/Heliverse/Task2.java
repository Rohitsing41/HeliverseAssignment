package Heliverse;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Task2 {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Login With Valid credentials for the Ecommerce website
        
        driver.get("https://demo.nopcommerce.com/login?returnurl=%2F");
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("rohitsingjrajput97@gmail.com");
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Password@41");
       driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();
         WebElement LoginMsg =driver.findElement(By.xpath("//input[@type='checkbox')]"));
         if(LoginMsg.isDisplayed())
         {
        	 System.out.println("User Loged In succesfully");
         }
         else
         {
        	 System.out.println("User Loged in Failed");
         }
       
        //Login with invalid Credentials for the E commerce website
        WebElement InvalidEmail= driver.findElement(By.xpath("//input[@id='Email']"));
        InvalidEmail.clear();
        InvalidEmail.sendKeys("sing@gmail.com");
        
        WebElement InvalidPswd = driver.findElement(By.xpath("//input[@id='Password']"));
        InvalidPswd.clear();
        InvalidPswd.sendKeys("pwd@123");
        driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();
         
        WebElement ErrorMsg= driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']"));
        if(ErrorMsg.isDisplayed())
        {
        	System.out.println("Error Message is displayed for invalid credentials");
        }
        else
        {
        	System.out.println("Erro Message is not displayed for Invalid credentials");
        }
	}

}
