/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pairs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 *
 * @author halon
 */
public class Buttons {
    
    public Game game;
    public Button button;
    int i = 0;
    
    public Buttons() {
        this.button = new Button();
        this.button.setText("kak");
    }
    
    public void fillButtons() {
        for (int j = 0; j < 8; j++) {
            final Button temp = new Button("Button " + j);
            final int numButton = j;
            temp.setId("" + j);
            temp.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    System.out.println("id(" + temp.getId() + ") =  " + numButton);
                }
            });
            
        }
    }

    private void addn(Button[] k, int j) {
        k[j].setText("pis");
        
    }
    
    private void addButton() {
        i++;
        final Button temp = new Button("Button " + i);
        final int numButton = i;
        temp.setId("" + i);
        temp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("id(" + temp.getId() + ") =  " + numButton);
            }
        });
//        gpnael.add(temp, i, 1);
    }
    
}
