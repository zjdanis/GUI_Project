/**
 * Declaring the methods for Item which will be implemented by Product.
 *
 * @author Zachery Danis
 */
public interface Item {

  int getId();

  void setName(String name);

  String getName();

  void setManufacturer(String manufacturer);

  String getManufacturer();
}
