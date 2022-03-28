package Main;

import Model.Article;
import Model.Book;
import Model.Catalog;
import Utility.*;


public class Main {
    public static void main(String[] agrs) {
        String path = "c:/Users/ciobo/Desktop/facultate/an_2/sem_2/PA/Laboratoare/PA_2022_2B4_CIOBOTARU_COSMIN/Lab5Homework/catalog.json";
        Catalog catalog = new Catalog("MyRefs");

        //Add command
        AddCommand addCommand = new AddCommand();
        addCommand.add(catalog, new Book("knuth67", "The Art of Computer Programming", "d:/books/programming/tacp.ps", 1967, "Donald E. Knuth", "book"));
        //catalog.add(new Book("knuth67", "The Art of Computer Programming", "d:/books/programming/tacp.ps", 1967, "Donald E. Knuth", "book"));
        addCommand.add(catalog, new Article("java17", "The Java Language Specification", "https://docs.oracle.com/javase/specs/jls/se17/html/index.html", 2021, "James Gosling & others", 89));
        //catalog.add(new Article("java17", "The Java Language Specification", "https://docs.oracle.com/javase/specs/jls/se17/html/index.html", 2021, "James Gosling & others", 89));

        //System.out.println(catalog);

        //Save command
        SaveCommand saveCommand = new SaveCommand();
        try {
            saveCommand.save(catalog);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //List command
        ListCommand listCommand = new ListCommand();
        try {
            listCommand.command(catalog);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();

        //Load command
        Catalog catalogLoader = new Catalog();
        LoadCommand loadCommand = new LoadCommand();
        try {
            loadCommand.load(catalogLoader, path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Continutul catalogLoader este:");
        try {
            listCommand.command(catalogLoader);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Catalogul afisat cu toStringCommand este:");
        //toString command
        toStringCommand toStringCommand = new toStringCommand();
        try {
            toStringCommand.command(catalog);
        }catch (Exception e){
            e.printStackTrace();
        }
        //View command

        ViewCommand viewCommand = new ViewCommand();
        try {
            viewCommand.view(catalogLoader, 1);
        }catch (Exception e){
            e.printStackTrace();
        }

        //Report command
        ReportCommand report = new ReportCommand();
        try{
            report.command(catalog);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}


