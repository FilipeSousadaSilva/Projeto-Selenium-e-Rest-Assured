package com.javaautomation.test.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test; 
import org.junit.jupiter.api.Assertions;

import org.openqa.selenium.support.PageFactory;

import com.javaautomation.test.pages.HomePage;
import com.javaautomation.test.services.DirectorService;
import com.javaautomation.test.services.FilmService;

public class GoogleJUnitTest extends JUnitTestBase {

  private HomePage homepage;

  @BeforeEach
  public void initPageObjects() {
    homepage = PageFactory.initElements(driver, HomePage.class);
  }

  @Test
  public void testSearchGoogleReturnResults() {
	  // running system methods
	  FilmService film = new FilmService();
	  DirectorService director = new DirectorService();
	  film.insertFilm(FilmName, FilmReleaseYear);
	  director.insertDirector(DirectorName, DirectorBirthDate);
	  // Initiate
	  driver.get(baseUrl);
	  // Action
	  homepage.searchByFilmAndDirector(director.getDirectorToSearch(), film.getFilmToSearch());
	  // Assert
	  Assertions.assertEquals("Resultado da busca foi encontrado", homepage.verifyIfPageReturnResults());
  }
}
