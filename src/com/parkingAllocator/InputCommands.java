package com.parkingAllocator;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.HashMap;

public class InputCommands {
    public Map<String, Method> commandsMap;

    public InputCommands(){
        commandsMap = new HashMap<String, Method>();
        try {
			generateCommandsMap();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    private void generateCommandsMap() throws NoSuchMethodException, SecurityException {
        commandsMap.put("create_parking_lot", ParkingLot.class.getMethod("createParkingLot", String.class));
        commandsMap.put("park", ParkingLot.class.getMethod("park", String.class, String.class));
        commandsMap.put("leave", ParkingLot.class.getMethod("leave", String.class));
        commandsMap.put("status", ParkingLot.class.getMethod("status"));
        commandsMap.put("registration_numbers_for_cars_with_colour", ParkingLot.class.getMethod("getRegistrationNumbersGivenColor", String.class));
        commandsMap.put("slot_numbers_for_cars_with_colour", ParkingLot.class.getMethod("getSlotNumbersGivenColor", String.class));
        commandsMap.put("slot_number_for_registration_number", ParkingLot.class.getMethod("getSlotNumberGivenRegNo", String.class));
    }
}
