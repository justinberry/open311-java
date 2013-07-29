package au.com.justinb.open311;

import au.com.justinb.open311.builder.QueryBuilder;
import au.com.justinb.open311.builder.SimpleQueryBuilder;
import au.com.justinb.open311.factory.QueryBuilderFactory;
import au.com.justinb.open311.mapping.RequestMappings;
import au.com.justinb.open311.model.ServiceRequest;
import au.com.justinb.open311.model.resource.BaseResource;
import au.com.justinb.open311.util.Format;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.PropertyNamingStrategy;
import org.codehaus.jackson.map.SerializationConfig;
import org.restlet.Request;
import org.restlet.data.Method;
import org.restlet.engine.Engine;
import org.restlet.ext.jackson.JacksonConverter;
import org.restlet.representation.EmptyRepresentation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import java.util.*;

public class GenericRequestAdapter<T> {

  private final ClientResource clientResource;

  private final QueryBuilderFactory queryBuilderFactory;

  private Class modelClass;
  private Class<? extends BaseResource> resourceClass;

  private Format format = Format.JSON;

  private static final ObjectMapper OBJECT_MAPPER = new JacksonConverter().getObjectMapper();

  static {
    Engine.getInstance().getRegisteredConverters().add(new JacksonConverter());

    OBJECT_MAPPER.setPropertyNamingStrategy(
      PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
    OBJECT_MAPPER.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
  }

  public GenericRequestAdapter(Class aModelClass) {
    modelClass = aModelClass;
    resourceClass = RequestMappings.getResource(modelClass);
    queryBuilderFactory = new QueryBuilderFactory();
    clientResource = new ClientResource("");
    clientResource.setChallengeResponse(Open311.getAuthetication());
  }

  public List<T> list(Map<String, String> extraProperties) throws Open311Exception {
    String url = RequestMappings.getListUrl(modelClass, format);

    QueryBuilder simpleQueryBuilder = queryBuilderFactory
      .newSimpleQueryBuilder()
      .withExtraProperties(extraProperties);

    clientResource.setRequest(new Request(Method.GET, url + simpleQueryBuilder.build()));

    return retrieveResources();
  }

  public List<T> list() throws Open311Exception {
    return list(new HashMap<String, String>());
  }

  public T get(String id) throws Open311Exception {
    String url = RequestMappings.getUrl(modelClass, format, id);
    clientResource.setRequest(new Request(Method.GET, url));

    List<T> modelObjects = retrieveResources();
    return modelObjects.size() > 0 ? modelObjects.get(0) : null;
  }

  @SuppressWarnings("unchecked")
  private List<T> retrieveResources() throws Open311Exception {

    List<T> modelObjects = new ArrayList<T>();
    try {
      List<LinkedHashMap> objectMaps = clientResource.wrap(resourceClass).retrieveList();
      for (LinkedHashMap hm : objectMaps) {
        modelObjects.add((T) OBJECT_MAPPER.convertValue(hm, modelClass));
      }
    } catch (ResourceException re) {
      throw new Open311Exception(re);
    }

    return modelObjects;
  }

  public void create(T modelObject) throws Open311Exception {

    String listUrlOfRequest = RequestMappings.getListUrl(modelObject.getClass(), format);
    String requestString = queryBuilderFactory.newQueryBuilder(modelObject).build();
    StringBuilder builder = new StringBuilder(listUrlOfRequest).append(requestString);

    clientResource.setRequest(new Request(Method.POST, builder.toString()));
    try {
      clientResource.post(new EmptyRepresentation());
    } catch (ResourceException re) {
      throw new Open311Exception(re);
    }
  }
}