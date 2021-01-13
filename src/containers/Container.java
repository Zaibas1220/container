package containers;

public class Container {
    private double capacity;
    private double volume;

    public Container(double capacity) {
        if (capacity <= 0) {
            this.capacity = 0;
        } else {
            this.capacity = capacity;
        }

        this.volume = 0;
    }

    public double getVolume() {
        return this.volume;
    }

    public double getOriginalCapacity() {
        return this.capacity;
    }

    public double getCurrentCapacity() {
        return this.capacity - this.volume;
    }

    public void addToTheContainer(double amount) {
        if (amount < 0){
        } else if((this.volume+amount)>this.capacity){
            this.volume = this.capacity;
        } else {
            this.volume += amount;
        }
    }

    public double takeFromTheContainer(double amount) {
        if (amount < 0){
            return 0;
        } else if (amount > this.volume){
            amount = this.volume;
            this.volume = 0;
            return amount;
        } else {
            this.volume -= amount;
            return amount;
        }
    }

    public String toString() {
        return "volume = " + this.volume + ", free space " + getCurrentCapacity();
    }
}
