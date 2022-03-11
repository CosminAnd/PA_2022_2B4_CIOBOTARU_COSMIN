/**
 * Clasa CoputerLab descrier salile in care se vor tine laboratoare, cu atributul specific pentru sistemul de operare.
 */

public class ComputerLab extends Room {
    private String operatingSystem;

    public ComputerLab(String newName, int newCap, String sys) {
        name = newName;
        if (newCap > 0)
            cap = newCap;
        else
            System.out.println("eroare capacitate");

        operatingSystem = sys;
        type = "LAB";
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String sys) {
        operatingSystem = sys;
    }
}
