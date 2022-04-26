package by.issoft.store.helpers;

import by.issoft.domain.Category;
import by.issoft.domain.Product;
import by.issoft.domain.categories.Categorys;
import by.issoft.store.Store;
import java.util.*;

public class StoreHelper {
    Store store;

    public StoreHelper(Store store) {
        this.store = store;
    }

    public void FillStore() {
        RandomStorePopulator randomStorePopulator = new RandomStorePopulator();
        //Set<Category> categorySet = createCategoryList();
        ArrayList<Category> categoryList = createCategoryListByFabric();
        for (Category category : categoryList) {
            Random random = new Random();
            int randomNumberOfProducts = random.nextInt(30) + 1;
            for (int i = 0; i < randomNumberOfProducts; i++) {
                Product product = new Product(
                        randomStorePopulator.addFakeProductName(category.getName()),
                        randomStorePopulator.addFakeProductPrice(),
                        randomStorePopulator.addFakeProductRate());
                category.addToList(product);
            }
            this.store.addToList(category);
        }
    }

    public ArrayList<Category> createCategoryListByFabric() {
        ArrayList<Category> list = new ArrayList<>();
        CategoryFabric factory = new CategoryFabric();
        for (Categorys category : Categorys.values()) {
            list.add(factory.getCategory(category.name()));
        }
        return list;
    }

  /*  public Set<Category> createCategoryList() {
        Set<Category> categoriesList = new HashSet<>();
        Reflections reflections = new Reflections("by.issoft.domain.categories");
        Set<Class<? extends Category>> types = reflections.getSubTypesOf(Category.class);
        for (Class<? extends Category> type : types) {
            try {
                categoriesList.add(type.getConstructor().newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return categoriesList;
    }*/
}
