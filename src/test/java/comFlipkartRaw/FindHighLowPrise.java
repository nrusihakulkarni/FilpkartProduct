package comFlipkartRaw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.WebElement;

class SortMothod implements Comparator<FindHighLowPrise> {

	@Override
	public int compare(FindHighLowPrise o1, FindHighLowPrise o2) {
		// TODO Auto-generated method stub
		return Integer.valueOf(o1.prise).compareTo(o2.prise);
	}

}

public class FindHighLowPrise {

	int prise;
	String productName;
	List<FindHighLowPrise> list;

	public FindHighLowPrise() {

	}

	public FindHighLowPrise(int prise, String productName) {
		super();
		this.prise = prise;
		this.productName = productName;
	}

	public void FindPrise(List<WebElement> getProductlist, List<WebElement> getPriselist) {

		list = new ArrayList<FindHighLowPrise>();

		System.out.println(String.format("%54s", "\n Name OF Product ") + String.format("%130s", "Prise ")
				+ "\n *****************************************************************************************************\n"); // for
																																															// UI

		for (int i = 0; i < getProductlist.size(); i++) {

			list.add(new FindHighLowPrise(
					Integer.parseInt(getPriselist.get(i).getText().replace("₹", "").replace(",", "")),
					getProductlist.get(i).getText()));

			System.out.println(String.format(" %-140s", getProductlist.get(i).getText()) + "|"
					+ String.format("%-20s", getPriselist.get(i).getText().replace("₹", "").replace(",", "")));

		}

		Collections.sort(list, new SortMothod());

	}

	public void lowPrise() {
		System.out.println("\n lowest prise television    ::  " + list.get(0));
	}

	public void highPrise() {
		System.out.println("\n Highest  prise television  ::  " + list.get((list.size() - 1)));
	}

	@Override
	public String toString() {
		return "FindHighLowPrise [prise =   " + prise + ", productName =   " + productName + "]";
	}

}
