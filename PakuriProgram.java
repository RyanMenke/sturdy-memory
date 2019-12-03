import java.util.Scanner;


public class PakuriProgram {
    //I chose this way of initializing the menu so that I could account both for values outside of the menu range and non integer values
    private static int initializeMenu(Scanner scanner) {

        System.out.println("\nPakudex Main Menu");
        System.out.println("-----------------");
        System.out.println("1. List Pakuri");
        System.out.println("2. Show Pakuri");
        System.out.println("3. Add Pakuri");
        System.out.println("4. Evolve Pakuri");
        System.out.println("5. Sort Pakuri");
        System.out.println("6. Exit");
        System.out.println("\nWhat would you like to do? ");
        //tries to parse the scanner string into an int, if it can't or it it's outside the range it will print the desired message and re-initialize the menu
        String menuOp = scanner.next();
        try {
            int menu = Integer.parseInt(menuOp);
            if (menu > 0 && menu < 7) {
                return menu;
            }
            else {
                System.out.println("Unrecognized menu selection!");
                return initializeMenu(scanner);
            }
        }
        catch (Exception exception) {
            System.out.println("Unrecognized menu selection!");
            return initializeMenu(scanner);
        }
    }
    //similar concept as the menu, I just wanted to deal with values outside the expected range or format
    private static Pakudex initializePakudex(Scanner scanner) {
        System.out.println("Enter max capacity of the Pakudex: ");
        String pakudeximput = scanner.next();
        try {
            int pakudexLength = Integer.parseInt(pakudeximput);
            if (pakudexLength > 0) {
                System.out.println("The Pakudex can hold " + pakudexLength + " species of Pakuri.");
                return new Pakudex(pakudexLength);
            } else {
                System.out.println("Please enter a valid size.");
                return initializePakudex(scanner);
            }
        }
        catch (Exception exception) {
            System.out.println("Please enter a valid size.");
            return initializePakudex(scanner);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");
        //initializes pakudex
        Pakudex pakudex = initializePakudex(scanner);
        int menu = -1;
        while (menu != 6) {
            //initializes menu
            menu = initializeMenu(scanner);
            if (menu == 1) {
                String[] pakuArray = pakudex.getSpeciesArray();
                //if menu one is chosen and no pakuri are in it yet it will print this
                if (pakuArray == null) {
                    System.out.println("No Pakuri in Pakudex yet!");
                }
                else {
                    //if they are in the pakudex it will pring them in order
                    System.out.print("Pakuri In Pakudex:");
                    System.out.print("\n");
                    for (int i = 0; i < pakuArray.length; i++) {
                        int j = i + 1;
                        if (pakuArray[i] != null) {
                            System.out.println(j + ". " + pakuArray[i]);
                        } else {
                            break;
                        }

                    }
                }
            }
            else if (menu == 2) {
                System.out.println("Enter the name of the species to display: ");
                String species = scanner.next();
                int[] stats = pakudex.getStats(species);
                //stats only returns null if the pakuri doesn't exist, so this is a check for that
                if (stats != null) {
                    System.out.println("Species: " + species);
                    System.out.println("Attack: " + stats[0]);
                    System.out.println("Defense: " + stats[1]);
                    System.out.println("Speed: " + stats[2]);
                    //prints this message if the pakuri is not present in the pakudex
                } else {
                    System.out.println("\nError: No such Pakuri!");
                }
            }
            else if (menu == 3) {
                //adds species to pakudex 1 by 1
                System.out.print("Enter the name of the species to add: ");
                String species = scanner.next();
                if (pakudex.addPakuri(species) == true) {
                    System.out.print("Pakuri species " + species + " successfully added!");
                }
            }
            else if (menu == 4) {
                //evlolves pakuri using the.evolveSpecies method
                System.out.print("Enter the name of the species to evolve: ");
                String species = scanner.next();
                if (pakudex.evolveSpecies(species) == true) {
                    System.out.println(species + " has evolved!");
                }
                else {
                    //prints if it cannot find the pakuri in the dex
                    System.out.println("Error: No such Pakuri!");
                }

            }
            else if (menu == 5) {
                //sorts in lexilogical order
                pakudex.sortPakuri();
                System.out.println("Pakuri have been sorted!");
            }
            else if (menu == 6) {
                //quits
                System.out.println("Thanks for using Pakudex! Bye!");
            }
            else {
                //exactly what the print statement says
                System.out.println("Unrecognized menu selection!");
            }
        }
    }
}
