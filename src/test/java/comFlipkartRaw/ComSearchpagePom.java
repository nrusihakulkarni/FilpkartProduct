package comFlipkartRaw;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ComSearchpagePom {

	WebDriver driver = BaseClass.driver;

	FindHighLowPrise findHighLowPrise;

	public ComSearchpagePom() {
		PageFactory.initElements(driver, this);
		findHighLowPrise = new FindHighLowPrise();

	}

	@FindBy(xpath = "//button[@class='_2KpZ6l _2doB4z']")
	WebElement cloaseButton;

	@FindBy(xpath = "//input[@name='q']")
	WebElement SearchBar;

	@FindBy(xpath = "//button[@class='L0Z3Pu']")
	WebElement SearchButton;

	@FindBy(xpath = "//div[contains(text(),'Price -- Low to High')]")
	WebElement lowToHighPRise;

	@FindBy(xpath = "//div[contains(text(),'Price -- High to Low')]")
	WebElement highToLowPRise;

	@FindBy(xpath = "//span[@class='_10Ermr']")
	WebElement resultTitel;

	By nameOfProduct = By.xpath("//div[@class='_4rR01T']");
	By priseOFProduct = By.xpath("//div[@class='_30jeq3 _1_WHN1']");

	public void getWebpage(String url) {
		driver.navigate().to(url);
	}

	public void closePopup() {
		cloaseButton.click();
	}

	@SuppressWarnings("deprecation")
	public void searchProdut(String product) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		SearchBar.sendKeys(product);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		SearchButton.click();
	}

	public void validatePage(String expected) {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Assert.assertTrue(resultTitel.getText().contains(expected), "Page Found");
	}

	@SuppressWarnings("deprecation")
	public void getProductPrise() {
		List<WebElement> productList = driver.findElements(nameOfProduct);
		List<WebElement> priseList = driver.findElements(priseOFProduct);
		findHighLowPrise.FindPrise(productList, priseList);
	}

	public void lowToHigh() {
		findHighLowPrise.lowPrise();

	}

	public void highToLow() {
		findHighLowPrise.highPrise();

	}

}
