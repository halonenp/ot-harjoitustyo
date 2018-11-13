/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pairs;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author halon
 */
public class Menu extends Application {

    

    @Override
    public void start(Stage ikkuna) throws Exception {
        Game game = new Game();
        game.fill();
        
        
        GridPane firstPlayer = new GridPane();
        Button but1 = new Button("Seuraava");
        firstPlayer.add(but1, 0, 2);
        luoNakuna(firstPlayer, "Pelaajan 1 nimi");

        GridPane secondPlayer = new GridPane();
        Button but2 = new Button("Oispa kaljaa");
        secondPlayer.add(but2, 0, 2);
        luoNakuna(secondPlayer, "Pelaajan 2 nimi");

        Button[][] buttonContainer = new Button[2][4];

        VBox vbox = new VBox();

        for (int i = 0; i < 2; i++) {
            for (int t = 0; t < 4; t++) {
                int f = i + t;

                Button button = new Button();
                button.setText("kak");
                //Create event handler
                button.setOnAction((event) -> {
                    if (button.getText().equals("kak")) {
                        button.setText(game.taulukko.get(f));
                    } else {
                        button.setText("kak");
                    }

                });
                buttonContainer[i][t] = button;//Add the current button to the Button 2D array
                vbox.getChildren().add(buttonContainer[i][t]);//Add current button to the VBox
            }
        }

        StackPane root = new StackPane();

        root.getChildren()
                .add(vbox);
        Scene scene = new Scene(root, 500, 500);

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
