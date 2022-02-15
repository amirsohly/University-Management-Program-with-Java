package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.util.Optional;
import java.util.Scanner;

public class PresentClassController {
    public ListView Teacher_lv;
    public TextField Name_tf;
    public TextField Number_tf;
    public Button ShowTeachers;
    public TextField time_tf;
    public TextField location_tf;

    public void teachersList() throws FileNotFoundException
    {
        ObservableList<String> items = FXCollections.observableArrayList();
        Scanner fp2=new Scanner(new File("teachersNoPass.txt"));
        fp2.useDelimiter("[\n]");
        while (fp2.hasNext()){
            items.add(fp2.next());
        }
        Teacher_lv.setItems(items);
    }

    public void employTeacher(MouseEvent mouseEvent) throws IOException {
        String teacher = (String) Teacher_lv.getFocusModel().getFocusedItem();
        Class newClass=new Class(Name_tf.getText(),Long.parseLong(Number_tf.getText()),time_tf.getText(),location_tf.getText(),teacher);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Present Class");
        alert.setHeaderText("Are You Sure That You Want Present This Class");
        alert.setContentText(newClass.toString());
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK)
        {
            newClass.addToFile();
            Scanner scanner=new Scanner(teacher);
            scanner.useDelimiter("[\t]");
            scanner.next();
            String teacherNumber=scanner.next();
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("t"+teacherNumber+".txt",true));
            bufferedWriter.write(newClass.toString());
            bufferedWriter.close();
            BufferedWriter bufferedWriter2=new BufferedWriter(new FileWriter("c"+Number_tf.getText()+".txt",true));
            bufferedWriter2.close();
        }
    }
}