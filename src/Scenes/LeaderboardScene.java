package Scenes;

import Model.DatabaseConnection;
import Model.ScoresService;
import Model.StudentsService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.awt.event.ActionListener;

public class LeaderboardScene {

    public static Scene LeaderboardMaker(Stage stage){

        DatabaseConnection x = DatabaseConnectionHub.x;
        ObservableList<Integer> Scores = FXCollections.observableArrayList();

        ListView LeaderboardTable = new ListView(Scores.sorted());

        VBox LeaderboardVBOX = new VBox();
        LeaderboardVBOX.setAlignment(Pos.CENTER);
        LeaderboardVBOX.setPadding(new Insets(20,20,20,20));
        LeaderboardVBOX.setStyle("-fx-background-color: #82CAFF;");
        Scene LeaderboardScene = new Scene(LeaderboardVBOX, 1024, 768);

        MenuBar LeaderboardMenuBar = new MenuBar();

        Menu OptionsMenu_LeaderboardVersion = new Menu("Options");
        MenuItem OptionsItem_Exit_LeaderboardVersion = new MenuItem("Exit");
        OptionsItem_Exit_LeaderboardVersion.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
        MenuItem OptionsItem_Logout_LeaderboardVersion = new MenuItem("Logout");
        OptionsItem_Logout_LeaderboardVersion.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(LoginScene.LoginSceneMaker(stage));
            }
        });
        MenuItem OptionsItem_Settings_LeaderboardVersion = new MenuItem("Settings");
        OptionsMenu_LeaderboardVersion.getItems().addAll(OptionsItem_Exit_LeaderboardVersion, OptionsItem_Logout_LeaderboardVersion, OptionsItem_Settings_LeaderboardVersion);

        Menu LeaderboardMenu_LeaderboardVersion = new Menu("Leaderboard");
        MenuItem LeaderboardItem_Maths_LeaderboardVersion = new MenuItem("Maths");
        LeaderboardItem_Maths_LeaderboardVersion.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //LeaderboardTable.getItems().removeAll();

                ObservableList potential = LeaderboardTable.getSelectionModel().getSelectedItems();
                LeaderboardTable.getSelectionModel().clearSelection();
                Scores.remove(potential);

                //Scores.removeAll();
                Scores.addAll(ScoresService.getScores("Maths", x));
                stage.setScene(LeaderboardScene);
            }
        });
        MenuItem LeaderboardItem_Typing_LeaderboardVersion = new MenuItem("Typing");
        LeaderboardItem_Typing_LeaderboardVersion.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LeaderboardTable.getItems().removeAll();
                Scores.removeAll();
                Scores.addAll(ScoresService.getScores("Typing", x));
                stage.setScene(LeaderboardScene);
            }
        });
        MenuItem LeaderboardItem_History_LeaderboardVersion = new MenuItem("History");
        LeaderboardItem_History_LeaderboardVersion.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LeaderboardTable.getItems().removeAll();
                Scores.removeAll();
                Scores.addAll(ScoresService.getScores("History", x));
                stage.setScene(LeaderboardScene);
            }
        });
        LeaderboardMenu_LeaderboardVersion.getItems().addAll(LeaderboardItem_Maths_LeaderboardVersion, LeaderboardItem_Typing_LeaderboardVersion, LeaderboardItem_History_LeaderboardVersion);

        LeaderboardMenuBar.getMenus().addAll(OptionsMenu_LeaderboardVersion, LeaderboardMenu_LeaderboardVersion);
        LeaderboardVBOX.getChildren().add(LeaderboardMenuBar);


        Label LeaderboardTitle = new Label("Leaderboard");
        LeaderboardTitle.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        LeaderboardTitle.setPadding(new Insets(0,0,20,0));
        LeaderboardVBOX.getChildren().add(LeaderboardTitle);

        LeaderboardTable.setMinSize(100,100);
        LeaderboardTable.setMaxSize(300,300);
        LeaderboardVBOX.getChildren().add(LeaderboardTable);

        return LeaderboardScene;
    }
}
