package Pom_class_APLM1;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks_class_APLM1
{
	public WebDriver driver;
	@After(order = 0)
	public void Test_scenario_failed(Scenario sc)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		byte[] screenshotAs = ts.getScreenshotAs(OutputType.BYTES);
		sc.attach(screenshotAs,"Image/png","Screen_Shot_failed");
	}
}
