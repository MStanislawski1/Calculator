package main;

import javafx.util.Pair;

import java.util.List;

public class Calculations {

    public Double getResult(Pair<List<Double>, List<String>> operations) {

        int numbersIndexes = 0;
        List<Double> numbers = operations.getKey();
        List<String> operators = operations.getValue();

        for (String operator : operators) {
            if (operator.equals("*")) {
                numbers.set(numbersIndexes, numbers.get(numbersIndexes) * numbers.get(numbersIndexes + 1));
                numbers.remove(numbersIndexes + 1);
                numbersIndexes--;
            } else if (operator.equals("/")) {
                numbers.set(numbersIndexes, numbers.get(numbersIndexes) / numbers.get(numbersIndexes + 1));
                numbers.remove(numbersIndexes + 1);
                numbersIndexes--;
            }

            numbersIndexes++;
        }

        operators.removeIf(s -> s.equals("*") || s.equals("/"));
        numbersIndexes = 0;

        for (String operator : operators) {
            if (operator.equals("+")) {
                numbers.set(numbersIndexes, numbers.get(numbersIndexes) + numbers.get(numbersIndexes + 1));
                numbers.remove(numbersIndexes + 1);
                numbersIndexes--;
            } else if (operator.equals("-")) {
                numbers.set(numbersIndexes, numbers.get(numbersIndexes) - numbers.get(numbersIndexes + 1));
                numbers.remove(numbersIndexes + 1);
                numbersIndexes--;
            }

            numbersIndexes++;
        }

        return numbers.get(0);
    }
}