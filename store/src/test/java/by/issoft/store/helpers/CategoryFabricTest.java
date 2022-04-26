package by.issoft.store.helpers;

import by.issoft.domain.categories.BeerCategory;
import by.issoft.domain.categories.Categorys;
import by.issoft.domain.categories.SushiCategory;
import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CategoryFabricTest {

    @Test
    void getCategory_Valid() {
        //any
        CategoryFabric categoryFabric=new CategoryFabric();
        BeerCategory beerCategory=new BeerCategory();
        SushiCategory sushiCategory=new SushiCategory();

        //expect
        assertThat(categoryFabric.getCategory(Categorys.BeerCategory.name()).getClass().getName(),is(beerCategory.getClass().getName()));
        assertThat(categoryFabric.getCategory(Categorys.SushiCategory.name()).getClass().getName(),is(sushiCategory.getClass().getName()));

    }

    @Test
    void getCategory_InvalidCategoryType() {
        //any
        CategoryFabric categoryFabric=new CategoryFabric();

        //expect
        assertThrows(IllegalArgumentException.class, () -> categoryFabric.getCategory("NotImplementedCategory"));
    }
}