package steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class AmazonHome_Steps {

	WebDriver driver = WebDriverManager.chromedriver().create();	
	
	@SuppressWarnings("deprecation")
	@Given("I am on Amazn Home Page")
	public void i_am_on_amazn_home_page() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.amazon.in");	
		System.out.println("Amazon Website launched");
	}

	@When("I click on Main  menu")
	public void i_click_on_main_menu() {
		driver.findElement(By.id("nav-hamburger-menu")).click();;
		System.out.println("Clicked on Menu");
	}

	@And("I select TV Appliances and Electronics Section from Submenu and Click Televisions")
	public void i_select_tv_appliances_and_electronics() {
		driver.findElement(By.xpath("//div[contains(text(),'TV, Appliances, Electronics')]")).click();;
		System.out.println("Clicked on SubMenu TV");
		driver.findElement(By.xpath("//a[contains(text(),'Televisions')]")).click();;		
		System.out.println("Clicked on MenuItem List Televisions");
	}
	
	@And("I should be selecting {string} from the list and see Specific brand Tv Reesults")
	public void i_should_be_selecting_from_the_list_and_see_specific_brand_tv_reesults(String string) {
		try {
		
		List<WebElement> elementList = new ArrayList<WebElement>(); 
		elementList=driver.findElements(By.xpath("//ul/li[@class='a-spacing-micro']/span/a/span"));
		for(int i=0;i<elementList.size();i++) 
		{ 
			  String CurrentOption = elementList.get(i).getText(); 
			  if(CurrentOption.contains(string))
			  { 
				  elementList.get(i).click(); 
				  break;
			   } 
		}	
		System.out.println("Selected Brand" +string);		
	}
		catch(Exception e){
			e.toString();	
		}
	}
	
	@Then("I should be able to Select based on {string}")
	public void i_should_be_able_to_select_based_on(String string) {
	   try {
		   Thread.sleep(5000);
		   driver.findElement(By.xpath("//span[@id='a-autoid-0']")).click();	  
		   List<WebElement> elementList = new ArrayList<WebElement>(); 
		   elementList=driver.findElements(By.xpath("//ul[@class='a-nostyle a-list-link']/li/a"));
			for(int i=0;i<elementList.size();i++) 
			{ 
				  String CurrentOption = elementList.get(i).getText(); 
				  if(CurrentOption.contains(string))
				  { 
					  elementList.get(i).click(); 
					  break;
				   } 
			}	
			System.out.println("Selected Price " +string);		
	   }
	   catch(Exception e)
	   {
		  System.out.println( e.toString());
	   }
	}
	
	@And("I should be able to validate the selected item")
	public void i_should_be_able_to_validate_the_selected_item() {
		 try {
			 driver.findElement(By.xpath("//div[@data-cel-widget='search_result_2']")).click();
		   Thread.sleep(2000);
		   String parent = driver.getWindowHandle();
		   Set<String> allwindows = driver.getWindowHandles();			   
		   for(String child: allwindows)
		   {
			   if(!parent.equalsIgnoreCase(child))
			   {			   
				   driver.switchTo().window(child);
				   System.out.println(driver.getTitle());
			   }
		   }		  
			 boolean status= driver.findElement(By.xpath("//h1[contains(text(),'About this item')]")).isDisplayed();
			 if(status==true)
			 { List<WebElement> elementList = new ArrayList<WebElement>(); 
			   elementList = driver.findElements(By.xpath("//ul[@class='a-unordered-list a-vertical a-spacing-mini']/li/span"));
			   for(int i=0;i<elementList.size();i++) 
				{ 
					  String CurrentOption = elementList.get(i).getText(); 
					 System.out.println("About this item list of details" +CurrentOption);
				}	
			 }		  
			  Thread.sleep(10000);	
			 
	   }
	   catch(Exception ex)
	   {
		   System.out.println( ex.toString());
	   }
		 driver.quit();
	}
}

	