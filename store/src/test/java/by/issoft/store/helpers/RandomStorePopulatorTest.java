package by.issoft.store.helpers;

import by.issoft.domain.categories.BeerCategory;
import by.issoft.domain.categories.SushiCategory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomStorePopulatorTest {

    @Test
    void addFakeProductName_Valid() {
        //any
        RandomStorePopulator randomStorePopulator = new RandomStorePopulator();

        //expect
        assertNotNull(randomStorePopulator.addFakeProductName("Sushi"));
        assertNotEquals(randomStorePopulator.addFakeProductName("Sushi"),"Non");
    }

    @Test
    void addFakeProductName_NotImplemented() {
        //any
        RandomStorePopulator randomStorePopulator = new RandomStorePopulator();

        //expect
        assertEquals(randomStorePopulator.addFakeProductName("Cars"),"Non");
    }

    @Test
    void addFakeProductPrice_Valid() {
        //any
        RandomStorePopulator randomStorePopulator = new RandomStorePopulator();

        //expect
        assertNotNull(randomStorePopulator.addFakeProductPrice());
    }

    @Test
    void addFakeProductRate_Valid() {
        //any
        RandomStorePopulator randomStorePopulator = new RandomStorePopulator();

        //expect
        assertNotNull(randomStorePopulator.addFakeProductRate());
    }
}