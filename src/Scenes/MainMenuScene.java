package Scenes;

import Model.DatabaseConnection;
import Model.ScoresService;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenuScene{

    public static Scene MainMenuMaker(Stage stage){

        DatabaseConnection x = DatabaseConnectionHub.x;

        VBox MainMenuVBOX = new VBox();
        MainMenuVBOX.setAlignment(Pos.TOP_LEFT);
        MainMenuVBOX.setPadding(new Insets(20, 20, 20, 20));
        MainMenuVBOX.setStyle("-fx-background-color: #82CAFF;");
        Scene MainMenuScene = new Scene(MainMenuVBOX, 1024, 768);

        MenuBar MainMenuBar = new MenuBar();

        Menu OptionsMenu = new Menu("Options");
        MenuItem OptionsItem_Exit = new MenuItem("Exit");
        OptionsItem_Exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
        MenuItem OptionsItem_Logout = new MenuItem("Logout");
        OptionsItem_Logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(LoginScene.LoginSceneMaker(stage));
            }
        });
        MenuItem OptionsItem_Settings = new MenuItem("Settings");
        OptionsMenu.getItems().addAll(OptionsItem_Exit, OptionsItem_Logout, OptionsItem_Settings);

        Menu LeaderboardMenu = new Menu("Leaderboard");
        MenuItem LeaderboardItem_Maths = new MenuItem("Maths");
        LeaderboardItem_Maths.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LeaderboardScene.Scores.remove(0, LeaderboardScene.Scores.size()-1);
                LeaderboardScene.Scores.addAll(ScoresService.getScores("Maths", x));
                LeaderboardScene.LeaderboardTable.setItems(LeaderboardScene.Scores.sorted());
                stage.setScene(LeaderboardScene.LeaderboardMaker(stage));
            }
        });
        MenuItem LeaderboardItem_Typing = new MenuItem("Typing");
        LeaderboardItem_Typing.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LeaderboardScene.Scores.remove(0, LeaderboardScene.Scores.size()-1);
                LeaderboardScene.Scores.addAll(ScoresService.getScores("Typing", x));
                LeaderboardScene.LeaderboardTable.setItems(LeaderboardScene.Scores.sorted());
                stage.setScene(LeaderboardScene.LeaderboardMaker(stage));
            }
        });
        MenuItem LeaderboardItem_History = new MenuItem("History");
        LeaderboardItem_History.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LeaderboardScene.Scores.remove(0, LeaderboardScene.Scores.size()-1);
                LeaderboardScene.Scores.addAll(ScoresService.getScores("History", x));
                LeaderboardScene.LeaderboardTable.setItems(LeaderboardScene.Scores.sorted());
                stage.setScene(LeaderboardScene.LeaderboardMaker(stage));
            }
        });
        LeaderboardMenu.getItems().addAll(LeaderboardItem_Maths, LeaderboardItem_Typing, LeaderboardItem_History);

        MainMenuBar.getMenus().addAll(OptionsMenu, LeaderboardMenu);
        MainMenuVBOX.getChildren().add(MainMenuBar);

        return MainMenuScene;
    }
}
