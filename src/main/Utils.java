package main;

import javafx.scene.control.Button;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Utils {

    private static String OPERATORS_REGEX = "[-+*/]";
    private static String NUMBERS_REGEX = "\\d*\\.?\\d";

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
        if(result.length() > 0) {
            String stringBeforeZero = result.substring(result.length() - 1);
            return result.endsWith("0") && !isOperator(stringBeforeZero) && !isDouble(result);
        } else return false;
    }

    public static boolean replaceOperator(String result) {
        return result.length() >= 1 && isOperator(result.substring(result.length() - 1));
    }

    public static Pair<List<Double>, List<String>> getNumbersForCalculations(String calculations) {

        // rezultat z wyciętym znakiem równości na końcu
        String positiveCalculations = calculations.substring(0, calculations.length()-1);
        List<Double> numbers = new ArrayList<>();
        List<String> numbersAndOperators = Arrays.asList(positiveCalculations.split(OPERATORS_REGEX));

        for (String numbersAndOperator : numbersAndOperators)
            if (isNumber(numbersAndOperator))
                numbers.add(Double.parseDouble(numbersAndOperator));

        /* TODO
            tutaj przypisujemy minus z pierwszej pozycji do pierwszej cyfry, ale użytkownik może też wpisać minus po znaku
            mnożenia lub dzielenia i jeżeli chcemy to wyświetlać tak jak teraz (bez żadnych nawiasów) to trzeba się
            zastanowić jak przypisać do cyfr minusy ze środka równania i usunąć je z listy operatorów
         */
        if (numbersAndOperators.size() > 0 && calculations.startsWith("-")) {
            numbers.set(0, numbers.get(0) * -1);
            // tutaj usuwamy ten startowy minus
            positiveCalculations = positiveCalculations.substring(1);
        }

        List<String> operators = Arrays.asList(positiveCalculations.split(NUMBERS_REGEX));

        return new Pair<>(numbers, operators);
    }

    // w programie jeżeli po znaku działania pojawia się 0, a później jakaś inna cyfra to to 0 jest nadpisywane
    // tutaj sprawdzamy czy nie mamy doczyniania z zerem po kropce, żeby można było napisać np 0.00003
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
