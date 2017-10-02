import java.text.*;
import java.util.Scanner;

/**
 * Created by Cody on 9/17/2017.
 */
public class Baristamatic
{
    private static Data data = new Data();
    private DecimalFormat df = new DecimalFormat("#0.00");

    private void displayInventoryAndMenu()
    {
        System.out.println("Inventory:\n");

        for(int i = 0; i < data.ingredientsAvailable.length; i++)
        {
            System.out.println(data.ingredientsAvailable[i].name
                    +","
                    + data.ingredientsAvailable[i].quantity);
            System.out.println();
        }

        System.out.println("Menu:\n");

        for(int i = 0; i < data.drinks.length; i++)
        {
            System.out.println(data.drinks[i].number+
                    ","+
                    data.drinks[i].name+
                    ",$"+
                    df.format(data.drinks[i].cost)+
                    ","+
                    canMake(data.drinks[i].number));
            System.out.println();
        }
    }

    // This is a nightmare for efficiency but I ran out of time
    // "Premature optimization is the root of all evils" ~ Don Knuth
    private boolean canMake(int number)
    {
        Drink drink = null;
        for (int i = 0; i < data.drinks.length; i++)
        {
            if (number == data.drinks[i].number)
            {
                drink = data.drinks[i];
            }
        }

        for (int i = 0; i < drink.ingredientsNeeded.length; i++)
        {
            for (int j = 0; j < data.ingredientsAvailable.length; j++)
            {
                if (drink.ingredientsNeeded[i].name.equals(data.ingredientsAvailable[j].name))
                {
                    if (data.ingredientsAvailable[j].quantity <= drink.ingredientsNeeded[i].quantity)
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private void restock()
    {
        for (int i = 0; i< data.ingredientsAvailable.length; i++)
        {
            data.ingredientsAvailable[i].quantity = 10;
        }
    }

    // This could be more efficient
    // "Premature optimization is the root of all evils" ~ Don Knuth
    private void orderDrink(int number)
    {
        Drink drink = null;
        for (int i = 0; i < data.drinks.length; i++)
        {
            if (number == data.drinks[i].number)
            {
                drink = data.drinks[i];
            }
        }

        if (drink == null)
        {
            System.out.println("\nInvalid drink entered\n");
            return;
        }

        if (!canMake(drink.number))
        {
            System.out.println("\nWe do not have enough ingredients to make this drink\n");
            return;
        }

        for (int i = 0; i < drink.ingredientsNeeded.length; i++)
        {
            for (int j = 0; j < data.ingredientsAvailable.length; j++)
            {
                if (drink.ingredientsNeeded[i].name.equals(data.ingredientsAvailable[j].name))
                {
                    data.ingredientsAvailable[j].quantity -= drink.ingredientsNeeded[i].quantity;
                }
            }
        }
        System.out.println("\nThank you for purchasing a " + drink.name + " for $" + df.format(drink.cost) + "\n");
    }

    void enterCommand()
    {
        displayInventoryAndMenu();

        // Create a scanner so we can read the command-line input
        Scanner scanner = new Scanner(System.in);

        // Get their input as a String
        String command = scanner.next();

        if(command.length() > 1)
        {
            System.out.println("\nInvalid input entered\n");
        }
        else if (command.toLowerCase().equals("q"))
        {
            System.exit(0);
        }
        else if (command.toLowerCase().equals("r"))
        {
            restock();
        }
        else
        {
            try
            {
                orderDrink(Integer.parseInt(command));
            }
            catch (Exception e)
            {
                System.out.println("Invalid input entered");
            }
        }

        enterCommand();
    }
}
