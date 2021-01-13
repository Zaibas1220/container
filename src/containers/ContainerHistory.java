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
        for (double value : history) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    public double minValue() {
        double minValue = 0;
        for (double value : history) {
            if (value > minValue) {
                minValue = value;
            }
        }
        return minValue;
    }

    public double average() {
        double average = 0;
        for (double value : history) {
            average += value;
        }
        return average / history.size();
    }

    public double greatesFluctuation() {
        double greatestFluctuation = 0;
        for (int i = 0; i < history.size() - 1; i++){
            double fluctuation = Math.abs(history.get(i) - history.get(i+1));
            if (fluctuation > greatestFluctuation){
                greatestFluctuation = fluctuation;
            }
        }
        return greatestFluctuation;
    }

    public double variance() {
        double variance = 0;
        if (history.size() > 1) {
            for (double num : history) {
                variance += Math.pow((num - average()), 2);
            }
            variance /= history.size() - 1;
        }
        return variance;
    }
}
