package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.util.Optional;
import java.util.Scanner;

public class GetClassController {

    public ListView getClasses_lv;
    String student;
    boolean isDublicate=false;

    public void setStudent(String student)
    {
        this.student=student;
    }

    public void viewClasses() throws FileNotFoundException
    {
        ObservableList<String> items = FXCollections.observableArrayList();
        Scanner fp2=new Scanner(new File("classes.txt"));
        fp2.useDelimiter("[\n]");
        while (fp2.hasNext()){
            items.add(fp2.next());
        }
        getClasses_lv.setItems(items);
    }

    public void getClass(MouseEvent mouseEvent) throws IOException {
        String selectedClass= (String) getClasses_lv.getFocusModel().getFocusedItem();
        Scanner scanner2=new Scanner(selectedClass);
        scanner2.useDelimiter("[\t]");
        scanner2.next();
        String classNumber=scanner2.next();
        System.out.println(student);
        Scanner scanner=new Scanner(new File("s"+student+".txt"));
        scanner.useDelimiter("[\n]");
        while (scanner.hasNext() )
        {
            if(scanner.next().equals(selectedClass))
            {
                isDublicate=true;
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Dublicate Class");
                alert.setHeaderText(null);
                alert.setContentText("You already Got this class!");
                alert.showAndWait();
            }
        }
        if (isDublicate==false)
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Get Class");
            alert.setHeaderText("Are You Sure That You Want Get This Class");
            alert.setContentText(selectedClass);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK)
            {
                isDublicate=true;
                BufferedWriter bufferedWriter1=new BufferedWriter(new FileWriter("s"+student+".txt",true));
                bufferedWriter1.write(selectedClass+"\n");
                bufferedWriter1.close();
                BufferedWriter bufferedWriter2=new BufferedWriter(new FileWriter("c"+classNumber+".txt",true));
                Scanner scanner1=new Scanner(new File("studentsNoPass.txt"));
                String studentFormation=null;
                while (scanner1.hasNextLine())
                {
                    studentFormation=scanner1.nextLine();
                    if (studentFormation.contains(student))
                    {
                        break;
                    }
                }
                bufferedWriter2.write(studentFormation+"\n");
                bufferedWriter2.close();
            }
        }
    }
}