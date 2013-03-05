package au.com.justinb.open311.model

import au.com.justinb.open311.GenericRequestAdapter
import au.com.justinb.open311.Open311
import au.com.justinb.open311.model.ServiceRequest
import au.com.justinb.open311.model.resource.ServiceRequestResource
import au.com.justinb.open311.util.Format
import org.junit.runner.RunWith
import org.spockframework.runtime.Sputnik
import spock.lang.Shared
import spock.lang.Specification

@RunWith(Sputnik)
class ServiceRequestTest extends Specification {

  def requestAdapter = new GenericRequestAdapter<ServiceRequest>(ServiceRequest.class)
  def serviceRequest = new ServiceRequest()

  def setup() {
    serviceRequest.serviceCode = "001"
    serviceRequest.latitude = "37.76524078"
    serviceRequest.longtitude = "-122.4212043"

    Open311.setBaseUrl("http://localhost:4567")
  }

  def "should create service request"() {
    when:
    requestAdapter.create(serviceRequest)

    and:
    def requests = requestAdapter.getList(ServiceRequestResource.class, Format.JSON)
    then:
    requests.size() == 15
  }

  def "should retrieve a list of service requests"() {
    when:
    def requests = requestAdapter.getList(ServiceRequestResource.class, Format.JSON)
    then:
    requests.size() == 15
    requests.get(0).serviceCode == serviceRequest.serviceCode
    requests.get(0).lat == serviceRequest.lat
    requests.get(0).long == serviceRequest.long
  }

//  def "should retrieve a single service request"() {
//    when:
//    def request = requestAdapter.get("http://localhost:4567/requests/3b81bb6a-1318-410d-8f4f-95e5dc9facad.json", ServiceRequestResource.class)
//    then:
//    request != null
//  }
}
