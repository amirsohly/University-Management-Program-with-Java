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

public class RemoveClassController {

    public ListView Classes_lv;
    String student;

    public void setStudent(String student)
    {
        this.student=student;
    }

    public void listView() throws FileNotFoundException {
        ObservableList<String> items = FXCollections.observableArrayList();
        Scanner scanner=new Scanner(new File("s"+student+".txt"));
        scanner.useDelimiter("[\n]");
        while (scanner.hasNext()){
            items.add(scanner.next());
        }
        Classes_lv.setItems(items);
    }

    public void viewClasses() throws FileNotFoundException
    {
        listView();
    }

    public void removeClass(MouseEvent mouseEvent) throws IOException {
        String selectedClass = (String) Classes_lv.getFocusModel().getFocusedItem();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Remove Class");
        alert.setHeaderText("Are You Sure That You Want Remove This Class");
        alert.setContentText(selectedClass);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK)
        {
            BufferedWriter bufferedWriter_tmp=new BufferedWriter(new FileWriter("s"+student+"_tmp.txt",true));
            Scanner scanner=new Scanner(new File("s"+student+".txt"));
            while (scanner.hasNextLine()){
                String Line=scanner.nextLine().trim();
                if(!selectedClass.equals(Line)) {
                    bufferedWriter_tmp.write(Line+"\n");
                }
            }
            bufferedWriter_tmp.close();
            //copy to main file
            new FileWriter("s"+student+".txt",false).close();
            FileChannel src = new FileInputStream(new File("s"+student+"_tmp.txt")).getChannel();
            FileChannel dest = new FileOutputStream(new File("s"+student)).getChannel();
            dest.transferFrom(src, 0, src.size());
            new FileWriter("s"+student+"_tmp.txt",false).close();
            File file=new File("s"+student+"_tmp.txt");
            file.delete();
            listView();

        }
    }
}