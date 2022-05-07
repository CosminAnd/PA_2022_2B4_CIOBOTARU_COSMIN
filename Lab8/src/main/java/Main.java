import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        try {
            var continents = new ContinentDAO();
            //continents.create("Europe",125);
            //Database.getConnection().commit();

            var countries = new CountryDAO();
            int europeId = continents.findByName("Europe");
            /*countries.create("Romania", 1);
            countries.create("Ukraine", 2);
            countries.create("Italy", 3);
            countries.create("France", 4);
            countries.create("Germany", 5);
            countries.create("Portugal", 6);
            countries.create("Greece", 7);
            countries.create("Spain", 8);
            countries.create("Portugal", 9);
            Database.getConnection().commit();


            countries.create("Norway", 10);
            Database.getConnection().commit();
             */


            //print all the countries in Europe
            //countries.printCountries(europeId);
            //continents.create("America", 126);

            var cities = new CityDAO();
            //countries.add("Moldova", 11, "1222", "Europe", europeId);

            cities.add("Iasi","Romania",0,"47.151726", "27.587914",1);

            /*try{
                cities.importCities();
            } catch (IOException e){
                e.printStackTrace();
            }*/
            //cities.findAll();
            cities.distanceToCities("Bucharest", "Madrid");



            Database.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            Database.rollback();
        }

        MainFrame mainFrame = new MainFrame("Rome" );

    }
}
