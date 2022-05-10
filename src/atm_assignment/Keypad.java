
package atm_assignment;

import java.util.Scanner;


public class Keypad {
    private Scanner input; // reads data from the command line

    public Keypad() {
        input = new Scanner(System.in);
    } // end no-argument Keypad constructor
      // return an integer value entered by user

    public int getInput() {
        return input.nextInt(); 
    } // end method getInput
} // end class Keypad