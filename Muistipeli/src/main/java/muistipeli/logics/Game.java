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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;
import muistipeli.logics.StatisticsUusi;
import muistipeli.ui.UserInterface;

/**
 * Luokka koko pelin logiikkaan
 *
 * @author halon
 */
public class Game {

    public final List<String> taulukko;
    public int vuoro;

    public Game() {
        this.taulukko = new ArrayList<>();
        this.vuoro = 0;
    }

    /**
     * Fill-metodit täyttävät pelilaudan, yksi kullekin vaikeusasteelle
     */
    public void fillEasy() {
        for (int i = 0; i < 2; i++) {
            this.taulukko.add("karhu");
            this.taulukko.add("mursu");
            this.taulukko.add("sandels");
        }
        Collections.shuffle(taulukko);
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

    public void fillHard() {
        for (int i = 0; i < 2; i++) {
            this.taulukko.add("karhu");
            this.taulukko.add("mursu");
            this.taulukko.add("sandels");
            this.taulukko.add("koff");
            this.taulukko.add("jallu");
            this.taulukko.add("maito");
        }
        Collections.shuffle(taulukko);
    }

    /**
     * asettaa vuoron takaisin pelaajalle 1
     */
    public void newGame() {
        this.vuoro = 0;
    }

    /**
     * kääntää kortin
     *
     * @param b käyttäjän painama nappi
     * @param i kortin paikka taulukossa
     */
    public void turnCard(final Button b, final int i) {
        b.setText(this.taulukko.get(i));
    }

    /**
     * Metodi tarkistaa löytyikö pari, jos löytyi lisää vuorossa olevalle
     * pelaajalle piste, muuten käännä takaisin ja vuoro vaihtuu
     *
     * @param b käyttäjän valitsema kortti
     * @param c käyttäjän valitsema kortti
     * @param p vuorossa oleva pelaaja
     */
    public void checkIfPairs(Button b, Button c, Players p) {

        if (b.getText().equals(c.getText())) {
            p.itsAMatch();

        } else {
            turnBack(b, c);
            this.vuoro++;
        }
    }

    /**
     * kääntää kortit takaisin piiloon
     *
     * @param b käyttäjän valitsema kortti
     * @param c käyttäjän valitsema kortti
     */
    public void turnBack(Button b, Button c) {
        PauseTransition pause = new PauseTransition(
                Duration.seconds(1)
        );
        pause.setOnFinished(even -> {
            b.setText("***");
            c.setText("***");

        });
        pause.play();
    }

    /**
     * Tarkistaa kumman vuoro
     *
     * @param first player1
     * @param second player2
     * @return palauttaa vuorossa olevan pelaajan
     */
    public Players whosTurn(final Players first, final Players second) {
        if (this.vuoro % 2 == 0) {
            return first;
        } else {
            return second;
        }
    }

    /**
     * Säätelee nuoli-labelia joka oisoittaa vuorossa olevan pelaajan
     *
     * @param p1 p1 vuoro-label
     * @param p2 p2 vuoro-label
     */
    public void showTurn(Label p1, Label p2) {
        if (this.vuoro % 2 == 0) {
            p2.setVisible(false);
            p1.setVisible(true);
        } else {
            p1.setVisible(false);
            p2.setVisible(true);
        }

    }

    /**
     * tarkistaa onko peli loppu
     *
     * @param fir player1
     * @param sec player2
     * @return true jos peli on loppu
     */
    public boolean checkGameOver(Players fir, Players sec) {
        if (fir.getIntNumebrOfPairs() + sec.getIntNumebrOfPairs() == taulukko.size() / 2) {

            return true;
        } else {
            return false;
        }
    }

    /**
     * Jos peli loppu, niin julistaa voittajan labelillä
     *
     * @param fir player1
     * @param sec player2
     * @param winner voittajan julistus -label
     * @param stats
     */
    public void checkWinner(Players fir, Players sec, Label winner, StatisticsUusi stats) {
        if (checkGameOver(fir, sec)) {
            winner.setVisible(true);
            if (fir.getIntNumebrOfPairs() > sec.getIntNumebrOfPairs()) {
                winner.setText(fir.getName() + " on voittaja!");
                try {
                    stats.PointForWinner(fir);
                } catch (Exception ex) {
                    Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (sec.getIntNumebrOfPairs() > fir.getIntNumebrOfPairs()) {
                winner.setText(sec.getName() + " on voittaja!");
                try {
                    stats.PointForWinner(sec);
                } catch (Exception ex) {
                    Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (fir.getIntNumebrOfPairs() == sec.getIntNumebrOfPairs()) {
                winner.setText("Tasapeli!");

            }
        }

    }

}
