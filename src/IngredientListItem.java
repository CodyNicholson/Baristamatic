/**
 * Created by Cody on 9/17/2017.
 */
public class IngredientListItem
{
    String name;
    int quantity;

    public IngredientListItem(String name)
    {
        this.name = name;
        this.quantity = 10;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
