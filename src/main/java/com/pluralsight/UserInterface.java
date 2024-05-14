package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;



    public UserInterface() {
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
                case 0:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }

    }

    public void displayMenu(){
        System.out.println("✧✦✧ 𝓜𝓔𝓝𝓤 ✧✦✧");
        System.out.println("1. Search for vehicles by price");
        System.out.println("2. Search for vehicles by make and model");
        System.out.println("3. Search for vehicles by year ");
        System.out.println("4. Search for vehicles by color");
        System.out.println("5. Search for vehicles by mileage");
        System.out.println("6. Search for vehicles by vehicle type ");
        System.out.println("7. Search for classic and vintage vehicles");
        System.out.println("8. All vehicles ");
        System.out.println("0. Exit");


    }

    private void displayVehicles(List<Vehicle> vehicles){
        System.out.println("                               ✦✧✦VEHICLES✦✧✦");
        System.out.println("ID   | Year | Make        | Model      | Type       | Color | Condition | Mileage | Price");
        System.out.println("⋆｡༄⋆˚⊹⋆｡༄⋆˚⊹⋆｡༄⋆˚⊹⋆｡༄⋆˚⊹⋆｡༄⋆˚⊹⋆｡༄⋆˚⊹⋆｡༄⋆˚⊹⋆｡༄⋆˚⊹⋆｡༄⋆˚⊹⋆｡༄⋆˚⊹⋆｡༄⋆˚⊹⋆｡༄⋆˚⊹⋆｡༄⋆˚⊹");
        for (Vehicle vehicle : vehicles) {

            String format = "%-5s | %-4d | %-11s | %-10s | %-10s | %-5s | %-9s | %-7d | $%.2f\n";
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

    }



    public void processGetByPriceRequest(){

    }

    public void processGetByMakeModelRequest(){

    }
    public void processGetByYearRequest(){

    }
    public void processGetByColorRequest(){

    }
    public void processGetByMileageRequest(){

    }
    public void processGetByVehicleTypeRequest(){

    }

    public void processGetByClassicVintageRequest(){

    }

    public void getAllVehiclesRequest(){
        List<Vehicle> allVehicles = dealership.getAllVehicles();
        displayVehicles(allVehicles);

    }

    public void processRemoveVehicleRequest(){

    }

}
