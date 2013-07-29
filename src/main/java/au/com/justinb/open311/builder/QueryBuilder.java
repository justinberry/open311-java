package au.com.justinb.open311.builder;

import java.util.Map;

public interface QueryBuilder {

  public String build();
  public QueryBuilder withExtraProperties(Map<String, String> extraProperties);
}
