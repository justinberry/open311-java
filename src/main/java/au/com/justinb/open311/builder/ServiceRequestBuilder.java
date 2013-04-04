package au.com.justinb.open311.builder;

import au.com.justinb.open311.model.ServiceRequest;

public class ServiceRequestBuilder implements QueryBuilder {

  public static final String QUESTION_MARK = "?";
  public static final String EQUALS = "=";
  public static final String AMPERSAND = "&";

  public static final String SERVICE_CODE = "service_code";
  public static final String LAT = "lat";
  public static final String LONG = "long";
  public static final String ADDRESS_STRING = "address_string";
  public static final String DESCRIPTION = "description";
  public static final String MEDIA_URL = "media_url";

  private final ServiceRequest serviceRequest;

  public ServiceRequestBuilder(ServiceRequest serviceRequest) {
    this.serviceRequest = serviceRequest;
  }

  @Override
  public String build() {

    StringBuilder stringBuilder = new StringBuilder(QUESTION_MARK);
    appendRequiredAttributes(stringBuilder);
    appendOptionalAttributes(stringBuilder);

    return stringBuilder.toString();
  }

  private void appendOptionalAttributes(StringBuilder stringBuilder) {
    append(stringBuilder, ADDRESS_STRING, serviceRequest.getAddress());
    append(stringBuilder, DESCRIPTION, serviceRequest.getDescription());
    append(stringBuilder, MEDIA_URL, serviceRequest.getMediaUrl());
//    append(stringBuilder, "email", TODO);
//    append(stringBuilder, "device_id", TODO);
//    append(stringBuilder, "account_id", TODO);
//    append(stringBuilder, "first_name", TODO);
//    append(stringBuilder, "last_name", TODO);
//    append(stringBuilder, "phone", TODO);
  }

  private void appendRequiredAttributes(StringBuilder stringBuilder) {

    append(stringBuilder, SERVICE_CODE, serviceRequest.getServiceCode());
    append(stringBuilder, LAT, serviceRequest.getLat());
    append(stringBuilder, LONG, serviceRequest.getLong());
  }

  private void append(StringBuilder builder, String key, Object value) {
    if (value == null) {
      return;
    }

    builder.append(AMPERSAND).append(key).append(EQUALS).append(value);
  }
}
