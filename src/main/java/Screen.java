/**
 * Implementing ScreenSpec and initializing the methods for Screen.
 *
 * @author Zachery Danis
 */
public class Screen implements ScreenSpec {

  private String resolution;
  private int refreshRate;
  private int responseTime;

  /**
   * Initializing resolution, refreshRate, and responseTime for the Screen.
   *
   * @param resolution assign value for screen resolution
   * @param refreshRate assign value for screen refresh rate
   * @param responseTime assign value for screen response time
   */
  public Screen(String resolution, int refreshRate, int responseTime) {
    this.resolution = resolution;
    this.refreshRate = refreshRate;
    this.responseTime = responseTime;
  }

  /**
   * Sets the values for Screen to a String so they can be printed.
   *
   * @return Print out of what the Screen sets
   */
  public String toString() {
    return "Screen:"
        + "\n"
        + "Resolution: "
        + resolution
        + "\n"
        + "Refresh rate: "
        + refreshRate
        + "\n"
        + "Response time: "
        + responseTime;
  }

  @Override
  public String getResolution() {
    return resolution;
  }

  @Override
  public int getRefreshRate() {
    return refreshRate;
  }

  @Override
  public int getResponseTime() {
    return responseTime;
  }
}
