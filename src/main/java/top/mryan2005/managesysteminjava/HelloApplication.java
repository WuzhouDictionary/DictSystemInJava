package top.mryan2005.managesysteminjava;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("梧典");
        stage.setScene(scene);
        stage.show();
        SQLLinker sql = new SQLLinker("SQL Server" ,"127.0.0.1", "1433", "sa", "A123456", "abc");
    }

    public static void main(String[] args) {
        launch();
    }
}