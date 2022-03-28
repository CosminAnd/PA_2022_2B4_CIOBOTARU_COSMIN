package Utility;

import Exceptions.InvalidLocationException;
import Model.Catalog;

import java.awt.*;
import java.io.File;
import java.net.URI;

public class ViewCommand implements Command {
    int index;

    public void view(Catalog catalog, int index) throws InvalidLocationException {
        this.index = index;
        command(catalog);
    }

    @Override
    public void command(Catalog catalog) throws InvalidLocationException {
        try {
            Desktop desktop = Desktop.getDesktop();
            var location = catalog.getItemList().get(index).getLocation();
            if (location.contains("https") || location.contains("http")) {
                desktop.browse(URI.create(location));
            } else
                desktop.open(new File(location));
        } catch (Exception e) {
            throw new InvalidLocationException(e);
        }
    }
}
