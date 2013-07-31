package au.com.justinb.open311.model

import au.com.justinb.open311.GenericRequestAdapter
import au.com.justinb.open311.Open311
import org.junit.runner.RunWith
import org.spockframework.runtime.Sputnik
import spock.lang.Specification

import java.text.SimpleDateFormat

@RunWith(Sputnik)
class ServiceRequestTest extends Specification {

  def requestAdapter = new GenericRequestAdapter<ServiceRequest>(ServiceRequest.class)
  def serviceRequest = new ServiceRequest()

  def setup() {

    Open311.setBasicAuth("android", "yyy");
    serviceRequest.serviceCode = "001"
    serviceRequest.latitude = 37.76524078
    serviceRequest.longtitude = -122.4212043
    serviceRequest.description = "This is a long description for testing stuff and things."
    serviceRequest.status = "open"

    Open311.setBaseUrl("http://localhost:4567")
  }

  def "should create service request"() {
    when:
    requestAdapter.create(serviceRequest)

    and:
    def requests = requestAdapter.list()
    then:
    requests.size() == 1
  }

  def "should retrieve a list of service requests"() {
    when:
    def requests = requestAdapter.list()
    then:
    requests.size() == 1
    requests.get(0).serviceCode == serviceRequest.serviceCode
    requests.get(0).lat == serviceRequest.lat
    requests.get(0).long == serviceRequest.long
    requests.get(0).requestedDatetime != null
    requests.get(0).description != null
//    requests.get(0).endDate != null
//    requests.get(0).startDate != null
  }

  def "should retrieve a single service request"() {
    when:
    def requests = requestAdapter.list()
    def request = requestAdapter.get(requests.get(0).serviceRequestId)
    then:
    request != null
  }

  def "should set service request status to closed"() {
    when:
    def requests = requestAdapter.list()
    serviceRequest.status = "closed"
    requestAdapter.update(requests.get(0).serviceRequestId, serviceRequest)
    def retrievedRequest = requestAdapter.get(requests.get(0).serviceRequestId)

    then:
    retrievedRequest != null
    retrievedRequest.status == "closed"
  }
}
