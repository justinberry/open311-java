package au.com.justinb.open311.model.resource;

import au.com.justinb.open311.model.ModelObject;
import au.com.justinb.open311.model.ServiceRequest;
import au.com.justinb.open311.model.list.ServiceRequestList;
import org.restlet.resource.Get;

import java.util.ArrayList;

public interface ServiceRequestResource extends BaseResource {

  @Get
  @Override
  ServiceRequestList retrieveList();
}
