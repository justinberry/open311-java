package au.com.justinb.open311.model;

import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

public class ServiceList implements Serializable {

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

  private ServiceList(Builder builder) {
    this.serviceCode = builder.serviceCode;
    this.serviceName = builder.serviceName;
    this.description = builder.description;
    this.metadata = builder.metadata;
    this.type = builder.type;
    this.keywords = builder.keywords;
    this.group = builder.group;
  }

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

  public static class Builder {

    private String serviceCode;
    private String serviceName;
    private String description;
    private String metadata;
    private String type;
    private String keywords;
    private String group;

    public Builder serviceCode(String serviceCode) {
      this.serviceCode = serviceCode;
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

    public Builder metadata(String metadata) {
      this.metadata = metadata;
      return this;
    }

    public Builder type(String type) {
      this.type = type;
      return this;
    }

    public Builder keywords(String keywords) {
      this.keywords = keywords;
      return this;
    }

    public Builder group(String group) {
      this.group = group;
      return this;
    }

    public ServiceList build() {
      return new ServiceList(this);
    }
  }
}
