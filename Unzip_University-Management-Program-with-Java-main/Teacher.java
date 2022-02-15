package sample;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Teacher {
    String name;
    String password;
    long number;
    String major;

    public Teacher(String name,String password,long number,String major)
    {
        this.name=name;
        this.password=password;
        this.number=number;
        this.major=major;
    }

    public String toStringPass()
    {
        return name+"\t"+password+"\t"+number+"\t"+major+"\n";
    }

    public String toStringNoPass()
    {
        return name+"\t"+number+"\t"+major+"\n";
    }

    public void addToFilePass() throws IOException {
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("teachersPass.txt",true));
        bufferedWriter.write(toStringPass());
        bufferedWriter.close();
    }
    public void addToFileNoPass() throws IOException {
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("teachersNoPass.txt",true));
        bufferedWriter.write(toStringNoPass());
        bufferedWriter.close();
    }
}