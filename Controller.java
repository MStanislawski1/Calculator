package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private Label elo;

    @FXML
    protected void onHelloButtonClick() {
        elo.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private Label Wyswietlacz;

    private long Number1=0;
    private long Number2;
    private String operator="";
    private boolean start = true;

    Licz licz=new Licz();

    public void ButtonNumber(ActionEvent e){
        if (start){
            Wyswietlacz.setText("");
            start=false;
        }
        String value=((Button)e.getSource()).getText();
        Wyswietlacz.setText(Wyswietlacz.getText()+value);
    }

    public void ButtonOperation(ActionEvent e){
        String value=((Button)e.getSource()).getText();
        if (!value.equals("=")){
            if(!operator.isEmpty()){
                return;
            }
            operator=value;
            Number1=Long.parseLong(Wyswietlacz.getText());
            Wyswietlacz.setText("");
        }
        else{
            if(operator.isEmpty()){
                return;
            }
            Number2=Long.parseLong(Wyswietlacz.getText());
            float output = licz.calculate(Number1, Number2, operator);
            Wyswietlacz.setText(String.valueOf(output));
        }
    }





//    public void Exitbutton (ActionEvent event){
//        System.exit(0);
//    }
//    public void button0 (ActionEvent event){
//        System.out.println("0");
//    }

    public void exitButton(ActionEvent e){
        System.exit(0);
    }

//    public void buttonClicked(ActionEvent e){
//        System.out.println("dupa");
//    }
//
//    public void buttonClicked0(ActionEvent e){
//        System.out.println("0");
//    }
//    public void buttonClicked1(ActionEvent e){
//        System.out.println("1");
//    }
//    public void buttonClicked2(ActionEvent e){
//        System.out.println("2");
//    }
//    public void buttonClicked3(ActionEvent e){
//        System.out.println("3");
//    }
//    public void buttonClicked4(ActionEvent e){
//        System.out.println("4");
//    }
//    public void buttonClicked5(ActionEvent e){
//        System.out.println("5");
//    }
//    public void buttonClicked6(ActionEvent e){
//        System.out.println("6");
//    }
//    public void buttonClicked7(ActionEvent e){
//        System.out.println("7");
//    }
//    public void buttonClicked8(ActionEvent e){
//        System.out.println("8");
//    }
//    public void buttonClicked9(ActionEvent e){
//        System.out.println("9");
//    }

//    public void ButtonNumber(ActionEvent e){
//        String no = ((Button)e.getSource()).getText();
//        Wyswietlacz.setText(Wyswietlacz.getText()+no);
//    }
//
//    public void ButtonOperation(ActionEvent e){
//        String operation = ((Button)e.getSource()).getText();
//        if (!operation.equals("=")){
//            if(!op.equals("=")){
//                return;
//            }
//            op=operation;
//            Number1 = Long.parseLong(Wyswietlacz.getText());
//            Wyswietlacz.setText("");
//        }
//        else{
//            if(op.equals("")){
//                return;
//            }
//            Number2 = Long.parseLong(Wyswietlacz.getText());
//            calculate(Number1,Number2,op);
//            op="";
//        }
//    }
//    public void calculate(long n1, long n2, String op){
//        switch (op){
//
//            case "+" : Wyswietlacz.setText(n1 + n2 + "");break;
//            case "-" : Wyswietlacz.setText(n1 - n2 + "");break;
//            case "*" : Wyswietlacz.setText(n1 * n2 + "");break;
//            case "/" :
//                if (n2 == 0){
//                    Wyswietlacz.setText("0");break;
//                }
//                Wyswietlacz.setText(n1/n2+ "");break;
//        }
//    }

//    public void NumberClicked(ActionEvent e){
//        int value = Integer.parseInt()
//    }
}