package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class receivedClassesController {
    public ListView Classes_lv;
    String student;

    public void setStudent(String student)
    {
        this.student=student;
    }

    public void viewClasses() throws FileNotFoundException
    {
        ObservableList<String> items = FXCollections.observableArrayList();
        Scanner scanner=new Scanner(new File("s"+student+".txt"));
        scanner.useDelimiter("[\n]");
        while (scanner.hasNext()){
            items.add(scanner.next());
        }
        Classes_lv.setItems(items);
    }
}