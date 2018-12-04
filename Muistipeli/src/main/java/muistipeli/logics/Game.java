/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.logics;

import muistipeli.players.Players;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.animation.PauseTransition;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

/**
 * @author halon
 */
public class Game {

    public final List<String> taulukko;
    private int vuoro;

    public Game() {
        this.taulukko = new ArrayList<>();
        this.vuoro = 0;
    }

    public void fill() {
        for (int i = 0; i < 2; i++) {
            this.taulukko.add("karhu");
            this.taulukko.add("mursu");
            this.taulukko.add("norsu");
            this.taulukko.add("sandels");
        }
        Collections.shuffle(taulukko);
    }

    public void turnCard(final Button b, final int i) {
        b.setText(this.taulukko.get(i));
    }

    public void checkIfPairs(final Button b, final Button c, final Players p) {

        if (b.getText().equals(c.getText())) {
            System.out.println("pari!");
            p.itsAMatch();//jos löytyi pari lisää piste oikealle pelaajalle

        } else {
            turnBack(b, c);
            this.vuoro++;//paria ei löytynyt niin vaihda vuoroa
        }
    }

    public void turnBack(final Button b, final Button c) {//kääntää kortit takaisin tauon jälkeen
        PauseTransition pause = new PauseTransition(
                Duration.seconds(1)
        );
        pause.setOnFinished(even -> {
            b.setText("***");
            c.setText("***");

        });
        pause.play();
    }

    public Players whosTurn(final Players first, final Players second) {
        if (this.vuoro % 2 == 0) {
            return first;
        } else {
            return second;
        }
    }

    public boolean checkGameOver(Players fir, Players sec) {
        if (fir.getIntNumebrOfPairs() + sec.getIntNumebrOfPairs() == 4) {

            return true;
        } else {
            return false;
        }
    }

    public void checkWinner(Players fir, Players sec, Label winner) {
        if (checkGameOver(fir, sec)) {

            if (fir.getIntNumebrOfPairs() > sec.getIntNumebrOfPairs()) {
                System.out.println("eka");
                winner.setText(fir.getName() + " on voittaja!");

            }
            if (sec.getIntNumebrOfPairs() > fir.getIntNumebrOfPairs()) {
                System.out.println("toka");
                winner.setText(sec.getName() + " on voittaja!");

            }
            if (fir.getIntNumebrOfPairs() == sec.getIntNumebrOfPairs()) {
                System.out.println("tasuri");
                winner.setText("Tasapeli!");

            }
        }

    }

}
