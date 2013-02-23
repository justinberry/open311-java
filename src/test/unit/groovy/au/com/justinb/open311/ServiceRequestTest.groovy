package au.com.justinb.open311

import au.com.justinb.open311.model.ServiceRequest
import au.com.justinb.open311.model.resource.ServiceRequestResource
import org.junit.runner.RunWith
import org.spockframework.runtime.Sputnik
import spock.lang.Specification

@RunWith(Sputnik)
class ServiceRequestTest extends Specification {

  def requestAdapter = new GenericRequestAdapter<ServiceRequest>()

  def "should retrieve a single service request"() {
    when:
    def serviceRequest = requestAdapter.get("http://localhost:4567/requests/3b81bb6a-1318-410d-8f4f-95e5dc9facad.json", ServiceRequestResource.class)
    then:
    serviceRequest != null
  }

  def "should retrieve a list of service requests"() {
    when:
    def serviceRequests = requestAdapter.getList("http://localhost:4567/requests.json", ServiceRequestResource.class)
    then:
    serviceRequests.size() == 15
  }

  def "should create service request"() {
    when:
    ServiceRequest request = new ServiceRequest()
    request.serviceCode = "002"
    request.latitude = "36.3833"
    request.longtitude = "145.4"
    requestAdapter.create("http://localhost:4567/requests.json", request)

    and:
    def serviceRequests = requestAdapter.getList("http://localhost:4567/requests.json", ServiceRequestResource.class)

    then:
    serviceRequests.size() == 1
  }
}
