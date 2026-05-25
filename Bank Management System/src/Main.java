import java.util.Scanner;

public class Main {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        System.out.println("Welcome to ABC Bank");
        int choice;

        do {
            System.out.println("\n1. Create Account");
            System.out.println("2. Balance Enquiry");
            System.out.println("3. Check Details");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Display All Account");
            System.out.println("7. Quit");
            System.out.println("Enter your choice : ");
            choice = sc.nextInt();

            switch(choice) {

                case 1 -> {
                    String fName, lName;
                    long amount;

                    sc.nextLine();
                    System.out.println("FirstName : ");
                    fName = sc.nextLine();
                    System.out.println("LastName : ");
                    lName = sc.nextLine();
                    System.out.println("Amount : ");
                    amount = sc.nextInt();

                    Account account = new Account(fName, lName, amount);
                    bank.createAccount(account);
                    break;
                }

                case 2 -> {
                    int accoutNo;
                    System.out.println("Account Number : ");
                    accoutNo = sc.nextInt();
                    bank.checkBalance(accoutNo);
                    break;
                }

                case 3 -> {
                    int accountNo;
                    System.out.println("Account Number : ");
                    accountNo = sc.nextInt();
                    bank.checkAccountDetails(accountNo);
                    break;
                }

                case 4 -> {
                    int accountNo;
                    long amount;
                    System.out.println("Account Number : ");
                    accountNo = sc.nextInt();
                    System.out.println("Amount : ");
                    amount = sc.nextLong();
                    bank.deposit(accountNo, amount);
                    break;
                }

                case 5 -> {
                    int accountNo;
                    long amount;
                    System.out.println("Account Number : ");
                    accountNo = sc.nextInt();
                    System.out.println("Amount : ");
                    amount = sc.nextLong();
                    bank.withdraw(accountNo, amount);
                    break;
                }

                case 6 -> {
                    bank.printAllAccount();
                    break;
                }

                case 7 -> {
                    break;
                }


                default -> {
                    System.out.println("Invalid choice");
                    break;
                }
            }
        } while(choice != 7);
    }
}
