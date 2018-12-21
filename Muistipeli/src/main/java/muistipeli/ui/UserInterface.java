/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.ui;

import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import muistipeli.dao.FileStatisticsDao;

/**
 * UI
 *
 * @author halon
 */
public class UserInterface extends Application {

    public int gameSize;
    public int order = 0; //määrittää onko kortin kääntö eka vai toka
    public Button firstCard;
    public Button secondCard;
    Players player1 = new Players("", 1, 0);
    Players player2 = new Players("", 1, 0);
    private FileStatisticsDao stats;

    @Override
    public void init() throws Exception {
        stats = new FileStatisticsDao("statistics.txt");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Game game = new Game();

        GridPane firstPlayer = new GridPane();
        TextField nameField1 = new TextField();
        Button buttonNext = new Button("Seuraava");
        firstPlayer.add(buttonNext, 0, 2);
        createView(firstPlayer, "Pelaajan 1 nimi", nameField1);//ekan pelaajan näkymä

        GridPane secondPlayer = new GridPane();
        Button buttonStart = new Button("Pelaamaan!");
        secondPlayer.add(buttonStart, 0, 2);
        TextField nameField2 = new TextField();
        createView(secondPlayer, "Pelaajan 2 nimi", nameField2);//tokan pelaajan näkymä

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
        root.add(turn1, 110, 20);
        root.add(turn2, 110, 50);
        root.add(p1Points, 2, 20);
        root.add(p2Points, 2, 50);
        root.add(winner, 120, 600);
        root.add(newGame, 4, 4);
        root.getChildren().add(vbox);

        Scene scene = new Scene(root, 400, 400);

        Scene firstScene = new Scene(firstPlayer);
        Scene secondScene = new Scene(secondPlayer);

        buttonNext.setOnAction((event) -> {
            player1.setName1(nameField1.getText());
            primaryStage.setScene(secondScene);
            Label nameLabel1 = new Label("  " + player1.getName());
            root.add(nameLabel1, 100, 20);
        }
        );
        buttonStart.setOnAction((event) -> {

            player2.setName2(nameField2.getText());
            if (player1.namesDiffer(player1.getName(), player2.getName())) {
                try {
                    stats.addPlayer(player1, player2);
                } catch (Exception ex) {
                    Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
                primaryStage.setScene(scene);

                Label nameLabel2 = new Label("  " + player2.getName());
                root.add(nameLabel2, 100, 50);
                if (butGroup.getSelectedToggle() == butEasy) {
                    gameSize = 8;
                    game.fillEasy();
                    board(game, p1Points, p2Points, turn1, turn2, winner, newGame, vbox, stats);
                }
                if (butGroup.getSelectedToggle() == butNormal) {
                    gameSize = 10;
                    game.fill();
                    board(game, p1Points, p2Points, turn1, turn2, winner, newGame, vbox, stats);
                }
                if (butGroup.getSelectedToggle() == butHard) {
                    gameSize = 12;
                    game.fillHard();
                    board(game, p1Points, p2Points, turn1, turn2, winner, newGame, vbox, stats);
                }
            }

        }
        );

        newGame.setOnAction((event) -> {
            game.newGame();
            Collections.shuffle(game.cards);
            vbox.getChildren().clear();
            board(game, p1Points, p2Points, turn1, turn2, winner, newGame, vbox, stats);
            newGame.setVisible(false);
            winner.setVisible(false);
            player1.newGame();
            p1Points.setText(player1.getNumberOfPairs());
            player2.newGame();
            p2Points.setText(player2.getNumberOfPairs());
            game.showTurn(turn1, turn2);
            try {
                stats.addPlayer(player1, player2);
            } catch (Exception ex) {
                Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        );

        primaryStage.setScene(firstScene);
        primaryStage.show();

    }

    /**
     * Tämä metodi asettelee pelaajien nimienasetusnäkymät
     *
     * @param layout GridPane-pohja
     * @param str teksti kumman pelaajan nimi tulee
     * @param text textfield
     * @return palauttaa asettelun
     */
    private GridPane createView(GridPane layout, String str, TextField text) {

        layout.add(new Label(str), 0, 0);
        layout.add(text, 0, 1);
        layout.setPrefSize(300, 180);
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        return layout;
    }

    /**
     * Tässä metodissa itse peli
     *
     * @param game Game-olio
     * @param p1Points label pelaajan1 pisteille
     * @param p2Points label pelaajan2 pisteille
     * @param turn1 label pelaajan1 vuorolle
     * @param turn2 label pelaajan2 vuorolle
     * @param winner label voittajan julistukseen
     * @param newGame uusi peli -nappula
     * @param vbox napit tässä vboxissa
     */
    private void board(Game game, Label p1Points, Label p2Points, Label turn1, Label turn2, Label winner,
            Button newGame, VBox vbox, FileStatisticsDao stats) {
        Button[] buttonContainer = new Button[gameSize];
        for (int i = 0; i < gameSize; i++) {

            int f = i;
            Button button = new Button();
            button.setText("***");

            button.setOnAction((ActionEvent event) -> {

                if (button.getText().equals("***")) {
                    if (order % 2 == 0) {
                        game.turnCard(button, f);
                        firstCard = (Button) event.getSource();
                        order++;
                    } else {
                        game.turnCard(button, f);
                        secondCard = (Button) event.getSource();
                        game.checkIfPairs(firstCard, secondCard, game.whosTurn(player1, player2));
                        p1Points.setText(player1.getNumberOfPairs());
                        p2Points.setText(player2.getNumberOfPairs());
                        order--;
                        game.showTurn(turn1, turn2);
                        if (game.checkGameOver(player1, player2)) {
                            game.checkWinner(player1, player2, winner, stats);
                            newGame.setVisible(true);
                        }
                    }
                } else {
                    return;//return varmistaa ettei voi painaa jo auki olevia nappeja
                }

            });

            buttonContainer[i] = button;
            vbox.getChildren().add(buttonContainer[i]);

        }
    }

}
