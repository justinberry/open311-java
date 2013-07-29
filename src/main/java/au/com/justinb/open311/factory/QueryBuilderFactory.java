package au.com.justinb.open311.factory;

import au.com.justinb.open311.builder.QueryBuilder;
import au.com.justinb.open311.builder.ServiceRequestQueryBuilder;
import au.com.justinb.open311.builder.SimpleQueryBuilder;
import au.com.justinb.open311.model.ServiceRequest;

public class QueryBuilderFactory {

  public QueryBuilder newQueryBuilder(Object modelObject) {

    if (ServiceRequest.class.equals(modelObject.getClass())) {
      return new ServiceRequestQueryBuilder((ServiceRequest) modelObject);
    } else {
      throw new RuntimeException("No mapping found for " + modelObject);
    }
  }

  public SimpleQueryBuilder newSimpleQueryBuilder() {
    return new SimpleQueryBuilder();
  }
}
