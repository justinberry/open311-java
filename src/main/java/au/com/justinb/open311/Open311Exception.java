package au.com.justinb.open311;

public class Open311Exception extends Throwable {

  private Exception cause;

  public Open311Exception(Exception cause) {
    this.cause = cause;
  }

  public Exception getCause() {
    return cause;
  }
}
