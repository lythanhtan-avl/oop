import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class NewRentalAgency extends RentalAgency{
    public void loadVehiclesFromFile(String filename){
        try {
            File file = new File(filename);
            Scanner sc = new Scanner(file);
            String line;
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                String[] vehicle = line.split(",");
                if(vehicle[0].compareTo("car") == 1){
                    super.addVehicle(new Car(vehicle[1], vehicle[2], Double.parseDouble(vehicle[3]), Integer.parseInt(vehicle[4]), vehicle[5]));
                }
                else {
                    super.addVehicle(new Bike(vehicle[1], vehicle[2], Double.parseDouble(vehicle[3]), vehicle[4]));
                }
            }
        } catch (FileNotFoundException e) {
           e.fillInStackTrace();
        }

    }
    public void sortVehicles(){
        Collections.sort(super.getVehicles(), new compareByRentalPrice());
    }
}
class compareByRentalPrice implements Comparator<Vehicle> {
    public int compare (Vehicle a, Vehicle b) {
        if (a.getrentalPrice() > b.getrentalPrice()) {
            return 1;
        } else if (a.getrentalPrice() < b.getrentalPrice()) {
            return -1;
        } else {
            return 0;
        }
    }
}
