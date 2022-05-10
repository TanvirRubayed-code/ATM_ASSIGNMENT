
package atm_assignment;


public class CashDispenser {
    private final static int INITIAL_COUNT = 500;
    private int count; 

    public CashDispenser() {
        count = INITIAL_COUNT; // set count attribute to default
    } // end CashDispenser constructor

    public void dispenseCash(int amount) {
        int billsRequired = amount / 20; 
        count -= billsRequired; 
    } // end method dispenseCash

    // indicates whether cash dispenser can dispense desired amount
    public boolean isSufficientCashAvailable(int amount) {
        int billsRequired = amount / 20; 

        if (count >= billsRequired)
            return true; 
        else
            return false; 
    } // end method isSufficientCashAvailable
} // end class CashDispenser
