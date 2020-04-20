package com.javaautomation.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Sample page
 */
public class HomePage extends Page {

  @FindBy(xpath = "//input[@title='Pesquisar']")
  @CacheLookup
  public WebElement input;
  
  @FindBy(css = "div#result-stats")
  @CacheLookup
  public WebElement result;
  
  public HomePage(WebDriver webDriver) {
    super(webDriver);
  }
  
  public void searchByFilmAndDirector(String directorName, String filmName){
	  this.insertText(input, filmName + " dirigido por " + directorName);
	  input.submit();
  }
  
  public String verifyIfPageReturnResults() {
	  System.out.println("Resultado extraído: " + this.getText(result));
	  
	  if (this.getText(result).contains("Aproximadamente ") 
			  && this.getText(result).contains("resultados")) {
		  return "Resultado da busca foi encontrado";
	  }
	  
	  return "Resultado não encontrado";
  }
}
