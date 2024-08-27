package com.agasa.xd_f371_v0_0_1;

import com.agasa.xd_f371_v0_0_1.model.QDatabase;
import com.sun.tools.javac.Main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class F371Application extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Xăng dầu F371");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
        QDatabase qDatabase = new QDatabase();
        qDatabase.test();
    }
}