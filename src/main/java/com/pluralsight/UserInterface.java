package com.pluralsight;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;
    private DealershipFileManager dealershipFileManager;




    public UserInterface() {
        dealershipFileManager = new DealershipFileManager("dealership.csv");
    }

    private void init(){
        DealershipFileManager dealershipFileManager = new DealershipFileManager("dealership.csv");
        this.dealership = dealershipFileManager.getDealership();
    }


    public void display(){
        init();
        Scanner scanner = new Scanner(System.in);
        int input;

        while (true) {
            displayMenu();
            System.out.print("Enter your search: ");
            input = scanner.nextInt();

            switch (input){
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processGetByClassicVintageRequest();
                    break;
                case 8:
                    getAllVehiclesRequest();
                    break;
                case 9:
                    addOrRemoveMenu();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }

    }

    public void displayMenu(){
        System.out.println(" ");
        System.out.println("✧✦✧ 𝓜𝓔𝓝𝓤 ✧✦✧");
        System.out.println("Search For Vehicles By:");
        System.out.println(" 1.  Price");
        System.out.println(" 2.  Make and Model");
        System.out.println(" 3.  Year ");
        System.out.println(" 4.  Color");
        System.out.println(" 5.  Mileage");
        System.out.println(" 6.  Vehicle Type ");
        System.out.println(" 7.  Classic and Vintage");
        System.out.println(" 8.  All vehicles ");
        System.out.println(" 9.  Add or Remove a vehicle");
        System.out.println(" 0.  Exit");


    }

    private void displayVehicles(List<Vehicle> vehicles){
        System.out.println("                                          ✦✧✦☾𝓘𝓃𝔱𝓮𝔯𝓰𝔞𝔩𝒶𝓬𝒕𝔦𝓬 𝔇𝓻𝓮𝐚𝔪 𝓒𝐚𝔯𝔰☽✦✧✦");
        System.out.println("⋆｡༄⋆˚⊹⋆｡༄⋆˚⊹⋆｡༄⋆˚⊹⋆｡༄⋆˚⊹⋆｡༄⋆˚⊹⋆｡༄⋆˚⊹⋆｡༄⋆˚⊹⋆｡༄⋆˚⊹⋆｡༄⋆˚⊹⋆｡༄⋆˚⊹⋆｡༄⋆˚⊹⋆｡༄⋆˚⊹⋆｡༄⋆˚⊹⋆｡༄⋆˚⊹⋆｡༄⋆˚⊹⋆｡༄⋆˚");
        System.out.println("Vin   | Year | Make            | Model        | Type         | Color    | Condition | Mileage | Price");
        System.out.println("✧✦      ✦✧✦✧   ✦✧✦✧              ✦✧✦✧✦          ✦✧✦✧           ✦✧✦✧✦      ✧✦✧✦✧✦✧✦✧   ✦✧✦✧✦✧✦   ✧✦✧✦✧✦");
        for (Vehicle vehicle : vehicles) {

            String format = "%-5s | %-4d | %-15s | %-12s | %-12s | %-8s | %-9s | %-7d | $%.2f\n";
            System.out.printf(format,
                    vehicle.getVin(),
                    vehicle.getYear(),
                    vehicle.getMake(),
                    vehicle.getModel(),
                    vehicle.getVehicleType(),
                    vehicle.getColor(),
                    vehicle.getCondition(),
                    vehicle.getOdometer(),
                    vehicle.getPrice()
            );

        }
        System.out.println("⋆｡༄⋆˚⊹⋆｡༄⋆˚⊹⋆｡༄⋆˚⊹⋆｡༄⋆˚⊹⋆｡༄⋆˚⊹⋆｡༄⋆˚⊹⋆｡༄⋆˚⊹⋆｡༄⋆˚⊹⋆｡༄⋆˚⊹⋆｡༄⋆˚⊹⋆｡༄⋆˚⊹⋆｡༄⋆˚⊹⋆｡༄⋆˚⊹⋆｡༄⋆˚⊹⋆｡༄⋆˚⊹⋆｡༄⋆˚");

    }



    public void processGetByPriceRequest(){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter minimum price: ");
        double min = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter max price: ");
        double max = scanner.nextDouble();
        scanner.nextLine();

        List<Vehicle> vehiclesInPriceRange = dealership.getVehiclesByPrice(min,max);

        vehiclesInPriceRange.sort(Comparator.comparingDouble(Vehicle::getPrice));


        displayVehicles(vehiclesInPriceRange);


    }

    public void processGetByMakeModelRequest(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter make: ");
        String make = scanner.nextLine();
        System.out.print("Enter model: ");
        String model = scanner.nextLine();

        List<Vehicle> vehiclesByMakeModel = dealership.getVehiclesByMakeModel(make,model);

        displayVehicles(vehiclesByMakeModel);

    }
    public void processGetByYearRequest(){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter starting year: ");
        double min = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter ending year: ");
        double max = scanner.nextDouble();
        scanner.nextLine();

        List<Vehicle> vehiclesByYear = dealership.getVehiclesByYear(min,max);



        displayVehicles(vehiclesByYear);

    }
    public void processGetByColorRequest(){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter color: ");
        String color = scanner.nextLine();


        List<Vehicle> vehiclesByColor = dealership.getVehiclesByColor(color);

        displayVehicles(vehiclesByColor);

    }
    public void processGetByMileageRequest(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter minimum miles: ");
        double min = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter max miles: ");
        double max = scanner.nextDouble();
        scanner.nextLine();

        List<Vehicle> vehiclesByMileage = dealership.getVehiclesByMileage(min,max);



        displayVehicles(vehiclesByMileage);

    }
    public void processGetByVehicleTypeRequest(){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter type: ");
        String vehicleType = scanner.nextLine();


        List<Vehicle> vehiclesByType = dealership.getVehiclesByType(vehicleType);

        displayVehicles(vehiclesByType);

    }

    public void processGetByClassicVintageRequest(){
        List<Vehicle> vehiclesByCondition = dealership.getVehiclesByCondition();
        displayVehicles(vehiclesByCondition);


    }

    public void getAllVehiclesRequest(){
        List<Vehicle> allVehicles = dealership.getAllVehicles();
        displayVehicles(allVehicles);

    }

    public void processRemoveVehicleRequest(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Vin number of the vehicle you want to remove.");
        System.out.print("Vin: ");
        int vin = scanner.nextInt();

        Vehicle vehicleToRemove = dealership.findVehicleByVin(vin);

        if (vehicleToRemove != null) {
            dealership.removeVehicle(vehicleToRemove);
            System.out.println("Vehicle removed successfully.");

            dealershipFileManager.saveDealership(dealership);

        } else {
            System.out.println("Vehicle with vin " + vin + " not found.");

        }

    }

    public void processAddVehicleRequest(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Vehicle info");
        System.out.println(" ");
        System.out.print("Vin: ");
        int vin = scanner.nextInt();
        System.out.print("Year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Make: ");
        String make = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Type: ");
        String type = scanner.nextLine();
        System.out.print("Color: ");
        String color = scanner.nextLine();
        System.out.print("Condition: ");
        String condition = scanner.nextLine();
        System.out.print("Odometer: ");
        int mileage = scanner.nextInt();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Vehicle vehicle = new Vehicle(vin,year,make, model, type, color, condition,mileage,price);
        dealership.addVehicle(vehicle);

        dealershipFileManager.saveDealership(dealership);


    }

    public void addOrRemoveMenu(){
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Options");
            System.out.println("A: Add a vehicle.");
            System.out.println("R: Remove a vehicle.");
            System.out.println("X: Save and exit");


            String input = scanner.nextLine().toUpperCase();

            switch (input){
                case "A":
                    processAddVehicleRequest();
                    break;
                case "R":
                    processRemoveVehicleRequest();
                    break;
                case "X":
                    System.out.println("Saving... Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try Again.");

            }



        }




    }

}
