package test;



import javafx.util.Pair;
import main.Calculations;
import main.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestCalculator {

    static Calculations calculations;
    String positiveTestCalculation;
    String negativeTestCalculation;

    @BeforeAll
    public static void initCalculator() {
        calculations = new Calculations();
    }

    @Test
    public void unsuccessfulDividingByZeroTest() {
        positiveTestCalculation = "10/0";
        negativeTestCalculation = "-10/0";

        Pair<List<Double>, List<String>> positiveCalculations = Utils.getNumbersForCalculations(positiveTestCalculation);
        Pair<List<Double>, List<String>> negativeCalculations = Utils.getNumbersForCalculations(negativeTestCalculation);

        Double positiveCalculationsResult = calculations.getResult(positiveCalculations);
        Double negativeCalculationsResult = calculations.getResult(negativeCalculations);

        Assertions.assertEquals("Infinity", String.valueOf(positiveCalculationsResult));
        Assertions.assertEquals("-Infinity", String.valueOf(negativeCalculationsResult));
    }

    @Test
    public void multiplicationBeforeAddingTest() {
        positiveTestCalculation = "10+2*4";
        negativeTestCalculation = "-10+2*4";

        Pair<List<Double>, List<String>> positiveCalculations = Utils.getNumbersForCalculations(positiveTestCalculation);
        Pair<List<Double>, List<String>> negativeCalculations = Utils.getNumbersForCalculations(negativeTestCalculation);

        Double positiveCalculationsResult = calculations.getResult(positiveCalculations);
        Double negativeCalculationsResult = calculations.getResult(negativeCalculations);

        Assertions.assertEquals(18.0, positiveCalculationsResult);
        Assertions.assertEquals(-2.0, negativeCalculationsResult);
    }

    @Test
    public void multiplicationBeforeSubtractionTest() {
        positiveTestCalculation = "10-2*4";
        negativeTestCalculation = "-10-2*4";

        Pair<List<Double>, List<String>> positiveCalculations = Utils.getNumbersForCalculations(positiveTestCalculation);
        Pair<List<Double>, List<String>> negativeCalculations = Utils.getNumbersForCalculations(negativeTestCalculation);

        Double positiveCalculationsResult = calculations.getResult(positiveCalculations);
        Double negativeCalculationsResult = calculations.getResult(negativeCalculations);

        Assertions.assertEquals(2.0, positiveCalculationsResult);
        Assertions.assertEquals(-18.0, negativeCalculationsResult);
    }

    @Test
    public void divisionBeforeAddingTest() {
        positiveTestCalculation = "10+2/4";
        negativeTestCalculation = "-10+2/4";

        Pair<List<Double>, List<String>> positiveCalculations = Utils.getNumbersForCalculations(positiveTestCalculation);
        Pair<List<Double>, List<String>> negativeCalculations = Utils.getNumbersForCalculations(negativeTestCalculation);

        Double positiveCalculationsResult = calculations.getResult(positiveCalculations);
        Double negativeCalculationsResult = calculations.getResult(negativeCalculations);

        Assertions.assertEquals(10.5, positiveCalculationsResult);
        Assertions.assertEquals(-9.5, negativeCalculationsResult);
    }

    @Test
    public void divisionBeforeSubtractionTest() {
        positiveTestCalculation = "10-2/4";
        negativeTestCalculation = "-10-2/4";

        Pair<List<Double>, List<String>> positiveCalculations = Utils.getNumbersForCalculations(positiveTestCalculation);
        Pair<List<Double>, List<String>> negativeCalculations = Utils.getNumbersForCalculations(negativeTestCalculation);

        Double positiveCalculationsResult = calculations.getResult(positiveCalculations);
        Double negativeCalculationsResult = calculations.getResult(negativeCalculations);

        Assertions.assertEquals(9.5, positiveCalculationsResult);
        Assertions.assertEquals(-10.5, negativeCalculationsResult);
    }
}