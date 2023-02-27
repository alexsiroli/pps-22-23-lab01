package lab01.example.model;

/**
 * This class represent a particular instance of a BankAccount.
 * In particular, a Simple Bank Account allows always the deposit
 * while the withdrawal is allowed only if the balance greater or equal the withdrawal amount
 */
public class SimpleBankAccountWithAtm implements BankAccount {

    private final SimpleBankAccount bankAccount;
    public final static int FEE = 1;

    public SimpleBankAccountWithAtm(final AccountHolder holder, final double balance) {
        this.bankAccount = new SimpleBankAccount(holder, balance);
    }

    @Override
    public AccountHolder getHolder() {
        return this.bankAccount.getHolder();
    }

    @Override
    public double getBalance() {
        return this.bankAccount.getBalance();
    }

    @Override
    public void deposit(int userID, double amount) {
        if (this.validAmount(amount)){
            this.bankAccount.deposit(userID, amount - FEE);
        }
    }

    @Override
    public void withdraw(int userID, double amount) {
        if (this.validAmount(amount)){
            this.bankAccount.withdraw(userID, amount + FEE);
        }
    }

    private boolean validAmount(final double amount) {
        return amount > 0;
    }

}
