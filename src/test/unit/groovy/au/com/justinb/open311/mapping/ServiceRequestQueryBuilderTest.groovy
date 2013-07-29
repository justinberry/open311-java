package groovy.au.com.justinb.open311.mapping

import au.com.justinb.open311.builder.ServiceRequestQueryBuilder
import au.com.justinb.open311.model.ServiceRequest
import org.junit.runner.RunWith
import org.spockframework.runtime.Sputnik
import spock.lang.Specification

@RunWith(Sputnik)
class ServiceRequestQueryBuilderTest extends Specification {

  ServiceRequest serviceRequest = Mock()

  ServiceRequestQueryBuilder queryBuilder

  def setup() {
    queryBuilder = new ServiceRequestQueryBuilder(serviceRequest)
  }

  def "should add extra properties to URL"() {
    given:
      def extraProperties = new HashMap()
      extraProperties.put("someKey", "someVal")
      queryBuilder.withExtraProperties(extraProperties)
    when:
      def url = queryBuilder.build()
    then:
      url == "?someKey=someVal"
  }
}
