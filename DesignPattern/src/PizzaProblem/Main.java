package PizzaProblem;

// Abstract Product Interface
interface Topping {
    String getTitle();
}

// Concrete Product Classes
class Mozzarella implements Topping {
    public String getTitle() {
        return "Mozzarella";
    }
}

class Salami implements Topping {
    public String getTitle() {
        return "Salami";
    }
}

// Abstract Factory Interface
interface ToppingMaker {
    Topping makeTopping();
}

// Concrete Factory Classes
class MozzarellaFactory implements ToppingMaker {
    public Topping makeTopping() {
        return new Mozzarella();
    }
}

class SalamiFactory implements ToppingMaker {
    public Topping makeTopping() {
        return new Salami();
    }
}

// Main class to demonstrate pizza creation
public class Main {
    public static void main(String[] args) {
        // Create pizza with mozzarella topping
        ToppingMaker mozzarellaFactory = new MozzarellaFactory();
        Pizza mozzarellaPizza = new Pizza(mozzarellaFactory);
        mozzarellaPizza.addTopping();

        // Create pizza with salami topping
        ToppingMaker salamiFactory = new SalamiFactory();
        Pizza salamiPizza = new Pizza(salamiFactory);
        salamiPizza.addTopping();
    }
}
