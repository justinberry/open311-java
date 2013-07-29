package au.com.justinb.open311.mapping;

import au.com.justinb.open311.Open311;
import au.com.justinb.open311.builder.QueryBuilder;
import au.com.justinb.open311.factory.QueryBuilderFactory;
import au.com.justinb.open311.model.ServiceList;
import au.com.justinb.open311.model.ServiceRequest;
import au.com.justinb.open311.model.resource.BaseResource;
import au.com.justinb.open311.model.resource.ServiceRequestResource;
import au.com.justinb.open311.model.resource.ServiceResource;
import au.com.justinb.open311.util.Format;

import java.util.HashMap;
import java.util.Map;

public class RequestMappings {

  private static final Map<Class, RequestMapping> requestMappings = new HashMap<Class, RequestMapping>();

  static {

    requestMappings.put(ServiceRequest.class, new RequestMapping("requests/${id}.${format}",
      "requests.${format}",
      ServiceRequestResource.class));

    requestMappings.put(ServiceList.class, new RequestMapping("services/${id}.${format}",
      "services.${format}",
      ServiceResource.class));

//    listRequestMappings.put(new ArrayList<ServiceList>().getClass(), "services.${format}");
  }

  public static Class<? extends BaseResource> getResource(Class modelClass) {
    return requestMappings.get(modelClass).getResourceClass();
  }

  public static String getUrl(Class requestType, Format format, String id) {

    String path = requestMappings.get(requestType).getUrl();

    if (path == null) {
      throw new RuntimeException("No Open311 list mapping found for type " + requestType);
    }

    path = path.replaceAll("\\$\\{id\\}", id);
    path = path.replaceAll("\\$\\{format\\}", format.getType());

    return Open311.getBaseUrl() + path;
  }

  public static String getListUrl(Class requestType, Format format) {
    String path = requestMappings.get(requestType).getListUrl();

    if (path == null) {
      throw new RuntimeException("No Open311 mapping found for type " + requestType);
    }

    path = path.replaceAll("\\$\\{format\\}", format.getType());

    return Open311.getBaseUrl() + path;
  }
}
