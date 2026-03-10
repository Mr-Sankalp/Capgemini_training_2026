package org.example;

import junit.framework.TestCase;

public class BankTest extends TestCase {

    private BankAccount account;

    protected void setUp() {
        account = new BankAccount(100);
    }

    public void testDeposit() {
        account.deposit(50);
        assertEquals(150, account.getBalance());
    }

    public void testWithdrawSuccess() {
        account.withdraw(50);
        assertEquals(50, account.getBalance());
    }

    public void testWithdrawInsufficientFunds() {
        try {
            account.withdraw(178);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // test passes
        }
    }
}