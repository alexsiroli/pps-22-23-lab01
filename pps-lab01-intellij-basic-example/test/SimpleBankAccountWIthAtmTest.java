import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static lab01.example.model.SimpleBankAccountWithAtm.FEE;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The test suite for testing the SimpleBankAccountWithAtm implementation
 */
public class SimpleBankAccountWIthAtmTest {

    private static final int DEPOSIT_AMOUNT = 100;

    private AccountHolder accountHolder;
    private BankAccount bankAccountWithAtm;

    @BeforeEach
    void beforeEach(){
        this.accountHolder = new AccountHolder("Maria", "Verdi", 1);
        this.bankAccountWithAtm = new SimpleBankAccountWithAtm(this.accountHolder, 0);
    }

    @Test
    void testInitialBalance() {
        assertEquals(0, this.bankAccountWithAtm.getBalance());
    }

    @Test
    void testDeposit() {
        this.correctDeposit();
        assertEquals(DEPOSIT_AMOUNT-FEE, this.bankAccountWithAtm.getBalance());
    }

    @Test
    void testWrongDeposit() {
        this.correctDeposit();
        this.bankAccountWithAtm.deposit(2, 50);
        assertEquals(DEPOSIT_AMOUNT-FEE, this.bankAccountWithAtm.getBalance());
    }

    @Test
    void testWithdraw() {
        this.correctDeposit();
        this.bankAccountWithAtm.withdraw(this.accountHolder.getId(), 70);
        assertEquals(DEPOSIT_AMOUNT-70-FEE-FEE, this.bankAccountWithAtm.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        this.correctDeposit();
        this.bankAccountWithAtm.withdraw(2, 70);
        assertEquals(DEPOSIT_AMOUNT-FEE, this.bankAccountWithAtm.getBalance());
    }

    @Test
    void testExcessiveWithdraw() {
        this.correctDeposit();
        this.bankAccountWithAtm.withdraw(this.accountHolder.getId(), 100-FEE);
        assertEquals(DEPOSIT_AMOUNT-FEE, this.bankAccountWithAtm.getBalance());
    }

    @Test
    void testWrongAmount() {
        this.correctDeposit();
        this.bankAccountWithAtm.deposit(this.accountHolder.getId(), 0);
        this.bankAccountWithAtm.withdraw(this.accountHolder.getId(), -10);
        assertEquals(DEPOSIT_AMOUNT-FEE, this.bankAccountWithAtm.getBalance());
    }

    private void correctDeposit() {
        this.bankAccountWithAtm.deposit(this.accountHolder.getId(), DEPOSIT_AMOUNT);
    }
}
