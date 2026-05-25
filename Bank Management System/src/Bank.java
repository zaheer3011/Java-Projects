import java.util.Map;
import java.util.HashMap;

class InsufficientBalance extends Exception {
    public String tostring() { return "Insufficient Balance! Minimum Balance should be 500"; }
}

public class Bank {

    private Map<Integer, Account> accountDetails = new HashMap <> ();

    public void createAccount(Account account) {

        if(account != null) {
            int accountNo = account.getAccountNo();
            accountDetails.put(accountNo, account);
            System.out.println("Congratulation!..Account created successfully");
            System.out.println("Account Number : " + accountNo + '\n');
        }

        else {
            System.out.println("Account has not created" + '\n' + "Check your details properly");
        }
    }

    public void checkAccountDetails(int accountNo) {
        if(isAcountAvailable(accountNo)) {
            this.execute(accountNo);
        }

        else {
            System.out.println("Invalid Account Number");
        }
    }

    public void checkBalance(int accountNo) {
        if(accountDetails.containsKey(accountNo)) {
            long currBalance = accountDetails.get(accountNo).getBalance();
            System.out.println("Balance : " + currBalance);
        }
        else {
            System.out.println("Invalid Account Number");
        }
    }

    public void deposit(int accountNo, long amount) {
        if(isAcountAvailable(accountNo)) {
            Account acc = accountDetails.get(accountNo);
            long currBalance = acc.getBalance() + amount;
            acc.setBalance(currBalance);
            System.out.println("Amount Deposited successfully");
            this.checkBalance(accountNo);
        }

        else {
            System.out.println("Invalid Account Number");
        }
    }

    public void withdraw(int accountNo, long amount) {
        if(isAcountAvailable(accountNo)) {
            try {
               if(accountDetails.get(accountNo).getBalance() > amount) {
                   Account acc = accountDetails.get(accountNo);
                   long currBalance = acc.getBalance() - amount;
                   acc.setBalance(currBalance);
                   System.out.println("Amount Withdrawn successfully");
                   this.checkBalance(accountNo);
               }

               throw new InsufficientBalance();

            }
            catch(InsufficientBalance e) {
              System.out.println(e);
            }
        }

        else {
            System.out.println("Invalid Account Number");
        }
    }

    public void printAllAccount() {
        for(Map.Entry<Integer, Account> details : accountDetails.entrySet()) {
            int currAccountNo = details.getKey();
            this.execute(currAccountNo);
        }
    }

    public boolean isAcountAvailable(int accountNo) {

        if(accountDetails.containsKey(accountNo))
            return true;
        return false;
    }


    public void execute(int accountNo) {
       Account acc = accountDetails.get(accountNo);

       System.out.println("Account Number : " + accountNo);
       System.out.println("Name : " + acc.getFirstName() + " " + acc.getLastName());
       System.out.println("Balance : " + acc.getBalance());
     }
}
