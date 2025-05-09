public class Vehicle {
    int vin;
    int year;
    String make;
    String model;
    String vehicleType;
    String color;
    int odometer;
    double price;

    Vehicle( int vin,
    int year,
    String make,
    String model,
    String vehicleType,
    String color,
    int odometer,
    double price){
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model= model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

    public String toString() {
        return String.format("""
                VIN: '%d'
                YEAR: '%d'
                MAKE: '%s'
                MODEL: '%s'
                COLOR: '%s'
                TYPE: '%s'
                PRICE: '$%.2f'
                MILES: '%d'
                """,
                this.vin, this.year, this.make, this.model, this.color, this.vehicleType, this.price, this.odometer);
    }
}
