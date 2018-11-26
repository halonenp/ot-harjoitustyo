/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pairs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.animation.PauseTransition;
import javafx.scene.control.Button;
import javafx.util.Duration;

/**
 *
 * @author halon
 */
public class Game {

    public List<String> taulukko;
    Players players;
    int vuoro;

    public Game() {
        this.taulukko = new ArrayList<>();
        this.vuoro = 0;
    }

    public int getVuoro() {
        return this.vuoro;
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

    public void turnCard(Button b, int i) {
        b.setText(this.taulukko.get(i));
    }

    public void checkIfPairs(Button b, Button c, Players p) {

        if (b.getText().equals(c.getText())) {
            System.out.println("pari!");
            p.itsAMatch();

        } else {
            turnBack(b, c);
            this.vuoro++;
        }
    }

    public void turnBack(Button b, Button c) {
        PauseTransition pause = new PauseTransition(
                Duration.seconds(1)
        );
        pause.setOnFinished(even -> {
            b.setText("kak");
            c.setText("kak");

        });
        pause.play();
    }

    public Players whosTurn(Players first, Players second) {
        if (this.vuoro % 2 == 0) {
            return first;
        } else {
            return second;
        }
    }

}
