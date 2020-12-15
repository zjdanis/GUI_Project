import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Executes program, loads the FXML file and determines the screen size.
 *
 * @author Zachery Danis
 */
public class Main extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {

    Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

    Scene scene = new Scene(root, 666, 475);

    primaryStage.setTitle("FXML Welcome");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
