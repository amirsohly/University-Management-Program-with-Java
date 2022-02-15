package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.Optional;
import java.util.Scanner;

public class ViewStudentsController {

    public ListView Classes_lv;
    String classNumber;

    public void myFunction(String number)
    {
        classNumber=number;
    }

    public void viewStudents() throws FileNotFoundException
    {
        ObservableList<String> items = FXCollections.observableArrayList();
        Scanner scanner=new Scanner(new File("c"+classNumber+".txt"));
        scanner.useDelimiter("[\n]");
        while (scanner.hasNext()){
            items.add(scanner.next());
        }
        Classes_lv.setItems(items);
    }

    public void removeClass(MouseEvent mouseEvent) throws IOException {
        String selectedStudent = (String) Classes_lv.getFocusModel().getFocusedItem();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Remove Student");
        alert.setHeaderText("Are You Sure That You Want Remove This Student");
        alert.setContentText(selectedStudent);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            RemoveFileLine remove = new RemoveFileLine();
            remove.remove("c" + classNumber, selectedStudent);
            Scanner scanner=new Scanner(selectedStudent);
            scanner.useDelimiter("[\t]");
            scanner.next();
            String stuNumber=scanner.next();
            Scanner scanner1=new Scanner(new File("classes.txt"));

            while (scanner1.hasNextLine())
            {
                String removedClass=scanner1.nextLine();
                Scanner scanner2=new Scanner(removedClass);
                scanner2.useDelimiter("[\t]");
                scanner2.next();
                if (scanner2.next().equals(classNumber))
                {
                    RemoveFileLine remove1=new RemoveFileLine();
                    remove1.remove("s"+stuNumber,removedClass);
                    break;
                }
            }
        }
    }
}