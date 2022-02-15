package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ViewClassesController {

    public ListView Classes_lv;

    public void viewClasses() throws FileNotFoundException
    {
        ObservableList<String> items = FXCollections.observableArrayList();
        Scanner scanner=new Scanner(new File("classes.txt"));
        scanner.useDelimiter("[\n]");
        while (scanner.hasNext()){
            items.add(scanner.next());
        }
        Classes_lv.setItems(items);
    }
}