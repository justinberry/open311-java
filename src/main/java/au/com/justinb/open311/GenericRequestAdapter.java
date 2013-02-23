package au.com.justinb.open311;

import au.com.justinb.open311.model.ModelObject;
import au.com.justinb.open311.model.resource.BaseResource;
import au.com.justinb.open311.util.ReflectionUtils;
import org.restlet.Request;
import org.restlet.data.Method;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import java.util.ArrayList;

public class GenericRequestAdapter<T extends ModelObject> {

  private ClientResource clientResource = new ClientResource("");

  public ArrayList<T> getList(String uri, Class<? extends BaseResource> resourceClazz) {
    clientResource.setRequest(new Request(Method.GET, uri));
    return clientResource.wrap(resourceClazz).retrieveList();
  }

  public T get(String uri, Class<? extends BaseResource> resourceClazz) {
    clientResource.setRequest(new Request(Method.GET, uri));
    ArrayList<T> list = clientResource.wrap(resourceClazz).retrieveList();
    return list.size() > 0 ? list.get(0) : null;
  }

  public void create(String baseUri, T modelObject) {
    String requestUri = ReflectionUtils.constructQueryString(baseUri, modelObject);
    clientResource.setRequest(new Request(Method.POST, requestUri));
    try {
      clientResource.post(modelObject);
    } catch (ResourceException re) {
      System.out.println("ResourceException: " + re);
    }
  }
}