public interface Storage {
    int getStorageCapacity();
    default int getStorageDiffUnits(String unit){
        if(unit.compareTo("megabyte")==0){
            return getStorageCapacity()*1000;
        }
        if(unit.compareTo("kilobyte")==0){
            return getStorageCapacity()*1000000;
        }
        if(unit.compareTo(("byte"))==0){
            return getStorageCapacity()*1000000000;
        }
        return getStorageCapacity();
    }
}
