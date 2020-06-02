package com.pageobject;

import org.openqa.selenium.By;

public class PageObject {

	public static final By username = By.xpath("//input[@id='username']");
	public static final By password = By.xpath("//input[@id='password']");
	public static final By signinButton = By.xpath("//button[@class='btn btn-lg btn-primary btn-block']");
	public static final By homepageMessage = By.xpath("//h2[contains(text(),'Primary Balance:')]");
	public static final By transferButton = By.xpath("//a[contains(text(),'Transfer')]");
	public static final By betweenAcc = By.xpath("//a[contains(text(),'Between Accounts')]");
	public static final By transferFrom = By.xpath("//select[@id='transferFrom']"); // value="Primary"
																					// //value="Savings"
	public static final By amount = By.xpath("//input[@id='amount']");
	public static final By homepageMessage2 = By.xpath("//h2[contains(text(),'Primary Balance:')]");
	public static final By confirmTransferButton = By.xpath("//button[@class='btn btn-lg btn-primary btn-block']");
	public static final By primaryBal =By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/h1[1]/span[1]");

}
