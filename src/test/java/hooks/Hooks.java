package hooks;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import stepDefinition.Commons;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks {

	 WebDriver driver;
	 Properties p;
     
	@Before
    public void setup() throws IOException, InterruptedException
    {
    	driver=Commons.initilizeBrowser();
    	    	
    	p=Commons.getProperties();
    	driver.get(p.getProperty("appURL"));
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    			
	}
		
    
    @After
    public void tearDown() {
        		
       driver.quit();
       
    }
    
    /*public String getCurrentStepText(Scenario scenario) {
        // Cucumber doesn't expose step text directly in hooks.
        // You can use custom formatters or third-party libraries like cucumber-extents or PicoContainer
        return null; // Placeholder unless you wire in step context
    }*/
    
    public void captureScreenshot(Scenario scenario, String label) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", label);
        } catch (WebDriverException e) {
            System.err.println("Screenshot capture failed: " + e.getMessage());
        }
    }




    @AfterStep
    public void addScreenshot(Scenario scenario) {
    	//String stepText = getCurrentStepText(scenario);
    	// this is for cucumber junit report
        if(scenario.isFailed()) {
        	captureScreenshot(scenario, "Failure Screenshot:");
        }
        else {
                captureScreenshot(scenario, "Step Screenshot");
        }
        	/*TakesScreenshot ts=(TakesScreenshot) driver;
        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshot, "image/png",scenario.getName());*/ 	            
        
      
    }
   
}
