import Model.*;
import Scenes.DatabaseConnectionHub;
import Scenes.LoginScene;
import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import javafx.application.Application;
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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

import java.util.*;

public class Main extends Application {

        @Override
        public void start(Stage stage) throws Exception {

            stage.setScene(LoginScene.LoginSceneMaker(stage));
            stage.show();

            /*VBox LoginSceneBase = new VBox();
            LoginSceneBase.setAlignment(Pos.CENTER);
            LoginSceneBase.setPadding(new Insets(20, 20, 20, 20));
            LoginSceneBase.setStyle("-fx-background-color: #82CAFF;");
            Scene LoginScene = new Scene(LoginSceneBase, 1024, 768);*/

            /*VBox DataVBOX = new VBox();
            DataVBOX.setAlignment(Pos.TOP_LEFT);
            DataVBOX.setPadding(new Insets(20, 20, 20, 20));
            DataVBOX.setStyle("-fx-background-color: #82CAFF;");
            Scene CreateNewAccountScene = new Scene(DataVBOX, 1024, 768);*/

            /*VBox AccountCreatedVBOX = new VBox();
            AccountCreatedVBOX.setAlignment(Pos.TOP_LEFT);
            AccountCreatedVBOX.setPadding(new Insets(20, 20, 20, 20));
            AccountCreatedVBOX.setStyle("-fx-background-color: #82CAFF;");
            Scene AccountCreatedScene = new Scene(AccountCreatedVBOX, 1024, 768);*/

            /*VBox MainMenuVBOX = new VBox();
            MainMenuVBOX.setAlignment(Pos.TOP_LEFT);
            MainMenuVBOX.setPadding(new Insets(20, 20, 20, 20));
            MainMenuVBOX.setStyle("-fx-background-color: #82CAFF;");
            Scene MainMenuScene = new Scene(MainMenuVBOX, 1024, 768);*/

            /*VBox LeaderboardVBOX = new VBox();
            LeaderboardVBOX.setAlignment(Pos.CENTER);
            LeaderboardVBOX.setPadding(new Insets(20,20,20,20));
            LeaderboardVBOX.setStyle("-fx-background-color: #82CAFF;");
            Scene LeaderboardScene = new Scene(LeaderboardVBOX, 1024, 768);*/

            /*Label LoginTitle = new Label("Login");
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

            PasswordField pf = new PasswordField();
            pf.setMaxWidth(150);
            pf.setAlignment(Pos.CENTER);
            pf.setPromptText("Enter your password");
            pf.setStyle("-fx-font-style: italic");
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

            Button LoginButton = new Button("Login");
            LoginButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if(pf.getText().compareTo(StudentsService.selectById((int)Integer.parseInt(UsernameTextField.getText()),x).getPassword()) == 0){
                        stage.setScene(MainMenuScene);
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
                    stage.setScene(CreateNewAccountScene);
                }
            });
            CreateNewAccountButtonHBOX.getChildren().add(CreateNewAccountButtonGoTo);

            Button ForgotPassword = new Button("Forgot your password?");
            ForgotPassword.setTextFill(Color.RED);
            LoginSceneBase.getChildren().add(ForgotPassword);*/

            /*Label CreateNewAccountTitle = new Label("Create a new account");
            CreateNewAccountTitle.setFont(Font.font("Arial", FontWeight.BOLD, 40));
            DataVBOX.getChildren().add(CreateNewAccountTitle);

            HBox DataHBOX = new HBox();
            DataHBOX.setAlignment(Pos.CENTER_LEFT);
            DataHBOX.setPadding(new Insets(0, 0, 15, 0));
            DataVBOX.getChildren().add(DataHBOX);

            VBox LabelVBOX = new VBox();
            LabelVBOX.setAlignment(Pos.CENTER_LEFT);
            LabelVBOX.setPadding(new Insets(0, 0, 15, 0));
            DataHBOX.getChildren().add(LabelVBOX);

            VBox TextFieldVBOX = new VBox();
            TextFieldVBOX.setAlignment(Pos.CENTER_LEFT);
            TextFieldVBOX.setPadding(new Insets(0, 0, 15, 0));
            DataHBOX.getChildren().add(TextFieldVBOX);

            Label NameDefine = new Label("Name:");
            NameDefine.setPadding(new Insets(0, 10, 15, 0));
            NameDefine.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            LabelVBOX.getChildren().add(NameDefine);

            TextField NameDefineTextField = new TextField();
            NameDefineTextField.setMaxWidth(150);
            NameDefineTextField.setAlignment(Pos.CENTER);
            NameDefineTextField.setPromptText("Enter your name");
            NameDefineTextField.setStyle("-fx-font-style: italic");
            NameDefineTextField.setPadding(new Insets(0, 10, 15, 0));
            TextFieldVBOX.getChildren().add(NameDefineTextField);

            HBox PasswordDefineHBOX = new HBox();
            PasswordDefineHBOX.setPadding(new Insets(20,0,20,0));
            LabelVBOX.getChildren().add(PasswordDefineHBOX);

            Label PasswordDefine = new Label("Password:");
            PasswordDefine.setPadding(new Insets(0, 10, 15, 0));
            PasswordDefine.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            PasswordDefineHBOX.getChildren().add(PasswordDefine);

            HBox PasswordDefineTextFieldHBOX = new HBox();
            PasswordDefineTextFieldHBOX.setPadding(new Insets(20,0,20,0));
            TextFieldVBOX.getChildren().add(PasswordDefineTextFieldHBOX);

            TextField PasswordDefineTextField = new TextField();
            PasswordDefineTextField.setMaxWidth(150);
            PasswordDefineTextField.setAlignment(Pos.CENTER);
            PasswordDefineTextField.setPromptText("Enter your password");
            PasswordDefineTextField.setStyle("-fx-font-style: italic");
            PasswordDefineTextField.setPadding(new Insets(0, 10, 15, 0));
            PasswordDefineTextFieldHBOX.getChildren().add(PasswordDefineTextField);

            Label PasswordDefineConfirm = new Label("Confirm Password:");
            PasswordDefineConfirm.setPadding(new Insets(0, 10, 15, 0));
            PasswordDefineConfirm.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            LabelVBOX.getChildren().add(PasswordDefineConfirm);

            TextField PasswordDefineConfirmTextField = new TextField();
            PasswordDefineConfirmTextField.setMaxWidth(150);
            PasswordDefineConfirmTextField.setAlignment(Pos.CENTER);
            PasswordDefineConfirmTextField.setPromptText("Re-enter your Password");
            PasswordDefineConfirmTextField.setStyle("-fx-font-style: italic");
            PasswordDefineConfirmTextField.setPadding(new Insets(0, 10, 15, 0));
            TextFieldVBOX.getChildren().add(PasswordDefineConfirmTextField);

            HBox CreateNewAccountButtonGoBackHBOX = new HBox();
            CreateNewAccountButtonGoBackHBOX.setPadding(new Insets(0,0,20,0));
            DataVBOX.getChildren().add(CreateNewAccountButtonGoBackHBOX);

            Button CreateNewAccountButtonGoBack = new Button("Go back to login");
            CreateNewAccountButtonGoBack.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    stage.setScene(LoginScene);
                }
            });
            CreateNewAccountButtonGoBackHBOX.getChildren().add(CreateNewAccountButtonGoBack);

            Label PleaseConfirmPasswordLabel = new Label("Please confirm your password");
            PleaseConfirmPasswordLabel.setPadding(new Insets(15, 0, 0, 0));
            PleaseConfirmPasswordLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            PleaseConfirmPasswordLabel.setTextFill(Color.RED);
            PleaseConfirmPasswordLabel.setVisible(false);
            TextFieldVBOX.getChildren().add(PleaseConfirmPasswordLabel);

            Button CreateNewAccountButtonContinue = new Button("Continue");
            CreateNewAccountButtonContinue.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if(PasswordDefineTextField.getText().compareTo(PasswordDefineConfirmTextField.getText()) == 0) {
                        stage.setScene(AccountCreatedScene);
                        Students AddingStudents = new Students(0, NameDefineTextField.getText(), PasswordDefineTextField.getText());
                        StudentsService.save(AddingStudents, x);
                        PleaseConfirmPasswordLabel.setVisible(false);
                        NameDefineTextField.clear();
                        PasswordDefineTextField.clear();
                        PasswordDefineConfirmTextField.clear();
                    }else{
                        PleaseConfirmPasswordLabel.setVisible(true);
                    }
                }
            });
            DataVBOX.getChildren().add(CreateNewAccountButtonContinue);*/

            /*Label CreatedAccountTitle = new Label("Account Created");
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
                    stage.setScene(MainMenuScene);
                }
            });
            AccountCreatedVBOX.getChildren().add(AccountCreatedButtonContinue);*/

            /*MenuBar MainMenuBar = new MenuBar();

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
                    stage.setScene(LoginScene);
                }
            });
            MenuItem OptionsItem_Settings = new MenuItem("Settings");
            OptionsMenu.getItems().addAll(OptionsItem_Exit, OptionsItem_Logout, OptionsItem_Settings);

            Menu LeaderboardMenu = new Menu("Leaderboard");
            MenuItem LeaderboardItem_Maths = new MenuItem("Maths");
            LeaderboardItem_Maths.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    stage.setScene(LeaderboardScene);
                }
            });
            MenuItem LeaderboardItem_Typing = new MenuItem("Typing");
            LeaderboardItem_Typing.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    stage.setScene(LeaderboardScene);
                }
            });
            MenuItem LeaderboardItem_History = new MenuItem("History");
            LeaderboardItem_History.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    stage.setScene(LeaderboardScene);
                }
            });
            LeaderboardMenu.getItems().addAll(LeaderboardItem_Maths, LeaderboardItem_Typing, LeaderboardItem_History);

            MainMenuBar.getMenus().addAll(OptionsMenu, LeaderboardMenu);
            MainMenuVBOX.getChildren().add(MainMenuBar);*/

            /*MenuBar LeaderboardMenuBar = new MenuBar();

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
                    stage.setScene(LoginScene);
                }
            });
            MenuItem OptionsItem_Settings_LeaderboardVersion = new MenuItem("Settings");
            OptionsMenu_LeaderboardVersion.getItems().addAll(OptionsItem_Exit_LeaderboardVersion, OptionsItem_Logout_LeaderboardVersion, OptionsItem_Settings_LeaderboardVersion);

            Menu LeaderboardMenu_LeaderboardVersion = new Menu("Leaderboard");
            MenuItem LeaderboardItem_Maths_LeaderboardVersion = new MenuItem("Maths");
            LeaderboardItem_Maths_LeaderboardVersion.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    stage.setScene(LeaderboardScene);
                }
            });
            MenuItem LeaderboardItem_Typing_LeaderboardVersion = new MenuItem("Typing");
            LeaderboardItem_Typing_LeaderboardVersion.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    stage.setScene(LeaderboardScene);
                }
            });
            MenuItem LeaderboardItem_History_LeaderboardVersion = new MenuItem("History");
            LeaderboardItem_History_LeaderboardVersion.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
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

            ObservableList<String> MathScoresArrayList = FXCollections.observableArrayList("First word","Second word", "Third word", "Etc.");
            ListView<String> MathsScores = new ListView<>(MathScoresArrayList);

            ListView LeaderboardTable = new ListView();
            LeaderboardTable.setItems(MathsScores);
            LeaderboardVBOX.getChildren().add(LeaderboardTable);*/



        }

        public static void main(String[] args) {
            launch(args);
        }
    }

    //Just wanted to check this is working

