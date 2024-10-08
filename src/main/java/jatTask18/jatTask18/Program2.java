package jatTask18.jatTask18;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Program2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
	       
	       // Initialize ChromeDriver
	       WebDriver driver = new ChromeDriver();
	      
	       try
	       {
           driver.get("https://jqueryui.com/droppable/");
           
           // Maximize the window
           driver.manage().window().maximize();
           
           waitForElement(4000);
           
          WebElement elm = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
           driver.switchTo().frame(elm);
          Actions action = new Actions(driver);
          WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));
          WebElement target = driver.findElement(By.xpath("//div[@id='droppable']"));
          
          action.dragAndDrop(source, target).build().perform();    
          waitForElement(4000);          
          

          String expectedColor = "rgba(255, 250, 144, 1)";

          String rgbaActualColor = driver.findElement(By.xpath("//div[@id='droppable']"))
                                         .getCssValue("background-color");
          
          // to check if background color and text changes and matches with expected        
          if (rgbaActualColor.contains(expectedColor) && (driver.findElements(By.xpath("//p[contains(text(),'Dropped!')]")).size()>0))
          {
        	  System.out.println("background color of target element changed and text of target element changed to Dropped!");
          }
          
          else
          {
        	  System.out.println("background color of target element not changed and text of target element not changed");
          }

          driver.switchTo().defaultContent();
           
       } 
	       
	   catch(Exception e)
	       {
		// TODO Auto-generated catch block
					e.printStackTrace();
	       }
			   
		   finally {
			   }
           // Close the browser
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
