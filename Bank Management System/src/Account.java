public class Account {

    private String firstName;
    private String lastName;
    private long balance;
    private int accountNo;

    private static int nextAccountNo = 0;

    public Account(String firstName, String lastName, long amount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = amount;

        this.accountNo = ++nextAccountNo;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setBalance(long amount) {
        this.balance = amount;
    }

    public long getBalance() {
        return balance;
    }
}
