
package atm_assignment;


public class Deposit extends Transaction {
    private double amount; 
    private Keypad keypad; 
    private DepositSlot depositSlot; 
    private final static int CANCELED = 0; 

    // Deposit constructor
    public Deposit(int userAccountNumber, Screen atmScreen,
            BankDatabase atmBankDatabase, Keypad atmKeypad,
            DepositSlot atmDepositSlot) {
        // initialize superclass variables
        super(userAccountNumber, atmScreen, atmBankDatabase);

        // initialize references to keypad and deposit slot
        keypad = atmKeypad;
        depositSlot = atmDepositSlot;
    } // end Deposit constructor

    // perform transaction
    @Override
    public void execute() {
        BankDatabase bankDatabase = getBankDatabase(); 
        Screen screen = getScreen();

        amount = promptForDepositAmount(); 

        // check whether user entered a deposit amount or canceled
        if (amount != CANCELED) {
            screen.displayMessage(
                    "\nPlease insert a deposit envelope containing ");
            screen.displayDollarAmount(amount);
            screen.displayMessageLine(".");

            // receive deposit envelope
            boolean envelopeReceived = depositSlot.isEnvelopeReceived();

            // check whether deposit envelope was received
            if (envelopeReceived) {
                screen.displayMessageLine("\nYour envelope has been " +
                        "received.\nNOTE: The money just deposited will not " +
                        "be available until we verify the amount of any " +
                        "enclosed cash and your checks clear.");
                // credit account to reflect the deposit
                bankDatabase.credit(getAccountNumber(), amount);
            } // end if
            else // deposit envelope not received
            {
                screen.displayMessageLine("\nYou did not insert an " +
                        "envelope, so the ATM has canceled your transaction.");
            } // end else
        } // end if
        else // user canceled instead of entering amount
        {
            screen.displayMessageLine("\nCanceling transaction...");
        } // end else
    } // end method execute

    // prompt user to enter a deposit amount in cents
    private double promptForDepositAmount() {
        Screen screen = getScreen(); // get reference to screen

        // display the prompt
        screen.displayMessage("\nPlease enter a deposit amount in " +
                "CENTS (or 0 to cancel): ");
        int input = keypad.getInput(); // receive input of deposit amount

        // check whether the user canceled or entered a valid amount
        if (input == CANCELED)
            return CANCELED;
        else {
            return (double) input / 100; // return dollar amount
        } // end else
    } // end method promptForDepositAmount
} // end class Deposit