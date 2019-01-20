package com.parkingAllocator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.parkingAllocator.InputCommands;

public class InputCommandTests {
	InputCommands commands = new InputCommands();
    @Test
    public void checkCommandInList() throws Exception {
        assertFalse(commands.commandsMap.isEmpty());
        assertTrue(commands.commandsMap.containsKey("create_parking_lot"));
        assertTrue(commands.commandsMap.containsKey("park"));
        assertTrue(commands.commandsMap.containsKey("status"));
        assertTrue(commands.commandsMap.containsKey("leave"));
        assertTrue(commands.commandsMap.containsKey("registration_numbers_for_cars_with_colour"));
        assertTrue(commands.commandsMap.containsKey("slot_numbers_for_cars_with_colour"));
        assertTrue(commands.commandsMap.containsKey("slot_number_for_registration_number"));
        assertFalse(commands.commandsMap.containsKey("mytestcommand"));
    }
}
