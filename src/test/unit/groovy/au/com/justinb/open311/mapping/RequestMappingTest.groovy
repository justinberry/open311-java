package au.com.justinb.open311.mapping

import au.com.justinb.open311.model.ServiceRequest
import au.com.justinb.open311.util.Format
import org.junit.runner.RunWith
import org.spockframework.runtime.Sputnik
import spock.lang.Specification

@RunWith(Sputnik)
class RequestMappingTest extends Specification {

  def "correct list url is returned"() {
    when:
    def url = RequestMappings.getListUrlOfRequest(ServiceRequest.class, Format.JSON)
    then:
    url == "http://localhost/requests.json"
  }
}
