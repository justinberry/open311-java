package au.com.justinb.open311.util;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import org.codehaus.jackson.annotate.JsonProperty;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;

public class ReflectionUtils {

  private static final String CAMEL_CASE_REGEX = "([a-z])([A-Z])";
  private static final String TO_UNDERSCORED_REGEX = "$1_$2";
  private static final String UTF_8 = "utf-8";
  private static final String START_PARAM = "?";

  public static String constructQueryString(String baseUri, Object modelObject) {
    List<NameValuePair> params = new ArrayList<NameValuePair>();

    try {
      BeanInfo info = Introspector.getBeanInfo(modelObject.getClass(), Object.class);
      for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
        String name = pd.getName();
        name = name.replaceAll(CAMEL_CASE_REGEX, TO_UNDERSCORED_REGEX).toLowerCase();
        java.lang.reflect.Method getter = pd.getReadMethod();

        // FIXME - ANY getters will be resolved, we really should only be trying
        // to access getters for properties who have the JsonProperty annotation.

        Object value = null;
        try {
          value = getter.invoke(modelObject);
          if (value != null) {
            params.add(new BasicNameValuePair(name, value.toString()));
          }
        } catch (Exception e) {
          System.err.println("Warning: Failed to access getter for: " + name
            + " on " + modelObject + ": " + e.getMessage());
        }
      }
    } catch (IntrospectionException e) {
      System.err.println("IntrospectionException: " + e.getMessage());
    }

    return baseUri + START_PARAM + URLEncodedUtils.format(params, UTF_8);
  }
}
