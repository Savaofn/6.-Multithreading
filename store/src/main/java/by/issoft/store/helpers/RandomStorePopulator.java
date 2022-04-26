package by.issoft.store.helpers;

import com.github.javafaker.Faker;

public class RandomStorePopulator {
    Faker faker = new Faker();

    public String addFakeProductName(String name) {
        switch (name) {
            case "Beer":
                return faker.beer().name();
            case "Sushi":
                return faker.food().sushi();
            case "Book":
                return faker.book().title();
            case "Spice":
                return faker.food().spice();
            default:
                return "Non";
        }
    }

    public String addFakeProductPrice() {
        return faker.commerce().price(10, 100);
    }

    public String addFakeProductRate() {
        return Integer.toString(faker.number().numberBetween(1, 100));
    }

}
















 /*public void addFakeProducts(Category category) {
        int numberOfProduct = random.nextInt(30) + 1;
        while (numberOfProduct > 0) {
            String name = faker.commerce().productName();
            Double price = Double.parseDouble(faker.commerce().price(10, 10000));
            int number = random.nextInt(300) + 1;
            Product product = new Product(name, number, price);
            category.addToList(product);

    }*/
