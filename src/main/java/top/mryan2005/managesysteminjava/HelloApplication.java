package top.mryan2005.managesysteminjava;

import com.alibaba.fastjson.JSONObject;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import top.mryan2005.managesysteminjava.Settings.readJSON;

import java.io.IOException;
import java.sql.SQLException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("梧典");
        stage.setScene(scene);
        stage.show();
        readJSON readJSON = new readJSON("src/main/resources/config.json");
        JSONObject config = readJSON.getJSONContent();
        SQLLinker sql = new SQLLinker((String) config.get("SQLType"),(String) config.get("SQLServer"), (String) config.get("SQLPort"), (String) config.get("SQLUser"), (String) config.get("SQLPassword"), (String) config.get("SQLDatabase"));
    }

    public static void main(String[] args) {
        launch();
    }
}