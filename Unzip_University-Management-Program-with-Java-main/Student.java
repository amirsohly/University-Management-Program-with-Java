package sample;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Student {
    String name;
    String password;
    long number;

    public Student(String name,String password,long number)
    {
        this.name=name;
        this.password=password;
        this.number=number;
    }
    public String toStringPass()
    {
        return name+"\t"+password+"\t"+number+"\n";
    }

    public String toStringNoPass()
    {
        return name+"\t"+number+"\n";
    }

    public void addToFilePass() throws IOException {
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("studentsPass.txt",true));
        bufferedWriter.write(toStringPass());
        bufferedWriter.close();
    }

    public void addToFileNopass() throws IOException {
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("studentsNoPass.txt",true));
        bufferedWriter.write(toStringNoPass());
        bufferedWriter.close();
    }

}