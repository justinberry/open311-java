package au.com.justinb.open311.mapping;

import au.com.justinb.open311.builder.QueryBuilder;
import au.com.justinb.open311.builder.ServiceRequestQueryBuilder;
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
}
