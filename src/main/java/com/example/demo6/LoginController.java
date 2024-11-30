package com.example.demo6;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    public TextField tf;
    public PasswordField pf;
    public Text message;

    public void handleLogin(ActionEvent event) throws IOException {
        String user = tf.getText();
        String pass = pf.getText();
        String defaultPass = "123";
        if (pass.equals(defaultPass)){
            System.out.println("Success");
//            message.setText("Success!!!!");

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Welcome.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 320, 240);

            Welcome welcome = fxmlLoader.getController();
            welcome.setUsername(user);

            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        }
        else{
            System.out.println("Access Denied!!!");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid Credentials");
            alert.setHeaderText("Login Failed!");
            alert.setContentText("Wrong Password");
            alert.show();
        }
    }
}
