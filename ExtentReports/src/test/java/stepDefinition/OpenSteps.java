package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class OpenSteps {
	public static ExtentHtmlReporter reporter=new ExtentHtmlReporter("./ExtentReports/Report1.html");
	public static ExtentReports extent=new ExtentReports();
	public static WebDriver driver;
	public static String er;
	public static String ar;
	
	@BeforeTest
	public static void openBrowser() { 
		System.out.println("Open");
		extent.attachReporter(reporter);
		ExtentTest logger1=extent.createTest("OpenBrowser");
		logger1.log(Status.INFO,"Opening the Browser");
		try {
			String dp=System.getProperty("user.dir")+"//Driver//chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", dp);
			driver=new ChromeDriver();
			logger1.log(Status.PASS,"Opening Pass");
	 
		} catch (Exception e) {
			System.out.println(e);
			logger1.log(Status.FAIL,"Opening Fail");
		
		}
		extent.flush();
	}  
	
	@Test
	public static void naviagte() throws Exception {
		System.out.println("Naviagte");	
		extent.attachReporter(reporter);
		ExtentTest logger2=extent.createTest("Navigate");
		logger2.log(Status.INFO,"Navigating to the Browser");
		try {
			er="Google";
			driver.get("https:/google.com");
			ar=driver.getTitle();
			Assert.assertTrue((er.equals(ar))?true:false);
			System.out.println("Navigation Pass");
			logger2.log(Status.PASS,"Navigation Pass");
			
		} catch (AssertionError e) {
			System.out.println(e);
			logger2.log(Status.FAIL,"Navigation Fail");
			//logger2.addScreenCaptureFromPath("C:\\Users\\DIGANTH\\Pictures\\Images\\killua.jpg");
			logger2.log(Status.FAIL,(Markup) logger2.addScreenCaptureFromPath("C:\\Users\\DIGANTH\\Pictures\\Images\\killua.jpg"));
		}
		extent.flush();
	}
	
	@AfterTest
	public static void closeBrowser() {
		System.out.println("Close");
		extent.attachReporter(reporter);
		ExtentTest logger3=extent.createTest("CloseBrowser");
		logger3.log(Status.INFO,"Closing to the Browser");
		try {
			driver.close();
			logger3.log(Status.PASS,"Closing Pass");
		} catch (Exception e) {
			System.out.println(e);
			logger3.log(Status.FAIL,"Closing Fail");		
		}
		extent.flush();
	}
}
