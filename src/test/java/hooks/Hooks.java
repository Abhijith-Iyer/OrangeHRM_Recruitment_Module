package hooks;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
//import java.util.List;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import stepDefinition.Commons;
import utilities.StepCaptureListener;
import utilities.StepContext;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
//import io.cucumber.plugin.event.PickleStepTestStep;


public class Hooks extends Commons {

	 WebDriver driver;
	 Properties p;
	 //StepCaptureListener stepcapture = new StepCaptureListener();
	 private final StepContext stepContext;
	   public Hooks(StepContext stepContext) {
	        this.stepContext = stepContext;
	    }



	@Before
    public void setup() throws IOException, InterruptedException
    {
		InputStream stream = ClassLoader.getSystemResourceAsStream("META-INF/services/io.cucumber.plugin.Plugin");
	    System.out.println("SPI file found? " + (stream != null));
		StepCaptureListener.reset();
    	driver=Commons.initializeBrowser();

    	p=Commons.getProperties();
    	//driver.get(p.getProperty("appURL"));
    	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    	//driver.manage().window().maximize();
    	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    	 driver.manage().window().maximize();
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // Set once

    	 driver.get(p.getProperty("appURL")); // After waits and maximize

	}

	/*@After
    public void afterScenario(Scenario scenario) {
        try {
            Commons.assertAll();
        } catch (AssertionError e) {
            scenario.attach(e.getMessage().getBytes(), "text/plain", "Soft Assertion Failures");
            throw e; // rethrow to mark scenario as failed
        }
    }*/

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
    /*public String saveScreenshotToFile(byte[] screenshotBytes, String stepName) {
        String fileName = "screenshots/" + stepName.replaceAll("[^a-zA-Z0-9]", "_") + "_" + System.currentTimeMillis() + ".png";
        String fullPath = System.getProperty("user.dir") + "/target/extent-report/" + fileName;

        try {
            java.nio.file.Path path = java.nio.file.Paths.get(fullPath);
            java.nio.file.Files.createDirectories(path.getParent());
            java.nio.file.Files.write(path, screenshotBytes);
        } catch (IOException e) {
            System.err.println("Failed to save screenshot: " + e.getMessage());
        }

        return "../" + fileName; // Relative path for ExtentCucumberAdapter
    }*/
    public String saveScreenshotToExtentFolder(byte[] screenshotBytes, String stepName) {
        String fileName = "screenshots/" + stepName.replaceAll("[^a-zA-Z0-9]", "_") + "_" + System.currentTimeMillis() + ".png";
        String fullPath = System.getProperty("user.dir") + "/target/extent-report/" + fileName;

        try {
            java.nio.file.Path path = java.nio.file.Paths.get(fullPath);
            java.nio.file.Files.createDirectories(path.getParent());
            java.nio.file.Files.write(path, screenshotBytes);
        } catch (IOException e) {
            System.err.println("Failed to save screenshot: " + e.getMessage());
        }

        return fileName; // ✅ Relative path for ExtentCucumberAdapter
    }




    @AfterStep
    public void addScreenshot(Scenario scenario) throws IOException {
    	/*String stepText = getCurrentStepText(scenario);
    	this is for cucumber junit report
    	 String stepText = step.getStep().getText();
    	 boolean isValidationStep = stepText.contains("Validate") || stepText.contains("Check");
         //boolean isFailed = scenario.isFailed();
        if(scenario.isFailed()) {
        	captureScreenshot(scenario, "Failure Screenshot:");
        }
        if(isValidationStep){
                captureScreenshot(scenario, "Step Screenshot");
        }
        	TakesScreenshot ts=(TakesScreenshot) driver;
        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshot, "image/png",scenario.getName());*/

        // Get the latest step from your listener
        /*List<String> steps = null;
		try {
			steps = StepCaptureListener.getStepNames();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String currentStep = steps.isEmpty() ? "" : steps.get(steps.size() - 1);*/
    	boolean isFailed = scenario.isFailed();
    	String currentStep = stepContext.getCurrentStep();
    	 if (currentStep == null || currentStep.trim().isEmpty()) {
    	        System.out.println("No step text captured yet — skipping screenshot logic.");
    	        return;
    	    }
        System.out.println("Current Step from PicoContainer: " + currentStep);

        boolean isValidationStep = currentStep.toLowerCase().contains("validate") || currentStep.toLowerCase().contains("check");
        ExtentCucumberAdapter.addTestStepLog("Step: " + currentStep);
        System.out.println("Current Step: " + currentStep);
        System.out.println("Validation Step? " + isValidationStep);
        //System.out.println("Step list: " + steps);
        System.out.println("Current Step: " + currentStep);

        if (isFailed || isValidationStep) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot: " + currentStep);
            String screenshotPath = saveScreenshotToExtentFolder(screenshot, currentStep);
            ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(screenshotPath);

            //ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(saveScreenshotToFile(screenshot, currentStep));
            //captureScreenshot(scenario, "Step Screenshot");
        }

        stepContext.setCurrentStep(null);


    }


}
