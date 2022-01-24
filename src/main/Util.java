package main;

import javafx.scene.control.Button;

public class Util {

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
}
