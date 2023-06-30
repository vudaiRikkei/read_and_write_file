package demo.demo_IOTextFile;

import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // File

        File file = new File("test.html");
        File file2 = new File("E:\\Rikkei Academi\\code\\MD3\\jv03_23\\IOtext_filedemo.txt");
        System.out.println(file.exists());
        System.out.println(file2.exists());
        System.out.println(file2.length());
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        File directory = new File("resource");
        if (!directory.exists()) {
//          directory.delete();
            directory.mkdir();
        }
        if (directory.exists()) {
//            String[] list = directory.list();
//            for (String name: list
//                 ) {
//                System.out.println(name);
//            }
            File[] listFile = directory.listFiles();
            for (File f : listFile) {
                System.out.println(f.delete());
            }
            // ghi ra file
            // text
//            char[] chars = {'a', 'b', 'c'};
            String str = "kjfa kjlbslkf  faksjf sak fw v;kj a;í v;kabf sdn ă;kf ;ds f;ă ";
            FileWriter fw = null;
            BufferedWriter bw = null;
            try {
                File fileWrite = new File("text.txt");
                if (!fileWrite.exists()) {
                    fileWrite.createNewFile();
                }
                fw = new FileWriter(fileWrite, true);
                bw = new BufferedWriter(fw);
                bw.write(str);
                bw.newLine();
                bw.flush();// Đẩy dữ liệu từ bộ nhớ đẹm sang bộ nhớ chính
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                if (fw != null) {
                    try {
                        fw.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (bw != null) {
                    try {
                        bw.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        }
        // đọc file
        // text
        FileReader fr = null;
        try {
            fr = new FileReader("text.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            String str = "";
            while ((line = br.readLine()) != null) {
                str += line;
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FileInputStream fileInputStream = new FileInputStream("book.txt");
    }
}