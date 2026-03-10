package oops_concept;

// Abstraction
abstract class Shape {
    abstract void draw();
}

// Concrete implementation
class Circle extends Shape {
    void draw() {
        System.out.println("Drawing Circle");
    }
}

// Encapsulation
class BankAccount {

    private String accountHolder;   // private variable
    private double balance;

    public BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Invalid balance amount!");
        }
    }
}

public class Day11_Abstraction_Encapsulation
{

    public static void main(String[] args) {

        // Abstraction Demo
        Shape s = new Circle();
        s.draw();

        System.out.println("------------------");

        // Encapsulation Demo
        BankAccount account = new BankAccount("Yash", 5000);

        System.out.println("Account Holder: " + account.getAccountHolder());
        System.out.println("Balance: " + account.getBalance());

        account.setBalance(8000);
        System.out.println("Updated Balance: " + account.getBalance());
    }
}