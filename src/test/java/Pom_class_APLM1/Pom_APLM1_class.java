package Pom_class_APLM1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pom_APLM1_class 
{
	public static WebDriver driver;
	public WebDriverWait wait;
	
	public Pom_APLM1_class(WebDriver driver1)
	{
		driver = driver1;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//li[@class='Header_nav__bmQKS Header_userProfile__mrRoT']")
	public WebElement Login_icon;
	public void Login_icon_bar()
	{
		Login_icon.click();
	} 
	@FindBy(xpath = "//input[@name='mobileNumber']")
	public WebElement Phone_number_textfield;
	public WebElement Phone_textfield()
	{
		return Phone_number_textfield;
	}
	@FindBy(xpath = "//button[@title='Login']")
	public WebElement Signup;
	public void Signup_button()
	{
		Signup.click();
	}
	@FindBy(xpath = "//input[@id='searchProduct' and @placeholder='Search Medicines']")
	public WebElement Main_page_search;
	public WebElement Main_search()
	{
		return Main_page_search;
	}
	@FindBy(xpath = "//input[@placeholder='Search medicines, brands and more']")
	public WebElement Search_product_textfield;
	public WebElement Search_textfield()
	{
		return Search_product_textfield;
	}
	@FindBy(xpath = "//img[@title='Online Doctor Consultation & Medicines']")
	public WebElement Image_refresher;
	public void Image_refresher_icon()
	{
		Image_refresher.click();
	}
	@FindBy(xpath = "//a[text()='Find Doctors']")
	public WebElement Find_Doc;
	public void Find_Doctor()
	{
		Find_Doc.click();
	}
	@FindBy(xpath = "//a[@href='/doctors/doctors-in-bangalore-dcity']")
	public WebElement Bangalore_city;
	public void Bangalore_city_selector()
	{
		Bangalore_city.click();
	}
	@FindBy(xpath ="//div[@class='jss194']//button[2]")
	public WebElement Partner_docs;
	public void Partner_Doctor()
	{
		wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(Partner_docs));
		Partner_docs.click();
	}
	@FindBy(xpath = "//span[text()='Filters']")
	public WebElement Filter;
	public void Filter_options()
	{
		Filter.click();
	}
	@FindBy(xpath = "//span[text()='6-10']")
	public WebElement six_to_ten_years;
	public void six_to_ten_years_option()
	{
		six_to_ten_years.click();
	}
	@FindBy(xpath = "//span[text()='Apply Filters']")
	public WebElement Apply_Filters;
	public void Apply_Filter_Options()
	{
		Apply_Filters.click();
	}
	@FindBy(xpath = "(//span[@class='MuiButton-label'])[5]")
	public WebElement Experience;
	public WebElement Experience_idenfier()
	{
		
		return Experience;
	}
}
