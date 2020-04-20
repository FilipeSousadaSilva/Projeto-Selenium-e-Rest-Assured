package com.javaautomation.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public abstract class Page {

  protected WebDriver driver;

  /*
   * Constructor injecting the WebDriver interface
   * 
   * @param webDriver
   */
  public Page(WebDriver driver) {
    this.driver = driver;
  }

  public String getTitle() {
    return driver.getTitle();
  }
  
  public void click(WebElement element) {
	  waitElementClickable(element);
	  element.click();
  }
  
  public void waitElementClickable(WebElement element) {
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  wait.
	  	until(ExpectedConditions.
	  			elementToBeClickable(element)); 
  }
  
  public void waitElementVisibility(WebElement element) {
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  wait.
	  	until(ExpectedConditions.
	  			visibilityOf(element)); 
  }
  
  public void insertText(WebElement element, String text) {
	  waitElementClickable(element);
	  System.out.println("Texto preenchido: "+ text);
	  element.sendKeys(text);
  }
  
  public String getText(WebElement element) {
	  waitElementVisibility(element);
	  return element.getText();
  }
}
