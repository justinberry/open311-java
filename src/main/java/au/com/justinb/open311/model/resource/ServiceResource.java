package au.com.justinb.open311.model.resource;

import au.com.justinb.open311.model.ServiceList;
import org.restlet.resource.Get;

import java.util.ArrayList;

public interface ServiceResource extends BaseResource {

  @Get
  @Override
  ArrayList<ServiceList> retrieveList();
}
