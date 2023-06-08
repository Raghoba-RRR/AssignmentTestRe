package Interview_Task;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class upload_file {

	WebDriver driver;
	
	@Test
	public void upload()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
			driver.get("http://the-internet.herokuapp.com/upload ");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS ); 
			
			driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("C:\\Users\\ragho\\OneDrive\\Desktop\\sampal.xlsx");

	driver.close();
     driver.quit();
	}
	
}
