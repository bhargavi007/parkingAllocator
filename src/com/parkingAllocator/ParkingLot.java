package com.parkingAllocator;

import java.util.*;

public class ParkingLot {
    int LOT_SIZE = 0;
    private class Car {
        String regNum;
        String color;
        public Car(String regNum, String color) {
            this.regNum = regNum;
            this.color = color;
        }
    }
    ArrayList<Integer> availableSlotList;
    // Slot and Car Mapping
    Map<String, Car> mapSlotCar;
    // Registration and Slot mapping
    Map<String, String> mapRegSlot;
    // Color and Registration List mapping
    Map<String, ArrayList<String>> mapColor;


    public void createParkingLot(String lotCount) {
        try {
            this.LOT_SIZE = Integer.parseInt(lotCount);
        } catch (Exception e) {
            System.out.println("Lot Count is invalid");
            System.out.println();
        }
        this.availableSlotList = new ArrayList<Integer>() {};
        for (int i=1; i<= this.LOT_SIZE; i++) {
            availableSlotList.add(i);
        }
        this.mapSlotCar = new HashMap<String, Car>();
        this.mapRegSlot = new HashMap<String, String>();
        this.mapColor = new HashMap<String, ArrayList<String>>();
        
        System.out.println("Created a parking lot with " + lotCount + " slots");
        System.out.println();
    }
    
    //To park a car given regNo and color
    public void park(String regNo, String color) {
        if (this.LOT_SIZE == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } 
        else if (this.mapSlotCar.size() == this.LOT_SIZE) {
            System.out.println("Sorry, parking lot is full");
            System.out.println();
        } 
        else {
            Collections.sort(availableSlotList);
            String slot = availableSlotList.get(0).toString();
            Car car = new Car(regNo, color);
            this.mapSlotCar.put(slot, car);
            this.mapRegSlot.put(regNo, slot);
            if (this.mapColor.containsKey(color)) {
                ArrayList<String> regNoList = this.mapColor.get(color);
                regNoList.add(regNo);
                this.mapColor.remove(color);
                this.mapColor.put(color, regNoList);
            } 
            else {
                ArrayList<String> regNoList = new ArrayList<String>();
                regNoList.add(regNo);
                this.mapColor.put(color, regNoList);
            }
            System.out.println("Allocated slot number: " + slot);
            System.out.println();
            availableSlotList.remove(0);
        }
    }
    public void leave(String slotNo) {
        if (this.LOT_SIZE == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        }
        else if (this.mapSlotCar.size() > 0) {
            Car carToLeave = this.mapSlotCar.get(slotNo);
            if (carToLeave != null) {
                this.mapSlotCar.remove(slotNo);
                this.mapRegSlot.remove(carToLeave.regNum);
                ArrayList<String> regNoList = this.mapColor.get(carToLeave.color);
                if (regNoList.contains(carToLeave.regNum)) {
                    regNoList.remove(carToLeave.regNum);
                }
                // Add the Lot No. back to available slot list.
                this.availableSlotList.add(Integer.parseInt(slotNo));
                System.out.println("Slot number " + slotNo + " is free");
                System.out.println();
            } else {
                System.out.println("Slot number " + slotNo + " is already empty");
                System.out.println();
            }
        } 
        else {
            System.out.println("Parking lot is empty");
            System.out.println();
        }
    }
    
    public void status() {
        if (this.LOT_SIZE == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (this.mapSlotCar.size() > 0) {
            // Print the current status.
            System.out.println("Slot No.\tRegistration No.\tColour");
            Car car;
            for (int i = 1; i <= this.LOT_SIZE; i++) {
                String key = Integer.toString(i);
                if (this.mapSlotCar.containsKey(key)) {
                    car = this.mapSlotCar.get(key);
                    System.out.println(i + "\t" + car.regNum + "\t" + car.color);
                }
            }
            System.out.println();
        } else {
            System.out.println("Parking lot is empty");
            System.out.println();
        }
    }
    
    public void getRegistrationNumbersGivenColor(String color) {
        if (this.LOT_SIZE == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } 
        else if (this.mapColor.containsKey(color)) {
            ArrayList<String> regNoList = this.mapColor.get(color);
            System.out.println();
            //print registration number
            for (int i=0; i < regNoList.size(); i++) {
                if (!(i==regNoList.size() - 1)){
                    System.out.print(regNoList.get(i) + ",");
                } 
                else {
                    System.out.print(regNoList.get(i));
                }
            }
        } 
        else {
            System.out.println("Not found");
            System.out.println();
        }
    }
    
    public void getSlotNumbersGivenColor(String color) {
        if (this.LOT_SIZE == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } 
        else if (this.mapColor.containsKey(color)) {
            ArrayList<String> regNoList = this.mapColor.get(color);
            ArrayList<Integer> slotList = new ArrayList<Integer>();
            System.out.println();
            for (int i=0; i < regNoList.size(); i++) {
                slotList.add(Integer.valueOf(this.mapRegSlot.get(regNoList.get(i))));
            }
            Collections.sort(slotList);
            //print slots
            for (int j=0; j < slotList.size(); j++) {
                if (!(j == slotList.size() - 1)) {
                    System.out.print(slotList.get(j) + ",");
                } else {
                    System.out.print(slotList.get(j));
                }
            }
            System.out.println();
        } else {
            System.out.println("Not found");
            System.out.println();
        }
    }
    
    public void getSlotNumberGivenRegNo(String regNo) {
        if (this.LOT_SIZE == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (this.mapRegSlot.containsKey(regNo)) {
            System.out.println(this.mapRegSlot.get(regNo));
        } else {
            System.out.println("Not found");
            System.out.println();
        }
    }
}
