package au.com.justinb.open311.mapping;

import au.com.justinb.open311.Open311;
import au.com.justinb.open311.model.ServiceRequest;
import au.com.justinb.open311.util.Format;

import java.util.HashMap;
import java.util.Map;

public class RequestMappings {

  private static final Map<Class, String> requestMappings = new HashMap<Class, String>();
  private static final Map<Class, String> listMappings = new HashMap<Class, String>();

  static {
    requestMappings.put(ServiceRequest.class, "requests/${id}.${format}");
    listMappings.put(ServiceRequest.class, "requests.${format}");
  }

  public static String getUrlOfRequest(Class requestType, Format format, String id) {

    String path = requestMappings.get(requestType);

    if (path == null) {
      throw new RuntimeException("No Open311 list mapping found for type " + requestType);
    }

    path = path.replaceAll("\\$\\{id\\}", id);
    path = path.replaceAll("\\$\\{format\\}", format.getType());

    return Open311.getBaseUrl() + path;
  }

  public static String getListUrlOfRequest(Class requestType, Format format) {
    String path = listMappings.get(requestType);
    path = path.replaceAll("\\$\\{format\\}", format.getType());

    if (path == null) {
      throw new RuntimeException("No Open311 mapping found for type " + requestType);
    }

    return Open311.getBaseUrl() + path;
  }
}
