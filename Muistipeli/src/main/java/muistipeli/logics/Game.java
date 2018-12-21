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
import muistipeli.dao.FileStatisticsDao;
import muistipeli.ui.UserInterface;

/**
 * Luokka koko pelin logiikkaan
 *
 * @author halon
 */
public class Game {

    public final List<String> cards;
    public int turn;

    public Game() {
        this.cards = new ArrayList<>();
        this.turn = 0;
    }

    /**
     * Fill-metodit täyttävät pelilaudan, yksi kullekin vaikeusasteelle
     */
    public void fillEasy() {
        for (int i = 0; i < 2; i++) {
            this.cards.add("auto");
            this.cards.add("mopo");
            this.cards.add("vene");
            this.cards.add("bussi");
        }
        Collections.shuffle(cards);
    }

    public void fill() {
        for (int i = 0; i < 2; i++) {
            this.cards.add("limu");
            this.cards.add("olut");
            this.cards.add("vesi");
            this.cards.add("maito");
            this.cards.add("mehu");
        }
        Collections.shuffle(cards);
    }

    public void fillHard() {
        for (int i = 0; i < 2; i++) {
            this.cards.add("karhu");
            this.cards.add("marsu");
            this.cards.add("hylje");
            this.cards.add("koira");
            this.cards.add("haukka");
            this.cards.add("apina");
        }
        Collections.shuffle(cards);
    }

    /**
     * asettaa vuoron takaisin pelaajalle 1
     */
    public void newGame() {
        this.turn = 0;
    }

    /**
     * kääntää kortin
     *
     * @param b käyttäjän painama nappi
     * @param i kortin paikka taulukossa
     */
    public void turnCard(final Button b, final int i) {
        b.setText(this.cards.get(i));
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
            this.turn++;
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
        if (this.turn % 2 == 0) {
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
        if (this.turn % 2 == 0) {
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
        if (fir.getIntNumberOfPairs() + sec.getIntNumberOfPairs() == cards.size() / 2) {

            return true;
        } else {
            return false;
        }
    }

    /**
     * Jos peli loppu, niin julistaa voittajan labelillä ja voittajalle +1
     * voittoihin tekstitiedostossa
     *
     * @param fir player1
     * @param sec player2
     * @param winner voittajan julistus -label
     * @param stats tekstitiedosto mihin kirjoitetaan
     */
    public void checkWinner(Players fir, Players sec, Label winner, FileStatisticsDao stats) {
        winner.setVisible(true);
        if (fir.getIntNumberOfPairs() > sec.getIntNumberOfPairs()) {
            winner.setText(fir.getName() + " on voittaja!");
            try {
                stats.pointForWinner(fir);
            } catch (Exception ex) {
                Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (sec.getIntNumberOfPairs() > fir.getIntNumberOfPairs()) {
            winner.setText(sec.getName() + " on voittaja!");
            try {
                stats.pointForWinner(sec);
            } catch (Exception ex) {
                Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (fir.getIntNumberOfPairs() == sec.getIntNumberOfPairs()) {
            winner.setText("Tasapeli!");
        }
    }

}
