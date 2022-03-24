package main;

import model.Article;
import model.Book;
import model.Catalog;
import utility.InvalidCatalogException;
import utility.CatalogUtil;

import java.io.IOException;

public class Main {
    private void testCreateSave() throws IOException {
        Catalog catalog = new Catalog("MyRefs");

        catalog.add(new Book("knuth67", "The Art of Computer Programming", "d:/books/programming/tacp.ps", 1967, "Donald E. Knuth", "book"));
        catalog.add(new Article("java17", "The Java Language Specification", "https://docs.oracle.com/javase/specs/jls/se17/html/index.html", 2021, "James Gosling & others", 89));

        try {
            CatalogUtil.save(catalog, "c:/Users/ciobo/Desktop/facultate/an_2/sem_2/PA/Laboratoare/PA_2022_2B4_CIOBOTARU_COSMIN/Lab5/catalog.json");
        } catch (IOException e) {
            System.out.println("Erroare save");
        }
    }

    private void testLoadView() throws InvalidCatalogException {
        Catalog catalog;
        try {
            catalog = CatalogUtil.load("c:/Users/ciobo/Desktop/facultate/an_2/sem_2/PA/Laboratoare/PA_2022_2B4_CIOBOTARU_COSMIN/Lab5/catalog.json");
            System.out.println(catalog.findById("java17"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Main app = new Main();
        try {
            app.testCreateSave();
        } catch (Exception e) {
            System.out.println("Eroare main 1");
        }

        try {
            app.testLoadView();
        } catch (Exception e) {
            System.out.println("Eroare main 1");
        }

    }

}


