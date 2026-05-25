import java.util.Scanner;
import java.io.*;

public class PT5BLosala {

    static Scanner input = new Scanner(System.in);

    static String holiday;
    static double budget = 0;
    static boolean budgetSet = false;

    static String[] names = new String[100];
    static String[] categories = new String[100];
    static double[] prices = new double[100];
    static int[] quantities = new int[100];
    static double[] totals = new double[100];

    static int count = 0;
    static double totalSpent = 0;

    public static void main(String[] args) {

        System.out.println("HOLIDAY SHOPPING BUDGET PLANNER SYSTEM");

        holiday = chooseHoliday();

        int choice;

        do {

            System.out.println("\n1. Add Products");
            System.out.println("2. View Receipt");
            System.out.println("3. View Budget Feedback");
            System.out.println("4. Exit");

            System.out.print("Choice: ");
            choice = getInt();

            switch (choice) {

                case 1:
                    addProducts();
                    break;

                case 2:
                    displayReceipt();
                    break;

                case 3:
                    showFeedback();
                    break;

                case 4:
                    System.out.println("Program Ended.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);
    }

    public static String chooseHoliday() {

        System.out.println("\nHOLIDAY MENU");
        System.out.println("1. Christmas");
        System.out.println("2. New Year");
        System.out.println("3. Valentine's Day");
        System.out.println("4. Halloween");
        System.out.println("5. Other");

        System.out.print("Choose: ");
        int choice = getInt();
        input.nextLine();

        switch (choice) {

            case 1:
                return "Christmas";

            case 2:
                return "New Year";

            case 3:
                return "Valentine's Day";

            case 4:
                return "Halloween";

            case 5:
                System.out.print("Holiday Name: ");
                return input.nextLine();

            default:
                return "Unknown";
        }
    }

    public static String chooseCategory() {

        System.out.println("\nCategory Menu");
        System.out.println("1. Food");
        System.out.println("2. Bills");
        System.out.println("3. Accessories");
        System.out.println("4. Savings");

        System.out.print("Choose Category: ");

        int choice = getInt();

        switch (choice) {

            case 1:
                return "Food";

            case 2:
                return "Bills";

            case 3:
                return "Accessories";

            case 4:
                return "Savings";

            default:
                return "Unknown";
        }
    }

    public static void addProducts() {

        try {

            if (!budgetSet) {

                System.out.print("\nEnter Budget: ");
                budget = input.nextDouble();
                input.nextLine();

                budgetSet = true;
            }

            System.out.print("How many products: ");
            int qty = getInt();
            input.nextLine();

            for (int i = 0; i < qty; i++) {

                System.out.println("\nProduct " + (count + 1));

                categories[count] = chooseCategory();
                input.nextLine();

                System.out.print("Product Name: ");
                names[count] = input.nextLine();

                System.out.print("Price: ");
                prices[count] = input.nextDouble();

                System.out.print("Quantity: ");
                quantities[count] = input.nextInt();
                input.nextLine();

                totals[count] =
                        prices[count] * quantities[count];

                totalSpent += totals[count];

                count++;
            }

            saveFile();

            System.out.println(
            "\nProducts added successfully.");

        }

        catch (Exception e) {

            System.out.println("Invalid input.");
            input.nextLine();
        }
    }

    public static void displayReceipt() {

        if (count == 0) {

            System.out.println(
            "No products yet.");

            return;
        }

        double food = 0;
        double bills = 0;
        double accessories = 0;
        double savings = 0;

        System.out.println(
        "\n========== RECEIPT ==========");

        System.out.println(
        "Holiday: " + holiday);

        System.out.printf(
        "%-15s %-15s %-10s %-8s %-10s%n",
        "Product",
        "Category",
        "Price",
        "Qty",
        "Total");

        for (int i = 0; i < count; i++) {

            System.out.printf(
            "%-15s %-15s %-10.2f %-8d %-10.2f%n",

            names[i],
            categories[i],
            prices[i],
            quantities[i],
            totals[i]);

            if (categories[i].equals("Food")) {

                food += totals[i];

            }

            else if (
            categories[i].equals("Bills")) {

                bills += totals[i];

            }

            else if (
            categories[i].equals("Accessories")) {

                accessories += totals[i];

            }

            else if (
            categories[i].equals("Savings")) {

                savings += totals[i];
            }
        }

        System.out.println(
        "------------------------------------------");

        System.out.printf(
        "Food Total: %.2f%n",
        food);

        System.out.printf(
        "Bills Total: %.2f%n",
        bills);

        System.out.printf(
        "Accessories Total: %.2f%n",
        accessories);

        System.out.printf(
        "Savings Total: %.2f%n",
        savings);

        System.out.println(
        "------------------------------------------");

        System.out.printf(
        "Grand Total: %.2f%n",
        totalSpent);

        System.out.printf(
        "Remaining Budget: %.2f%n",
        (budget - totalSpent));
    }

    public static void showFeedback() {

        if (!budgetSet) {

            System.out.println(
            "No data yet.");

            return;
        }

        double percent =
        (totalSpent / budget) * 100;

        System.out.println(
        "\n====== BUDGET FEEDBACK ======");

        System.out.printf(
        "Budget: %.2f%n",
        budget);

        System.out.printf(
        "Total Spent: %.2f%n",
        totalSpent);

        System.out.printf(
        "Remaining: %.2f%n",
        (budget - totalSpent));

        System.out.printf(
        "Spent Percent: %.2f%%%n",
        percent);

        System.out.println(
        "\nSaved to file: holiday_records.txt");

        if (percent > 100) {

            System.out.println(
            "Budget Exceeded!");

        }

        else if (percent > 70) {

            System.out.println(
            "Close to exceeding budget.");

        }

        else if (percent > 30) {

            System.out.println(
            "Above recommended spending.");

        }

        else {

            System.out.println(
            "Within recommended spending.");
        }
    }

    public static void saveFile() {

        try {

            PrintWriter write =
            new PrintWriter(
            new FileWriter(
            "holiday_records.txt",
            true));

            write.println(
            "\nHoliday: " + holiday);

            for (int i = 0; i < count; i++) {

                write.printf(
                "%s %s %.2f %d %.2f%n",

                names[i],
                categories[i],
                prices[i],
                quantities[i],
                totals[i]);
            }

            write.printf(
            "Total: %.2f%n",
            totalSpent);

            write.close();

        }

        catch (IOException e) {

            System.out.println(
            "File error.");
        }
    }

    public static int getInt() {

        try {

            return input.nextInt();

        }

        catch (Exception e) {

            input.nextLine();
            return 0;
        }
    }
}