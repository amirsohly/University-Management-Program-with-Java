package sample;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.Scanner;

public class RemoveFileLine {

    public void remove(String fileName,String lineToRemove) throws IOException {
        BufferedWriter bufferedWriter_tmp=new BufferedWriter(new FileWriter(fileName+"_tmp.txt",true));
        Scanner scanner=new Scanner(new File(fileName+".txt"));
        while (scanner.hasNextLine()){
            String Line=scanner.nextLine().trim();
            if(!lineToRemove.equals(Line)) {
                bufferedWriter_tmp.write(Line+"\n");
            }
        }
        bufferedWriter_tmp.close();
        //copy to main file
        new FileWriter(fileName+".txt",false).close();
        FileChannel src = new FileInputStream(new File(fileName+"_tmp.txt")).getChannel();
        FileChannel dest = new FileOutputStream(new File(fileName)).getChannel();
        dest.transferFrom(src, 0, src.size());
        new FileWriter(fileName+"_tmp.txt",false).close();
        File file=new File(fileName+"_tmp.txt");
        file.delete();
    }
}
