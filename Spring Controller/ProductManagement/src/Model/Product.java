package Model;

public class Product {
    private int id;
    private String name;
    private String manufactor;
    private String description;

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

    public String getManufactor() {
        return manufactor;
    }

    public void setManufactor(String manufactor) {
        this.manufactor = manufactor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product(int id, String name, String manufactor, String description) {
        this.id = id;
        this.name = name;
        this.manufactor = manufactor;
        this.description = description;
    }

    public Product() {
    }
}
