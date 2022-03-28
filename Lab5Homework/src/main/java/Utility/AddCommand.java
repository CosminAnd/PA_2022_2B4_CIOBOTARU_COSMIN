package Utility;

import Model.Catalog;
import Model.Item;

public class AddCommand implements Command{
    private Item item;

    public void add(Catalog catalog, Item item){
        this.item = item;
        command(catalog);
    }

    @Override
    public void command(Catalog catalog) {
        catalog.getItemList().add(item);
    }
}
