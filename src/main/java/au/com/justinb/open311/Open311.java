package au.com.justinb.open311;

import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;

public class Open311 {

  private static String baseUrl = "http://localhost/";

  private static ChallengeResponse challengeResponse;

  public static void setBaseUrl(String url) {
    baseUrl = url;
  }

  public static void setBasicAuth(String username, String password) {
    challengeResponse = new ChallengeResponse(ChallengeScheme.HTTP_BASIC,
      username, password);
  }

  public static ChallengeResponse getAuthetication() {
    return challengeResponse;
  }

  public static String getBaseUrl() {
    return baseUrl.endsWith("/") ? baseUrl : baseUrl + "/";
  }
}
