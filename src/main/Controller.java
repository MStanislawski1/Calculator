package main;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import static main.Util.*;

public class Controller extends Calculations {

    @FXML
    public Button clear;

    @FXML
    public Button separator;

    @FXML
    public Button equals;

    @FXML
    public Button minus;

    @FXML
    public Button newCalculation;

    @FXML
    private TextField calculationScreen;

    @FXML
    private Label resultScreen;

    @FXML
    private Button zero;

    @FXML
    private Button seven;

    @FXML
    private Button eight;

    @FXML
    private Button nine;

    @FXML
    private Button multiplication;

    @FXML
    private Button four;

    @FXML
    private Button five;

    @FXML
    private Button six;

    @FXML
    private Button division;

    @FXML
    private Button one;

    @FXML
    private Button two;

    @FXML
    private Button three;

    @FXML
    private Button plus;

    private String result = "";
    private double finalResult = 0;

    public void zeroButtonClick() {
        if ((result.length() >= 2 && result.endsWith("0") && !isOperator(result.substring(result.length() - 2)))
                || result.length() == 0
                || (!result.isBlank() && isNumber(result.substring(result.length() - 1)))
                || (!result.isBlank() && result.endsWith(","))
                || (!result.isBlank() && isOperator(result.substring(result.length() - 1)))) {
            result = result + "0";
            calculationScreen.setText(result);
        }
    }

    public void sevenButtonClick() {
        if (Util.operatorBeforeZero(result))
            result = result.substring(0, result.length() - 1) + "7";
        else if (result.equals("0"))
            result = "7";
        else result = result + "7";

        calculationScreen.setText(result);
    }

    public void eightButtonClick() {
        if (Util.operatorBeforeZero(result))
            result = result.substring(0, result.length() - 1) + "8";
        else if (result.equals("0"))
            result = "8";
        else result = result + "8";

        calculationScreen.setText(result);
    }

    public void nineButtonClick() {
        if (Util.operatorBeforeZero(result))
            result = result.substring(0, result.length() - 1) + "9";
        else if (result.equals("0"))
            result = "9";
        else result = result + "9";

        calculationScreen.setText(result);
    }

    public void fourButtonClick() {
        if (Util.operatorBeforeZero(result))
            result = result.substring(0, result.length() - 1) + "4";
        else if (result.equals("0"))
            result = "4";
        else result = result + "4";

        calculationScreen.setText(result);
    }

    public void fiveButtonClick() {
        if (Util.operatorBeforeZero(result))
            result = result.substring(0, result.length() - 1) + "5";
        else if (result.equals("0"))
            result = "5";
        else result = result + "5";

        calculationScreen.setText(result);
    }

    public void sixButtonClick() {
        if (Util.operatorBeforeZero(result))
            result = result.substring(0, result.length() - 1) + "6";
        else if (result.equals("0"))
            result = "6";
        else result = result + "6";

        calculationScreen.setText(result);
    }

    public void oneButtonClick() {
        if (Util.operatorBeforeZero(result))
            result = result.substring(0, result.length() - 1) + "1";
        else if (result.equals("0"))
            result = "1";
        else result = result + "1";

        calculationScreen.setText(result);
    }

    public void twoButtonClick() {
        if (Util.operatorBeforeZero(result))
            result = result.substring(0, result.length() - 1) + "2";
        else if (result.equals("0"))
            result = "2";
        else result = result + "2";

        calculationScreen.setText(result);
    }

    public void threeButtonClick() {
        if (Util.operatorBeforeZero(result))
            result = result.substring(0, result.length() - 1) + "3";
        else if (result.equals("0"))
            result = "3";
        else result = result + "3";

        calculationScreen.setText(result);
    }

    public void separatorButtonClick() {
        if (!result.isBlank() && isNumber(result.substring(result.length() - 1))) {
            result = result + ",";
            calculationScreen.setText(result);
        }
    }

    public void multiplicationButtonClick() {
        if (!result.isBlank() && isNumber(result.substring(result.length() - 1)))
            result = result + "*";
        else if (replaceOperator(result) && result.length() > 1)
            result = result.substring(0, result.length() - 1) + "*";
        else
            result = "";

        calculationScreen.setText(result);
    }

    public void divisionButtonClick() {
        if (!result.isBlank() && isNumber(result.substring(result.length() - 1)))
            result = result + "/";
        else if (replaceOperator(result) && result.length() > 1)
            result = result.substring(0, result.length() - 1) + "/";
        else
            result = "";

        calculationScreen.setText(result);
    }

    public void plusButtonClick() {
        if (!result.isBlank() && isNumber(result.substring(result.length() - 1)))
            result = result + "+";
        else if (replaceOperator(result) && result.length() > 1)
            result = result.substring(0, result.length() - 1) + "+";
        else
            result = "";

        calculationScreen.setText(result);
    }

    public void minusButtonClick() {
        if (result.isBlank() || (!result.isBlank() && isNumber(result.substring(result.length() - 1))))
            result = result + "-";
        else if (replaceOperator(result))
            result = result.substring(0, result.length() - 1) + "-";

        calculationScreen.setText(result);
    }

    public void equalsButtonClick() {
        if (!result.isBlank() && isNumber(result.substring(result.length() - 1)))
            result = result + "=";
        else if (replaceOperator(result) && result.length() > 1)
            result = result.substring(0, result.length() - 1) + "=";
        else if (result.equals("-") || result.contains("/0"))
            result = "";

        if (!result.contains("/0")) {
            calculationScreen.setText(result + finalResult);
            resultScreen.setText(String.valueOf(finalResult));
        } else {
            String errorMessage = "Nie można dzielić przez 0!";
            resultScreen.setText(errorMessage);
            result = "";
            calculationScreen.setText(result);
        }

        changeClickable(false, seven, eight, nine, multiplication, four, five, six, division, one, two, three, plus, separator, zero, equals, minus);
    }

    public void clearButtonClick() {

        if (result.length() >= 1) {
            result = result.substring(0, result.length() - 1);
            calculationScreen.setText(result);
        }

        resultScreen.setText("");
        changeClickable(true, seven, eight, nine, multiplication, four, five, six, division, one, two, three, plus, separator, zero, equals, minus);
    }

    public void newButtonClicked() {
        result = "";
        resultScreen.setText("");
        finalResult = 0.0;
        calculationScreen.setText("");
        changeClickable(true, seven, eight, nine, multiplication, four, five, six, division, one, two, three, plus, separator, zero, equals, minus);
    }
}