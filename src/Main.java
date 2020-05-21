import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FunctionProduct functionProduct = new FunctionProduct();
        //System.out.println(functionProduct.arrayList);
        functionProduct.creatObj();
        functionProduct.addProduct();
        functionProduct.arrayList.forEach(k -> System.out.println(k));

        // write.( ghi)
        String path = "arrayList.txt";
        functionProduct.writeToFile(functionProduct.arrayList, path);

        //read(doc)
        functionProduct.readFromFile(path);


//        System.out.println("sauKhi sua");
//        functionProduct.arrayList.forEach(k -> System.out.println(k));
    }
}
