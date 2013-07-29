package au.com.justinb.open311.builder;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class AbstractQueryBuilder implements QueryBuilder {

  public static final String EQUALS = "=";
  public static final String AMPERSAND = "&";
  public static final String QUESTION_MARK = "?";

  private Map<String, String> extraProperties;

  StringBuilder stringBuilder = new StringBuilder(QUESTION_MARK);

  public AbstractQueryBuilder() {
    this.extraProperties = new HashMap<String, String>();
  }

  @Override
  public String build() {
    if (extraProperties != null) {
      appendExtraProperties(stringBuilder);
    }

    return stringBuilder.toString();
  }

  private void appendExtraProperties(StringBuilder stringBuilder) {
    Iterator<Map.Entry<String, String>> iterator = extraProperties.entrySet().iterator();
    while (iterator.hasNext()) {
      Map.Entry<String, String> next = iterator.next();
      append(stringBuilder, next.getKey(), next.getValue());
    }
  }

  @Override
  public QueryBuilder withExtraProperties(Map<String, String> extraProperties) {
    this.extraProperties.putAll(extraProperties);
    return this;
  }


  protected void append(StringBuilder builder, String key, Object value) {
    if (value == null) {
      return;
    }

    if (builder.length() > 1) {
      builder.append(AMPERSAND);
    }

    builder.append(key).append(EQUALS).append(value);
  }
}
