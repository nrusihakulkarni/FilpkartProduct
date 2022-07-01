package comFlipkartRaw;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public Properties prop;

	public static WebDriver driver;

	public BaseClass() {

		try {
			FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/resorces/Input.properties");
			prop = new Properties();
			prop.load(file);

		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
		switch (prop.getProperty("browser").toLowerCase()) {
		case "chrome":

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":

			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
			break;
			
			
		default:
			break;
		}

	}

	public void propReder() {
		

	}

}
