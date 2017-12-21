/**
 * Created by Cody on 9/17/2017.
 */
public class IngredientNeeded
{
    public String name;
    public double cost;
    public int quantity;

    public IngredientNeeded(String name, double cost, int quantity)
    {
        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
