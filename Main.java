package rps.panda.org;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("rps.fxml")));
        primaryStage.setTitle("Rock Paper Scissors!");
        primaryStage.getIcons().add(new Image("/logo.png"));
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root));
        primaryStage.setOnCloseRequest(e -> {

            e.consume();
            boolean result = AlertBox.yesPopup("Rock Paper Scissors", "Are you sure you want to exit?");

            if(result) {
                System.exit(0);
            }
        });
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
