/**
 * Created by Cody on 9/17/2017.
 */
public class Data
{
    // **** Create Drinks **** //
    IngredientNeeded coffee3  = new IngredientNeeded("Coffee", 0.75, 3);
    IngredientNeeded sugar1   = new IngredientNeeded("Sugar", 0.25, 1);
    IngredientNeeded cream1   = new IngredientNeeded("Creme", 0.25, 1);
    IngredientNeeded[] coffeeIngredientsNeeded = {coffee3, sugar1, cream1};
    Drink coffeed = new Drink(5,"Coffee", coffeeIngredientsNeeded);

    IngredientNeeded decafCoffee3 = new IngredientNeeded("Decaf Coffee", 0.75, 3);
    IngredientNeeded[] decafCoffeeIngredientsNeeded = {decafCoffee3, sugar1, cream1};
    Drink decafCoffeed = new Drink(6,"Decaf Coffee", decafCoffeeIngredientsNeeded);

    IngredientNeeded expresso2    = new IngredientNeeded("Expresso", 1.10, 2);
    IngredientNeeded steamedMilk1 = new IngredientNeeded("Steamed Milk", 0.35, 1);
    IngredientNeeded[] caffeLatteIngredientsNeeded = {expresso2, steamedMilk1};
    Drink caffeLatted = new Drink(2,"Caffe Latte", caffeLatteIngredientsNeeded);

    IngredientNeeded expresso3 = new IngredientNeeded("Expresso", 1.10, 3);
    Drink caffeAmericanod = new Drink(1, "Caffe Americano", expresso3);

    IngredientNeeded expresso1 = new IngredientNeeded("Expresso", 1.10, 1);
    IngredientNeeded cocoa1 = new IngredientNeeded("Cocoa", 0.90, 1);
    IngredientNeeded whippedCream1 = new IngredientNeeded("Whipped Cream", 1.00, 1);
    IngredientNeeded[] caffeMochaIngredientsNeeded = {expresso1, cocoa1, steamedMilk1, whippedCream1};
    Drink caffeMochad = new Drink(3,"Caffe Mocha", caffeMochaIngredientsNeeded);

    IngredientNeeded foamedMilk1 = new IngredientNeeded("Foamed Milk", 0.35, 1);
    IngredientNeeded[] cappuccinoIngredientsNeeded = {expresso2, steamedMilk1, foamedMilk1};
    Drink cappuccinod = new Drink(4,"Cappuccino", cappuccinoIngredientsNeeded);

    Drink[] drinks = {caffeAmericanod, caffeLatted, caffeMochad, cappuccinod, coffeed, decafCoffeed};

    // **** IngredientNeeded Inventory Items **** //
    IngredientListItem coffeei       = new IngredientListItem("Coffee");
    IngredientListItem decafCoffeei  = new IngredientListItem("Decaf Coffee");
    IngredientListItem sugari        = new IngredientListItem("Sugar");
    IngredientListItem creami        = new IngredientListItem("Cream");
    IngredientListItem steamedMilki  = new IngredientListItem("Steamed Milk");
    IngredientListItem foamedMilki   = new IngredientListItem("Foamed Milk");
    IngredientListItem expressoi     = new IngredientListItem("Expresso");
    IngredientListItem cocoai        = new IngredientListItem("Cocoa");
    IngredientListItem whippedCreami = new IngredientListItem("Whipped Cream");
    IngredientListItem[] ingredientsAvailable = {coffeei, decafCoffeei, sugari, creami, steamedMilki, foamedMilki, expressoi, cocoai, whippedCreami};
}
