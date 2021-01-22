/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videorendersystem;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class Vieo_Player extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        Parent root = FXMLLoader.load(getClass().getResource("video_player.fxml"));
        primaryStage.setTitle("Movies");
        primaryStage.getIcons().add(new javafx.scene.image.Image("file:resources/small.png"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setMaxHeight(850);
        primaryStage.setMaxWidth(1215);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
