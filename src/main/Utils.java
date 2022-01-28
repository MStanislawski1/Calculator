package main;

import javafx.scene.control.Button;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Utils {

    static Controller classWithValue = new Controller();
    public static String numberAndOperation;

    private static String OPERATORS_REGEX = "[-+*/]";
    private static String NUMBERS_REGEX = "\\d+(\\.\\d+)?";

    public static boolean isOperator(String character) {
        return Pattern.matches(OPERATORS_REGEX, character);
    }

    public static boolean isNumber(String character) {
        return Pattern.matches(NUMBERS_REGEX, character);
    }

    public static void changeClickable(boolean clickable, Button... button) {
        for (Button b : button) {
            b.setDisable(!clickable);
        }
    }

    public static boolean operatorBeforeZero(String result) {
        if (result.length() > 0) {
            String stringBeforeZero = result.substring(result.length() - 1);
            return result.endsWith("0") && !isOperator(stringBeforeZero) && !isDouble(result);
        } else return false;
    }

    public static boolean replaceOperator(String result) {
        return result.length() >= 1 && isOperator(result.substring(result.length() - 1));
    }

    public static Pair<List<Double>, List<String>> getNumbersForCalculations(String calculations) {

        numberAndOperation = classWithValue.getValueOfResult();//przypisanie wartości ze zmiennej result
        List summaryValue = new ArrayList();//lista na wszystko


        if (numberAndOperation.contains("+")) {
            System.out.println("zawiera+");
        } else if (numberAndOperation.contains("-")) {
            System.out.println("zawiera-");
        } else if (numberAndOperation.contains("*")) {
            System.out.println("zawiera*");
        } else if (numberAndOperation.contains("/")) {
            System.out.println("zawiera/");
        }

        /* TODO
            Przykładowa funkcja, operacje są typu String, ale możesz utworzyć Enum
            Wydzielić cyfry i znaki specjalnie możesz np przy pomocy funkcji split() z klasy String
            Uważaj tylko na pierwszy znak bo jeżeli to będzie minus to trzeba go dopisać do pierwszej cyfry, a nie do listy z operacjami
        */

        List<Double> numbers = new ArrayList<>();
        List<String> operations = new ArrayList<>();

        return new Pair<>(numbers, operations);
    }

    /*
    public static Pair<List<Double>, List<String>> getNumbersForCalculations(String calculations) {

        // usunięty znak =
        String positiveCalculations = calculations.substring(0, calculations.length()-1);
        List<Double> numbers = new ArrayList<>();
        List<String> numbersAndOperators = Arrays.asList(positiveCalculations.split(OPERATORS_REGEX));

        for (String numbersAndOperator : numbersAndOperators)
            if (isNumber(numbersAndOperator))
                numbers.add(Double.parseDouble(numbersAndOperator));

        // tutaj dopisujemy minus do pierwszej cyfry, ale nie ma jeszcze możliwości dopisania minusa do cyfry w środku wyrażenia, np jak by było 3*-5
        // trzeba to jakoś dopisać
        if(numbersAndOperators.size()>0 && calculations.startsWith("-")) {
            numbers.set(0, numbers.get(0) * -1);
            // usunięty pierwszy minus
            positiveCalculations = positiveCalculations.substring(1);
        }

        List<String> operators = Arrays.asList(positiveCalculations.split(NUMBERS_REGEX));

        return new Pair<>(numbers,operators);
    }
    */

    //to umożliwia wpisanie zera po kropce, np 0.0003, inaczej zostałoby 0.3
    private static boolean isDouble(String result) {
        boolean isDouble = false;
        if (result.endsWith("0")) {
            for (int i = result.length() - 2; i >= 0; ) {
                if (result.charAt(i) == '0') i--;
                else {
                    if (result.charAt(i) == '.')
                        isDouble = true;
                    break;
                }
            }
        }
        return isDouble;
    }

}
