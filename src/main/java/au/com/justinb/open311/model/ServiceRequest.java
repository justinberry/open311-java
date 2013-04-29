package au.com.justinb.open311.model;

import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;
import java.util.Date;

/*
 * TODO - This class is ridiculously large. Need to rethink
 * and break it down.
 */
public class ServiceRequest implements Serializable {

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
  private Double latitude;

  @JsonProperty(value = "long")
  private Double longtitude;

  @JsonProperty
  private String mediaUrl;

  private String email;

  private String deviceId;

  private String accountId;

  private String firstName;

  private String lastName;

  private String phone;

  public ServiceRequest(Builder builder) {
    this.jurisdictionId = builder.jurisdictionId;
    this.serviceRequestId = builder.serviceRequestId;
    this.serviceCode = builder.serviceCode;
    this.startDate = builder.startDate;
    this.endDate = builder.endDate;
    this.status = builder.status;
    this.statusNotes = builder.statusNotes;
    this.serviceName = builder.serviceName;
    this.description = builder.description;
    this.agencyResponsible = builder.agencyResponsible;
    this.serviceNotice = builder.serviceNotice;
    this.requestedDatetime = builder.requestedDatetime;
    this.updatedDatetime = builder.updatedDatetime;
    this.expectedDatetime = builder.expectedDatetime;
    this.address = builder.address;
    this.addressId = builder.addressId;
    this.zipcode = builder.zipcode;
    this.latitude = builder.latitude;
    this.longtitude = builder.longtitude;
    this.mediaUrl = builder.mediaUrl;
    this.email = builder.email;
    this.deviceId = builder.deviceId;
    this.accountId = builder.accountId;
    this.firstName = builder.firstName;
    this.lastName = builder.lastName;
    this.phone = builder.phone;
  }

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

  public Date getEndDate() {
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

  public Double getLat() {
    return latitude;
  }

  public Double getLong() {
    return longtitude;
  }

  public String getMediaUrl() {
    return mediaUrl;
  }

  public String getEmail() {
    return email;
  }

  public String getDeviceId() {
    return deviceId;
  }

  public String getAccountId() {
    return accountId;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getPhone() {
    return phone;
  }

  public static class Builder {

    private String jurisdictionId;
    private String serviceRequestId;
    private String serviceCode;
    private Date startDate;
    private Date endDate;
    private String status;
    private String statusNotes;
    private String serviceName;
    private String description;
    private String agencyResponsible;
    private String serviceNotice;
    private Date requestedDatetime;
    private Date updatedDatetime;
    private Date expectedDatetime;
    private String address;
    private String addressId;
    private String zipcode;
    private Double latitude;
    private Double longtitude;
    private String mediaUrl;
    private String email;
    private String deviceId;
    private String accountId;
    private String firstName;
    private String lastName;
    private String phone;

    public Builder jurisdictionId(String jurisdictionId) {
      this.jurisdictionId = jurisdictionId;
      return this;
    }

    public Builder serviceRequestId(String serviceRequestId) {
      this.serviceRequestId = serviceRequestId;
      return this;
    }

    public Builder serviceCode(String serviceCode) {
      this.serviceCode = serviceCode;
      return this;
    }

    public Builder startDate(Date startDate) {
      this.startDate = startDate;
      return this;
    }

    public Builder endDate(Date endDate) {
      this.endDate = endDate;
      return this;
    }

    public Builder status(String status) {
      this.status = status;
      return this;
    }

    public Builder statusNotes(String statusNotes) {
      this.statusNotes = statusNotes;
      return this;
    }

    public Builder serviceName(String serviceName) {
      this.serviceName = serviceName;
      return this;
    }

    public Builder description(String description) {
      this.description = description;
      return this;
    }

    public Builder agencyResponsible(String agencyResponsible) {
      this.agencyResponsible = agencyResponsible;
      return this;
    }

    public Builder serviceNotice(String serviceNotice) {
      this.serviceNotice = serviceNotice;
      return this;
    }

    public Builder requestedDatetime(Date requestedDatetime) {
      this.requestedDatetime = requestedDatetime;
      return this;
    }

    public Builder updatedDatetime(Date updatedDatetime) {
      this.updatedDatetime = updatedDatetime;
      return this;
    }

    public Builder expectedDatetime(Date expectedDatetime) {
      this.expectedDatetime = expectedDatetime;
      return this;
    }

    public Builder address(String address) {
      this.address = address;
      return this;
    }

    public Builder addressId(String addressId) {
      this.addressId = addressId;
      return this;
    }

    public Builder zipcode(String zipcode) {
      this.zipcode = zipcode;
      return this;
    }

    public Builder latitude(Double latitude) {
      this.latitude = latitude;
      return this;
    }

    public Builder longtitude(Double longtitude) {
      this.longtitude = longtitude;
      return this;
    }

    public Builder mediaUrl(String mediaUrl) {
      this.mediaUrl = mediaUrl;
      return this;
    }

    public Builder email(String email) {
      this.email = email;
      return this;
    }

    public Builder deviceId(String deviceId) {
      this.deviceId = deviceId;
      return this;
    }

    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    public Builder firstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    public Builder lastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    public Builder phone(String phone) {
      this.phone = phone;
      return this;
    }

    public ServiceRequest createServiceRequest() {
      return new ServiceRequest(this);
    }
  }
}