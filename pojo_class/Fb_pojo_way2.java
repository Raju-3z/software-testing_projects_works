package pojo_class;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit_projects.Base_class;

public class Fb_pojo_way2 extends Base_class {
	public Fb_pojo_way2(){
		PageFactory.initElements(driver,this);		
	}
	@FindAll({
		@FindBy(xpath="//input[@id='email']"),
		@FindBy(xpath="//input[@data-testid='royal_email']"),
	     })
		private WebElement varRef;
	
	@FindAll({
		@FindBy(xpath = "//input[@type='password']"),
		@FindBy(xpath ="//input[@aria-label='Password']"),
	     })
		private WebElement varRef1;
	
	@FindAll({
		@FindBy(xpath="//button[@id='loginbutton']"),
		@FindBy(xpath="//button[@name='login']"),
	     })
		private WebElement varRef2 ;

	public WebElement getVarRef() {
		return varRef;
	}

	public WebElement getVarRef1() {
		return varRef1;
	}

	public WebElement getVarRef2() {
		return varRef2;
	}
	

}
