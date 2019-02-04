package module.github.api.integration;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class Utility {
	HttpClient httpClient = HttpClientBuilder.create().build();
	HttpGet getRequest = null;
	HttpPost postRequest = null;
	HttpPatch patchRequest = null;
	HttpResponse response = null;
	String result = "";

	public String makeGetCall(String url, String token) {

		getRequest = new HttpGet(url);
		getRequest.addHeader("Accept", "application/vnd.github.squirrel-girl-preview");
		getRequest.addHeader("Content-Type", "application/json");
		getRequest.addHeader("Authorization", "Bearer " + token);
		try {
			response = httpClient.execute(getRequest);
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
			}
			result = EntityUtils.toString(response.getEntity());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Sorry, unable to process your request...");
		}
		return result;
	}

	public String makePostCall(String url, String token, JSONObject obj) {
		postRequest = new HttpPost(url);
		postRequest.addHeader("Authorization", "Bearer " + token);
		postRequest.setHeader("Content-Type", "application/json");
		postRequest.setHeader("Accept", "application/json");
		try {
			postRequest.setEntity(new StringEntity(obj.toString()));
			response = httpClient.execute(postRequest);
			if (response.getStatusLine().getStatusCode() != 201) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
			}
			result = EntityUtils.toString(response.getEntity());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public String makePatchCall(String url, String token, JSONObject obj) {
		patchRequest = new HttpPatch(url);
		patchRequest.addHeader("Authorization", "Bearer " + token);
		patchRequest.setHeader("Content-Type", "application/json");
		patchRequest.setHeader("Accept", "application/json");
		try {
			patchRequest.setEntity(new StringEntity(obj.toString()));
			response = httpClient.execute(patchRequest);
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
			}
			result = EntityUtils.toString(response.getEntity());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
