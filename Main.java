import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        boolean flag = true;
        ArrayList<String> groceries = new ArrayList<>();

        while (flag) {
            printActions();
            // enhanced switch statement
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1 -> addItem(groceries);
                case 2 -> removeItem(groceries);
                default -> flag = false;
            }
            groceries.sort(Comparator.naturalOrder());
            System.out.println(groceries);
        }

    }
    public static void addItem(ArrayList<String> groceries) {
        System.out.println("Add item(s) [separate items by comma]:");
        String[] items = scanner.nextLine().split(",");

        for (String item : items) {
            //remove trailing spaces
            String trimmedItem = item.trim();
            //check if the item is already in the list
            if (!groceries.contains(trimmedItem)) {
                groceries.add(trimmedItem);
            }
        }

    }

    public static void removeItem(ArrayList<String> groceries) {
        System.out.println("Remove item(s) [separate items by comma]:");
        String[] items = scanner.nextLine().split(",");

        for (String item : items) {
            //remove trailing spaces
            String trimmedItem = item.trim();
            groceries.remove(trimmedItem);
        }

    }



    public static void printActions(){
        String textBlock = """
                Available actions:
                
                0 - to shutdown
                
                1 - to add item(s) to list (comma delimited list)
                
                2 - to remove any items (comma delimited list)
                
                Enter a number for which action you want to do:""";
        System.out.print(textBlock + " ");
    }

}