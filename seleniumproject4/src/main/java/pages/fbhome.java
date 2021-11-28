package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class fbhome {

public static WebDriver driver;
	
	@FindBy (id="email" ) WebElement email;
	@FindBy (id="pass" ) WebElement pass;
    @FindBy (xpath="//*[@name='login']") WebElement login;
	//changed
	//changed from github
	public fbhome(WebDriver driver) {
		fbhome.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	public void emailid(String emailtext) {
		email.clear();
		email.sendKeys(emailtext);
	}
	
	public void password(String passtext) {
		pass.sendKeys(passtext);
	}
	
	public void loginclick() {
		login.click();
	}
	
	public void findfblinks() {
	List<WebElement>  listoflinks =driver.findElements(By.tagName("a"));
	System.out.println("Total links are= " + listoflinks.size());
	
	for (int i=0;i<listoflinks.size();i++) {
		System.out.println(listoflinks.get(i).getAttribute("href"));
	}	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void findlinks() {
		 List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		 System.out.println(allLinks.size());
		 for (int i=0;i<allLinks.size();i++) {
			 allLinks.get(i);
			 System.out.println(allLinks.get(i).getAttribute("href"));
		 }
	}
	
}

