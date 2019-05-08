package edu.hcmuaf.fit.itse.noon.group03.util;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import edu.hcmuaf.fit.itse.noon.group03.constant.Constant;

public class GoogleUtils {
	public static String getToken(final String code) throws ClientProtocolException, IOException {
		String response = Request.Post(edu.hcmuaf.fit.itse.noon.group03.constant.Constant.GOOGLE_LINK_GET_TOKEN)
				.bodyForm(Form.form().add("client_id", Constant.GOOGLE_CLIENT_ID)
						.add("client_secret", Constant.GOOGLE_CLIENT_SECRET)
						.add("redirect_uri", Constant.GOOGLE_REDIRECT_URI).add("code", code)
						.add("grant_type", Constant.GOOGLE_GRANT_TYPE).build())
				.execute().returnContent().asString();
		JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
		String accessToken = jobj.get("access_token").getAsString();
		return accessToken;
	}

	public static String getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
		String link = Constant.GOOGLE_LINK_GET_USER_INFO + accessToken;
		String response = Request.Get(link).execute().returnContent().asString();
		System.out.println(response);
		// GooglePojo googlePojo = new Gson().fromJson(response, GooglePojo.class);
		JsonObject json = new Gson().fromJson(response, JsonObject.class);
//		UserAccount usr = new UserAccount();
//		usr.setEmail(json.get("email").getAsString());
		return json.get("id").getAsString();
//		return usr;
	}
}