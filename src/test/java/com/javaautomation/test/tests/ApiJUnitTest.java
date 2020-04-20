package com.javaautomation.test.tests;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;

public class ApiJUnitTest extends JUnitTestBase {

  @Test
  public void getRequestAndValidateReturnFromApi() {
	  RestAssured.baseURI = apiUrl;
	  RestAssured.when().get("/").
	  	then().statusCode(200).body("userId", equalTo(1),"id",equalTo(1), "title",
	  			equalTo("delectus aut autem"), "completed", equalTo(false));
  }
}
