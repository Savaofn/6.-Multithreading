package by.issoft.consoleApp;

import by.issoft.domain.Category;
import by.issoft.domain.Product;
import by.issoft.domain.PurchasedGoods;
import by.issoft.store.Store;
import by.issoft.store.helpers.OrderHelper;
import by.issoft.store.helpers.SortingStore;
import by.issoft.store.helpers.StoreHelper;
import de.vandermeer.asciitable.AsciiTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

public class StoreApp {
    public static void main(String[] args) throws IOException {
        StoreApp storeApp = new StoreApp();
        storeApp.creates();
    }

    public void creates() throws IOException {
        Store store = Store.getInstance();
        StoreHelper storeHelper = new StoreHelper(store);
        storeHelper.FillStore();
        SortingStore sortingStore = new SortingStore();
        new Thread().start();
        PurchasedGoods purchasedGoods = new PurchasedGoods();
        purchasedGoods.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Boolean bool = true;
        while (bool) {
            System.out.println("Your choice? (? to help)");
            String choice = "";
            try {
                choice = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            switch (choice) {
                case "?":
                    System.out.println("ALL to see all products, SORT to sort products, TOP to see top 5 products, EXIT to exit, ORDER to new order");
                    break;
                case "TOP":
                    printSortProduct(sortingStore.getTopFiveProduct(store.allProduct()));
                    break;
                case "SORT":
                    printSortProduct(sortingStore.sortProducts(store.allProduct()));
                    break;
                case "EXIT":
                    bool = false;
                    break;
                case "ALL":
                    printStore(storeHelper, store);
                    break;
                case "ORDER":
                    System.out.println("Name of product?");
                    String orderChoice = "";
                    orderChoice = reader.readLine();
                    System.out.println("Your name?");
                    String orderName = "";
                    orderName = reader.readLine();
                    Product product = store.findProductByName(orderChoice);
                    new Thread().start();
                    OrderHelper orderHelper = new OrderHelper(purchasedGoods, product, orderName);
                    orderHelper.start();

                    break;
                default:
                    System.out.println("Unknown command");
            }
        }

    }

    public void printStore(StoreHelper storeHelper, Store store) {
        AsciiTable table = new AsciiTable();
        storeHelper.FillStore();
        table.addRule();
        table.addRow("Welcome to Yarik Store catalog", "   ", "   ");
        table.addRule();
        for (Category category : store.getList()) {
            table.addRow("CATEGORY " + category.getName(), "   ", "   ");
            table.addRule();
            table.addRow("Name", "Price", "Rate");
            table.addRule();
            for (Product product : category.getList()) {
                table.addRow(product.getName(), product.getPrice() + "$", product.getRate() + "%");
                table.addRule();
            }
            table.addRow("", "", "");
            table.addRule();
        }
        String rendTable = table.render();
        System.out.println(rendTable);
    }

    public void printSortProduct(List<Product> productList) {
        AsciiTable table = new AsciiTable();
        table.addRule();
        table.addRow("Sorted product", "   ", "   ");
        table.addRule();
        table.addRow("Name", "Price", "Rate");
        table.addRule();
        for (Product product : productList) {
            table.addRow(product.getName(), product.getPrice() + "$", product.getRate() + "%");
            table.addRule();
        }
        String rendTable = table.render();
        System.out.println(rendTable);
    }
}
