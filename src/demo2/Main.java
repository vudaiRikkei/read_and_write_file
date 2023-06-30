package demo2;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String pathFileProduct = "E:\\Rikkei Academi\\code\\MD3\\jv03_23\\IOtext_file\\src\\data\\productData.txt";
    private static ReadAndWriteFile<Product> productReadAndWriteFile = new ReadAndWriteFile<>();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        List<Product> products = productReadAndWriteFile.readFromFile(pathFileProduct);
//        products.add(create());
//        productReadAndWriteFile.writeToFile(products, pathFileProduct);
        System.out.println(products);
    }
    static Product create(){
        System.out.println("enter id");
        int id = scanner.nextInt();
        System.out.println("enter name");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("enter price");
        double price = Double.parseDouble(scanner.nextLine());
        return new Product(id, name, price);
    }
}
