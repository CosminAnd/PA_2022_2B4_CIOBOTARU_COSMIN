public class Switch extends Node{
    @Override
    public void setAddress (String newAddress){
        System.out.println("Nu poti schimba adresa.");
    }

    @Override
    public void setStorageCapacity(int newStorageCapacity) {
        System.out.println("Nu poti schimba capacitatea.");
    }

    @Override
    public int getStorageCapacity() {
        return 0;
    }

    @Override
    public String getAddress() {
        return null;
    }

}
