package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    private Label elo;

    @FXML
    protected void onHelloButtonClick() {
        elo.setText("Welcome to JavaFX Application!");
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

    public void buttonClicked(ActionEvent e){
        System.out.println("dupa");
    }

    public void buttonClicked0(ActionEvent e){
        System.out.println("0");
    }
    public void buttonClicked1(ActionEvent e){
        System.out.println("1");
    }
    public void buttonClicked2(ActionEvent e){
        System.out.println("2");
    }
    public void buttonClicked3(ActionEvent e){
        System.out.println("3");
    }
    public void buttonClicked4(ActionEvent e){
        System.out.println("4");
    }
    public void buttonClicked5(ActionEvent e){
        System.out.println("5");
    }
    public void buttonClicked6(ActionEvent e){
        System.out.println("6");
    }
    public void buttonClicked7(ActionEvent e){
        System.out.println("7");
    }
    public void buttonClicked8(ActionEvent e){
        System.out.println("8");
    }
    public void buttonClicked9(ActionEvent e){
        System.out.println("9");
    }

}