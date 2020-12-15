import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Controls the program, carrying out function of sample.fxml
 *
 * @author Zachery Danis
 */
public class Controller {

  public Button recordProd;

  @FXML private TextField passwordInput;

  @FXML private TextField nameInput;

  @FXML private Label errorMessage;

  ObservableList<Product> productLine = FXCollections.observableArrayList();

  @FXML private TextField manufacturerInput;

  @FXML private ChoiceBox<ItemType> choiceBox;

  @FXML private TableView<Product> tableView;

  @FXML private TextField productInput;

  @FXML private Label productError;

  @FXML private TableColumn<Product, String> prodTable;

  @FXML private TableColumn<Product, String> manufacturerTable;

  @FXML private TableColumn<Product, ItemType> typeTable;

  public Button addProd;

  public Controller() throws FileNotFoundException {}

  @FXML
  void addProduct() {}

  ObservableList<String> produceObservableList = FXCollections.observableArrayList();

  @FXML private Label prodErrorMessage;

  @FXML private ListView<Product> displayProduct;

  @FXML private ComboBox<String> comboBox;

  @FXML public Button newEmployee;

  @FXML
  void createEmployee() {}

  @FXML
  void recordProduction() {}

  @FXML private TextArea productionLog;

  /** Initialize Combo box and Choice box. */
  public void initialize() {
    for (int i = 1; i <= 10; i++) {
      comboBox.getItems().add(String.valueOf(i));
    }
    for (ItemType item : ItemType.values()) {
      choiceBox.getItems().add(item);
    }
  }

  final String JDBC_DRIVER = "org.h2.Driver";
  final String DB_URL = "jdbc:h2:./res/H2";

  //  Database credentials
  final String USER = "";
  final String PASS = "";

  File password = new File("res/h2");
  Scanner sc = new Scanner(password);
  final String PASSWORD = sc.nextLine();

  /** Try and catch method that inserts a product into the database. */
  public void databaseConnection() {
    Connection conn = null;
    Statement stmt = null;

    try {
      // STEP 1: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      // STEP 2: Open a connection
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("You have connected to the database");

      // STEP 3: Execute a query
      String sql = "INSERT INTO PRODUCT (NAME, MANUFACTURER, TYPE) VALUES(?, ?, ?)";

      stmt = conn.prepareStatement(sql);

      ItemType itemType;
      if (choiceBox.getSelectionModel().isEmpty()) {
        productError.setText("Invalid Input. Please Select Item Type");
      } else {
        itemType = choiceBox.getValue();
        ((PreparedStatement) stmt).setString(3, itemType.toString());
      }

      String manufacturer = manufacturerInput.getText();
      if (manufacturer.equals("")) {
        productError.setText("Invalid Input. Please Enter manufacturer");
      } else {
        manufacturer = manufacturerInput.getText();
        ((PreparedStatement) stmt).setString(2, manufacturer);
      }

      String product = productInput.getText();
      if (product.equals("")) {
        productError.setText("Invalid Input. Please Enter a Product.");
      } else {
        product = productInput.getText();
        ((PreparedStatement) stmt).setString(1, product);
      }

      // STEP 4: Clean-up environment
      stmt.close();
      conn.close();

    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    conn = null;
    stmt = null;

    try {
      // Step 1: Register JDBC Driver
      Class.forName(JDBC_DRIVER);

      // Step 2: Open a Connection
      conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
      System.out.println("You have connected to the database");

      // Step 3: Execute a Query
      stmt = conn.createStatement();

      String sql = "SELECT * FROM PRODUCT";

      ResultSet rs = stmt.executeQuery(sql);

      prodTable.setCellValueFactory(new PropertyValueFactory<>("name"));
      manufacturerTable.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
      typeTable.setCellValueFactory(new PropertyValueFactory<>("type"));
      tableView.setItems(productLine);

      while (rs.next()) {
        productLine.add(
            new Widget(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("manufacturer"),
                ItemType.valueOf(rs.getString("type"))));
        produceObservableList.add(
            new Widget(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("manufacturer"),
                    ItemType.valueOf(rs.getString("type")))
                .toString());
        displayProduct
            .getItems()
            .add(
                new Widget(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("manufacturer"),
                    ItemType.valueOf(rs.getString("type"))));
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    conn = null;
    stmt = null;

    try {
      // Step 1: Register JDBC Driver
      Class.forName(JDBC_DRIVER);

      // Step 2: Open a Connection
      conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
      System.out.println("You have connected to the database");

      // Step 3: Execute a Query
      stmt = conn.createStatement();
      String sql;

      try {
        Employee employee = new Employee(nameInput.getText(), passwordInput.getText());

        sql = "INSERT INTO EMPLOYEE(NAME, EMAIL, USER, PASS) VALUES (?,?,?,?)";

        PreparedStatement state = conn.prepareStatement(sql);

        String NAME = "";
        if (employee.name.equals("")) {
          errorMessage.setText("Invalid Entry. Please Try Again.");
        } else {
          NAME = employee.name;
          state.setString(1, NAME);
        }

        String EMAIL = employee.email;
        String USERNAME = employee.username;

        if (!NAME.equals("")) {
          state.setString(2, EMAIL);
          state.setString(3, USERNAME);

          state.executeUpdate();
          System.out.println("Employee added to EMPLOYEE table...");
        }

        String PASSWORD = reverseString(employee.password);
        state.setString(4, PASSWORD);

      } catch (NullPointerException e) {
        prodErrorMessage.setText("Invalid Entry. Please Try Again.");
      }

    } catch (Exception e) {
      // Handle errors for JDBC
      e.printStackTrace();
    }

    try {
      if (conn != null) conn.close();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Takes in the password that the employee entered and reverses it.
   *
   * @param pass password that was entered
   * @return password
   */
  public String reverseString(String pass) {
    if (pass.isEmpty()) {
      return pass;
    }
    return reverseString(pass.substring(1)) + pass.charAt(0);
  }

  /**
   * Records the production of the products.
   * Try and catch that will insert the record of production. 
   * 
   * @param isRecorded determines if product was recorded 
   */
  public void recordProduction(boolean isRecorded) {
    Connection conn = null;
    Statement stmt = null;

    try {
      // Step 1: Register JDBC Driver
      Class.forName(JDBC_DRIVER);

      // Step 2: Open a Connection
      conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
      System.out.println("You have connected to the database");

      // Step 3: Execute a Query
      stmt = conn.createStatement();
      String sql;

      int productsProduced = 1;
      if (isRecorded) {
        try {
          for (int i = 0; i < Integer.parseInt(comboBox.getValue()); i++) {
            sql =
                "INSERT INTO PRODUCTIONRECORD(PRODUCT_ID, SERIAL_NUM, DATE_PRODUCED)"
                    + "VALUES(?, ?, CURRENT_TIMESTAMP)";

            ProductionRecord prodRecord =
                new ProductionRecord(
                    displayProduct.getSelectionModel().getSelectedItem(), productsProduced++);

            PreparedStatement state = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            state.setInt(1, prodRecord.getProductId());
            state.setString(2, prodRecord.getSerialNum());

            state.executeUpdate();

            productionLog.appendText(prodRecord.toString() + "\n");
          }
        } catch (NullPointerException e) {
          prodErrorMessage.setText("Invalid Entry. Please Try Again.");
        }
      } else {
        sql = "SELECT * FROM PRODUCTIONRECORD";
        ResultSet rs = stmt.executeQuery(sql);

        for (int i = 0; rs.next(); i++) {
          productionLog.appendText(
              "Product Number: "
                  + rs.getString(1)
                  + " Product Id: "
                  + rs.getString(2)
                  + " Serial Number: "
                  + rs.getString(3)
                  + " Date: "
                  + rs.getString(4)
                  + "\n");
        }
      }

    } catch (Exception e) {
      // Handle errors for JDBC
      e.printStackTrace();
    }
    try {
      if (conn != null) conn.close();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
