package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.*;
import java.util.Optional;
import java.util.Scanner;

public class teacherClassesController {
    public ListView Classes_lv;
    String teacher;

    public void setTeacher(String teacher)
    {
        this.teacher=teacher;
    }

    public void viewClasses() throws FileNotFoundException
    {
        ObservableList<String> items = FXCollections.observableArrayList();
        System.out.println(teacher);
        Scanner scanner=new Scanner(new File("t"+teacher+".txt"));
        scanner.useDelimiter("[\n]");
        while (scanner.hasNext()){
            items.add(scanner.next());
        }
        Classes_lv.setItems(items);
    }

    public void viewStudents(MouseEvent mouseEvent) throws IOException {
        String selectedClass = (String) Classes_lv.getFocusModel().getFocusedItem();
        Scanner scanner=new Scanner(selectedClass);
        scanner.useDelimiter("[\t]");
        scanner.next();
        String classNumber=scanner.next();
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("ViewStudents.fxml"));
            Parent root=(Parent) loader.load();

            ViewStudentsController viewStudentsController=loader.getController();
            viewStudentsController.myFunction(classNumber);
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}