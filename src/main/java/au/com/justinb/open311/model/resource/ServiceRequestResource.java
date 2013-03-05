package au.com.justinb.open311.model.resource;

import au.com.justinb.open311.model.ServiceRequest;
import org.restlet.resource.Get;

import java.util.ArrayList;

public interface ServiceRequestResource extends BaseResource<ServiceRequest> {

  @Get
  ArrayList<ServiceRequest> retrieveList();
}