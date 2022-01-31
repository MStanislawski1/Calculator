import javafx.scene.control.Button;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Utils {

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

        boolean startWithSecondIndex = false;
        String positiveCalculations = calculations;
        List<Double> numbers = new ArrayList<>();
        List<String> operators = new ArrayList<>();
        List<String> numbersAsStrings = Arrays.asList(positiveCalculations.split(OPERATORS_REGEX));

        for (String number : numbersAsStrings)
            if (isNumber(number))
                numbers.add(Double.parseDouble(number));

        if (numbersAsStrings.size() > 0 && calculations.startsWith("-")) {
            numbers.set(0, numbers.get(0) * -1);
            positiveCalculations = positiveCalculations.substring(1);
        }

        String[] operatorsTable = positiveCalculations.split(NUMBERS_REGEX);

        for (int i = 0; i < operatorsTable.length; i++)
            if (operatorsTable[i] != null && operatorsTable[i].length() > 0) {
                if (operatorsTable[i].length() == 2) {
                    if (startWithSecondIndex) numbers.set(i, numbers.get(i) * -1);
                    else numbers.set(i + 1, numbers.get(i + 1) * -1);
                    operatorsTable[i] = operatorsTable[i].substring(0, 1);
                }
                operators.add(operatorsTable[i]);
            } else startWithSecondIndex = true;

        return new Pair<>(numbers, operators);
    }

    //umożliwia wpisanie zera po kropce np. 0.003
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
