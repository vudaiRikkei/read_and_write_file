package bt2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Bt2 {
    public static void main(String[] args) {
        String fileP = "E:\\Rikkei Academi\\code\\MD3\\jv03_23\\IOtext_file\\src\\bt2\\databt2";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileP))){
            int count =0;
            while (( bufferedReader.readLine()) != null) {
                count ++;
            }
            System.out.println("Số dòng trong file: " + count);
        } catch (IOException e) {
            System.out.println("Đã có lỗi sảy ra");
        }

    }

}
