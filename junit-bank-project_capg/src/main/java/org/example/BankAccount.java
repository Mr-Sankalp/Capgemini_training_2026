package org.example;

public class BankAccount {

    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {

        balance+=amount;
        System.out.println(balance);
    }
    public void withdraw(int amount)
    {
        if(amount <=0)
        {
            throw new IllegalArgumentException("withdraw amount must be positive");
        }
        if(amount > balance)
        {
            throw new IllegalArgumentException("insufficient funds");
        }
        balance-=amount;
    }

}
