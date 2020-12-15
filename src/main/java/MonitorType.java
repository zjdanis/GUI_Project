/**
 * Sets constant values for types of monitors.
 *
 * @author Zachery Danis
 */
public enum MonitorType {
  LCD("LCD"),
  LED("LED");
  public String type;

  MonitorType(String type) {
    this.type = type;
  }
}
