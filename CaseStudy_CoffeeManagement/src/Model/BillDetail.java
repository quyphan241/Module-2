package Model;

public class BillDetail {
    private int price;
    private int quantity;
    private int Product_id_product;
    private int Bill_id_bill;

    private String name_product;

    public BillDetail(int price, int quantity, int product_id_product, int bill_id_bill, String name_product) {
        this.price = price;
        this.quantity = quantity;
        Product_id_product = product_id_product;
        Bill_id_bill = bill_id_bill;

        this.name_product = name_product;

    }



    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProduct_id_product() {
        return Product_id_product;
    }

    public void setProduct_id_product(int product_id_product) {
        Product_id_product = product_id_product;
    }

    public int getBill_id_bill() {
        return Bill_id_bill;
    }

    public void setBill_id_bill(int bill_id_bill) {
        Bill_id_bill = bill_id_bill;
    }
}
