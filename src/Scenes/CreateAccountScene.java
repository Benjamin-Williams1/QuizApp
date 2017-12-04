package Scenes;

import Model.DatabaseConnection;
import Model.Students;
import Model.StudentsService;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class CreateAccountScene {

    public static Scene CreateAccountMaker(Stage stage){

        DatabaseConnection x = DatabaseConnectionHub.x;

        VBox DataVBOX = new VBox();
        DataVBOX.setAlignment(Pos.TOP_LEFT);
        DataVBOX.setPadding(new Insets(20, 20, 20, 20));
        DataVBOX.setStyle("-fx-background-color: #82CAFF;");
        Scene CreateNewAccountScene = new Scene(DataVBOX, 1024, 768);

        Label CreateNewAccountTitle = new Label("Create a new account");
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
                stage.setScene(LoginScene.LoginSceneMaker(stage));
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
                    stage.setScene(AccountCreatedScene.AccountCreatedMaker(stage));
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
        DataVBOX.getChildren().add(CreateNewAccountButtonContinue);

        return CreateNewAccountScene;
    }
}
