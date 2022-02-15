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

public class TeacherController implements Initializable {

    public TextField txtField;
    public Label label;

    public void myFunction(String string)
    {
        label.setText(string);
    }

    public void teacherClasses()
    {
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("teacherClasses.fxml"));
            Parent root=(Parent) loader.load();

            teacherClassesController teacherClassesController=loader.getController();
            teacherClassesController.setTeacher(label.getText());
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


}