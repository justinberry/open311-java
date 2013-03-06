package au.com.justinb.open311.mapping

import au.com.justinb.open311.model.ServiceRequest
import au.com.justinb.open311.model.resource.ServiceRequestResource
import au.com.justinb.open311.util.Format
import org.junit.runner.RunWith
import org.spockframework.runtime.Sputnik
import spock.lang.Specification

@RunWith(Sputnik)
class RequestMappingTest extends Specification {

  def "list url for service requests is returned"() {
    when:
    def urlJson = RequestMappings.getListUrl(ServiceRequest.class, Format.JSON)
    def urlXml = RequestMappings.getListUrl(ServiceRequest.class, Format.XML)
    then:
    urlJson == "http://localhost/requests.json"
    urlXml == "http://localhost/requests.xml"
  }

  def "single url for service request is returned"() {
    when:
    def urlJson = RequestMappings.getUrl(ServiceRequest.class, Format.JSON, "someId")
    def urlXml = RequestMappings.getUrl(ServiceRequest.class, Format.XML, "someId")
    then:
    urlJson == "http://localhost/requests/someId.json"
    urlXml == "http://localhost/requests/someId.xml"
  }

  def "resource class is returned for service request"() {
    when:
    def resourceClass = RequestMappings.getResource(ServiceRequest.class)
    then:
    resourceClass == ServiceRequestResource.class
  }
}
