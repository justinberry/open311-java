package au.com.justinb.open311.util;

public enum Format {
  JSON("json"),
  XML("xml");

  private final String type;

  Format(String aType) {
    type = aType;
  }

  public String getType() {
    return type;
  }
}