package TopBrains_Assessment;

public class BankingRiskManager {

    // --- Custom Exceptions ---
    static class AmountInvalidException extends Exception {
        public AmountInvalidException(String message) {
            super(message);
        }
    }

    static class AmountExceedsLimitException extends Exception {
        public AmountExceedsLimitException(String message) {
            super(message);
        }
    }

    static class InactiveAccountException extends Exception {
        public InactiveAccountException(String message) {
            super(message);
        }
    }

    static class InsufficientBalanceException extends Exception {
        public InsufficientBalanceException(String message) {
            super(message);
        }
    }

    // --- Bank Account Class ---
    static class BankAccount {
        private double balance;
        private boolean active;

        public BankAccount(double balance, boolean active) {
            this.balance = balance;
            this.active = active;
        }

        public double getBalance() {
            return balance;
        }

        public boolean isActive() {
            return active;
        }

        public void withdraw(double amount)
                throws AmountInvalidException, AmountExceedsLimitException,
                InactiveAccountException, InsufficientBalanceException {
            validateAmount(amount);
            validateAccountStatus();
            validateBalance(amount);

            balance -= amount;
            System.out.println("Withdrawal of ₹" + amount + " successful. Remaining balance: ₹" + balance);
        }

        private void validateAmount(double amount) throws AmountInvalidException, AmountExceedsLimitException {
            if (amount <= 0) {
                throw new AmountInvalidException("Withdrawal amount must be greater than zero.");
            }
            if (amount > 50000) {
                throw new AmountExceedsLimitException("Withdrawal amount exceeds the maximum limit of ₹50,000.");
            }
        }

        private void validateAccountStatus() throws InactiveAccountException {
            if (!active) {
                throw new InactiveAccountException("Cannot process withdrawal: Account is inactive.");
            }
        }

        private void validateBalance(double amount) throws InsufficientBalanceException {
            if (balance < amount) {
                throw new InsufficientBalanceException("Insufficient balance for this withdrawal.");
            }
        }
    }

    // --- Main Method ---
    public static void main(String[] args) {
        BankAccount account = new BankAccount(30000, true);

        double[] withdrawals = { -1000, 60000, 10000, 5000 };

        for (double amount : withdrawals) {
            try {
                account.withdraw(amount);
            } catch (AmountInvalidException | AmountExceedsLimitException |
                     InactiveAccountException | InsufficientBalanceException e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                System.out.println("Transaction attempt completed.\n");
            }
        }
    }
}