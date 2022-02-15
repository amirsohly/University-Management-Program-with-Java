package sample;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RegisterStudentController {

    public TextField Name_tf;
    public TextField Password_tf;
    public TextField Number_tf;
    public Button Register_Stu;

    public void registerStudent() throws IOException {
        Student student=new Student(Name_tf.getText(),Password_tf.getText(),Long.parseLong(Number_tf.getText()));
        student.addToFilePass();
        student.addToFileNopass();
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("s"+Number_tf.getText()+".txt",true));
        bufferedWriter.close();
    }
}