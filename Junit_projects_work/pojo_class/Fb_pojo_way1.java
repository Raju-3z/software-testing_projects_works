package pojo_class;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit_projects.Base_class;

public class Fb_pojo_way1 extends Base_class {
	public Fb_pojo_way1(){
		PageFactory.initElements(driver,this);
		
	}
	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(xpath ="//input[@aria-label='Password']")
	private WebElement Password;
	
	@FindBy(name = "login")
	private WebElement loginbtn;

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
}
