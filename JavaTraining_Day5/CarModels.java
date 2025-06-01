import java.util.*;

public class CarModels {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose a Car Brand:");
        System.out.println("1. Mahindra");
        System.out.println("2. Tata");
        System.out.println("3. Maruti");
        System.out.print("Enter your selection (1-3): ");
        int brandInput = sc.nextInt();

        String carBrand;
        switch (brandInput) {
            case 1: carBrand = "Mahindra"; break;
            case 2: carBrand = "Tata"; break;
            case 3: carBrand = "Maruti"; break;
            default:
                System.out.println("Invalid brand selection. Exiting...");
                return;
        }

        String chosenModel = null;
        if (carBrand.equals("Mahindra")) {
            System.out.println("Pick a Model:");
            System.out.println("1. Scorpio");
            System.out.println("2. Thar");
            System.out.println("3. Scorpio N");
            System.out.println("4. XUV 700");
            System.out.print("Enter your selection (1-4): ");
            int modelInput = sc.nextInt();

            switch (modelInput) {
                case 1: chosenModel = "Scorpio"; break;
                case 2: chosenModel = "Thar"; break;
                case 3: chosenModel = "Scorpio N"; break;
                case 4: chosenModel = "XUV 700"; break;
                default:
                    System.out.println("Invalid model selection. Exiting...");
                    sc.close();
                    return;
            }
        }

        System.out.println("Select Gearbox Type:");
        System.out.println("1. Manual");
        System.out.println("2. Automatic");
        System.out.print("Enter your choice (1-2): ");
        int gearboxInput = sc.nextInt();

        String gearbox;
        switch (gearboxInput) {
            case 1: gearbox = "Manual"; break;
            case 2: gearbox = "Automatic"; break;
            default:
                System.out.println("Invalid transmission selection. Exiting...");
                sc.close();
                return;
        }

        System.out.println("Choose Fuel Option:");
        System.out.println("1. Diesel");
        System.out.println("2. Petrol");
        System.out.println("3. CNG");
        System.out.print("Enter your choice (1-3): ");
        int fuelInput = sc.nextInt();

        String fuelType;
        switch (fuelInput) {
            case 1: fuelType = "Diesel"; break;
            case 2: fuelType = "Petrol"; break;
            case 3: fuelType = "CNG"; break;
            default:
                System.out.println("Invalid fuel option. Exiting...");
                sc.close();
                return;
        }

        System.out.println("Pick an Exterior Color:");
        System.out.println("1. Silver");
        System.out.println("2. Black");
        System.out.println("3. White");
        System.out.print("Enter your choice (1-3): ");
        int paintInput = sc.nextInt();

        String paintColor;
        switch (paintInput) {
            case 1: paintColor = "Silver"; break;
            case 2: paintColor = "Black"; break;
            case 3: paintColor = "White"; break;
            default:
                System.out.println("Invalid color selection. Exiting...");
                sc.close();
                return;
        }

        System.out.println("Choose Delivery City:");
        System.out.println("1. Delhi");
        System.out.println("2. Bangalore");
        System.out.println("3. Hyderabad");
        System.out.println("4. Chennai");
        System.out.print("Enter your selection (1-4): ");
        int cityInput = sc.nextInt();

        String cityLocation;
        switch (cityInput) {
            case 1: cityLocation = "Delhi"; break;
            case 2: cityLocation = "Bangalore"; break;
            case 3: cityLocation = "Hyderabad"; break;
            case 4: cityLocation = "Chennai"; break;
            default:
                System.out.println("Invalid city selection. Exiting...");
                sc.close();
                return;
        }

        System.out.println("\n Your Custom Car Configuration ");
        System.out.println("Brand: " + carBrand);
        if (chosenModel != null)
            System.out.println("Model: " + chosenModel);
        System.out.println("Transmission: " + gearbox);
        System.out.println("Fuel: " + fuelType);
        System.out.println("Color: " + paintColor);
        System.out.println("Delivery Location: " + cityLocation);

        sc.close();
    }
}
