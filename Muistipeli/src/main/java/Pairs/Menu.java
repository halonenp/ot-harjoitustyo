/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pairs;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author halon
 */
public class Menu extends Application {

    Game game;
    Cards card;

    @Override
    public void start(Stage ikkuna) throws Exception {
        
        GridPane firstPlayer = new GridPane();
        Button but1 = new Button("Seuraava");
        firstPlayer.add(but1, 0, 2);
        luoNakuna(firstPlayer, "Pelaajan 1 nimi");

        GridPane secondPlayer = new GridPane();
        Button but2 = new Button("Oispa kaljaa");
        secondPlayer.add(but2, 0, 2);
        luoNakuna(secondPlayer, "Pelaajan 2 nimi");

       
        GridPane game = new GridPane();
        for (int i = 0; i < 8; i++) {
            game.add(new Button(Cards.PIILO.toString()), 0, i);
        }

        Scene first = new Scene(firstPlayer);
        Scene second = new Scene(secondPlayer);
        Scene gameview = new Scene(game);

        but1.setOnAction((event) -> {
            ikkuna.setScene(second);
        });
        but2.setOnAction((event) -> {
            ikkuna.setScene(gameview);
        });

        ikkuna.setScene(first);
        ikkuna.show();
    }

    private GridPane luoNakuna(GridPane asettelu, String kak) {

        TextField text = new TextField();
        asettelu.add(new Label(kak), 0, 0);
        asettelu.add(text, 0, 1);

        asettelu.setPrefSize(300, 180);
        asettelu.setAlignment(Pos.CENTER);
        asettelu.setVgap(10);
        asettelu.setHgap(10);
        asettelu.setPadding(new Insets(20, 20, 20, 20));
        return asettelu;
    }

}
