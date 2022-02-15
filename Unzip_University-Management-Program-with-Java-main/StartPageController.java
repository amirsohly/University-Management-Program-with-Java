package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartPageController {
    public void Manager_Action()
    {
        try {
            Stage primaryStage=new Stage();
            Parent Patient = FXMLLoader.load(getClass().getResource("Manager.fxml"));
            primaryStage.setTitle("Manager");
            primaryStage.setScene(new Scene(Patient, 600, 400));
            primaryStage.show();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void Student_Action()
    {
        try {
            Stage primaryStage=new Stage();
            Parent Patient = FXMLLoader.load(getClass().getResource("LoginStudent.fxml"));
            primaryStage.setTitle("Student");
            primaryStage.setScene(new Scene(Patient, 600, 400));
            primaryStage.show();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void Teacher_Action()
    {
        try {
            Stage primaryStage=new Stage();
            Parent Patient = FXMLLoader.load(getClass().getResource("LoginTeacher.fxml"));
            primaryStage.setTitle("Teacher");
            primaryStage.setScene(new Scene(Patient, 600, 400));
            primaryStage.show();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}