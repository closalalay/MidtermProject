import java.util.Scanner;
import java.io.*;

public class PT5BLosala {

    static Scanner input = new Scanner(System.in);

    static String holiday;
    static double budget;

    static double totalSpent = 0;

    static double foodTotal = 0;
    static double billsTotal = 0;
    static double accessoriesTotal = 0;
    static double savingsTotal = 0;

    static String[][] products;
    static int size;

    public static void main(String[] args) {

        System.out.println(
        "HOLIDAY SHOPPING BUDGET PLANNER SYSTEM");

        holiday = chooseHoliday();

        int choice;

        do {

            System.out.println("\n1. Add Products");
            System.out.println("2. View Saved Records");
            System.out.println("3. View Budget Feedback");
            System.out.println("4. Exit");

            System.out.print("Choice: ");
            choice = getInt();

            switch(choice) {

                case 1:
                    addProducts();
                    break;

                case 2:
                    viewRecords();
                    break;

                case 3:
                    showFeedback();
                    break;

                case 4:
                    System.out.println("Program Ended.");
                    break;

                default:
                    System.out.println(
                    "Invalid choice.");
            }

        } while(choice != 4);
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

        switch(choice) {

            case 1:
                return "Christmas";

            case 2:
                return "New Year";

            case 3:
                return "Valentine's Day";

            case 4:
                return "Halloween";

            case 5:

                System.out.print(
                "Holiday Name: ");

                return input.nextLine();

            default:
                return "Unknown";
        }
    }

    public static String chooseCategory() {

        System.out.println("\n1. Food");
        System.out.println("2. Bills");
        System.out.println("3. Accessories");
        System.out.println("4. Savings");

        System.out.print("Category: ");

        int choice = getInt();

        switch(choice) {

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

            System.out.print(
            "\nEnter Budget: ");

            budget =
            input.nextDouble();

            System.out.print(
            "How many products: ");

            size =
            input.nextInt();

            input.nextLine();

            products =
            new String[size][5];

            totalSpent = 0;

            foodTotal = 0;
            billsTotal = 0;
            accessoriesTotal = 0;
            savingsTotal = 0;

            for(int i = 0;
                i < size;
                i++) {

                System.out.println(
                "\nProduct " +
                (i + 1));

                products[i][0] =
                chooseCategory();

                input.nextLine();

                System.out.print(
                "Product Name: ");

                products[i][1] =
                input.nextLine();

                System.out.print(
                "Price: ");

                double price =
                input.nextDouble();

                System.out.print(
                "Quantity: ");

                int qty =
                input.nextInt();

                input.nextLine();

                double total =
                price * qty;

                products[i][2] =
                String.valueOf(price);

                products[i][3] =
                String.valueOf(qty);

                products[i][4] =
                String.valueOf(total);

                totalSpent += total;

                if(products[i][0]
                .equals("Food")) {

                    foodTotal += total;

                }

                else if(products[i][0]
                .equals("Bills")) {

                    billsTotal += total;

                }

                else if(products[i][0]
                .equals("Accessories")) {

                    accessoriesTotal += total;

                }

                else if(products[i][0]
                .equals("Savings")) {

                    savingsTotal += total;
                }
            }

            displayReceipt();

            saveFile();

        }

        catch(Exception e) {

            System.out.println(
            "Invalid Input.");

            input.nextLine();
        }
    }

    public static void displayReceipt() {

        String[] order =
        {"Food",
         "Bills",
         "Accessories",
         "Savings"};

        System.out.println(
        "\n+----------------------------------------------------------+");

        System.out.printf(
        "| Holiday: %-47s |\n",
        holiday);

        System.out.println(
        "+----------------------------------------------------------+");

        System.out.printf(
        "| %-12s %-12s %-8s %-6s %-8s |\n",
        "Category",
        "Product",
        "Price",
        "Qty",
        "Total");

        System.out.println(
        "+----------------------------------------------------------+");

        for(int c = 0;
            c < order.length;
            c++) {

            for(int i = 0;
                i < size;
                i++) {

                if(products[i][0]
                .equals(order[c])) {

                    for(int j = 0;
                        j < products[i].length;
                        j++) {

                        System.out.printf(
                        "%-13s",
                        products[i][j]);
                    }

                    System.out.println();
                }
            }
        }

        System.out.println(
        "+----------------------------------------------------------+");

        System.out.println(
        "Total Spent: " +
        totalSpent);

        System.out.println(
        "Remaining Budget: " +
        (budget - totalSpent));
    }

    public static void showFeedback() {

        if(budget == 0) {

            System.out.println(
            "No data yet.");

            return;
        }

        double percent =
        (totalSpent /
        budget) * 100;

        System.out.println(
        "\nBUDGET FEEDBACK");

        System.out.printf(
        "Spent: %.2f%%\n",
        percent);

        System.out.println(
        "Recommended: 30%");

        if(percent == 100) {

            System.out.println(
            "No more budget left.");

        }

        else if(percent > 100) {

            System.out.println(
            "Budget Exceeded!");

        }

        else if(percent > 70) {

            System.out.println(
            "You are close to exceeding your budget.");

        }

        else if(percent > 30) {

            System.out.println(
            "Careful, exceeded recommended spending.");

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
            "\nHoliday: " +
            holiday);

            for(int i = 0;
                i < size;
                i++) {

                for(int j = 0;
                    j < products[i].length;
                    j++) {

                    write.print(
                    products[i][j]
                    + "\t");
                }

                write.println();
            }

            write.println(
            "Total: " +
            totalSpent);

            write.close();
        }

        catch(IOException e) {

            System.out.println(
            "File Error.");
        }
    }

    public static void viewRecords() {

        try {

            BufferedReader read =
            new BufferedReader(
            new FileReader(
            "holiday_records.txt"));

            String line;

            while((line =
            read.readLine())
            != null) {

                System.out.println(
                line);
            }

            read.close();
        }

        catch(IOException e) {

            System.out.println(
            "No records.");
        }
    }

    public static int getInt() {

        int num = 0;

        try {

            num =
            input.nextInt();

        }

        catch(Exception e) {

            input.nextLine();
        }

        return num;
    }
}