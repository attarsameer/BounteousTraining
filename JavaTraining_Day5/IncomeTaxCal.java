package JavaTraining_Day5;
import java.util.*;
public class IncomeTaxCal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("INCOME TAX ESTIMATOR");
        System.out.print("Enter your gross annual salary (in Rs.): ");
        double annualIncome = sc.nextDouble();

        System.out.print("Enter your current age (in years): ");
        int userAge = sc.nextInt();

        System.out.print("Total investment under investment (in Rs.): ");
        double investment80C = sc.nextDouble();

        System.out.print("Health insurance premium paid (in Rs.): ");
        double healthPremium = sc.nextDouble();

        System.out.print("Interest paid on home loan (in Rs.): ");
        double loanInterest = sc.nextDouble();

        double allowed80C = Math.min(investment80C, 150000);
        double healthLimit = (userAge >= 60) ? 50000 : 25000;
        double allowed80D = Math.min(healthPremium, healthLimit);
        double allowed24B = Math.min(loanInterest, 200000);

        double totalExemptions = allowed80C + allowed80D + allowed24B;
        double netTaxable = annualIncome - totalExemptions;
        if (netTaxable < 0) netTaxable = 0;

        double taxPayable = computeIncomeTax(netTaxable, userAge);

        // Output
        System.out.println("\nTAX SUMMARY");
        System.out.printf("Total Deductions Allowed: Rs. %.2f%n", totalExemptions);
        System.out.printf("Taxable Income: Rs. %.2f%n", netTaxable);
        System.out.printf("Total Tax Payable: Rs. %.2f%n", taxPayable);

        sc.close();
    }

    private static double computeIncomeTax(double income, int age) {
        double totalTax = 0;

        if (age < 60) {
            if (income <= 250000) {
                totalTax = 0;
            } else if (income <= 500000) {
                totalTax = (income - 250000) * 0.05;
            } else if (income <= 1000000) {
                totalTax = 250000 * 0.05 + (income - 500000) * 0.20;
            } else {
                totalTax = 250000 * 0.05 + 500000 * 0.20 + (income - 1000000) * 0.30;
            }
        } else if (age <= 80) {
            if (income <= 300000) {
                totalTax = 0;
            } else if (income <= 500000) {
                totalTax = (income - 300000) * 0.05;
            } else if (income <= 1000000) {
                totalTax = 200000 * 0.05 + (income - 500000) * 0.20;
            } else {
                totalTax = 200000 * 0.05 + 500000 * 0.20 + (income - 1000000) * 0.30;
            }
        } else { // For citizens over 80
            if (income <= 500000) {
                totalTax = 0;
            } else if (income <= 1000000) {
                totalTax = (income - 500000) * 0.20;
            } else {
                totalTax = 500000 * 0.20 + (income - 1000000) * 0.30;
            }
        }

        return totalTax;
    }
}
