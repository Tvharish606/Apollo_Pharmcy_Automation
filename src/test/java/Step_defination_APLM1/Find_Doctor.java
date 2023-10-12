package Step_defination_APLM1;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import Pom_class_APLM1.Pom_APLM1_class;
import io.cucumber.java.en.*;

public class Find_Doctor 
{
	public WebDriver driver;
	WebDriverWait wait;
	@Given("when user open the Browser and enter the url")
	public void when_user_open_the_browser_and_enter_the_url() 
	{
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		ChromeOptions C=new ChromeOptions();
		C.addArguments("--disable-notifications");
		driver.manage().window().maximize();
		driver.get("https://www.apollopharmacy.in/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='Header_nav__bmQKS Header_userProfile__mrRoT']")));
	}
@Given("user entered the valid phone number and valid otp")
	public void user_entered_the_valid_phone_number_and_valid_otp() throws InterruptedException
	{
		Pom_APLM1_class Pom=new Pom_APLM1_class(driver);
		Pom.Login_icon_bar();
		wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(Pom.Phone_textfield()));
		Pom.Phone_textfield().sendKeys("8660463204");
		Pom.Signup_button();
		Thread.sleep(20000);
	}
	@Given("click on login button")
	public void click_on_login_button() 
	{
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
	@When("user click on find doctor module")
	public void user_click_on_find_doctor_module()
	{
	    Pom_APLM1_class Pom=new Pom_APLM1_class(driver);
	    Pom.Find_Doctor();
	}
	@When("select the location Bangalore")
	public void select_the_location_bangalore() 
	{
		Pom_APLM1_class Pom=new Pom_APLM1_class(driver);
	   wait=new WebDriverWait(driver, 010);
	   wait.until(ExpectedConditions.visibilityOf(Pom.Bangalore_city));
	   Pom.Bangalore_city_selector();
	}
	@When("click on Partner Doctor link")
	public void click_on_partner_doctor_link() 
	{
		Pom_APLM1_class Pom=new Pom_APLM1_class(driver);
		wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(Pom.Partner_docs));
		Pom.Partner_Doctor();
	}
	@When("click on Filter and select the six to ten years experienced")
	public void click_on_filter_and_select_the_six_to_ten_years_experienced()
	{
	  Pom_APLM1_class Pom=new Pom_APLM1_class(driver);
	  Pom.Filter_options();
	  wait=new WebDriverWait(driver, 10);
	  wait.until(ExpectedConditions.visibilityOf(Pom.six_to_ten_years));
	  Pom.six_to_ten_years_option();
	  Pom.Apply_Filter_Options();  
	}
	@Then("check wheather the six to ten years exiperenced doctors list is displayed")
	public void check_wheather_the_six_to_ten_years_exiperenced_doctors_list_is_displayed() 
	{
		Pom_APLM1_class Pom=new Pom_APLM1_class(driver);
		String Actual_Experience_text = Pom.Experience.getText();
		String Excepted_experience_text="6-10";
		Assert.assertEquals(Actual_Experience_text,Excepted_experience_text);
	}
}
