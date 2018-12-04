/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.ui;

import muistipeli.logics.Game;
import muistipeli.players.Players;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
//todo: kumman vuoro, uusi peli -nappula aloittaa uuden pelin, korttien määrä vaihdettavissa
/**
 *
 * @author halon
 */
public class UserInterface extends Application {

    public int k = 0; //määrittää onko kortin kääntö eka vai toka
    public Button eka;
    public Button toka;
    Players player1 = new Players("");
    Players player2 = new Players("");

    @Override
    public void start(Stage ikkuna) throws Exception {

        Game game = new Game();

        GridPane firstPlayer = new GridPane();
        TextField text1 = new TextField();
        Button but1 = new Button("Seuraava");
        firstPlayer.add(but1, 0, 2);
        luoNakuna(firstPlayer, "Pelaajan 1 nimi", text1);//ekan pelaajan näkymä

        GridPane secondPlayer = new GridPane();
        Button but2 = new Button("Oispa kaljaa");
        secondPlayer.add(but2, 0, 2);
        TextField text2 = new TextField();
        luoNakuna(secondPlayer, "Pelaajan 2 nimi", text2);//tokan pelaajan näkymä

        Button[] buttonContainer = new Button[8];

        VBox vbox = new VBox();

        Label p1Points = new Label(player1.getNumberOfPairs());
        Label p2Points = new Label(player2.getNumberOfPairs());
        Label winner = new Label("");
        Button newGame = new Button("Uusi peli");
        newGame.setVisible(false);

        for (int i = 0; i < 8; i++) {//itse peli ja napit tässä loopissa

            int f = i;
            Button button = new Button();
            button.setText("***");

            button.setOnAction((ActionEvent event) -> {

                if (button.getText().equals("***")) {
                    if (k % 2 == 0) {
                        game.turnCard(button, f);
                        eka = (Button) event.getSource();
                        k++;
                    } else {
                        game.turnCard(button, f);
                        toka = (Button) event.getSource();
                        game.checkIfPairs(eka, toka, game.whosTurn(player1, player2));//tarkistaa löytyikö pari sekä
                        p1Points.setText(player1.getNumberOfPairs());                 //lisää pisteen oikealle pelaajalle jos löytyi
                        p2Points.setText(player2.getNumberOfPairs());
                        k--;
                        if (game.checkGameOver(player1, player2)) {         //Jos peli on loppu
                            game.checkWinner(player1, player2, winner);     //julista voittaja
                            newGame.setVisible(true);                       //uusi peli -nappi näkyviin (ei tee vielä mitään)
                        }
                    }
                } else {
                    return;//return varmistaa ettei voi painaa jo auki olevia nappeja
                }

            });

            buttonContainer[i] = button;//lisää nappi arryhin
            vbox.getChildren().add(buttonContainer[i]);//lisää napit vboxiin

        }

        GridPane root = new GridPane();
        //root.setPrefSize(500, 500);
        root.add(p1Points, 2, 20);
        root.add(p2Points, 2, 50);
        root.add(winner, 120, 600);
        root.add(newGame, 4, 4);
        root.getChildren().add(vbox);

        Scene scene = new Scene(root, 400, 400);

        Scene first = new Scene(firstPlayer);
        Scene second = new Scene(secondPlayer);

        but1.setOnAction(
                (event) -> {
                    player1.setName1(text1.getText());
                    ikkuna.setScene(second);
                    Label tesi1 = new Label("  " + player1.getName());
                    root.add(tesi1, 100, 20);
                }
        );
        but2.setOnAction(
                (event) -> {
                    player2.setName2(text2.getText());
                    ikkuna.setScene(scene);
                    Label tesi2 = new Label("  " + player2.getName());
                    root.add(tesi2, 100, 50);
                    game.fill();
                }
        );

        ikkuna.setScene(first);
        ikkuna.show();

    }

    private GridPane luoNakuna(GridPane asettelu, String kak, TextField text) {//tämä metodi asettelee pelaajien näkymät

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
