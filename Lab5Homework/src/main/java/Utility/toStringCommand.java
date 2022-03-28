package Utility;

import Model.Catalog;

import java.io.IOException;

public class toStringCommand implements Command {
    @Override
    public void command(Catalog catalog) throws IOException {
        try {
            System.out.println(catalog);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }
}
