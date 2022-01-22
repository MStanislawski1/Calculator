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


    void buttonClicked(ActionEvent e){
        System.out.println("dupa");
    }
}