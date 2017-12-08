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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import static sun.rmi.transport.TransportConstants.Return;

public class LoginScene{

    public static Scene LoginSceneMaker(Stage stage){

        DatabaseConnection x = DatabaseConnectionHub.x;

        VBox LoginSceneBase = new VBox();
        LoginSceneBase.setAlignment(Pos.CENTER);
        LoginSceneBase.setPadding(new Insets(20, 20, 20, 20));
        LoginSceneBase.setStyle("-fx-background-color: #82CAFF;");
        Scene LoginScene = new Scene(LoginSceneBase, 1024, 768);

        Label LoginTitle = new Label("Login");
        LoginTitle.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        LoginSceneBase.getChildren().add(LoginTitle);

        HBox UsernameHBOX = new HBox();
        UsernameHBOX.setAlignment(Pos.CENTER);
        UsernameHBOX.setPadding(new Insets(50, 0, 20, 0));
        LoginSceneBase.getChildren().add(UsernameHBOX);

        HBox PasswordHBOX = new HBox();
        PasswordHBOX.setAlignment(Pos.CENTER);
        PasswordHBOX.setPadding(new Insets(0, 0, 40, 0));
        LoginSceneBase.getChildren().add(PasswordHBOX);

        stage.setTitle("Login");
        stage.setScene(LoginScene);
        stage.show();

        Label Username = new Label("Username:");
        Username.setPadding(new Insets(0, 10, 0, 0));
        Username.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        UsernameHBOX.getChildren().add(Username);

        TextField UsernameTextField = new TextField();
        UsernameTextField.setMaxWidth(150);
        UsernameTextField.setAlignment(Pos.CENTER);
        UsernameTextField.setPromptText("Enter your username");
        UsernameTextField.setStyle("-fx-font-style: italic");
        UsernameHBOX.getChildren().add(UsernameTextField);

        Label Password = new Label("Password:");
        Password.setPadding(new Insets(0, 10, 0, 0));
        Password.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        PasswordHBOX.getChildren().add(Password);

        Button LoginButton = new Button("Login"); //Defined here for use in the passwordfield automatic login

        PasswordField pf = new PasswordField();
        pf.setMaxWidth(150);
        pf.setAlignment(Pos.CENTER);
        pf.setPromptText("Enter your password");
        pf.setStyle("-fx-font-style: italic");
        pf.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LoginButton.fire();
            }
        });
        PasswordHBOX.getChildren().add(pf);

        Label WrongPassword = new Label("Wrong Password");
        WrongPassword.setPadding(new Insets(0, 10, 0, 0));
        WrongPassword.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        WrongPassword.setTextFill(Color.RED);
        WrongPassword.setVisible(false);
        LoginSceneBase.getChildren().add(WrongPassword);

        HBox LoginButtonHBOX = new HBox();
        LoginButtonHBOX.setAlignment(Pos.CENTER);
        LoginButtonHBOX.setPadding(new Insets(20, 0, 20, 0));
        LoginSceneBase.getChildren().add(LoginButtonHBOX);

        LoginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(pf.getText().compareTo(StudentsService.selectById((int)Integer.parseInt(UsernameTextField.getText()),x).getPassword()) == 0){
                    stage.setScene(MainMenuScene.MainMenuMaker(stage));
                    pf.clear();
                    UsernameTextField.clear();
                    WrongPassword.setVisible(false);
                }
                else{
                    WrongPassword.setVisible(true);
                }
            }
        });
        LoginButtonHBOX.getChildren().add(LoginButton);

        HBox CreateNewAccountButtonHBOX = new HBox();
        CreateNewAccountButtonHBOX.setAlignment(Pos.CENTER);
        CreateNewAccountButtonHBOX.setPadding(new Insets(20, 0, 20, 0));
        LoginSceneBase.getChildren().add(CreateNewAccountButtonHBOX);

        Button CreateNewAccountButtonGoTo = new Button("Create new account");
        CreateNewAccountButtonGoTo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(CreateAccountScene.CreateAccountMaker(stage));
            }
        });
        CreateNewAccountButtonHBOX.getChildren().add(CreateNewAccountButtonGoTo);

        Button ForgotPassword = new Button("Forgot your password?");
        ForgotPassword.setTextFill(Color.RED);
        ForgotPassword.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Button Has No Functionality Currently");
            }
        });
        LoginSceneBase.getChildren().add(ForgotPassword);

        return  LoginScene;
    }
}
