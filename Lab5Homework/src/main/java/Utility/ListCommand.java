package Utility;

import Model.Catalog;
import Model.Item;

import java.io.IOException;


public class ListCommand implements Command{

    @Override
    public void command (Catalog catalog) throws IOException {
        try {
            for (Item item : catalog.getItemList()) {
                System.out.println(item);
            }
        } catch ( Exception e) {
            throw new IOException(e);
        }
    }
}
