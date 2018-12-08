/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.ui;

import muistipeli.logics.Game;
import muistipeli.players.Players;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
//todo: uusi peli -nappula aloittaa uuden pelin

/**
 *
 * @author halon
 */
public class UserInterface extends Application {

    public int t; //pelin koko
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

        ToggleGroup butGroup = new ToggleGroup();
        RadioButton butEasy = new RadioButton("Helppo");
        butEasy.setToggleGroup(butGroup);
        butEasy.setSelected(true);
        RadioButton butNormal = new RadioButton("Normaali");
        butNormal.setToggleGroup(butGroup);
        RadioButton butHard = new RadioButton("Vaikea");
        butHard.setToggleGroup(butGroup);

        VBox butStack = new VBox();
        butStack.setSpacing(2);
        butStack.getChildren().add(butEasy);
        butStack.getChildren().add(butNormal);
        butStack.getChildren().add(butHard);
        secondPlayer.add(butStack, 0, 5);//Vaikeusasteen valinta

        VBox vbox = new VBox();

        Label turn1 = new Label("  <--Vuoro");
        Label turn2 = new Label("  <--Vuoro");
        turn2.setVisible(false);
        Label p1Points = new Label(player1.getNumberOfPairs());
        Label p2Points = new Label(player2.getNumberOfPairs());
        Label winner = new Label("");
        Button newGame = new Button("Uusi peli");
        newGame.setVisible(false);

        GridPane root = new GridPane();
        //root.setPrefSize(500, 500);
        root.add(turn1, 110, 20);
        root.add(turn2, 110, 50);
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
        but2.setOnAction((event) -> {

            player2.setName2(text2.getText());
            ikkuna.setScene(scene);
            Label tesi2 = new Label("  " + player2.getName());
            root.add(tesi2, 100, 50);
            if (butGroup.getSelectedToggle() == butEasy) {
                t = 6;
                game.fillEasy();
                board(game, p1Points, p2Points, turn1, turn2, winner, newGame, vbox);
            }
            if (butGroup.getSelectedToggle() == butNormal) {
                t = 8;
                game.fill();
                board(game, p1Points, p2Points, turn1, turn2, winner, newGame, vbox);
            }
            if (butGroup.getSelectedToggle() == butHard) {
                t = 12;
                game.fillHard();
                board(game, p1Points, p2Points, turn1, turn2, winner, newGame, vbox);
            }

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

    private void board(Game game, Label p1Points, Label p2Points, Label turn1, Label turn2, Label winner, Button newGame, VBox vbox) {
        Button[] buttonContainer = new Button[t];
        for (int i = 0; i < t; i++) {//itse peli ja napit tässä loopissa

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
                        game.showTurn(turn1, turn2);
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
    }

}
