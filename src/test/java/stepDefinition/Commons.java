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
  	     
public static WebDriver initilizeBrowser() throws IOException
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
		    	driver=new EdgeDriver();
		        break;
		    case "firefox":
		    	driver=new FirefoxDriver();
		        break;
		    default:
		        System.out.println("No matching browser");
		        driver=null;
			}
		}
	 driver.manage().deleteAllCookies(); 
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
	 
	 return driver;
	 
}

public static WebDriver getDriver() {
		return driver;
	}

public static Properties getProperties() throws IOException
{		 
    FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\Configuration.properties");
   	p=new Properties();
	p.load(file);
	return p;
}

public static Logger getLogger() 
{		 
	logger=LogManager.getLogger(); //Log4j
	return logger;
}

public static void clickop(WebElement element) {
	element.click();
}
public static void sendkeys(WebElement element,String value) {
	element.sendKeys(value);
}
public static void scrolltoelement(WebElement element) {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView();", element);
}
public static void forceclick(WebElement element) {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", element);
}
public static void forcesendkeys(WebElement element, String val) {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].SetAttribute('value',"+val+")",element);
}
public static void waittillvisible(WebElement element, long i) {
	wait = new WebDriverWait(driver,Duration.ofSeconds(i));
	wait.until(ExpectedConditions.visibilityOf(element));
}

public static void waitandclick(WebElement element, long i) {
	wait = new WebDriverWait(driver,Duration.ofSeconds(i));
	wait.until(ExpectedConditions.visibilityOf(element));
	element.click();
}
public static void clearWebField(WebElement element){
    while(!element.getAttribute("value").equals("")){
        element.sendKeys(Keys.BACK_SPACE);
    }
}
}
