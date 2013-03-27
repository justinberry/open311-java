package au.com.justinb.open311.model;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Date;

public class ServiceRequest {

  @JsonProperty
  private String jurisdictionId;

  @JsonProperty
  private String serviceRequestId;

  @JsonProperty
  private String serviceCode;

  @JsonProperty
  private Date startDate;

  @JsonProperty
  private Date endDate;

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
  private Date requestedDatetime;

  @JsonProperty
  private Date updatedDatetime;

  @JsonProperty
  private Date expectedDatetime;

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

  public Date getStartDate() {
    return startDate;
  }

  public Date getEndDate()  {
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

  public Date getRequestedDatetime() {
    return requestedDatetime;
  }

  public Date getUpdatedDatetime() {
    return updatedDatetime;
  }

  public Date getExpectedDatetime() {
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
