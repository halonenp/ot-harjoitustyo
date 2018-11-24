/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pairs;

import java.util.ArrayList;
import java.util.Timer;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author halon
 */
public class Menu extends Application {

    public int k = 0;
    public int kortti1 = 0;
    public int kortti2 = 0;
    public String text = "";
    public Button eka;
    public Button toka;
    String name1 = "";
    String name2;
    Players player1 = new Players("jallu");

    @Override
    public void start(Stage ikkuna) throws Exception {

        Game game = new Game();
        game.fill();

        GridPane firstPlayer = new GridPane();
        TextField text1 = new TextField();
        Button but1 = new Button("Seuraava");
        firstPlayer.add(but1, 0, 2);
        luoNakuna(firstPlayer, "Pelaajan 1 nimi", text1);
        but1.setOnAction(action -> {
            player1.setName(text1.getText());
            System.out.println("kakke");
        });

        GridPane secondPlayer = new GridPane();
        Button but2 = new Button("Oispa kaljaa");
        secondPlayer.add(but2, 0, 2);
        TextField text2 = new TextField();
        luoNakuna(secondPlayer, "Pelaajan 2 nimi", text2);

        Button[] buttonContainer = new Button[8];

        VBox vbox = new VBox();
        System.out.println(k);
        for (int i = 0; i < 8; i++) {

            int f = i;
            System.out.println(player1.getName());
            Button button = new Button();
            button.setText("kak");

            //Create event handler
//            button.setOnAction(new EventHandler<ActionEvent>() {
//                @Override
//                public void handle(ActionEvent event) {
//
//                    if (k % 2 == 0) {
//                        game.turnCard(button, f);
//                        System.out.println("perkele");
//                        k++;
//                        kortti1 = f;
//                        System.out.println(kortti1);
//
//                    } else {
//                        game.turnCard(button, f);
//                        System.out.println("saatana");
//                        k++;
//                        kortti2 = f;
//                        System.out.println(kortti2);
//                        wit();
//                        
//                    }
//                }
//              
//            });
            button.setOnAction((event) -> {
                if (button.getText().equals("kak")) {
                    if (k % 2 == 0) {
                        game.turnCard(button, f);
                        eka = (Button) event.getSource();
                        k++;
                        System.out.println(player1.getName());
                    } else {
                        game.turnCard(button, f);
                        toka = (Button) event.getSource();
                        game.checkIfPairs(eka, toka);
                        k--;
                    }
                } else {
                    return;
                }

            });

            buttonContainer[i] = button;//Add the current button to the Button 2D array
            vbox.getChildren().add(buttonContainer[i]);//Add current button to the VBox

        }

        StackPane root = new StackPane();

        root.getChildren()
                .add(vbox);
        Scene scene = new Scene(root, 300, 300);

        Scene first = new Scene(firstPlayer);
        Scene second = new Scene(secondPlayer);

        but1.setOnAction(
                (event) -> {
                    ikkuna.setScene(second);
                }
        );
        but2.setOnAction(
                (event) -> {
                    ikkuna.setScene(scene);
                }
        );

        ikkuna.setScene(first);

        ikkuna.show();
    }

    private GridPane luoNakuna(GridPane asettelu, String kak, TextField text) {

        asettelu.add(new Label(kak), 0, 0);
        asettelu.add(text, 0, 1);
        asettelu.setPrefSize(300, 180);
        asettelu.setAlignment(Pos.CENTER);
        asettelu.setVgap(10);
        asettelu.setHgap(10);
        asettelu.setPadding(new Insets(20, 20, 20, 20));
        return asettelu;
    }

    private void wit() {
        try {
            Thread.sleep(1000);

        } catch (java.lang.InterruptedException iex) {

        }
    }

}
