package by.issoft.store.helpers;

import by.issoft.domain.Category;
import by.issoft.domain.categories.BeerCategory;
import by.issoft.domain.categories.Categorys;
import by.issoft.store.Store;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

class StoreHelperTest {

    @Test
    void fillStore() {
        //any
        Store store = Store.getInstance();
        StoreHelper storeHelper = new StoreHelper(store);
        storeHelper.FillStore();
        BeerCategory beerCategory = new BeerCategory();

        //except
        assertThat(store.getList().get(0).getClass().getName(), is(beerCategory.getClass().getName()));
    }

    @Test
    void createCategoryListByFabric() {
        //any
        Store store = Store.getInstance();
        StoreHelper storeHelper = new StoreHelper(store);
        BeerCategory beerCategory = new BeerCategory();

        //except
        assertThat(storeHelper.createCategoryListByFabric().get(0).getClass().getName(), is(beerCategory.getClass().getName()));
    }
}