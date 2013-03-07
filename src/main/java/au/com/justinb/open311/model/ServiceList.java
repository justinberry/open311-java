package au.com.justinb.open311.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class ServiceList {

  @JsonProperty
  private String serviceCode;

  @JsonProperty
  private String serviceName;

  @JsonProperty
  private String description;

  @JsonProperty
  private String metadata;

  @JsonProperty
  private String type;

  @JsonProperty
  private String keywords;

  @JsonProperty
  private String group;

  public String getServiceCode() {
    return serviceCode;
  }

  public String getServiceName() {
    return serviceName;
  }

  public String getDescription() {
    return description;
  }

  public String getMetadata() {
    return metadata;
  }

  public String getType() {
    return type;
  }

  public String getKeywords() {
    return keywords;
  }

  public String getGroup() {
    return group;
  }
}
