package Step_defination_APLM1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Pom_class_APLM1.Pom_APLM1_class;
import io.cucumber.java.en.*;

public class Apollo_Pharmacy_Options 
{
	public WebDriver driver;
	public WebDriverWait wait;
	@Given("Open the browser and enter the url")	
	public void open_the_browser_and_enter_the_url() 
	{
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		ChromeOptions C=new ChromeOptions();
		C.addArguments("--disable-notifications");
		driver.manage().window().maximize();
		driver.get("https://www.apollopharmacy.in/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='Header_nav__bmQKS Header_userProfile__mrRoT']"))); 
	}

	@When("user entered valid user name and click on next button")
	public void user_entered_valid_user_name_and_click_on_next_button() throws InterruptedException
	{
		Pom_APLM1_class Pom=new Pom_APLM1_class(driver);
		Pom.Login_icon_bar();
		wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(Pom.Phone_textfield()));
		Pom.Phone_textfield().sendKeys("8660463204");
		Pom.Signup_button();
		
	}

	@When("user entered the valid OTP and click on Sign_up button")
	public void user_entered_the_valid_otp_and_click_on_sign_up_button() throws InterruptedException
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

	@When("user click on Drinks options juices Apollo_Prdoucts_module")
	public void user_click_on_drinks_options_juices_apollo_prdoucts_module()
	{
	   Actions A=new Actions(driver);
	   WebElement Apollo_product_mod = driver.findElement(By.xpath("//a[text()='Apollo Products']"));
	   A.moveToElement(Apollo_product_mod).perform();
	   WebElement Juices_Options = driver.findElement(By.xpath("//a[text()='Juices']"));
	   A.moveToElement(Juices_Options).click().perform();
	   
	}

	@Then("check wheather Drinks page is displayed")
	public void check_wheather_drinks_page_is_displayed() 
	{
		String Actual_url = driver.getCurrentUrl();
	    String Excepted_juices_page_url="https://www.apollopharmacy.in/shop-by-category/apollo-juices";
	    if(Actual_url.equalsIgnoreCase(Excepted_juices_page_url))
	    {
	    	Assert.assertTrue(true);
	    }
	}


	@When("user click on ORS drinks options under Apollo_Prdoucts_module")
	public void user_click_on_ors_drinks_options_under_apollo_prdoucts_module() 
	{
		Actions A=new Actions(driver);
		 WebElement Apollo_product_mod = driver.findElement(By.xpath("//a[text()='Apollo Products']"));
		   A.moveToElement(Apollo_product_mod).perform();
		   WebElement ORS_Drinks_Options = driver.findElement(By.xpath("//a[text()='ORS Drinks']"));
		   A.moveToElement(ORS_Drinks_Options).click().perform();
	}
	
	@Then("check wheather ORS_Drinks page is displayed")
	public void check_wheather_ors_drinks_page_is_displayed()
	{
		String Actual_url = driver.getCurrentUrl();
		String Excepted_Ors_page_url="https://www.apollopharmacy.in/shop-by-category/apollo-ors-drinks";
	    if(Actual_url.equalsIgnoreCase(Excepted_Ors_page_url))
	    {
	    	Assert.assertTrue(true);
	    }
	}


}
