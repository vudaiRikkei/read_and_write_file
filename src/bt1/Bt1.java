package bt1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Bt1 {
    public static void main(String[] args) {
        String fileP = "E:\\Rikkei Academi\\code\\MD3\\jv03_23\\IOtext_file\\src\\bt1\\databt1";
        try (BufferedReader  bufferedReader = new BufferedReader(new FileReader(fileP))){
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append("\n");
            }
            String[] words = content.toString().split("\\s+");
            int wordCount = words.length;
            System.out.println("Số lượng từ trong file: " + wordCount);
        } catch (IOException e) {
            System.out.println("Đã có lỗi sảy ra");
        }
    }
}
