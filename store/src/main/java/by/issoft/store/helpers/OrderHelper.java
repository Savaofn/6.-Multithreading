package by.issoft.store.helpers;

import by.issoft.domain.Product;
import by.issoft.domain.PurchasedGoods;
import lombok.SneakyThrows;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;

public class OrderHelper extends Thread {
    @SneakyThrows
    @Override
    public void run() {
        semaphore = new Semaphore(1);
        semaphore.acquire();
        Random random = new Random();
        Thread.sleep(random.nextInt(30) * 1000);
        purchasedGoods.purchasedGoodsAdd(product);
        System.out.println(nameOfOrder + " order ready!");
        semaphore.release();
    }

    Semaphore semaphore;
    Product product;
    String nameOfOrder;
    PurchasedGoods purchasedGoods;

    public OrderHelper(PurchasedGoods purchasedGoods, Product product, String nameOfOrder) {
        this.purchasedGoods = purchasedGoods;
        this.product = product;
        this.nameOfOrder = nameOfOrder;
    }

}
