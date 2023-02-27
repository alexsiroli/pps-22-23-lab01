import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        this.bankAccountWithAtm.deposit(this.accountHolder.getId(), 101);
        assertEquals(100, this.bankAccountWithAtm.getBalance());
    }

    @Test
    void testWrongDeposit() {
        this.bankAccountWithAtm.deposit(this.accountHolder.getId(), 101);
        this.bankAccountWithAtm.deposit(1, 51);
        assertEquals(100, this.bankAccountWithAtm.getBalance());
    }

    @Test
    void testWithdraw() {
        this.bankAccountWithAtm.deposit(this.accountHolder.getId(), 101);
        this.bankAccountWithAtm.withdraw(this.accountHolder.getId(), 69);
        assertEquals(30, this.bankAccountWithAtm.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        this.bankAccountWithAtm.deposit(this.accountHolder.getId(), 101);
        this.bankAccountWithAtm.withdraw(1, 71);
        assertEquals(100, this.bankAccountWithAtm.getBalance());
    }

    @Test
    void testExcessiveWithdraw() {
        this.bankAccountWithAtm.deposit(this.accountHolder.getId(), 101);
        this.bankAccountWithAtm.withdraw(this.accountHolder.getId(), 100);
        assertEquals(100, this.bankAccountWithAtm.getBalance());
    }

    @Test
    void testWrongAmount() {
        this.bankAccountWithAtm.deposit(this.accountHolder.getId(), 101);
        this.bankAccountWithAtm.deposit(this.accountHolder.getId(), 0);
        this.bankAccountWithAtm.withdraw(this.accountHolder.getId(), -10);
        assertEquals(100, this.bankAccountWithAtm.getBalance());
    }
}
