package sample;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentController implements Initializable {

    public TextField txtField;
    public Label label;
    LoginStudentController login=new LoginStudentController();

    public void viewClasses()
    {
        try {
            Stage primaryStage = new Stage();
            Parent Patient = FXMLLoader.load(getClass().getResource("ViewClasses.fxml"));
            primaryStage.setTitle("View Classes");
            primaryStage.setScene(new Scene(Patient, 600, 400));
            primaryStage.show();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void getClassStu()
    {
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("GetClass.fxml"));
            Parent root=(Parent) loader.load();

            GetClassController getClassController=loader.getController();
            getClassController.setStudent(label.getText());
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void receivedClasses()
    {
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("receivedClasses.fxml"));
            Parent root=(Parent) loader.load();

            receivedClassesController receivedClassesController=loader.getController();
            receivedClassesController.setStudent(label.getText());
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeClass()
    {
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("RemoveClass.fxml"));
            Parent root=(Parent) loader.load();

            RemoveClassController removeClassController=loader.getController();
            removeClassController.setStudent(label.getText());
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void myFunction(String string) {
        label.setText(string);
    }
}