package by.issoft.domain;

public class Product {
    private String name;
    private String price;
    private String rate;

    public Product(String name, String price, String rate) {
        this.name = name;
        this.price = price;
        this.rate = rate;
    }
    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getRate() {
        return rate;
    }
}
