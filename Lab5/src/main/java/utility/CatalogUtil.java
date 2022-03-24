package utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Catalog;

import java.io.File;
import java.io.IOException;

public class CatalogUtil {

    private CatalogUtil() {
    }

    public static void save(Catalog catalog, String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(path), catalog);
    }

    public static Catalog load(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Catalog catalog;

            catalog = objectMapper.readValue(new File(path), Catalog.class);

        return catalog;
    }

}