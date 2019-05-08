package edu.hcmuaf.fit.itse.noon.group03.util;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import edu.hcmuaf.fit.itse.noon.group03.constant.Constant;

public class FBUtils {
	public static String getToken(final String code) throws ClientProtocolException, IOException {
		String link = String.format(Constant.FACEBOOK_LINK_GET_TOKEN, Constant.FACEBOOK_APP_ID,
				Constant.FACEBOOK_APP_SECRET, Constant.FACEBOOK_REDIRECT_URL, code);
		String response = Request.Get(link).execute().returnContent().asString();
		JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
		String accessToken = jobj.get("access_token").getAsString();
		return accessToken;
	}

	public static String getUserInfo(String accessToken) throws ClientProtocolException, IOException {
		String link = Constant.FACEBOOK_LINK_GET_USER_INFO + accessToken;
		String response = Request.Get(link).execute().returnContent().asString();
		System.out.println(link);
		JsonObject json = new Gson().fromJson(response, JsonObject.class);
//		UserAccount usr = new UserAccount();
//		usr.setEmail(json.get("email") == null ? null : json.get("email").getAsString());
//		usr.setFacebookID(json.get("id").getAsString());
		return json.get("id").getAsString();
//		FacebookClient facebookClient = new DefaultFacebookClient(accessToken, Constant.FACEBOOK_APP_SECRET,
//				Version.LATEST);
//		System.out.println(accessToken);
//		return null;
		// return facebookClient.fetchObject("me", User.class);
	}

//	public static void main(String[] args) throws ClientProtocolException, IOException {
//		String code = "AQCToxsjizq-vje3ErNrehxQvLHRzDpuF9pioDJ3if2TFyJi7kV7TgDtIzANNMs6mFe6od-RVDWCfgEzbI35yAsYzfDp25k9XqQdFMH49s1NAK_sir4nzl6tJ1p-8LUoyYxwvkdkrYFsGKUFGjstceXpJDUamwtrgdx6nfVXtEjjtz0NZe6yJTRxS-50Xl_E-5bIY2dPqF5HBoklIFqZoBx02ys6AgfpcV3QCfyyxY7DpaVis8RpONlPzIg11yqJLA9PhiW1pWjYELGmR9FMhUpVQeGfm0DvCZCUcjjxXX8Fw4AKEFpC3bL6KDvfAnN7ntSHBXm56kep6dMYk5A0TnfE#_=_";
//		String accessToken = getToken(code);
//		System.out.println(accessToken);
//
//		UserAccount user = getUserInfo(accessToken);
//		System.out.println(user.getEmail());
//	}

}
