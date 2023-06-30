package demo.demo_binary_file;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        List<Book> bookList = new ArrayList<>();
        Book book1 = new Book(1,"De men");
        Book book2 = new Book(2,"De choat");
        Book book3 = new Book(3,"De cu");
        Book book4 = new Book(4,"De choi");
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
        writeToFile(bookList,"books.txt");
        List<Book> list = readFromFile("books.txt");
        for (Book b: list) {
            System.out.println("ID :" +b.getId() + "| Name :" +b.getName());
        }
    }
    public static void writeToFile(List<Book> list,String fileName){
        File file =null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            file = new File(fileName);
            if (!file.exists()){
                file.createNewFile();
            }
            fos= new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            // ghi file
            oos.writeObject(list);
        }catch (IOException e){
            throw  new RuntimeException(e);
        }finally {
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(oos!=null){
                try {
                    oos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public static List<Book> readFromFile(String fileName){
        File file = null;
        FileInputStream fis =null;
        ObjectInputStream ois = null;
        List<Book> list = null;
        try{
            file = new File(fileName);
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            list = (List<Book>) ois.readObject();

        }catch (ClassNotFoundException c){
            c.printStackTrace();
        }catch (IOException e){
            throw  new RuntimeException(e);
        }finally {
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(ois!=null){
                try {
                    ois.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return list;
    }
}