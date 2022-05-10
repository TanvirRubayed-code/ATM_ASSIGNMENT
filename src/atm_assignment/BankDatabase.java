package atm_assignment;

public class BankDatabase {

    private Account[] accounts; 

    public BankDatabase() {
        accounts = new Account[2]; 
        accounts[0] = new Account(12345, 54321, 1000.0, 1200.0);
        accounts[1] = new Account(98765, 56789, 200.0, 200.0);
    } // end no-argument BankDatabase constructor

    // retrieve Account object containing specified account number
    private Account getAccount(int accountNumber) {
        for (Account currentAccount : accounts) {
            if (currentAccount.getAccountNumber() == accountNumber) {
                return currentAccount;
            }
        } // end for

        return null; 
    } // end method getAccount

    // determine whether user-specified account number and PIN match
    // those of an account in the database
    public boolean authenticateUser(int userAccountNumber, int userPIN) {
        Account userAccount = getAccount(userAccountNumber);

        if (userAccount != null) {
            return userAccount.validatePIN(userPIN);
        } else {
            return false; 
        }
    } // end method authenticateUser

    // return available balance of Account with specified account number
    public double getAvailableBalance(int userAccountNumber) {
        return getAccount(userAccountNumber).getAvailableBalance();
    } // end method getAvailableBalance

    // return total balance of Account with specified account number
    public double getTotalBalance(int userAccountNumber) {
        return getAccount(userAccountNumber).getTotalBalance();
    } // end method getTotalBalance

    // credit an amount to Account with specified account number
    public void credit(int userAccountNumber, double amount) {
        getAccount(userAccountNumber).credit(amount);
    } // end method credit
    // debit an amount from Account with specified account number

    public void debit(int userAccountNumber, double amount) {
        getAccount(userAccountNumber).debit(amount);
    } // end method debit

} // end class BankDatabase
