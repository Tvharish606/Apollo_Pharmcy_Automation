package Runner_Package;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features = "src/test/resources",
glue = "Step_defination_APLM1",monochrome = true,plugin = {"pretty","html:test_APLM1-output"})
public class Runner_class_APLM1 extends AbstractTestNGCucumberTests
{
	
}
