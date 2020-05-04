package tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.restassured.http.ContentType;

public class TesteAPI {
	

	@Before
	public void setUp() throws Exception {
		

	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void test() {
		
		String uriBase = "https://postman-echo.com/get";
		given()
			.relaxedHTTPSValidation()
			.param("foo1", "bar1")
			.param("foo2", "bar2")
		.when()
			.get(uriBase)
		.then()
			.statusCode(200) // O status http retornado foi 200
			.contentType(ContentType.JSON) // O response foi retornado no formato JSON
			.body("headers.host", is("postman-echo.com")) // A chave “host” possui exatamente o valor “postman-echo.com”
			.body("args.foo1", containsString("bar")); //A chave “foo1” contém o valor “bar”
		
		
	}

}
