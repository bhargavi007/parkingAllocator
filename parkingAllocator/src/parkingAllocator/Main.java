package parkingAllocator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import parkingAllocator.Parser;

public class Main {
    public static void main(String[] args) {
        Parser inputParser = new Parser();
        System.out.println("Please enter 'exit' to quit");
        System.out.println("Enter the commands...");
        while(true){
            try {
                BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
                String inputString = bufferRead.readLine();
                if (inputString.equalsIgnoreCase("exit")) {
                    break;
                } else if ((inputString == null) || (inputString.isEmpty())) {
                    // Do nothing
                } else {
                    inputParser.parseTextInput(inputString.trim());
                }
            } catch(IOException e) {
                System.out.println("Oops! Error in reading the input from console.");
                e.printStackTrace();
            }
        }
              
       
    }
}