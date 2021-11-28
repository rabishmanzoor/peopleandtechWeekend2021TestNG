package regressiontests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import commoncode.baseclass;
import pages.fbhome;

public class propertiesNewTest extends baseclass {
 
	
	@Test (groups = {"Functional"})
  public void f() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream ob= new FileInputStream("C:\\Users\\VAADMIN\\git\\peopleandtechWeekend2021TestNG\\seleniumproject4\\parametersdata.properties");
		prop.load(ob);
		
	String emailid=	prop.getProperty("Email");
	String passtxt=	prop.getProperty("Password");
	
	System.out.println(emailid);
	System.out.println(passtxt);
	
	fbhome fbhomeob= new fbhome(driver);
	fbhomeob.emailid(emailid);
	fbhomeob.password(passtxt);
	
  }
	
}
