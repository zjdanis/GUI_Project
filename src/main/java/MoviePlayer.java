/**
 * Sets values for the parameters of MoviePlayer, implements the methods defined in
 * MultimediaControl.
 *
 * @author Zachery Danis
 */
public class MoviePlayer extends Product implements MultimediaControl {
  private final String name;
  private final String manufacturer;
  private final Screen screen;
  private final MonitorType monitorType;
  private final String type;

  /**
   * Assigns values to name, manufacturer, screen, and monitorType.
   *
   * @param name assigns name of movie player
   * @param manufacturer sets the manufacturer of movie player
   * @param screen sets refresh rate, resolution, and response time
   * @param monitorType Assigns type of monitor
   */
  public MoviePlayer(String name, String manufacturer, Screen screen, MonitorType monitorType) {
    super();
    type = "VISUAL";
    this.name = name;
    this.manufacturer = manufacturer;
    this.screen = screen;
    this.monitorType = monitorType;
  }

  /**
   * Sets the values for MoviePlayer to a String so they can be printed.
   *
   * @return Print out of what the MoviePlayer sets
   */
  public String toString() {
    return super.toString() + "\n" + screen + "\n" + "Monitor Type: " + monitorType;
  }

  public void play() {
    System.out.println("Playing movie");
  }

  public void stop() {
    System.out.println("Stopping movie");
  }

  public void previous() {
    System.out.println("Previous movie");
  }

  public void next() {
    System.out.println("Next movie");
  }
}
