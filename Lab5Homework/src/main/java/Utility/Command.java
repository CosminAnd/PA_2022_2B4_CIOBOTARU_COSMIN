package Utility;

import Exceptions.InvalidCatalogException;
import Model.Catalog;
import Exceptions.InvalidLocationException;
import Exceptions.InvalidReportException;

import java.io.IOException;

public interface Command{
    void command(Catalog catalog) throws InvalidCatalogException, InvalidLocationException, InvalidReportException, IOException;

}
