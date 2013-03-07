package au.com.justinb.open311.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

public class ServiceRequest {

  @JsonProperty
  private String jurisdictionId;

  @JsonProperty
  private String serviceRequestId;

  @JsonProperty
  private String serviceCode;

  @JsonProperty
  private String startDate;

  @JsonProperty
  private String endDate;

  @JsonProperty
  private String status;

  @JsonProperty
  private String statusNotes;

  @JsonProperty
  private String serviceName;

  @JsonProperty
  private String description;

  @JsonProperty
  private String agencyResponsible;

  @JsonProperty
  private String serviceNotice;

  @JsonProperty
  private String requestedDatetime;

  @JsonProperty
  private String updatedDatetime;

  @JsonProperty
  private String expectedDatetime;

  @JsonProperty
  private String address;

  @JsonProperty
  private String addressId;

  @JsonProperty
  private String zipcode;

  @JsonProperty(value = "lat")
  private String latitude;

  @JsonProperty(value = "long")
  private String longtitude;

  @JsonProperty
  private String mediaUrl;

  public String getJurisdictionId() {
    return jurisdictionId;
  }

  public String getServiceRequestId() {
    return serviceRequestId;
  }

  public String getServiceCode() {
    return serviceCode;
  }

  public String getStartDate() {
    return startDate;
  }

  public String getEndDate()  {
    return endDate;
  }

  public String getStatus() {
    return status;
  }

  public String getStatusNotes() {
    return statusNotes;
  }

  public String getServiceName() {
    return serviceName;
  }

  public String getDescription() {
    return description;
  }

  public String getAgencyResponsible() {
    return agencyResponsible;
  }

  public String getServiceNotice() {
    return serviceNotice;
  }

  public String getRequestedDatetime() {
    return requestedDatetime;
  }

  public String getUpdatedDatetime() {
    return updatedDatetime;
  }

  public String getExpectedDatetime() {
    return expectedDatetime;
  }

  public String getAddress() {
    return address;
  }

  public String getAddressId() {
    return addressId;
  }

  public String getZipcode() {
    return zipcode;
  }

  public String getLat() {
    return latitude;
  }

  public String getLong() {
    return longtitude;
  }

  public String getMediaUrl() {
    return mediaUrl;
  }
}
