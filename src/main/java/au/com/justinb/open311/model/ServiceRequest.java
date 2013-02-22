package au.com.justinb.open311.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceRequest implements ModelObject {

  @JsonProperty(value = "service_code")
  String serviceCode;

  @JsonProperty(value = "lat")
  String latitude;

  @JsonProperty(value = "long")
  String longtitude;
}
