import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    Dealership(String name,String address,String phone){
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<Vehicle>();
    }
    public String toString() {
        return String.format(
                "DEALERSHIP NAME: '%s' #CARS: %d\n",
                this.name, this.inventory.size()
        );
    }

    public List<Vehicle> getVehiclesByPrice(double min,double max) {
        return inventory;
    }

    public List<Vehicle>  getVehiclesByMakeModel(String make, String model){
        return inventory;
    }

    public List<Vehicle>  getVehiclesByYear(int min,int max){
        return inventory;
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        return inventory;
    }

    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        return inventory;
    }

    public List<Vehicle> getVehiclesByType(String type) {
        return inventory;
    }

    public List<Vehicle> getAllVehicles() {
        return inventory;
    }


    void addVehicle(Vehicle v){
        inventory.add(v);
    }

    void removeVehicle(Vehicle v) {
        inventory.remove(v);
    }



   // Getters/Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Vehicle> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Vehicle> inventory) {
        this.inventory = inventory;
    }


    public static void main(String[] args) {
    }


}
