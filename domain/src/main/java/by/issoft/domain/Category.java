package by.issoft.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class Category {
    private String name;
    List<Product> list = new ArrayList<>();


    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Product> getList() {
        return list;
    }

    public void addToList(Product product) {
        this.list.add(product);
    }
}