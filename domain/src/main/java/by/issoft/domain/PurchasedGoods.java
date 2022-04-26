package by.issoft.domain;

import lombok.SneakyThrows;

import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

public class PurchasedGoods extends Thread {
    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            purchasedGoodsClear();
            System.out.println("Clear purchased goods");
            Thread.sleep(2 * 60 * 1000);
        }
    }

    CopyOnWriteArrayList<Product> purchasedGoods = new CopyOnWriteArrayList<>();

    public void purchasedGoodsAdd(Product product) {
        this.purchasedGoods.add(product);
    }

    public void purchasedGoodsClear() {
        this.purchasedGoods.clear();
    }

}
