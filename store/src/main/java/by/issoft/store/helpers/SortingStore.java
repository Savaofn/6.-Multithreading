package by.issoft.store.helpers;

import by.issoft.domain.Product;
import by.issoft.store.parsers.XmlReader;

import java.util.*;
import java.util.stream.Collectors;

public class SortingStore {
    private XmlReader xmlReader;

    public SortingStore() {
        xmlReader = new XmlReader();
    }

    public List<Product> getTopFiveProduct(List<Product> products) {
        Map<String,String> map = new HashMap<>();
        map.put("rate","desc");
        Comparator<Product> comparator = (a, b) -> Double.compare(Double.parseDouble(b.getRate().replace(',', '.')), Double.parseDouble(a.getRate().replace(',', '.')));
        return products.stream()
                .sorted(comparator)
                .limit(5).collect(Collectors.toList());
    }

    public List<Product> sortProducts(List<Product> products) {
        List<Comparator<Product>> comparatorList = this.createComparatorsList(xmlReader.getParsedMap());
        Comparator<Product> finalComp = comparatorList.get(0);
        for (int i = 1; i < comparatorList.size(); i++) {
            finalComp = finalComp.thenComparing(comparatorList.get(i));
        }
        Comparator<Product> comparator = finalComp;
        List<Product> sortedList = new ArrayList<>();
        products.stream()
                .sorted(comparator)
                .forEach(sortedList::add);
        return sortedList;
    }

    public List<Comparator<Product>> createComparatorsList( Map<String, String> typeSort) {
        List<Comparator<Product>> resultComparator = new ArrayList<>();
        for (Map.Entry<String, String> type : typeSort.entrySet()) {
            Comparator<Product> comparator;
            comparator = (a, b) -> b.getPrice().compareTo(a.getPrice());
            String key = type.getKey();
            String value = type.getValue();
            switch (key) {
                case "name":
                    if (value.equals("asc")) {
                        comparator = Comparator.comparing(Product::getName);
                    } else if (value.equals("desc")) {
                        comparator = Comparator.comparing(Product::getName).reversed();
                    }
                    resultComparator.add(comparator);
                    break;
                case "price":
                    if (value.equals("asc")) {
                        comparator = Comparator.comparingDouble(a -> Double.parseDouble(a.getPrice().replace(',', '.')));
                    } else if (value.equals("desc")) {
                        comparator = (a, b) -> Double.compare(Double.parseDouble(b.getPrice()), Double.parseDouble(a.getPrice()));
                    }
                    resultComparator.add(comparator);
                    break;
                case "rate":
                    if (value.equals("asc")) {
                        comparator = Comparator.comparingDouble(a -> Double.parseDouble(a.getRate().replace(',', '.')));
                    } else if (value.equals("desc")) {
                        comparator = (a, b) -> Double.compare(Double.parseDouble(b.getRate().replace(',', '.')), Double.parseDouble(a.getRate().replace(',', '.')));
                    }
                    resultComparator.add(comparator);
                    break;
            }
        }
        return resultComparator;
    }
}
