package edu.hcmuaf.fit.itse.noon.group03.constant;

public class Constant {

	public static String GOOGLE_CLIENT_ID = "1047932472616-4l3car2t55h2d9gu51gfafl5ejfhangu.apps.googleusercontent.com";
	public static String GOOGLE_CLIENT_SECRET = "fSbBDcioPIgvtYs3GQrvrJtf";
	public static String GOOGLE_REDIRECT_URI = "https://localhost:8443/itse_noon_group03/LoginController?LoginType=google";
	public static String GOOGLE_LINK_GET_TOKEN = "https://accounts.google.com/o/oauth2/token";
	public static String GOOGLE_LINK_GET_USER_INFO = "https://www.googleapis.com/userinfo/v2/me?fields=email%2Cfamily_name%2Cgiven_name%2Cid&access_token=";
	public static String GOOGLE_GRANT_TYPE = "authorization_code";

	public static String FACEBOOK_APP_ID = "1291754064336511";
	public static String FACEBOOK_APP_SECRET = "64211c943cb062c976105be6764241fa";
	public static String FACEBOOK_REDIRECT_URL = "https://localhost:8443/itse_noon_group03/LoginController?LoginType=fb";
	public static String FACEBOOK_LINK_GET_TOKEN = "https://graph.facebook.com/oauth/access_token?client_id=%s&client_secret=%s&redirect_uri=%s&code=%s";
	public static String FACEBOOK_LINK_GET_USER_INFO = "https://graph.facebook.com/me?fields=id,name,email&access_token=";
}
