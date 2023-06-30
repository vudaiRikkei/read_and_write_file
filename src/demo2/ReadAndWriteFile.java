package demo2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile<T> {

    public List<T> readFromFile(String pathFile){
        List<T> list = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(pathFile);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            list = (List<T>) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
        return list;
    }

    public void writeToFile(List<T> list, String pathFile){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(pathFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(list);
            fileOutputStream.close();
            objectOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ghi file thất bại");
        }
    }

}
