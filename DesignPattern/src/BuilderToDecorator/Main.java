package BuilderToDecorator;

// Interface for computer component
interface Component {
    String details();
    double price();
}

// Concrete component - Basic computer
class BasicComputer implements Component {
    private String storage;
    private String memory;
    private double basePrice;

    public BasicComputer(String storage, String memory, double basePrice) {
        this.storage = storage;
        this.memory = memory;
        this.basePrice = basePrice;
    }

    @Override
    public String details() {
        return "Storage: " + storage + ", Memory: " + memory;
    }

    @Override
    public double price() {
        return basePrice;
    }
}

// Abstract Decorator - BuilderToDecorator.ComponentDecorator
abstract class ComponentDecorator implements Component {
    protected Component decoratedComponent;

    public ComponentDecorator(Component decoratedComponent) {
        this.decoratedComponent = decoratedComponent;
    }

    public String details() {
        return decoratedComponent.details();
    }

    public double price() {
        return decoratedComponent.price();
    }
}

// Decorator - BuilderToDecorator.AddGraphicsCard
class AddGraphicsCard extends ComponentDecorator {
    private double graphicsCardPrice;

    public AddGraphicsCard(Component decoratedComponent, double graphicsCardPrice) {
        super(decoratedComponent);
        this.graphicsCardPrice = graphicsCardPrice;
    }

    @Override
    public String details() {
        return super.details() + ", with Graphics Card";
    }

    @Override
    public double price() {
        return super.price() + graphicsCardPrice;
    }
}

// Decorator - BuilderToDecorator.AddBluetooth
class AddBluetooth extends ComponentDecorator {
    private double bluetoothPrice;

    public AddBluetooth(Component decoratedComponent, double bluetoothPrice) {
        super(decoratedComponent);
        this.bluetoothPrice = bluetoothPrice;
    }

    @Override
    public String details() {
        return super.details() + ", with Bluetooth";
    }

    @Override
    public double price() {
        return super.price() + bluetoothPrice;
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating a basic computer
        Component basicComputer = new BasicComputer("1 TB", "8 GB", 600);

        // Adding features using decorators
        Component computerWithGraphics = new AddGraphicsCard(basicComputer, 150);
        Component fullyLoadedComputer = new AddBluetooth(computerWithGraphics, 75);

        // Output details and cost
        System.out.println("Computer Details: " + fullyLoadedComputer.details());
        System.out.println("Total Cost: $" + fullyLoadedComputer.price());
    }
}
