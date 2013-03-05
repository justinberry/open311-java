package au.com.justinb.open311;

public class Open311 {

  private static String baseUrl = "http://localhost/";

  public static void setBaseUrl(String url) {
    baseUrl = url;
  }

  public static String getBaseUrl() {
    return baseUrl.endsWith("/") ? baseUrl : baseUrl + "/";
  }
}
