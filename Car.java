public class Vehicle {
    int speed;

    public Vehicle(int speed) {
        this.speed = speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void move() {
        System.out.println("The vehicle is moving at " + speed + " km/h");
    }
}

public class Car extends Vehicle {
    private String fuelType;

    public Car(int speed, String fuelType) {
        super(speed);
        this.fuelType = fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getFuelType() {
        return fuelType;
    }

    @Override
    public void move() {
        System.out.println("The car is moving at " + getSpeed() + " km/h using " + fuelType);
    }
}

public class Bike extends Vehicle {
    private boolean helmetRequired;

    public Bike(int speed, boolean helmetRequired) {
        super(speed);
        this.helmetRequired = helmetRequired;
    }

    public void setHelmetRequired(boolean helmetRequired) {
        this.helmetRequired = helmetRequired;
    }

    public boolean isHelmetRequired() {
        return helmetRequired;
    }

    @Override
    public void move() {
        System.out.println("The bike is moving at " + getSpeed() + " km/h. Helmet required: " + helmetRequired);
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car(120, "Petrol");
        Bike bike = new Bike(80, true);

        car.move();
        bike.move();
    }
}