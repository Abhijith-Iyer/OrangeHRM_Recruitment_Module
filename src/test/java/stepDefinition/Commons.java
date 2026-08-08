package stepDefinition;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Commons {
	 static WebDriver driver;
     static Properties p;
     static Logger logger;
     static WebDriverWait wait;
     //static JavascriptExecutor js = (JavascriptExecutor)driver;
    
     /*public static SoftAssert softAssert = new SoftAssert();

     public static SoftAssert getSoftAssert() {
         return softAssert;
     }

     public static void assertAll() {
         softAssert.assertAll();
     }*/

/**
 * Initializes the browser (Chrome, Edge, Firefox) for local or remote execution based on configuration properties.
 */
public static WebDriver initializeBrowser() throws IOException
{
	p = getProperties();
    String executionEnv = p.getProperty("execution_env");
    String browser = p.getProperty("browser").toLowerCase();
    String os = p.getProperty("os").toLowerCase();
	
	if(executionEnv.equalsIgnoreCase("remote"))
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		//os
		 switch (os) {
         case "windows":
             capabilities.setPlatform(Platform.WINDOWS);
             break;
         case "mac":
             capabilities.setPlatform(Platform.MAC);
             break;
         case "linux":
             capabilities.setPlatform(Platform.LINUX);
             break;
         default:
             System.out.println("No matching OS");
             return null;
        }
		
		//browser
		 switch (browser) {
         case "chrome":
             capabilities.setBrowserName("chrome");
             break;
         case "edge":
             capabilities.setBrowserName("MicrosoftEdge");
             break;
         case "firefox":
             capabilities.setBrowserName("firefox");
             break;
         default:
             System.out.println("No matching browser");
             return null;
         }
       
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		
	}
	else if(executionEnv.equalsIgnoreCase("local"))
		{
			switch(browser.toLowerCase()) 
			{
			case "chrome":
		        ChromeOptions wdops = new ChromeOptions();
		        wdops.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		        driver=new ChromeDriver(wdops);
		        break;
		    case "edge":
		    	 EdgeOptions wdops1 = new EdgeOptions();
			     wdops1.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		    	driver=new EdgeDriver(wdops1);
		        break;
		    case "firefox":
		    	driver=new FirefoxDriver();
		        break;
		    default:
		        System.out.println("No matching browser");
		        driver=null;
			}
		}
	/* driver.manage().deleteAllCookies(); 
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));*/
	if (driver != null) {
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // Slightly increased
	} else {
	    throw new RuntimeException("Browser initialization failed: " + browser);
	}
	 
	 return driver;
	 
}

/**
 * Returns the WebDriver instance.
 */
public static WebDriver getDriver() {
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}

/**
 * Loads and returns the properties from the configuration file.
 */
public static Properties getProperties() throws IOException
{		 
    FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\Configuration.properties");
   	p=new Properties();
	p.load(file);
	return p;
}

/**
 * Returns a Logger instance for logging purposes.
 */
public static Logger getLogger() 
{		 
	logger=LogManager.getLogger(); //Log4j
	return logger;
}

/**
 * Sends the specified value to the given WebElement.
 */
public static void sendkeys(WebElement element,String value) {
	element.sendKeys(value);
}

/**
 * Scrolls the page to bring the specified WebElement into view.
 */
public static void scrolltoelement(WebElement element) {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView();", element);
}

/**
 * Forces a click on the WebElement using JavaScript, bypassing any overlays.
 */
public static void forceclick(WebElement element) {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", element);
}

/**
 * Scrolls to the bottom of the page.
 */
public static void scrolltolast() {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
}

/**
 * Scrolls to the top of the page.
 */
public static void scrolltotop() {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollTo(0, 0);");
}

/**
 * Forces setting the value of the WebElement using JavaScript.
 */
public static void forcesendkeys(WebElement element, String val) {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].SetAttribute('value',"+val+")",element);
}

/**
 * Waits for the specified WebElement to become visible within the given time.
 */
public static void waittillvisible(WebElement element, long i) {
	wait = new WebDriverWait(driver,Duration.ofSeconds(i));
	wait.until(ExpectedConditions.visibilityOf(element));
}

/**
 * Waits for the WebElement to be visible and then clicks it.
 */
public static void waitandclick(WebElement element, long i) {
	wait = new WebDriverWait(driver,Duration.ofSeconds(i));
	wait.until(ExpectedConditions.visibilityOf(element));
	element.click();
}

/**
 * Clears the content of the WebElement by sending backspace keys.
 */
public static void clearWebField(WebElement element){
    while(!element.getAttribute("value").equals("")){
        element.sendKeys(Keys.BACK_SPACE);
    }
}
}

