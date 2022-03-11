import java.util.Objects;

public class Computer extends Node implements Identifiable, Storage {
    private String address;
    private int storageCapacity;

    public Computer() {
    }

    public Computer(String address, int storageCapacity) {
        this.address = address;
        this.storageCapacity = storageCapacity;
    }

    public void setAddress(String newAddress) {
        this.address = newAddress;
    }

    public void setStorageCapacity(int newStorageCapacity) {
        this.storageCapacity = newStorageCapacity;
    }

    @Override
    public int getStorageCapacity() {
        return storageCapacity;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return address.equals(computer.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }

    @Override
    public String toString() {
        return address;
    }
}
