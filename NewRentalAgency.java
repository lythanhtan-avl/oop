import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;

class NewAgency extends Agency {
    public void loadFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 3) {
                    String type = parts[0].trim();
                    String brand = parts[1].trim();
                    String model = parts[2].trim();
                    double rentPrice = Double.parseDouble(parts[3].trim());
                    
                    if (type.equalsIgnoreCase("Car")) {
                        int numSeats = Integer.parseInt(parts[4].trim());
                        String fuelType = parts[5].trim();
                        add(new Car(brand, model, rentPrice, numSeats, fuelType));
                    } else if (type.equalsIgnoreCase("Bike")) {
                        String bikeType = parts[4].trim();
                        add(new Bike(brand, model, rentPrice, bikeType));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public void sortByRentPrice() {
        vehicles.sort(Comparator.comparingDouble(Vehicle::getRentPrice));
    }
}
