package StepsDefinition.SingleUerApi;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertEquals;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckResponseSendRequestSuccessfullySingleUserSteps {
	String url;
	int actualStatusCode;

	@Given("I have valid URL and method.")
	public void i_have_valid_url_and_method() {
		url = "https://reqres.in/api/users/2";
	}

	@When("I send request")
	public void i_send_request() {
		HttpResponse<String> response = null;
		try {
			HttpRequest request = HttpRequest.newBuilder().uri(new URI(url)).GET().build();
			response = HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
			actualStatusCode = response.statusCode();
			// String body = response.body();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Send get request fail");
		}
	}

	@Then("I get status code and response")
	public void i_get_status_code_and_response() {
		assertEquals(actualStatusCode, 200);
	}

}