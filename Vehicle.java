import java.util.ArrayList;

class Vehicle {
    private String brand;
    private String model;
    private double rentalPrice;

    public Vehicle(String brand, String model, double rentalPrice) {
        this.brand = brand;
        this.model = model;
        this.rentalPrice = rentalPrice;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getrentalPrice() {
        return rentalPrice;
    }

    public void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Rental Price: " + rentalPrice);
    }
}

class Car extends Vehicle {
    private int Seat;
    private String fuelType;

    public Car(String brand, String model, double rentalPrice, int seat, String fuelType) {
        super(brand, model, rentalPrice);
        this.Seat = seat;
        this.fuelType = fuelType;
    }

    public int getSeat() {
        return Seat;
    }

    public String getFuleType() {
        return fuelType;
    }

    @Override
    public void displayInfo() {
        System.out.println("Brand: " + getBrand());
        System.out.println("Model: " + getModel()); 
        System.out.println("Rental Price: " + getrentalPrice());
        System.out.println("Seat: " + Seat);
        System.out.println("Fuel Type: " + fuelType);
    }
}

class Bike extends Vehicle {
    private String type;

    public Bike(String brand, String model, double rentalPrice, String type) {
        super(brand, model, rentalPrice);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public void displayInfo() {
        System.out.println("Brand; " + getBrand());
        System.out.println("Model: " + getModel()); 
        System.out.println("Rental Price: " + getrentalPrice());
        System.out.println("Type: " + type);
    }
}

class RentalAgency {
    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    public RentalAgency(){};

    public void addVehicle(Vehicle v) {
        vehicles.add(v);
    }

    public void rentVehicle(String model) {
        int flag = 0 ;
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getModel() == model) {
                vehicles.remove(i);
                flag = 1;
            }
        }
        if (flag == 0) 
            System.out.println("Vehicle not found.");
    }

    public void displayVehicles() {
        for (int i = 0; i < vehicles.size(); i++) {
            vehicles.get(i).displayInfo();
            System.out.println("");
            }
        }

        public ArrayList<Vehicle> getVehicles() {
            return vehicles;
        }
    }
