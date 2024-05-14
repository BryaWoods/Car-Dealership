package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
                int odometer = Integer.parseInt(parts[6]);
                double price = Double.parseDouble(parts[7]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
                dealership.addVehicle(vehicle);


            }
            return dealership;

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return null;
        }
    }

    public void saveDealership(Dealership dealership){
        

    }

}

