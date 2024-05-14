package com.pluralsight;

import java.io.*;

public class DealershipFileManager {
    private String fileName;

    public DealershipFileManager(String fileName) {
        this.fileName = "dealership.csv";
    }

    public Dealership getDealership(){
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){

            String dealershipInfo = reader.readLine();
            String[] dealershipParts = dealershipInfo.split("\\|");
            String dealershipName = dealershipParts[0];
            String dealershipAddress = dealershipParts[1];
            String dealershipPhone = dealershipParts[2];


            Dealership dealership = new Dealership(dealershipName,dealershipAddress, dealershipPhone);
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                int vin = Integer.parseInt(parts[0]);
                int year = Integer.parseInt(parts[1]);
                String make = parts[2];
                String model = parts[3];
                String type = parts[4];
                String color = parts[5];
                String condition = parts[6];
                int odometer = Integer.parseInt(parts[7]);
                double price = Double.parseDouble(parts[8]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, condition, odometer, price);
                dealership.addVehicle(vehicle);


            }
            return dealership;

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return null;
        }
    }

    public void saveDealership(Dealership dealership){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
            writer.newLine();

            for (Vehicle vehicle : dealership.getAllVehicles()) {
                writer.write(vehicle.getVin() + "|" +
                        vehicle.getYear() + "|" +
                        vehicle.getMake() + "|" +
                        vehicle.getModel() + "|" +
                        vehicle.getVehicleType() + "|" +
                        vehicle.getColor() + "|" +
                        vehicle.getCondition() + "|" +
                        vehicle.getOdometer() + "|" +
                        vehicle.getPrice());
                writer.newLine();

            }
            System.out.println("Dealership information saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving dealership information: " + e.getMessage());
        }



    }

}

