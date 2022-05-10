package atm_assignment;

public class BalanceInquiry extends Transaction {

    // BalanceInquiry constructor
    public BalanceInquiry(int userAccountNumber, Screen atmScreen,
            BankDatabase atmBankDatabase) {
        super( userAccountNumber, atmScreen, atmBankDatabase );
    } // end BalanceInquiry constructor

    // performs the transaction
    public void execute() {
        BankDatabase bankDatabase = getBankDatabase();
        Screen screen = getScreen();

        double availableBalance = bankDatabase.getAvailableBalance(getAccountNumber());

        double totalBalance = bankDatabase.getTotalBalance(getAccountNumber());

        // display the balance information on the screen
        screen.displayMessageLine("\nBalance Information:");
        screen.displayMessage(" - Available balance: ");
        screen.displayDollarAmount(availableBalance);
        screen.displayMessage("\n - Total balance: ");
        screen.displayDollarAmount(totalBalance);
        screen.displayMessageLine("");
    } // end method execute

    public BankDatabase getBankDatabase() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Screen getScreen() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public int getAccountNumber() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
} // end class BalanceInquiry
