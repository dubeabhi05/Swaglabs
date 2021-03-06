package swaglabs.pages;

import org.junit.Assert;

import com.microsoft.playwright.Page;

public class LoginPage {
	
	    private static final String userName = "//input[@id='user-name']";
	    private static final String userPassword = "//input[@id='password']";
	    private static final String btnLogin = "//input[@id='login-button']";


	Page page;
	
	  public LoginPage(Page page) { 
		  this.page = page;
     }
	  
	  public void login(String username,String password) {
	      page.fill(userName, username);
	      page.fill(userPassword, password);
	      page.click(btnLogin);
	}
	
	public void loginFailed() {
		boolean visible = page.isVisible("//h3[text()='Epic sadface: Sorry, this user has been locked out.']");
		Assert.assertTrue(visible);
	}
	
	 

}
