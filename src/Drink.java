/**
 * Created by Cody on 9/17/2017.
 */
public class Drink
{
    int number;
    String name;
    double cost;
    IngredientNeeded[] ingredientsNeeded;

    public Drink(int number, String name, IngredientNeeded... ingredientsNeeded)
    {
        this.number = number;
        this.name = name;
        this.ingredientsNeeded = ingredientsNeeded;

        for (int i = 0; i < ingredientsNeeded.length; i++)
        {
            this.cost += ingredientsNeeded[i].cost * ingredientsNeeded[i].quantity;
        }
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public IngredientNeeded[] getIngredientsNeeded() {
        return ingredientsNeeded;
    }

    public void setIngredientsNeeded(IngredientNeeded[] ingredientsNeeded) {
        this.ingredientsNeeded = ingredientsNeeded;
    }
}
