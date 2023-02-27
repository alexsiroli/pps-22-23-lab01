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

    private AccountHolder accountHolder;
    private BankAccount bankAccountWithAtm;

    @BeforeEach
    void beforeEach(){
        this.accountHolder = new AccountHolder("Maria", "Verdi", 2);
        this.bankAccountWithAtm = new SimpleBankAccountWithAtm(this.accountHolder, 0);
    }

    @Test
    void testInitialBalance() {
        assertEquals(0, this.bankAccountWithAtm.getBalance());
    }

    @Test
    void testDeposit() {
        this.bankAccountWithAtm.deposit(this.accountHolder.getId(), 100);
        assertEquals(100-FEE, this.bankAccountWithAtm.getBalance());
    }

    @Test
    void testWrongDeposit() {
        this.bankAccountWithAtm.deposit(this.accountHolder.getId(), 100);
        this.bankAccountWithAtm.deposit(1, 50);
        assertEquals(100-FEE, this.bankAccountWithAtm.getBalance());
    }

    @Test
    void testWithdraw() {
        this.bankAccountWithAtm.deposit(this.accountHolder.getId(), 100);
        this.bankAccountWithAtm.withdraw(this.accountHolder.getId(), 70);
        assertEquals(30-FEE-FEE, this.bankAccountWithAtm.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        this.bankAccountWithAtm.deposit(this.accountHolder.getId(), 100);
        this.bankAccountWithAtm.withdraw(1, 70);
        assertEquals(100-FEE, this.bankAccountWithAtm.getBalance());
    }

    @Test
    void testExcessiveWithdraw() {
        this.bankAccountWithAtm.deposit(this.accountHolder.getId(), 100);
        this.bankAccountWithAtm.withdraw(this.accountHolder.getId(), 100-FEE);
        assertEquals(100-FEE, this.bankAccountWithAtm.getBalance());
    }

    @Test
    void testWrongAmount() {
        this.bankAccountWithAtm.deposit(this.accountHolder.getId(), 100);
        this.bankAccountWithAtm.deposit(this.accountHolder.getId(), 0);
        this.bankAccountWithAtm.withdraw(this.accountHolder.getId(), -10);
        assertEquals(100-FEE, this.bankAccountWithAtm.getBalance());
    }
}
