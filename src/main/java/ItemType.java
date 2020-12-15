/**
 * Sets constant values for types of items.
 *
 * @author Zachery Danis
 */
public enum ItemType {
  AUDIO("AU"),
  VISUAL("VI"),
  AUDIO_MOBILE("AM"),
  VISUAL_MOBILE("VM");

  String code;

  ItemType(String code) {
    this.code = code;
  }
}
