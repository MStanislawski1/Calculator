package main;

import javafx.scene.control.Button;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static boolean isOperator(String character) {
        return character.equals("-") || character.equals("+") || character.equals("*") || character.equals("/");
    }

    public static boolean isNumber(String character) {
        return character.equals("0")
                || character.equals("1")
                || character.equals("2")
                || character.equals("3")
                || character.equals("4")
                || character.equals("5")
                || character.equals("6")
                || character.equals("7")
                || character.equals("8")
                || character.equals("9");
    }

    public static void changeClickable(boolean clickable, Button... button) {
        for (Button b : button) {
            b.setDisable(!clickable);
        }
    }

    public static boolean operatorBeforeZero(String result) {
        return result.length() >= 2 && result.endsWith("0") && !isOperator(result.substring(result.length() - 2));
    }

    public static boolean replaceOperator(String result) {
        return result.length() >= 1 && isOperator(result.substring(result.length() - 1));
    }

    public static Pair<List<Double>, List<String>> getNumbersForCalculations(String calculations) {

        /* TODO
            Przykładowa funkcja, operacje są typu String, ale możesz utworzyć Enum
            Wydzielić cyfry i znaki specjalnie możesz np przy pomocy funkcji split() z klasy String
            Uważaj tylko na pierwszy znak bo jeżeli to będzie minus to trzeba go dopisać do pierwszej cyfry, a nie do listy z operacjami
        */

        List<Double> numbers = new ArrayList<>();
        List<String> operations = new ArrayList<>();

        return new Pair<>(numbers, operations);
    }
}