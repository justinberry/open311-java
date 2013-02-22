package au.com.justinb.open311.model.resource;

import au.com.justinb.open311.model.ModelObject;
import org.restlet.resource.Get;

import java.util.ArrayList;

public interface BaseResource<T extends ArrayList> {

  @Get
  T retrieveList();
}
