package au.com.justinb.open311.model.resource;

import org.restlet.resource.ClientResource;
import org.restlet.resource.Get;

import java.util.ArrayList;

public interface BaseResource<T> {

  @Get
  ArrayList<T> retrieveList();
}
