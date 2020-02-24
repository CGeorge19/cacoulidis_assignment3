public class SavingsAccount
{
    // declare variables
    private static double annualInterestRate;
    private double savingsBalance;

    // constructor
    public SavingsAccount(double balance)
    {
        savingsBalance = balance;
    }

    // getters and setters
    public static double getAnnualInterestRate()
    {
        return annualInterestRate;
    }

    public static void setAnnualInterestRate(double annualInterestRate)
    {
        SavingsAccount.annualInterestRate = annualInterestRate;
    }

    public double getSavingsBalance()
    {
        return savingsBalance;
    }

    // calculates interest made each month and adds it to the savings balance
    public void calculateMonthlyInterest()
    {
        savingsBalance += getSavingsBalance() * (getAnnualInterestRate() / 12.0);
    }

    // changes interest rate
    public static void modifyInterestRate(double interestRate)
    {
        setAnnualInterestRate(interestRate);
    }
}
