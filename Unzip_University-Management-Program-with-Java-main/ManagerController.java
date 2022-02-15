package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ManagerController {

    public void registerStudent() {
        try {
            Stage primaryStage = new Stage();
            Parent Patient = FXMLLoader.load(getClass().getResource("RegisterStudent.fxml"));
            primaryStage.setTitle("Register Student");
            primaryStage.setScene(new Scene(Patient, 600, 400));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void employTeacher() {
        try {
            Stage primaryStage = new Stage();
            Parent Patient = FXMLLoader.load(getClass().getResource("EmployTeacher.fxml"));
            primaryStage.setTitle("Employ Teacher");
            primaryStage.setScene(new Scene(Patient, 600, 400));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void presentClass()
    {
        try {
            Stage primaryStage = new Stage();
            Parent Patient = FXMLLoader.load(getClass().getResource("PresentClass.fxml"));
            primaryStage.setTitle("Present Class");
            primaryStage.setScene(new Scene(Patient, 600, 400));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
}