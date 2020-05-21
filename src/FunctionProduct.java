import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public  class FunctionProduct extends Product {
    public ArrayList<Product> arrayList = new ArrayList<>();// TT

    public void creatObj() {
        ArrayProduct arrayProduct = new ArrayProduct();
        Product[] strings = arrayProduct.arrProduct();
        for (int i = 0; i < strings.length; i++) {
            arrayList.add(strings[i]);
        }
    }

    // tao san phẩm mới
    private Product inputFromKeyboard() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter id: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter brand name: ");
        String brandName = sc.nextLine();
        System.out.print("Enter price: ");
        double price = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter description: ");
        String description = sc.nextLine();

        return new Product(id, name, brandName, description, price);
    }

    // them san phâm mới vào arraylis
    public Product addProduct() {
        Product product;
        product = inputFromKeyboard();
        arrayList.add(product);
        return product;
    }

    //
    public void writeToFile(ArrayList<Product> arrayList, String path) {
        FileOutputStream outputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            outputStream = new FileOutputStream(path);
            objectOutputStream = new ObjectOutputStream(outputStream);

            objectOutputStream.writeObject(arrayList);
            System.out.println("Writing");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    //

    ArrayList<Product> fileToArrayList;

    public void readFromFile(String path) {
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream = null;

        try {
            fileInputStream = new FileInputStream(path);
            objectInputStream = new ObjectInputStream(fileInputStream);

            fileToArrayList = (ArrayList<Product>) objectInputStream.readObject();
            System.out.println("reading...!");
            System.out.println(fileToArrayList);
            // tim kiem
            System.out.println("nhap id tim Kiem trong arraylist : ");
            Scanner scanner = new Scanner(System.in);
            searchProduct(scanner.nextInt());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
            } catch (IOException ex) {
                System.err.println(ex.getMessage() + "/Error closing file");
            }
        }
    }
    // method tim kiem

    public Product searchProduct(int id) {
        boolean matchId = false;
        Product temp = null;
        for (Product product : fileToArrayList) {
            if (product.getId() == id) {
//                product=addProduct();
                temp = product;
                matchId = true;
                break;
            }
        }
        if (matchId) {
            System.out.println("Found!");
            System.out.println(temp);
//            System.out.println(fileToArrayList);

        } else {
            System.out.println("Not found!");
        }
        return temp;
    }
}
