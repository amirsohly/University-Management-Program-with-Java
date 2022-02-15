package sample;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginTeacherController implements Initializable {
    boolean isLogin=false;
    public TextField Name_tf;
    public TextField Password_tf;
    public TextField Number_tf;
    public Button Login;
    public Label loginAlert;
    Parent parent;
    Stage stage;
    Label label;





    public void login() throws FileNotFoundException {
        Scanner scanner=new Scanner(new File("teachersPass.txt"));
        scanner.useDelimiter("[\n]");
        while (scanner.hasNext()){
            if (scanner.next().contains(Name_tf.getText()+"\t"+Password_tf.getText()+"\t"+Number_tf.getText()))
            {
                loginAlert.setText("Login Successfully");
                isLogin=true;

                try {
                    FXMLLoader loader=new FXMLLoader(getClass().getResource("Teacher.fxml"));
                    Parent root=(Parent) loader.load();

                    TeacherController teacherController=loader.getController();
                    teacherController.myFunction(Number_tf.getText());
                    Stage stage=new Stage();
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        if (isLogin==false)
        {
            loginAlert.setText("Login Failed");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}