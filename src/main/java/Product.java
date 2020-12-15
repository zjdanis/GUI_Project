/**
 * Initializing methods for the Products and implementing Item.
 *
 * @author Zachery Danis
 */
public abstract class Product implements Item {

  private int id;
  private String playlist;
  public String type;
  private String manufacturer;
  private String name;
  private String supportAudioFormats;
  private String supportPlaylistFormats;
  private ItemType itemType;

  public Product(String n, String m) {
    name = n;
    manufacturer = m;
  }

  /**
   * Assigns the values for type, name, manufacturer on MoviePlayer and AudioPlayer.
   */
  public Product() {
    this.type = "VISUAL";
    this.name = "DBPOWER MK101";
    this.manufacturer = "OracleProduction";
    this.supportAudioFormats = "DSD/FLAC/ALAC/WAV/AIFF/MQA/Ogg-Vorbis/MP3/AAC";
    this.supportPlaylistFormats = "M3U/PLS/WPL";
  }

  /**
   * Sets the variables name, manufacturer, and itemType.
   *
   * @param name assigns the name of the product
   * @param manufacturer assigns the manufacturer of the product
   * @param itemType assigns the type of item for the product
   */
  public Product(String name, String manufacturer, ItemType itemType) {
    this.type = "AUDIO";
    this.name = name;
    this.name = manufacturer;
    this.itemType = itemType;
  }

  public String toString() {
    return "Name: " + name + "\n" + "Manufacturer: " + manufacturer + "\n" + "Type: " + type;
  }

  public int getId() {
    return id;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

class Widget extends Product {
  Widget(int id, String name, String manufacturer, ItemType itemType) {
    super(name, manufacturer, itemType);
  }
}
