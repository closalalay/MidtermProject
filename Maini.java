import java.util.Scanner;

public class Maini {

    // compute total spent
    public static double getTotalSpent(double[] totals) {
        double sum = 0;
        for (int i = 0; i < totals.length; i++) {
            sum += totals[i];
        }
        return sum;
    }

    // find highest expense
    public static double getHighest(double[] totals) {
        double highest = totals[0];
        for (int i = 1; i < totals.length; i++) {
            if (totals[i] > highest) {
                highest = totals[i];
            }
        }
        return highest;
    }

    // display summary with grand total
    public static void displaySummary(String[] names, double[] prices, int[] quantities, double[] totals) {
        double grandTotal = 0;

        System.out.println("\n====== PURCHASE SUMMARY =====");
        System.out.println("Name\tPrice\tQty\tTotal");

        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + "\t" + prices[i] + "\t" + quantities[i] + "\t" + totals[i]);
            grandTotal += totals[i];
        }
        System.out.println("___________________________");
        System.out.println("GRAND TOTAL: " + grandTotal);
        System.out.println("___________________________");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your budget: ");
        double budget = input.nextDouble();

        System.out.print("How many products will you buy? ");
        int productQuantity = input.nextInt();

        String[] names = new String[productQuantity];
        double[] prices = new double[productQuantity];
        int[] quantities = new int[productQuantity];
        double[] totals = new double[productQuantity];

        input.nextLine();

        for (int i = 0; i < productQuantity; i++) {
            System.out.println("\n");
            System.out.print("Enter product name: ");
            names[i] = input.nextLine();

            System.out.print("Enter product price: ");
            prices[i] = input.nextDouble();

            System.out.print("Enter quantity: ");
            quantities[i] = input.nextInt();

            totals[i] = prices[i] * quantities[i];

            input.nextLine();
        }

        // compute totals and stats
        double totalSpent = getTotalSpent(totals);
        double remaining = budget - totalSpent;
        double percent = (totalSpent / budget) * 100;
        double highest = getHighest(totals);

        displaySummary(names, prices, quantities, totals);

        System.out.println("\nTotal Spent: " + totalSpent);
        System.out.println("Remaining Budget: " + remaining);
        System.out.println("Budget Spent percent: " + percent + "%");
        System.out.println("Highest Expense: " + highest);

        // displaying feedback
        double recommended = 30;
        System.out.println("\n====== RECOMMENDED BUDGET: 30% ======\n");

        if (percent > 100) {
            System.out.println("Budget Exceeded! You spent more than your budget!");
        } else if (percent > 70) {
            System.out.println("You are close to exceeding your budget!");
        } else if (percent > recommended) {
            System.out.println("Careful, you exceed the recommended spending limit!");
        } else {
            System.out.println("Within recommended spending limit.");
        }

        input.close();
    }
}
