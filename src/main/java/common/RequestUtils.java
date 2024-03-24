package common;

import java.net.http.HttpResponse;

public class RequestUtils {
	
	public HttpResponse<String> sendRequest(String url, String method, String requestBody){
		HttpResponse<String> reponse = null;
		Request request= new Request();
		if(method.equalsIgnoreCase(HttpMethod.GET.toString())) {
			reponse = request.sendGetRequest(url);
		}else if(method.equalsIgnoreCase(HttpMethod.POST.toString())) {
			reponse = request.sendPostRequest(url, requestBody);
		}
		return reponse;
	}

}
