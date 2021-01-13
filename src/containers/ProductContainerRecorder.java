package containers;

public class ProductContainerRecorder extends ProductContainer {
    private ContainerHistory containerHistory;

    public ProductContainerRecorder(String name, double capacity, double initialVolume) {
        super(name, capacity);
        containerHistory = new ContainerHistory();
        addToTheContainer(initialVolume);
    }

    public String history() {
        return containerHistory.toString();
    }

    @Override
    public void addToTheContainer(double amount) {
        super.addToTheContainer(amount);
        containerHistory.add(super.getVolume());
    }

    @Override
    public double takeFromTheContainer(double amount) {
        double taken = super.takeFromTheContainer(amount);
        containerHistory.add(super.getVolume());
        return taken;
    }

    public void printAnalysis() {
        System.out.println("Product: " + super.getName());
        System.out.println("History" + history());
        System.out.println("Greatest product amount: " + containerHistory.maxValue());
        System.out.println("Smallest product amount: " + containerHistory.minValue());
        System.out.println("Average: " + containerHistory.average());
        System.out.println("Greatest change: " + containerHistory.greatesFluctuation());
        System.out.println("Variance: " + containerHistory.variance());
    }
}
