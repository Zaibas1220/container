package containers;

import java.util.ArrayList;

public class ContainerHistory {
    private ArrayList<Double> history;

    public ContainerHistory() {
        history = new ArrayList<>();
    }

    public void add(double situation) {
        history.add(situation);
    }

    public void reset() {
        history.clear();
    }

    public String toString() {
        return history.toString();
    }

    public double maxValue() {
        double maxValue = 0;

        if (!history.isEmpty()) {
            for (double value : history) {
                if (value > maxValue) {
                    maxValue = value;
                }
            }
        }

        return maxValue;
    }

    public double minValue() {
        double minValue = 0;

        if (!history.isEmpty()) {
            for (double value : history) {
                if (value > minValue) {
                    minValue = value;
                }
            }
        }

        return minValue;
    }

    public double average() {
        double average = 0;

        if (!history.isEmpty()) {
            for (double value : history) {
                average += value;
            }
        }

        return average /= history.size();
    }

    public double greatesFluctuation() {
        if (!history.isEmpty()) {
            if (Math.abs(maxValue()) >= Math.abs(minValue())) {
                return maxValue();
            } else {
                return minValue();
            }
        }
        return 0;
    }
}
