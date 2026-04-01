import java.util.Scanner;

public class Maini {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("HOLIDAY SHOPPING BUDGET PLANNER SYSTEM\n");

        System.out.print("Enter your budget: ");
        double budget = input.nextDouble();
        if (budget <= 0) {
            System.out.println("Budget must be greater than 0.");
            input.close();
            return;
        }

        System.out.print("How many products will you buy? ");
        int productQuantity = input.nextInt();
        if (productQuantity <= 0) {
            System.out.println("Number of products must be at least 1.");
            input.close();
            return;
        }

        String[] names = new String[productQuantity];
        double[] prices = new double[productQuantity];
        int[] quantities = new int[productQuantity];
        double[] totals = new double[productQuantity];

        input.nextLine();

        for (int i = 0; i < productQuantity; i++) {
            System.out.println("\nProduct " + (i + 1));

            System.out.print("Enter product name: ");
            names[i] = input.nextLine();

            System.out.print("Enter product price: ");
            prices[i] = input.nextDouble();
            if (prices[i] < 0) {
                System.out.println("Price cannot be negative.");
                prices[i] = 0;
            }

            System.out.print("Enter quantity: ");
            quantities[i] = input.nextInt();
            if (quantities[i] < 0) {
                System.out.println("Quantity cannot be negative.");
                quantities[i] = 0;
            }

            totals[i] = prices[i] * quantities[i];
            input.nextLine();
        }

        double totalSpent = getTotalSpent(totals);
        double remaining = budget - totalSpent;
        double percent =(totalSpent / budget) * 100;
        double highest = getHighest(totals);

        displaySummary(names, prices, quantities, totals);

        System.out.println("\nTotal Spent: PHP " + totalSpent);
        System.out.println("Remaining Budget: PHP " + remaining);
        System.out.println("Budget Spent Percent: " + percent + "%");
        System.out.println("Highest Expense: PHP " + highest);

        double recommended = 30;
        System.out.println("\nBased on the 50/30/20 rule, 30% of income is typically\nallocated for wants, including holiday spending.\n");
        System.out.print("You spent "+percent+"% of your budget and ");

        if (percent == 100) {
            System.out.println("No more budget left");
        } else if (percent > 100) {
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
        System.out.println("\n====== RECEIPT =====");
        System.out.println("Name\tPrice\tQty\tTotal");

        double grandTotal = 0;
        for (int i = 0; i < names.length; i++) {
            String nameSpacing = (names[i].length() > 7) ? "\t" : "\t";
            System.out.println(names[i] + nameSpacing + prices[i] + "\t" + quantities[i] + "\t" + totals[i]);
            grandTotal += totals[i];
        }

        System.out.println("_______________________________");
        System.out.println("GRAND TOTAL: PHP " + grandTotal);
        System.out.println("_______________________________");
    }
}