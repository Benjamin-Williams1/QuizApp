package Scenes;

import Model.DatabaseConnection;
import Model.StudentsService;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class AccountCreatedScene {

    public static Scene AccountCreatedMaker(Stage stage){

        DatabaseConnection x = DatabaseConnectionHub.x;

        VBox AccountCreatedVBOX = new VBox();
        AccountCreatedVBOX.setAlignment(Pos.TOP_LEFT);
        AccountCreatedVBOX.setPadding(new Insets(20, 20, 20, 20));
        AccountCreatedVBOX.setStyle("-fx-background-color: #82CAFF;");
        Scene AccountCreatedScene = new Scene(AccountCreatedVBOX, 1024, 768);

        Label CreatedAccountTitle = new Label("Account Created");
        CreatedAccountTitle.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        AccountCreatedVBOX.getChildren().add(CreatedAccountTitle);

        Label AccountIDDisplayer = new Label("Your User ID is " + (StudentsService.LastAdded(x) + 1));
        AccountIDDisplayer.setPadding(new Insets(0, 10, 15, 0));
        AccountIDDisplayer.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        AccountCreatedVBOX.getChildren().add(AccountIDDisplayer);

        Button AccountCreatedButtonContinue = new Button("Continue");
        AccountCreatedButtonContinue.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(MainMenuScene.MainMenuMaker(stage));
            }
        });
        AccountCreatedVBOX.getChildren().add(AccountCreatedButtonContinue);

        return AccountCreatedScene;
    }
}
