package br.org.ietec.funcional;

import org.openqa.selenium.By;

public class Constant 
{
	public static final By MY_ACCOUNT = By.cssSelector("a.account_icon");
	public static final By USERNAME = By.id("log");
	public static final By PASSWORD = By.id("pwd");
	public static final By LOGIN = By.id("login");
	public static final By MSGERRO = By.cssSelector("p.response");
	public static final String MSG_ERRO_LOGIN = "ERROR: Invalid login credentials.";
	
	public static final By SEARCH = By.name("s");
	public static final By MSG_NAO_ENCONTRADO_LOCATOR = By.id("content");
	public static final String MSG_NAO_ENCONTRADO = "Sorry, but nothing matched your search criteria. Please try again with some different keywords";
	
	public static final By MENU_PRODUCTS = By.xpath("//a[contains(text(),'Product Category')]");
	public static final By COMPRAR = By.xpath("css=input[name=\"Buy\"]");
	public static final By CHECKOUT = By.xpath("//a[contains(text(),'Go to Checkout')]");
	public static final By QUANTIDADE = By.name("quantity");
	public static final By UPDATE_QUANT = By.name("submit");
	public static final By VALORUNITARIO = By.cssSelector("table.checkout_cart.1.3");
	public static final By VALORTOTAL = By.cssSelector("table.checkout_cart.1.4");
	
}
