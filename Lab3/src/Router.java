import java.util.Objects;

public class Router extends Node implements Identifiable {
    private String address;

    public Router() {
    }

    public Router(String address) {
        this.address = address;
    }

    public void setAddress(String newAddress) {
        this.address = newAddress;
    }

    @Override
    public void setStorageCapacity(int newStorageCapacity) {
        System.out.println("Nu poti schimba adresa.");
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Router router = (Router) o;
        return address.equals(router.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }

    @Override
    public int getStorageCapacity() {
        return 0;
    }

    @Override
    public String toString() {
        return "Router: address= " + address;
    }
}
