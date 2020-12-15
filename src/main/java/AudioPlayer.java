/**
 * Initializes information for AudioPlayer and implements the,
 * methods from MultimediaControl.
 *
 * @author Zachery Danis
 */
public class AudioPlayer extends Product implements MultimediaControl {

  private String supportAudioFormats;
  private String supportPlaylistFormats;

  /**
   * Constructor that sets values for name, manufacturer, supportAudioFormats,
   * and supportPlaylistFormats.
   *
   * @param name name of Audio Player
   * @param manufacturer the company that made it
   * @param supportAudioFormats types of audio files that are able to be used
   * @param supportPlaylistFormats ways that the playlist can be formatted
   *
   */
  public AudioPlayer(
      String name, String manufacturer, String supportAudioFormats, String supportPlaylistFormats) {
    super(name, manufacturer, ItemType.VISUAL);
    this.supportAudioFormats = supportAudioFormats;
    this.supportPlaylistFormats = supportPlaylistFormats;
  }

  /**
   * Sets the values for AudioPlayer to a String so they can be printed.
   *
   * @return Print out of what the AudioPlayer sets
   *
   */
  public String toString() {
    return super.toString()
        + "\n"
        + "Supported Audio Formats: "
        + supportAudioFormats
        + "\n"
        + "Supported Playlist Formats: "
        + supportPlaylistFormats;
  }

  @Override
  public void play() {
    System.out.println("Playing");
  }

  @Override
  public void stop() {
    System.out.println("Stopping");
  }

  @Override
  public void next() {
    System.out.println("Next");
  }

  @Override
  public void previous() {
    System.out.println("Previous");
  }
}
