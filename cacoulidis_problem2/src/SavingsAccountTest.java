public class SavingsAccountTest
{
    public static void main(String[] args)
    {
        // instantiate new instances of SavingsAccount saver1 & saver2
        SavingsAccount saver1 = new SavingsAccount(2000.00);
        SavingsAccount saver2 = new SavingsAccount(3000.00);

        // set interest rate to 4%
        SavingsAccount.setAnnualInterestRate(0.04);

        System.out.printf("%n%nMonthly Balance Report%n");
        System.out.printf("-------------------------------------------------------------%n");
        System.out.printf("Month |\tSavings 1 Balance |\tSavings 2 Balance |\tInterest Rate %n");

        // print out bank account balances update with interest earning for 12 months
        for (int i = 0; i < 12; i++)
        {
            System.out.printf("%d\t\t\t", i+1);

            // calculate interest added and update account values
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();

            // print results to user
            System.out.printf("$%.2f\t\t\t", saver1.getSavingsBalance());
            System.out.printf("$%.2f", saver2.getSavingsBalance());
            System.out.printf("\t\t\t%%%.1f%n", 100 * SavingsAccount.getAnnualInterestRate());
        }

        // set interest rate to 5%
        SavingsAccount.setAnnualInterestRate(0.05);

        // formatting
        System.out.printf("%n%nMonthly Balance Report%n");
        System.out.printf("-------------------------------------------------------------%n");
        System.out.printf("Month |\tSavings 1 Balance |\tSavings 2 Balance |\tInterest Rate %n");

        // print 1 bcas it is the first month w/ the 5% interest rate being added
        System.out.print("1\t\t\t");

        //add revenue from higher interest rate and print out results
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        System.out.printf("$%.2f\t\t\t", saver1.getSavingsBalance());
        System.out.printf("$%.2f\t\t\t", saver2.getSavingsBalance());
        System.out.printf("%%%.1f%n", 100 * SavingsAccount.getAnnualInterestRate());
    }
}
