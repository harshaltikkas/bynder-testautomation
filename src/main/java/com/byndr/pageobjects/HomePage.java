package com.byndr.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	@FindBy(name="username")
	public WebElement username;
	
	@FindBy(name="password")
	public WebElement password;
	
	@FindBy(xpath="//img[@class='byndr_logo']")
	public WebElement byndrLogoOnLogin;
	
	@FindBy(xpath="//button[contains(text(),'Log In')]")
	public WebElement logInBtn;
	
	@FindBy(xpath="//ul[@class='boxes feed ng-scope']")
	public WebElement newsFeedTab;
	
	@FindBy(xpath="//a[@id='nav-user-drop']")
	public WebElement logOutMenu;
	
	@FindBy(xpath="//a[contains(text(),'sign out')]")
	public WebElement signOutBtn;
	
	/*@FindBy(xpath="//div[@class='modal_footer']//button[@class='buttons_standard mat-button']")
	public WebElement okBtnOnAddLocPage;
	
	@FindBy(xpath="//div[@class='document list-view clearfix']//div[@class='sendingMemberName']")
	public List<WebElement> storeList;*/
}
