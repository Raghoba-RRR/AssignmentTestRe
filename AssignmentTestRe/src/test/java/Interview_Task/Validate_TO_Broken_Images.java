package Interview_Task;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Validate_TO_Broken_Images {
WebDriver driver;
	@Test
	public void Checkbrokenimage() throws IOException
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS );
			driver.get("http://the-internet.herokuapp.com/broken_images");
			
	//all img in url
			List<WebElement> images =driver.findElements(By.tagName("img"));
		System.out.println("the no.of img :"+  images.size());
			
	// vadidate broken img
			for(WebElement image : images)
			{
				String imageSrc =image.getAttribute("src");	
				
				try {
					URL url = new URL(imageSrc);
					URLConnection urlConnection =url.openConnection();
					HttpURLConnection httpurlconnection =(HttpURLConnection) urlConnection;
					httpurlconnection.setConnectTimeout(5000);
					httpurlconnection.connect();
					
					if(httpurlconnection.getResponseCode()==200)
System.out.println(imageSrc+ " >> "+httpurlconnection.getResponseCode()+ " >> " +httpurlconnection.getResponseMessage());	

					else
						System.err.println(imageSrc+ " >> "+httpurlconnection.getResponseCode()+ " >> " +httpurlconnection.getResponseMessage());

					httpurlconnection.disconnect();
				
				} catch (IOException e) {
					
					System.out.println(imageSrc);
				}
			
			}
			
			driver.quit();
			 } 
	}

		
		
	


