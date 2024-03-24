package common;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;

public class Request {
//	public String url;
//	public HttpMethod method;
//	public String requestBody;

	HttpRequest request;
	HttpResponse<String> response;

	public Request() {
		request = null;
	}

	// send method GET
	public HttpResponse<String> sendGetRequest(String url) {
		try {
			request = (HttpRequest) HttpRequest.newBuilder().uri(new URI(url)).GET().build();
			response = HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Send GET request incorrectly");
			e.printStackTrace();
		}
		return this.response;
	}

	public HttpResponse<String> sendPostRequest(String url, String requestBody) {
		try {
			request = (HttpRequest) HttpRequest.newBuilder().uri(new URI(url))
					.POST(BodyPublishers.ofString(requestBody, StandardCharsets.UTF_8)).build();
			response = HttpClient.newHttpClient().send(request, BodyHandlers.ofString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Send POST request incorrectly");
			e.printStackTrace();
		}
		return this.response;
	}

}
