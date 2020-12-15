/**
 * Declaring the methods for ScreenSpec which will be implemented by Screen.
 *
 * @author Zachery Danis
 */
public interface ScreenSpec {
  // an interface is like a contract that spells out how the software will interact
  String getResolution();

  int getRefreshRate();

  int getResponseTime();
}
