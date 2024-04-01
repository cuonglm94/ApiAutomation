package StepsDefinition.DogCeoBreedApi;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertEquals;

import java.lang.reflect.Array;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import common.JsonUtils;
import common.RequestUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class CheckBreedValidationSteps {
	String url, method;
	HttpResponse<String> response;
	String requestBody;
	
	@Given("I have valid URL and method of BreedApi")
	public void i_have_valid_url_and_method(List<Map<String, String>> givenTable) {
		//url="https://reqres.in/api/users?page=2";
		Map<String, String> row1= givenTable.get(0);
		url = row1.get("URL");
		method = row1.get("method").trim();
	}
	
	@When("I send request with {string} and {string}")
	public void i_send_request_with_request_body(String fieldName, String value) {
		RequestUtils requestUtils =  new RequestUtils();
		String newUrl;
		if(value.equalsIgnoreCase("missing")) {
			newUrl= url.replace(fieldName, "");
		}else {
			newUrl= url.replace(fieldName, value);
		}
		response = requestUtils.sendRequest(newUrl, method, requestBody);
	}

	
	@Then("I get {int} and {string}")
	public void i_get_response_body_with_page(int expectedStatusCode, String expectedMessage) {
		String responBody= response.body();
		JsonUtils jsonUtils= new JsonUtils();
		String actualMessage=jsonUtils.getValueByKey(responBody, "message"); 
		assertEquals(response.statusCode(),expectedStatusCode);
		assertEquals(actualMessage,expectedMessage);

	}
	

}
