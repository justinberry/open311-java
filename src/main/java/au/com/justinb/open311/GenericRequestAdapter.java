package au.com.justinb.open311;

import au.com.justinb.open311.model.ModelObject;
import au.com.justinb.open311.model.resource.BaseResource;
import org.restlet.engine.Engine;
import org.restlet.engine.converter.ConverterHelper;
import org.restlet.ext.jackson.JacksonConverter;
import org.restlet.resource.ClientResource;

import java.util.ArrayList;
import java.util.List;

public class GenericRequestAdapter {

  public GenericRequestAdapter() {
    List<ConverterHelper> converters = Engine.getInstance().getRegisteredConverters();
    converters.add(new JacksonConverter());
  }

  public ArrayList<ModelObject> getList(String requestString, Class<? extends BaseResource> resourceClazz) {
    ClientResource cr = new ClientResource(requestString);
    return cr.wrap(resourceClazz).retrieveList();
  }

  public ModelObject get(String requestString, Class<? extends BaseResource> resourceClazz) {
    ClientResource cr = new ClientResource(requestString);
    ArrayList<ModelObject> list = cr.wrap(resourceClazz).retrieveList();
    return list.get(0);
  }
}