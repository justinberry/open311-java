package au.com.justinb.open311.model;

import au.com.justinb.open311.model.resource.BaseResource;
import au.com.justinb.open311.model.resource.ServiceRequestResource;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = false)
public class ServiceRequest implements ModelObject {

  @JsonProperty(value = "service_code")
  private String serviceCode;

  @JsonProperty(value = "lat")
  private String latitude;

  @JsonProperty(value = "long")
  private String longtitude;

  @JsonProperty(value = "description")
  private String description;

  @JsonProperty(value = "media_url")
  private String mediaUrl;

  @JsonProperty(value = "service_request_id")
  private String serviceRequestId;

  @JsonProperty(value = "status")
  private String status;

  @JsonProperty(value = "requested_datetime")
  private String requestedDateTime;

  @JsonProperty(value = "service_name")
  private String serviceName;

  /*
   * Getters
   */

  public String getServiceCode() {
    return serviceCode;
  }

  public String getLat() {
    return latitude;
  }

  public String getLong() {
    return longtitude;
  }

  public String getDescription() {
    return description;
  }

  public String getMediaUrl() {
    return mediaUrl;
  }

  public String getServiceRequestId() {
    return serviceRequestId;
  }

  public String getStatus() {
    return status;
  }

  public String getRequestedDateTime() {
    return requestedDateTime;
  }

  public String getServiceName() {
    return serviceName;
  }}
