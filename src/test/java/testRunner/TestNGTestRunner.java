package testRunner;


//import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

//import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
//import io.cucumber.core.plugin.PluginFactory;
//import io.cucumber.plugin.Plugin;
import io.cucumber.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(
					features= {".//src/test/java/features/"},
					//features = "classpath:features",

					//features= {".//Features/Login.feature"},
					//features= {".//Features/Registration.feature"},
		
					//features= {".//Features/LoginDDTExcel.feature"},
					//features= {".//Features/Login.feature",".//Features/Registration.feature"},
					//features= {"@target/rerun.txt"},
					glue={"stepDefinition","hooks", "utilities"},
					plugin= {
								"pretty", "html:reports/myreport.html",   
								"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
								"rerun:target/rerun.txt",
							
							},
							
					dryRun=false,    // checks mapping between scenario steps and step definition methods
					monochrome=true,    // to avoid junk characters in output
					publish=true, // to publish report in cucumber server
					//tags="@trail and @smoke"  // this will execute scenarios tagged with @sanity
					tags="@trail22"
					//tags="@sanity and @regression" //Scenarios tagged with both @sanity and @regression
					//tags="@sanity and not @regression" //Scenarios tagged with @sanity but not tagged with @regression
					//tags="@sanity or @regression" //Scenarios tagged with either @sanity or @regression
		)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
	
	@Override
	  @DataProvider(parallel = false)
	  public Object[][] scenarios() {
	    return super.scenarios();
	  }
}
