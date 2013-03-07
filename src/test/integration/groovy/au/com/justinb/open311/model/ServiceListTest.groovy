package groovy.au.com.justinb.open311.model

import au.com.justinb.open311.GenericRequestAdapter
import au.com.justinb.open311.Open311
import au.com.justinb.open311.model.ServiceList
import org.junit.runner.RunWith
import org.spockframework.runtime.Sputnik
import spock.lang.Specification

@RunWith(Sputnik)
class ServiceListTest extends Specification {

  def requestAdapter = new GenericRequestAdapter<List<ServiceList>>(ServiceList.class)

  def setup() {
    Open311.setBaseUrl("http://localhost:4567")
  }

  def "should retrieve service list"() {
    when:
    def services = requestAdapter.list()
    then:
    services.size() == 12
    def service = services.get(0)
    service.serviceCode == "001"
    service.serviceName == "Road Blockage"
    service.description == "A road has been blocked."
    service.metadata == "false"
    service.type == "realtime"
    service.keywords == ""
    service.group == "Loss/Damage"
  }
}
