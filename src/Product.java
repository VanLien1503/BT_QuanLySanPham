import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String name;
    private String brandName;
    private String description;
    private double price;

    public Product() {
    }

    public Product(int id, String name, String brandName, String description, double price) {
        this.id = id;
        this.name = name;
        this.brandName = brandName;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ID : "+id +
                "\nName: "+name +
                "\n Thương Hiêu : "+brandName+
                "\n Mô Tả : "+description;
    }
}
