package swaglabs.pages;

import org.junit.Assert;

import com.microsoft.playwright.Page;

public class ItemsPage {
	Page page;
	
	private static final String cartBtn = "#shopping_cart_container > a";
	private static final String checkoutBtn = "[data-test=\"checkout\"]";
	public ItemsPage(Page page) {
		this.page = page;
	}
    
	
	public void orderProduct(String ProductName) {
		page.click("//div[text()='" + ProductName + "']/following::button[1]");
		page.click(cartBtn);
		Assert.assertTrue(page.isVisible("text="+ProductName));
		page.click(checkoutBtn);
	}

	public void loginSuccessful() {
		Assert.assertTrue(page.isVisible("text=Products"));
	}
	
}
