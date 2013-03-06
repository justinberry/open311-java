package au.com.justinb.open311.mapping;

import au.com.justinb.open311.Open311;
import au.com.justinb.open311.model.ServiceRequest;
import au.com.justinb.open311.model.resource.BaseResource;
import au.com.justinb.open311.model.resource.ServiceRequestResource;
import au.com.justinb.open311.util.Format;

import java.util.HashMap;
import java.util.Map;

public class RequestMappings {

  private static final Map<Class, String> requestMappings = new HashMap<Class, String>();
  private static final Map<Class, String> listRequestMappings = new HashMap<Class, String>();
  private static final Map<Class, Class<? extends BaseResource>> resourceMappings
    = new HashMap<Class, Class<? extends BaseResource>>();

  static {
    requestMappings.put(ServiceRequest.class, "requests/${id}.${format}");
    listRequestMappings.put(ServiceRequest.class, "requests.${format}");
    resourceMappings.put(ServiceRequest.class, ServiceRequestResource.class);
  }

  public static Class<? extends BaseResource> getResource(Class modelClass) {
    return resourceMappings.get(modelClass);
  }

  public static String getUrl(Class requestType, Format format, String id) {

    String path = requestMappings.get(requestType);

    if (path == null) {
      throw new RuntimeException("No Open311 list mapping found for type " + requestType);
    }

    path = path.replaceAll("\\$\\{id\\}", id);
    path = path.replaceAll("\\$\\{format\\}", format.getType());

    return Open311.getBaseUrl() + path;
  }

  public static String getListUrl(Class requestType, Format format) {
    String path = listRequestMappings.get(requestType);
    path = path.replaceAll("\\$\\{format\\}", format.getType());

    if (path == null) {
      throw new RuntimeException("No Open311 mapping found for type " + requestType);
    }

    return Open311.getBaseUrl() + path;
  }
}
