package Utility;

import Exceptions.InvalidCatalogException;
import Model.Catalog;
import Model.Item;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;

public class LoadCommand implements Command{
    private String path;

    public void load(Catalog catalog, String path) throws InvalidCatalogException{
        this.path=path;
        command(catalog);
    }

    @Override
    public void command(Catalog catalog) throws InvalidCatalogException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            catalog.setCatalog( objectMapper.readValue(new File(path), Catalog.class));
        } catch (Exception e){
            throw new InvalidCatalogException(e);
        }

    }
}
