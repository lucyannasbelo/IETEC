package br.org.ietec.funcional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class Utils 
{
	private static final WebDriver driver;
	private static final WebDriverWait wait;

	static{
		driver = Selenium.getDriver();
		wait = new WebDriverWait(driver, 10);
	}

	public static void IsVisible(By p_locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(p_locator));
	}

	public static void IsLocated(By p_locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(p_locator));
	}

	public static void IsClickable(By p_locator) {
		wait.until(ExpectedConditions.elementToBeClickable(p_locator));
	}

	public static void Click(By p_locator){
		driver.findElement(p_locator).click();
	}
	
	public static String GetTextOfElemet(By p_locator){
		return driver.findElement(p_locator).getText();
	}

	public static void ClearText (By p_locator){
		driver.findElement(p_locator).clear();
	}

	public static void FillOutWithText(By p_locator, String p_text){
		driver.findElement(p_locator).sendKeys(p_text);
	}

	public static String GetText(By p_locator){
		return  driver.findElement(p_locator).getText();
	}
	
	public static void SelectCheckOrRadio(By p_locator){
		if(!driver.findElement(p_locator).isSelected())
		{
			Click(p_locator);
			wait.until(ExpectedConditions.elementSelectionStateToBe(p_locator, true));			
		}
	}
	
	public static void DeselectCheck(By p_locator){
		if(driver.findElement(p_locator).isSelected())
		{
			Click(p_locator);
			wait.until(ExpectedConditions.elementSelectionStateToBe(p_locator, false));
		}
	}
	
	public static void SelectCheckOrRadioList(By p_locator, String p_options)
	{
		List<WebElement> options = driver.findElements(p_locator);
		
		for (WebElement webElement : options) {
			if(webElement.getText().equals(options) & !webElement.isSelected())
			{
				webElement.click();
				wait.until(ExpectedConditions.elementSelectionStateToBe(webElement, true));
			}
		}
	}
	
	public static void DeselectCheckList(By p_locator, String p_options)
	{
		List<WebElement> options = driver.findElements(p_locator);
		
		for (WebElement webElement : options) {
			if(webElement.getText().equals(options) & webElement.isSelected())
			{
				webElement.click();
				wait.until(ExpectedConditions.elementSelectionStateToBe(webElement, false));
			}
		}
	}

	public static void SelectByIndex(By p_locator, int p_index)
	{
		IsClickable(p_locator);
		Select list = new Select(driver.findElement(p_locator));
		list.selectByIndex(p_index);
	}

	public static void SelectByValue(By p_locator, String p_value)
	{
		IsClickable(p_locator);
		Select list = new Select(driver.findElement(p_locator));
		list.selectByValue(p_value);
	}

	public static void SelectByVisibleText(By p_locator, String p_text)
	{
		IsClickable(p_locator);
		Select list = new Select(driver.findElement(p_locator));
		list.selectByValue(p_text);
	}

	public static List <WebElement> GetOptionsList(By p_locator, String p_text)
	{
		IsClickable(p_locator);
		Select list = new Select(driver.findElement(p_locator));
		return list.getOptions();
	}

	public static void DeselectAll(By p_locator)
	{
		IsClickable(p_locator);
		Select list = new Select(driver.findElement(p_locator));
		list.deselectAll();
	}

	public static void DeselectByIndex(By p_locator, int p_index)
	{
		IsClickable(p_locator);
		Select list = new Select(driver.findElement(p_locator));
		list.deselectByIndex(p_index);
	}

	public static void DeselectByValue(By p_locator, String p_value)
	{
		IsClickable(p_locator);
		Select list = new Select(driver.findElement(p_locator));
		list.deselectByValue(p_value);
	}

	public static void DeselectByVisibleText(By p_locator, String p_text)
	{
		IsClickable(p_locator);
		Select list = new Select(driver.findElement(p_locator));
		list.deselectByVisibleText(p_text);
	}
	
	public static List<WebElement> GetAllSelectedOptions(By p_locator)
	{
		IsClickable(p_locator);
		Select list = new Select(driver.findElement(p_locator));
		return list.getAllSelectedOptions();
	}
	
	public static WebElement GetFirstSelectedOption(By p_locator)
	{
		IsClickable(p_locator);
		Select list = new Select(driver.findElement(p_locator));
		return list.getFirstSelectedOption();
	}
	
	public static void UploadFile(By p_locatorUpload, String p_path)
	{
		IsClickable(p_locatorUpload);
		driver.findElement(p_locatorUpload).sendKeys(p_path);		
	}

	/**
	 * @param text: Texto que ir� aparecer caso a mensagem n�o seja compat�vel com a da a��o
	 * @param locator: locator da caixa que possui a mensagem
	 * @param msg: a mensagem que deve aparece
	 */
	public static void CompareLocatorTextWithMsg(String p_msg, By p_locator, String p_text)	{
		IsLocated(p_locator);
		assertThat(p_msg, GetText(p_locator), is(p_text)); 
	}

	public static void CompareLocatorContainTextWithMsg(String p_msg, By p_locator, String p_text)	{
		IsLocated(p_locator);
		assertTrue(p_msg, GetText(p_locator).contains(p_text)); 
	}
	
	public static void CompareLocatorNotContainTextWithMsg(String p_msg, By p_locator, String p_text)	{
		IsLocated(p_locator);
		assertFalse(p_msg, GetText(p_locator).contains(p_text)); 
	}
	
	public static void Enter(By p_locator)
	{
		driver.findElement(p_locator).sendKeys(Keys.ENTER);
	}
	
	//// jun��es

	public static void ClearAndFillOut(By p_locator, String p_text){
		ClearText(p_locator);
		FillOutWithText(p_locator, p_text);
	}

	public static void IsClickableAndClick(By p_locator){
		IsClickable(p_locator);
		Click(p_locator);
	}

	public static void IsClickableClearAndFillOut(By p_locator, String p_text)
	{
		IsClickable(p_locator);
		ClearAndFillOut(p_locator, p_text);
	}
	
	public static void IsClickableAndSelectCheckOrRadio(By p_locator)
	{
		IsClickable(p_locator);
		SelectCheckOrRadio(p_locator);
	}
	
	public static void IsClickableAndDeselectCheckOrRadio(By p_locator)
	{
		IsClickable(p_locator);
		DeselectCheck(p_locator);
	}
}
