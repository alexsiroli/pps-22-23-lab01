package lab01.example.model;

/**
 * This class represent a particular instance of a BankAccount.
 * In particular, a Simple Bank Account allows always the deposit
 * while the withdrawal is allowed only if the balance greater or equal the withdrawal amount
 */
public class SimpleBankAccountWithAtm implements BankAccount {

    private double balance;
    private final AccountHolder holder;

    final int FEE = 1;

    public SimpleBankAccountWithAtm(final AccountHolder holder, final double balance) {
        this.holder = holder;
        this.balance = balance;
    }

    @Override
    public AccountHolder getHolder() {
        return this.holder;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(int userID, double amount) {
        if (this.checkUser(userID) && this.validAmount(amount)) {
            this.balance += amount;
            this.applyfee();
        }
    }

    @Override
    public void withdraw(int userID, double amount) {
        if (this.checkUser(userID) && this.isWithdrawAllowed(amount) && this.validAmount(amount)){
            this.balance -= amount;
            this.applyfee();
        }
    }

    private boolean checkUser(final int id) {
        return this.holder.getId() == id;
    }

    private boolean validAmount(final double amount) {
        return amount >= 1;
    }

    private boolean isWithdrawAllowed(final double amount){
        return this.balance >= amount + this.FEE;
    }

    private void applyfee() {
        this.balance -= this.FEE;
    }
}
