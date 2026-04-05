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
        double percent = (totalSpent / budget) * 100;
        double highest = getHighest(totals);

        displaySummary(names, prices, quantities, totals);

        System.out.println("\nTotal Spent: PHP " + totalSpent);
        System.out.println("Remaining Budget: PHP " + remaining);
        System.out.printf("Budget Spent Percent: %.2f%%\n", percent);
        System.out.println("Highest Expense: PHP " + highest);

        double recommended = 30;
        System.out.println("\nBased on the 50/30/20 rule, 30% of income is typically\nallocated for wants, including holiday spending.\n");
        System.out.print("You spent " + percent + "% of your budget and ");

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
        System.out.println("Name\t\tPrice\tQty\tTotal");

        double grandTotal = 0;
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + "\t\t" + prices[i] + "\t" + quantities[i] + "\t" + totals[i]);
            grandTotal += totals[i];
        }

        System.out.println("_______________________________");
        System.out.println("GRAND TOTAL: PHP " + grandTotal);
        System.out.println("_______________________________");
    }
}


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Company Profile Card</title>

    <!-- External CSS -->
    <link rel="stylesheet" href="styles.css">

    <!-- Internal CSS -->
    <style>
        article {
            background-color: white;
            border-radius: 8px;
            padding: 15px;
            margin: 20px auto;
            width: 300px;
            box-shadow: 2px 2px 5px gray;
        }
    </style>
</head>
<body>

    <header>
        <h1>My Company</h1>
        <p>Simple and Reliable Services</p>
    </header>

    <main>
        <article>
            <h2>About Us</h2>
            <p>
                Our company provides simple and reliable services to help customers
                solve their daily problems. We focus on quality and customer satisfaction.


body {
    background-color: #dcdcdc;
    font-family: Arial, sans-serif;
    text-align: center;
}

header {
    background-color: black;
    color: white;
    padding: 20px;
}

footer {
    background-color: black;
    color: white;
    padding: 15px;
    margin-top: 20px;
}
    <footer>
        <p>&copy; 2026 My Company</p>

        <!-- Inline CSS -->
        <button style="background-color: blue; color: white; padding: 8px 15px; border: none; border-radius: 5px;">
            Contact Us
        </button>
    </footer>

</body>
</html>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Company Profile Card</title>

    <!-- External CSS -->
    <link rel="stylesheet" href="styles.css">

    <!-- Internal CSS -->
    <style>
        article {
            background-color: white;
            border-radius: 8px;
            padding: 15px;
            margin: 20px auto;
            width: 300px;
            box-shadow: 2px 2px 5px gray;
        }
    </style>
</head>
<body>

    <header>
        <h1>My Company</h1>
        <p>Simple and Reliable Services</p>
    </header>

    <main>
        <article>
            <h2>About Us</h2>
            <p>
                Our company provides simple and reliable services to help customers
                solve their daily problems. We focus on quality and customer satisfaction.
            </p>
        </article>
    </main>

    <footer>
        <p>&copy; 2026 My Company</p>

        <!-- Inline CSS -->
        <button style="background-color: blue; color: white; padding: 8px 15px; border: none; border-radius: 5px;">
            Contact Us
        </button>
    </footer>

</body>
</html>

