package com.qa.rest.tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;



public class GetCallBDD {
	
	@Test
	public void test_numberOfData() {
		given().
		when().
		get("https://reqres.in/api/users").
		then().
		assertThat().body("data", hasSize(3));
	}

	@Test
	public void test_Name() {
		given().
		when().
		get("https://reqres.in/api/users").
		then().
		assertThat().body("data.first_name[0]", containsString("George"));
	}
	
	@Test
	public void test_StatusCode() {
		given().
		when().
		get("https://reqres.in/api/users").
		then().
		assertThat().statusCode(200);
	}
	
	@Test
	public void test_totalPages() {
		given().
		when().
		get("https://reqres.in/api/users").
		then().
		assertThat().body("total_pages", equalTo(4));
	}
	
	@Test
	public void test_responseHeader() {
		given().
		when().
		get("https://reqres.in/api/users").
		then().
		assertThat().header("Transfer-Encoding", "chunked");
}
	@Test
	public void test_cookiesResponse() {
		given().
		when().
		get("https://reqres.in/api/users").
		then().
		assertThat().cookie("__cfduid");
}
	@Test
	public void test_LastNameLastEntry() {
		given().
		when().
		get("https://reqres.in/api/users").
		then().
		assertThat().body("data.last_name[2]", containsString("Wong"));
	}
	
}