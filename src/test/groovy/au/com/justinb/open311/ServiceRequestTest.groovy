package au.com.justinb.open311

import au.com.justinb.open311.model.resource.ServiceRequestResource
import org.junit.runner.RunWith
import org.spockframework.runtime.Sputnik
import spock.lang.Specification

@RunWith(Sputnik)
class ServiceRequestTest extends Specification {

  def requestAdapter = new GenericRequestAdapter()

  def "should retrieve a single service request"() {
    when:
    def serviceRequest = requestAdapter.get("http://54.252.102.158/requests/3b81bb6a-1318-410d-8f4f-95e5dc9facad.json", ServiceRequestResource.class)
    then:
    serviceRequest != null
  }

  def "should retrieve a list of service requests"() {
    when:
    def serviceRequests = requestAdapter.getList("http://54.252.102.158/requests/3b81bb6a-1318-410d-8f4f-95e5dc9facad.json", ServiceRequestResource.class)
    then:
    serviceRequests.size() > 0
  }
}
