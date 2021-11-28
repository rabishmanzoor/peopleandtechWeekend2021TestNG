package commoncode;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;

public class baseclass implements ITestListener {
public WebDriver driver;
	
  @Override
public void onTestSuccess(ITestResult result) {
	// TODO Auto-generated method stub
	  this.driver= ((baseclass)result.getInstance()).driver;
	  try {
		shots("passed");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

@Override
public void onTestFailure(ITestResult result) {
	// TODO Auto-generated method stub
	this.driver= ((baseclass)result.getInstance()).driver;
	try {
		shots("failed");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

@BeforeTest (alwaysRun=true)
  @Parameters({"brow","url"})
  public void browser(String brow, String url) throws InterruptedException {
		if (brow.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\eclipseProject\\softwaretestingproject\\drivers\\chromedriver.exe");
			driver=new ChromeDriver(); 
			driver.get(url);
		    driver.manage().window().maximize();
		    Thread.sleep(5000);
		}
		
		else if(brow.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "E:\\eclipseProject\\softwaretestingproject\\drivers\\geckodriver.exe");
			//System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
			driver=new FirefoxDriver(); 
			driver.get(url);
		    driver.manage().window().maximize();
		    Thread.sleep(5000);
		}
		else {
			System.setProperty("webdriver.edge.driver", "E:\\eclipseProject\\softwaretestingproject\\drivers\\msedgedriver.exe");
			driver=new EdgeDriver();
			driver.get(url);
		    driver.manage().window().maximize();
		    Thread.sleep(5000);
		}
  }
  
  @AfterTest (alwaysRun=true)
  public void afterTest() throws InterruptedException {
	  Thread.sleep(5000);
	  driver.close();
  }
  
  public void shots(String folder) throws IOException {
		Date dt = new Date();
		String strdate=dt.toString().replace(" ", "_").replace(":", "_");
		File cap = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(cap, new File ("C:\\Users\\VAADMIN\\git\\peopleandtechWeekend2021TestNG\\seleniumproject4\\pictures\\"+folder+"\\"+strdate+".png"));
	}

}
