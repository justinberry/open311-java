package au.com.justinb.open311.mapping;

import au.com.justinb.open311.builder.QueryBuilder;
import au.com.justinb.open311.builder.ServiceRequestBuilder;
import au.com.justinb.open311.model.ServiceRequest;

public class RequestMapping {

  private final String url;
  private final String listUrl;
  private final Class resourceClass;

  public RequestMapping(String aUrl, String aListUrl, Class aResourceClass) {
    url = aUrl;
    listUrl = aListUrl;
    resourceClass = aResourceClass;
  }

  public String getUrl() {
    return url;
  }

  public String getListUrl() {
    return listUrl;
  }

  public Class getResourceClass() {
    return resourceClass;
  }

  public QueryBuilder getQueryBuilder(Object modelObject) {
    if (modelObject.getClass() == ServiceRequest.class) {
      return new ServiceRequestBuilder((ServiceRequest) modelObject);
    } else {
      throw new RuntimeException("No mapping found for " + modelObject);
    }
  }
}
