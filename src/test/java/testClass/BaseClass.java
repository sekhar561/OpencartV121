package testClass;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager; //Log4j
import org.apache.logging.log4j.Logger;	//Log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
	
	@Parameters({"os","browser"})
	@BeforeClass(groups = {"Sanity","Regression","Master"})
	public void setup(String os, String br) throws IOException {
		
		FileReader file = new FileReader(".//src//test/resources//config.properties");
		p = new Properties();
		p.load(file);
		
		
		logger =LogManager.getLogger(this.getClass());
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			if(os.equalsIgnoreCase("winodows"))
			{
				capabilities.setPlatform(Platform.WIN10);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No Matching Os");
				return;
			}
		//browsers
			
			switch(br.toLowerCase())
			{
			
			case "chrome": capabilities.setBrowserName("chrome"); break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
			default: System.out.println("No matching browser"); return;	
		}
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		
	}
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
			
		{
			switch(br.toLowerCase())
			{
			case "chrome" 	: driver = new ChromeDriver(); break;
			case "edge" 	: driver = new EdgeDriver(); break;
			case "firefox" 	: driver = new FirefoxDriver(); break;
			default: System.out.println("Invalid browser name..."); return;
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		driver.manage().deleteAllCookies();
		driver.get(p.getProperty("appURL"));// Read URL from properties file
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
		
	@AfterClass(groups = {"Sanity","Regression","Master"})
	public void tearDown() {
		
		driver.quit();	
	}
	
	public String RandomeString()
	{
		String generatedstring =RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}
	
	public String RandomeNumbers()
	{
		String generatednumbers =RandomStringUtils.randomNumeric(10);
		return generatednumbers;
	}
	
	public String RandomeAlphaNumaric()
	{
		String generatedstring =RandomStringUtils.randomAlphabetic(5);
		String generatednumbers =RandomStringUtils.randomNumeric(10);
		return(generatednumbers+"@"+generatedstring);
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	

}
