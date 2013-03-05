package au.com.justinb.open311;

import au.com.justinb.open311.mapping.RequestMappings;
import au.com.justinb.open311.model.resource.BaseResource;
import au.com.justinb.open311.util.Format;
import au.com.justinb.open311.util.ReflectionUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.restlet.Request;
import org.restlet.data.Method;
import org.restlet.ext.jackson.JacksonConverter;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class GenericRequestAdapter<T> {

  private ClientResource clientResource = new ClientResource("");

  // There's gotta be a better way of doing this URL mapping stuff..
  private Class modelClass;

  public GenericRequestAdapter(Class aModelClass) {
    modelClass = aModelClass;
  }

  public List<T> getList(Class<? extends BaseResource> resourceClazz, Format format) {
    String url = RequestMappings.getListUrlOfRequest(modelClass, format);
    clientResource.setRequest(new Request(Method.GET, url));

    return retrieveResources(resourceClazz);
  }

  public T get(Class<? extends BaseResource> resourceClazz, String id, Format format) {
    String path = RequestMappings.getUrlOfRequest(modelClass, id, format);

    List<T> modelObjects = retrieveResources(resourceClazz);
    return modelObjects.size() > 0 ? modelObjects.get(0) : null;
  }

  private List<T> retrieveResources(Class<? extends BaseResource> resourceClazz) {
    List<T> modelObjects = new ArrayList<T>();
    ArrayList<LinkedHashMap> objectMaps = clientResource.wrap(resourceClazz).retrieveList();
    ObjectMapper objectMapper = new JacksonConverter().getObjectMapper();
    for (LinkedHashMap hm : objectMaps) {
      modelObjects.add((T)objectMapper.convertValue(hm, modelClass));
    }
    return modelObjects;
  }

  public void create(T modelObject) {
    String requestUri = ReflectionUtils.constructQueryString(Open311.getBaseUrl(), modelObject);

    clientResource.setRequest(new Request(Method.POST, requestUri));
    try {
      clientResource.post(modelObject);
    } catch (ResourceException re) {
      System.out.println("ResourceException: " + re);
    }
  }
}