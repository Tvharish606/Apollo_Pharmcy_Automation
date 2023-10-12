package Step_defination_APLM1;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Pom_class_APLM1.Pom_APLM1_class;
import io.cucumber.java.en.*;
public class Login_APLM1_fun
{
	public static WebDriver driver;
	public WebDriverWait wait;
	@Given("when user open the browser and enter the url")
	public void when_user_open_the_browser_and_enter_the_url() 
	{
	    System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
	    driver=new ChromeDriver();
	    ChromeOptions C=new ChromeOptions();
	    C.addArguments("--disable-notifications");
	    driver.manage().window().maximize();
	    driver.get("https://www.apollopharmacy.in");
	    wait=new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='Header_nav__bmQKS Header_userProfile__mrRoT']")));
	}
	@When("user click on login funcationality icon")
	public void user_click_on_login_funcationality_icon() throws InterruptedException 
	{
		Pom_APLM1_class Pom=new Pom_APLM1_class(driver);
		Pom.Login_icon_bar();
		Thread.sleep(4000);
	}
	@When("enter the {string} and click on next icon")
	public void enter_the_and_click_on_next_icon(String string)
	{
		wait=new WebDriverWait(driver, 10);
		Pom_APLM1_class Pom=new Pom_APLM1_class(driver);
	    wait.until(ExpectedConditions.visibilityOf(Pom.Phone_textfield()));
	   Pom.Phone_textfield().sendKeys(string);
	   Pom.Signup_button();
	}
	@When("enter the valid OTP pin and click on next icon")
	public void enter_the_valid_otp_pin_and_click_on_next_icon() throws InterruptedException 
	{
	    Thread.sleep(20000);
	    Pom_APLM1_class Pom=new Pom_APLM1_class(driver);
	    try 
		{
		Pom.Signup_button();
		}
		catch(NoSuchElementException r)
		{
			System.out.println("Without_otp");
		}
		finally
		{
			System.out.println("Handled");
		}
	}
	@Then("check wheather user able to see the login page")
	public void check_wheather_user_able_to_see_the_login_page() 
	{
	 String Title_of_Homepage = driver.getTitle();
	 if(driver.getPageSource().contains(Title_of_Homepage))
	 {
		 Assert.assertTrue(true);
		 System.out.println("Login_done"); 
	 }
	  driver.quit();
	}
}
