package by.issoft.store.helpers;

import by.issoft.domain.Category;
import by.issoft.domain.categories.*;

public class CategoryFabric {
    public Category getCategory(String type) {
        Category toReturn = null;
        switch (type) {
            case "BeerCategory":
                toReturn = new BeerCategory();
                break;
            case "BookCategory":
                toReturn = new BookCategory();
                break;
            case "CheeseCategory":
                toReturn = new CheeseCategory();
                break;
            case "SpiceCategory":
                toReturn = new SpiceCategory();
                break;
            case "SushiCategory":
                toReturn = new SushiCategory();
                break;
            default:
                throw new IllegalArgumentException("Not implemented or wrong:" + type);
        }
        return toReturn;
    }
}

