package Utility;

import Exceptions.InvalidCatalogException;
import Model.Catalog;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;

public class SaveCommand implements Command  {
    Catalog catalog;
    public void save(Catalog catalog) throws InvalidCatalogException{
        this.catalog=catalog;
       try {
           command(catalog);
       }catch (Exception e){
           throw new InvalidCatalogException(e);
       }
    }
    @Override
    public void command(Catalog catalog) throws InvalidCatalogException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("c:/Users/ciobo/Desktop/facultate/an_2/sem_2/PA/Laboratoare/PA_2022_2B4_CIOBOTARU_COSMIN/Lab5Homework/catalog.json"), catalog);
        } catch (Exception e) {
            throw new InvalidCatalogException(e);
        }
    }
}
