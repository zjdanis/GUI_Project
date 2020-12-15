import java.util.Date;

/**
 * Creates a record of the products being produced.
 *
 * @author Zachery Danis
 */
public class ProductionRecord {
  private int productionNumber;
  private int productId;
  private String serialNumber;
  private Date dateProduced;
  private Product productProduced;
  private int item;

  /**
   * Creates a record for the production of the product, assigning a production number, serial
   * number, and date of production.
   *
   * @param productId assigns a value to for the ID of the product
   */
  public ProductionRecord(int productId) {
    productionNumber = 0;
    serialNumber = "0";
    dateProduced = new Date();
  }

  /**
   * Sets the record for the production of a product.
   *
   * @param productionNumber assigns a number of products produced
   * @param productId assigns the production ID
   * @param serialNumber assigns the serial number of the product
   * @param dateProduced assigns the date it was produced
   */
  public ProductionRecord(
      int productionNumber, int productId, String serialNumber, Date dateProduced) {
    this.productionNumber = productionNumber;
    this.productId = productId;
    this.serialNumber = serialNumber;
    this.dateProduced = dateProduced;
  }

  /**
   * Sets the production of a product and how many item have been produced.
   *
   * @param productProduced Assigns the product that has been produced
   * @param itemCount how many items have been produced
   */
  public ProductionRecord(Product productProduced, int itemCount) {
    this.productProduced = productProduced;
    this.item = itemCount;
    this.dateProduced = new Date();
  }

  /**
   * Sets the values for ProductionRecord to a String so they can be printed.
   *
   * @return Print out of what the ProductionRecord sets
   */
  public String toString() {
    return "Prod. Num: "
        + productionNumber
        + " Product ID: "
        + productId
        + " Serial Num: "
        + "App"
        + ItemType.AUDIO.code
        + "0000"
        + item
        + " Date: "
        + dateProduced;
  }

  public int getProductionNum() {
    return productionNumber;
  }

  public void setProductionNum(int productionNumber) {
    this.productionNumber = productionNumber;
  }

  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public String getSerialNum() {
    return serialNumber;
  }

  public void setSerialNum(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  public Date getProdDate() {
    return dateProduced;
  }

  public void setProdDate(Date dateProduced) {
    this.dateProduced = dateProduced;
  }
}
