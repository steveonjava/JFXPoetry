package steveonjava;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Stephen Chin <steveonjava@gmail.com>
 */
public class JFXPoetry extends Application {
    public static void main(String[] args) {
        Application.launch(JFXPoetry.class, args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Pippa's Song by Robert Browning");
        stage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("JFXPoetry.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("JFXPoetry.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
