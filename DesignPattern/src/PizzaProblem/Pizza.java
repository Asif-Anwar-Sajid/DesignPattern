package PizzaProblem;

// Main class for creating a pizza with various toppings
public class Pizza {
    private ToppingMaker toppingMaker;

    public Pizza(ToppingMaker toppingMaker) {
        this.toppingMaker = toppingMaker;
    }

    public void addTopping() {
        Topping topping = toppingMaker.makeTopping();
        System.out.println("Added " + topping.getTitle() + " topping.");
    }
}
