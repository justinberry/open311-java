package au.com.justinb.open311;

import au.com.justinb.open311.builder.QueryBuilder;
import au.com.justinb.open311.mapping.RequestMappings;
import au.com.justinb.open311.model.resource.BaseResource;
import au.com.justinb.open311.util.Format;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.PropertyNamingStrategy;
import org.codehaus.jackson.map.SerializationConfig;
import org.restlet.Request;
import org.restlet.data.Method;
import org.restlet.ext.jackson.JacksonConverter;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class GenericRequestAdapter<T> {

  private final ClientResource clientResource = new ClientResource("");

  private Class modelClass;
  private Class<? extends BaseResource> resourceClass;

  private Format format = Format.JSON;

  private static final ObjectMapper OBJECT_MAPPER = new JacksonConverter().getObjectMapper();

  static {
    OBJECT_MAPPER.setPropertyNamingStrategy(
      PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
    OBJECT_MAPPER.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
  }

  public GenericRequestAdapter(Class aModelClass, Format aFormat) {
    this(aModelClass);
    format = aFormat;
  }

  public GenericRequestAdapter(Class aModelClass) {
    modelClass = aModelClass;
    resourceClass = RequestMappings.getResource(modelClass);
  }

  public List<T> list() {
    String url = RequestMappings.getListUrl(modelClass, format);
    clientResource.setRequest(new Request(Method.GET, url));

    return retrieveResources();
  }

  public T get(String id) {
    String url = RequestMappings.getUrl(modelClass, format, id);
    clientResource.setRequest(new Request(Method.GET, url));

    List<T> modelObjects = retrieveResources();
    return modelObjects.size() > 0 ? modelObjects.get(0) : null;
  }

  @SuppressWarnings("unchecked")
  private List<T> retrieveResources() {

    List<T> modelObjects = new ArrayList<T>();
    try {
      ArrayList<LinkedHashMap> objectMaps = clientResource.wrap(resourceClass).retrieveList();
      for (LinkedHashMap hm : objectMaps) {
        modelObjects.add((T) OBJECT_MAPPER.convertValue(hm, modelClass));
      }
    } catch (ResourceException re) {
      System.out.println("ResourceException: " + re);
    }

    return modelObjects;
  }

  public void create(T modelObject) {

    String listUrlOfRequest = RequestMappings.getListUrl(modelObject.getClass(), format);
    String requestString = RequestMappings.getQueryBuilder(modelObject).build();
    StringBuilder builder = new StringBuilder(listUrlOfRequest).append(requestString);

    clientResource.setRequest(new Request(Method.POST, builder.toString()));
    try {
      clientResource.post(modelObject);
    } catch (ResourceException re) {
      System.out.println("ResourceException: " + re);
    }
  }
}