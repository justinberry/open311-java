package au.com.justinb.open311.builder;

import au.com.justinb.open311.model.ServiceRequest;

public class ServiceRequestQueryBuilder extends AbstractQueryBuilder {

  public static final String SERVICE_CODE = "service_code";
  public static final String LAT = "lat";
  public static final String LONG = "long";
  public static final String ADDRESS_STRING = "address_string";
  public static final String DESCRIPTION = "description";
  public static final String MEDIA_URL = "media_url";
  public static final String EMAIL = "email";
  public static final String DEVICE_ID = "device_id";
  public static final String ACCOUNT_ID = "account_id";
  public static final String FIRST_NAME = "first_name";
  public static final String LAST_NAME = "last_name";
  public static final String PHONE = "phone";
  public static final String STATUS = "status";

  private final ServiceRequest serviceRequest;

  public ServiceRequestQueryBuilder(ServiceRequest serviceRequest) {
    super();
    this.serviceRequest = serviceRequest;
  }

  @Override
  public String build() {

    if (serviceRequest != null) {
      appendRequiredAttributes(stringBuilder);
      appendOptionalAttributes(stringBuilder);
    }

    return super.build();
  }

  private void appendOptionalAttributes(StringBuilder stringBuilder) {
    append(stringBuilder, ADDRESS_STRING, serviceRequest.getAddress());
    append(stringBuilder, DESCRIPTION, serviceRequest.getDescription());
    append(stringBuilder, MEDIA_URL, serviceRequest.getMediaUrl());
    append(stringBuilder, EMAIL, serviceRequest.getEmail());
    append(stringBuilder, DEVICE_ID, serviceRequest.getDeviceId());
    append(stringBuilder, ACCOUNT_ID, serviceRequest.getAccountId());
    append(stringBuilder, FIRST_NAME, serviceRequest.getFirstName());
    append(stringBuilder, LAST_NAME, serviceRequest.getLastName());
    append(stringBuilder, PHONE, serviceRequest.getPhone());
    append(stringBuilder, STATUS, serviceRequest.getStatus());
  }

  private void appendRequiredAttributes(StringBuilder stringBuilder) {

    append(stringBuilder, SERVICE_CODE, serviceRequest.getServiceCode());
    append(stringBuilder, LAT, serviceRequest.getLat());
    append(stringBuilder, LONG, serviceRequest.getLong());
  }
}
