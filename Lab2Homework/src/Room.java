/**
 * Clasa Room este o clasa abstracta ce cuprinde caracteristicile generice ale unei sali.
 * Aceste sali vor avea si particularitati, dar vor mosteni caracteristicile de baza ale unui obiect Room.
 */

import java.util.Objects;

public abstract class Room {
    protected String name;
    protected int cap;
    protected String type;

    public String getName() {
        return name;
    }

    public int getCap() {
        return cap;
    }

    public String getType() {
        return type;
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setCap(int newCap) {
        if (newCap > 0)
            cap = newCap;
        else
            System.out.println("eroare capacitate");

    }

    public void setType(String newType) {
        type = newType;
    }

    @Override
    public String toString() {
        return "Room name=:" + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return cap == room.cap && Objects.equals(name, room.name) && type.equals(room.type);
    }

}
