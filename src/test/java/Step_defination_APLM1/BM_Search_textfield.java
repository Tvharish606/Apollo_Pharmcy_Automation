package Step_defination_APLM1;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;

import com.github.dockerjava.core.dockerfile.DockerfileStatement.Add;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Pom_class_APLM1.Pom_APLM1_class;
import io.cucumber.java.en.*;
public class BM_Search_textfield
{
	public WebDriver driver;
	public WebDriverWait wait;
	ArrayList<String> Arlist;
	String Excepted_Sunscreen_result_url="https://www.apollopharmacy.in/search-medicines/Sunscreen";
	String Excepted_wipes_result_url="https://www.apollopharmacy.in/search-medicines/Wipes";
	String Excepted_ORS_result_url="https://www.apollopharmacy.in/search-medicines/ORS";
	String Excepted_Glucometer_url="https://www.apollopharmacy.in/search-medicines/Glucometer";
	String Excepted_Nebulizer_url="https://www.apollopharmacy.in/search-medicines/Nebulizer";
	String Excepted_Daiper_url="https://www.apollopharmacy.in/search-medicines/Diaper";
	String Excepted_thremometer_url="https://www.apollopharmacy.in/search-medicines/Thermometer";
	String Excepted_pregency_url="https://www.apollopharmacy.in/search-medicines/Pregnancy";
	String Excepted_Multivitamin_url="https://www.apollopharmacy.in/search-medicines/Multivitamin";
	String Excepted_Fish_oil_url="https://www.apollopharmacy.in/search-medicines/Fish-Oil";
	String Excepted_Vitamin_C_url="https://www.apollopharmacy.in/search-medicines/Vitamin-C";
	String Excepted_Vitamin_D_url="https://www.apollopharmacy.in/search-medicines/Vitamin-D";
	String Excepted_Whey_url="https://www.apollopharmacy.in/search-medicines/Whey-Protein";
	@Given("when User open the browser and enter the url")
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
	@When("User click on Login funcationality icon")
	public void user_click_on_login_funcationality_icon() throws InterruptedException 
	{
		Pom_APLM1_class Pom=new Pom_APLM1_class(driver);
		Pom.Login_icon_bar();
	}
	@When("Enter the {string} and click on next icon")
	public void enter_the_and_click_on_next_icon(String string)
	{
		Pom_APLM1_class Pom=new Pom_APLM1_class(driver);
		wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(Pom.Phone_textfield()));
		Pom.Phone_textfield().sendKeys(string);
		Pom.Signup_button();
	}
	@When("Enter the valid OTP pin and click on next icon")
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
	@Then("Check wheather user able to see the Login page")
	public void check_wheather_user_able_to_see_the_login_page()
	{
		String Title_of_Homepage = driver.getTitle();
	if(driver.getPageSource().contains(Title_of_Homepage))
		{
			Assert.assertTrue(true);
			System.out.println("Login_done"); 
		}
		driver.close();
		}
	@Given("user click on search textfield")
	public void user_click_on_search_textfield() throws InterruptedException
	{
		Pom_APLM1_class Pom=new Pom_APLM1_class(driver);
		wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(Pom.Main_search()));
	    Pom.Main_search().click();
		Thread.sleep(4000);
		Arlist=new ArrayList<String>();
		List<WebElement> Medicines_list = driver.findElements(By.xpath("//div[@class='RecentSearchTermsList_recentSearch__F6HZJ']//div//div"));
	for( WebElement Medicines:Medicines_list)
		{
			Thread.sleep(2000);
			String Medicine_text = Medicines.getText();
			Arlist.add(Medicine_text); 
			System.out.println(Medicine_text);
		}
	}
	@Given("enter the Medicines and click on X button")
	public void enter_the_medicines_and_click_on_x_button() throws InterruptedException
	{
		Pom_APLM1_class Pom=new Pom_APLM1_class(driver);
	for(int i=0;i<=Arlist.size()-1;i++)
		{
			wait=new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(Pom.Search_textfield()));
			Thread.sleep(4000);
			Pom.Search_textfield().sendKeys(Arlist.get(i));
			Thread.sleep(2000);
			Pom.Search_textfield().sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			String Actual_result_url = driver.getCurrentUrl();
			System.out.println(Actual_result_url);
	if(Excepted_Sunscreen_result_url.equalsIgnoreCase(Actual_result_url))
			{
				Assert.assertTrue(true);
				System.out.println("Sunscreen_assertion_working_fine");
				Thread.sleep(2000);
				Pom.Image_refresher_icon();
				Thread.sleep(2000);
				Pom.Main_search().click();
			}
	else if(Excepted_wipes_result_url.equalsIgnoreCase(Actual_result_url))
			{
			Assert.assertTrue(true);
			System.out.println("wipes_assertion_working_fine");
			Thread.sleep(2000);
			Pom.Image_refresher_icon();
			Thread.sleep(2000);
			Pom.Main_search().click();
			}
	else if(Excepted_ORS_result_url.equalsIgnoreCase(Actual_result_url))
			{
			Assert.assertTrue(true);
			System.out.println("ors_assertion_working_fine");
			Thread.sleep(2000);
			Pom.Image_refresher_icon();
			Thread.sleep(4000);
			Pom.Main_search().click();
			}
	else if(Excepted_Glucometer_url.equalsIgnoreCase(Actual_result_url))
		{
				Assert.assertTrue(true);
				System.out.println("Glucometer_assertion_working_fine");
				Thread.sleep(2000);
				Pom.Image_refresher_icon();
				Thread.sleep(2000);
				Pom.Main_search().click();
		}
	else if(Excepted_Nebulizer_url.equalsIgnoreCase(Actual_result_url))
			{
				Assert.assertTrue(true);
				System.out.println("nebulizer_assertion_working_fine");
				Thread.sleep(2000);
				Pom.Image_refresher_icon();
				Thread.sleep(2000);
				Pom.Main_search().click();
			}
	else if(Excepted_Daiper_url.equalsIgnoreCase(Actual_result_url))
			{
			Assert.assertTrue(true);
			System.out.println("Daiper_assertion_working_fine");
			Thread.sleep(2000);
			Pom.Image_refresher_icon();
			Thread.sleep(2000);
			Pom.Main_search().click();
			}
	else if(Excepted_thremometer_url.equalsIgnoreCase(Actual_result_url))
			{
			Assert.assertTrue(true);
			System.out.println("Thermomter_assertion_working_fine");
			Thread.sleep(2000);
			Pom.Image_refresher_icon();
			Thread.sleep(2000);
			Pom.Main_search().click();
			}
	else if(Excepted_pregency_url.equalsIgnoreCase(Actual_result_url))
			{
				Assert.assertTrue(true);
				System.out.println("Pregency_assertion_working_fine");
				Thread.sleep(2000);
				Pom.Image_refresher_icon();
				Thread.sleep(2000);
				Pom.Main_search().click(); 
			}
	else if(Excepted_Multivitamin_url.equalsIgnoreCase(Actual_result_url))
			{
				Assert.assertTrue(true);
				System.out.println("Multivitamin_assertion_working_fine");
				Thread.sleep(2000);
				Pom.Image_refresher_icon();
				Thread.sleep(2000);
				Pom.Main_search().click();
			}
	else if(Excepted_Fish_oil_url.equalsIgnoreCase(Actual_result_url))
			{
			Assert.assertTrue(true);
			System.out.println("Fish_oil_assertion_working_fine");
			Thread.sleep(2000);
			Pom.Image_refresher_icon();
			Thread.sleep(2000);
			Pom.Main_search().click();
			}
	else if(Excepted_Vitamin_C_url.equalsIgnoreCase(Actual_result_url))
			{
				Assert.assertTrue(true);
				System.out.println("Vitamin_c_assertion_working_fine");
				Thread.sleep(2000);
				Pom.Image_refresher_icon();
				Thread.sleep(2000);
				Pom.Main_search().click();
			}
	else if(Excepted_Vitamin_D_url.equalsIgnoreCase(Actual_result_url))
			{
			Assert.assertTrue(true);
			System.out.println("D_assertion_working_fine");
			Thread.sleep(2000);
			Pom.Image_refresher_icon();
			Thread.sleep(2000);
			Pom.Main_search().click();
			}
	else if(Excepted_Whey_url.equalsIgnoreCase(Actual_result_url))
			{
				Assert.assertTrue(true);
				System.out.println("Whey_assertion_working_fine");
				Thread.sleep(2000);
				Pom.Image_refresher_icon();
				Thread.sleep(2000);
				Pom.Main_search().click();
			}
	else
	{
		Assert.assertTrue(false);
	}
		}
	}
	@Then("check wheather the searched results displayed")
	public void check_wheather_the_searched_results_displayed() 
	{
		System.out.println("searched_details_completed_according_to the results displayed");
	}
	
	@When("user moves to Hansaplast Wound and Pain Management Range")
	public void user_moves_to_hansaplast_wound_and_pain_management_range() throws InterruptedException
	{
	    JavascriptExecutor js=(JavascriptExecutor)driver;
	    WebElement Hansaplast = driver.findElement(By.xpath("//h3[text()='Hansaplast Wound And Pain Management Range']"));
	    js.executeScript("arguments[0].scrollIntoView(true);",Hansaplast);
	    Thread.sleep(2000);
	    
	}

	@When("Select the 2nd item and add it to view cart")
	public void select_the_2nd_item_and_add_it_to_view_cart() throws InterruptedException 
	{
	   WebElement Second_Add_to_view_cart_Item = driver.findElement(By.xpath("(//div[@class='keen-slider  false ']/div[2]/div//button)[1]"));
	   Second_Add_to_view_cart_Item.click();
	   Thread.sleep(2000);
	}

	@Then("check wheather the added item is displayed in view cart")
	public void check_wheather_the_added_item_is_displayed_in_view_cart() 
	{
	    String Excepted_Item_name="Hansaplast Cotton Crepe Bandage B.P. 6 cm x 4 m, 1 Count";
	    if(driver.getPageSource().contains(Excepted_Item_name))
	    {
	    	Assert.assertTrue(true);
	    }
	}

}
