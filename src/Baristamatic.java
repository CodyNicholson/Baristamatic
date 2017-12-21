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

        for(int i = 0; i < data.getIngredientsAvailable().length; i++)
        {
            System.out.println(data.getIngredientsAvailable()[i].getName()
                    +","
                    + data.getIngredientsAvailable()[i].getQuantity());
            System.out.println();
        }

        System.out.println("Menu:\n");

        for(int i = 0; i < data.getDrinks().length; i++)
        {
            System.out.println(data.getDrinks()[i].getNumber()+
                    ","+
                    data.getDrinks()[i].getName()+
                    ",$"+
                    df.format(data.getDrinks()[i].getCost())+
                    ","+
                    canMake(data.getDrinks()[i].getNumber()));
            System.out.println();
        }
    }

    // This is a nightmare for efficiency but I ran out of time
    // "Premature optimization is the root of all evils" ~ Don Knuth
    private boolean canMake(int number)
    {
        Drink drink = null;
        for (int i = 0; i < data.getDrinks().length; i++)
        {
            if (number == data.getDrinks()[i].getNumber())
            {
                drink = data.getDrinks()[i];
            }
        }

        for (int i = 0; i < drink.getIngredientsNeeded().length; i++)
        {
            for (int j = 0; j < data.getIngredientsAvailable().length; j++)
            {
                if (drink.getIngredientsNeeded()[i].getName().equals(data.getIngredientsAvailable()[j].getName()))
                {
                    if (data.getIngredientsAvailable()[j].getQuantity() <= drink.getIngredientsNeeded()[i].getQuantity())
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
        for (int i = 0; i< data.getIngredientsAvailable().length; i++)
        {
            data.getIngredientsAvailable()[i].setQuantity(10);
        }
    }

    // This could be more efficient
    // "Premature optimization is the root of all evils" ~ Don Knuth
    private void orderDrink(int number)
    {
        Drink drink = null;
        for (int i = 0; i < data.getDrinks().length; i++)
        {
            if (number == data.getDrinks()[i].getNumber())
            {
                drink = data.getDrinks()[i];
            }
        }

        if (drink == null)
        {
            System.out.println("\nInvalid drink entered\n");
            return;
        }

        if (!canMake(drink.getNumber()))
        {
            System.out.println("\nWe do not have enough ingredients to make this drink\n");
            return;
        }

        for (int i = 0; i < drink.getIngredientsNeeded().length; i++)
        {
            for (int j = 0; j < data.getIngredientsAvailable().length; j++)
            {
                if (drink.getIngredientsNeeded()[i].getName().equals(data.getIngredientsAvailable()[j].getName()))
                {
                    data.getIngredientsAvailable()[j].setQuantity(data.getIngredientsAvailable()[j].getQuantity() - drink.getIngredientsNeeded()[i].getQuantity());
                }
            }
        }
        System.out.println("\nThank you for purchasing a " + drink.name + " for $" + df.format(drink.cost) + "\n");
    }

    void enterCommand()
    {
        displayInventoryAndMenu();

        System.out.println("\nOrder a drink by entering the drink's number below:");

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
