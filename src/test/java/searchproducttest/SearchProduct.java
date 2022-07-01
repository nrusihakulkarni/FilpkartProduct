package searchproducttest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import comFlipkartRaw.BaseClass;
import comFlipkartRaw.ComSearchpagePom;

public class SearchProduct {
	BaseClass baseClass;
	ComSearchpagePom searchpage;

	@BeforeClass
	public void setInstance() {
		baseClass = new BaseClass();
		searchpage = new ComSearchpagePom();

	}

	@Test
	public void landingPage() {
		searchpage.getWebpage(baseClass.prop.getProperty("url"));

	}

	@Test
	public void productSearch() {
		searchpage.closePopup();
		searchpage.searchProdut(baseClass.prop.getProperty("seachproduct"));
		searchpage.validatePage("mobile");
	}

	@Test
	public void sortProduct() {
			
		searchpage.getProductPrise();
		searchpage.lowToHigh();
		searchpage.highToLow();
		
	}

	@AfterClass
	public void afterCalss() throws Exception {

		Thread.sleep(2500);
		BaseClass.driver.quit();

	}
}
