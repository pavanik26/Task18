package jatTask18.jatTask18;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Program1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
	       
	       // Initialize ChromeDriver with options
	       WebDriver driver = new ChromeDriver();
	       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
           driver.get("https://www.facebook.com");
           
           // Maximize the window
           driver.manage().window().maximize();
           
           waitForElement(4000);
           
           
           // to check if user is redirected to Facebook login page
           if(driver.findElements(By.xpath("//img[@alt='Facebook']")).size()>0)
           {
           System.out.println("landed on correct page");
           }
           else
           {
         	  System.out.println("landed on incorrect page");
           }  
           
           
           //click on Create new account
           WebElement createNewAccount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Create new account')]")));                   
           createNewAccount.click();
           
           WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
           firstName.sendKeys("testfname");
           
           WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
           lastName.sendKeys("testlname");
           
           WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
           day.sendKeys("10");
           
           WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
           month.sendKeys("October");
           
           WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
           year.sendKeys("1990");
           
           WebElement gender = driver.findElement(By.xpath("(//input[@id='sex'])[1]"));
           gender.click();
           
           WebElement email = driver.findElement(By.xpath("//input[@name='reg_email__']"));
           email.sendKeys("testfname710@gmail.com");
           
           WebElement pwd = driver.findElement(By.xpath("//input[@id='password_step_input']"));
           pwd.sendKeys("India@12345");
           
           WebElement btnSignUp = driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]"));
           btnSignUp.click(); 
           
          wait.until(ExpectedConditions.urlContains("facebook.com/?ref=home"));
           
           waitForElement(4000);
           
           // Check the current URL to confirm redirection
           String currentUrl = driver.getCurrentUrl();
           if (currentUrl.equals("https://www.facebook.com/")) {
               System.out.println("User successfully registered and redirected to the homepage.");
           } else {
               System.out.println("User registration failed or not redirected correctly.");
           }
           
           waitForElement(4000);
           driver.quit();
           
	} 
           
       public static void waitForElement(int milliseconds)
       	{
       		try {
       			Thread.sleep(milliseconds);
       		} catch (InterruptedException e) {
       			// TODO Auto-generated catch block
       			e.printStackTrace();
       		}
       	} 


	}


