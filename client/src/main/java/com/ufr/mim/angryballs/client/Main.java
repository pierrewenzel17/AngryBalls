package com.ufr.mim.angryballs.client;

import com.ufr.mim.angryballs.client.utils.ConstantsUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public final class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("AngryBalls developed by Pierre WENZEL and Sebastien PHILIPP");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ConstantsUtil.FXML_FILE +
                ConstantsUtil.FILE_SEPARATOR + "sample.fxml"));
        AnchorPane root = fxmlLoader.load();
        fxmlLoader.getController();

        Scene scene = new Scene(root, 650, 400);
        primaryStage.setMinWidth(400);
        primaryStage.setMinHeight(250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
