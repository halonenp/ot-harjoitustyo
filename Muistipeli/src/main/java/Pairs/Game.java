/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pairs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author halon
 */
public class Game {

    Cards card;
    private Cards[][] cards;
    List<String> taulukko;

    public Game() {
        this.taulukko = new ArrayList<>();
    }
//
//    public Game() {
//        this.cards = new Cards[2][8];
//
//        for (int j = 0; j < 8; j++) {
//            this.cards[1][j] = Cards.AA;
//        }
//        for (int i = 0; i < 8; i++) {
//            this.cards[2][i] = Cards.PIILO;
//        }
//
//    }

    public void fill() {
        for (int i = 0; i < 8; i++) {
            this.taulukko.add("karhu");
            this.taulukko.add("mursu");
            this.taulukko.add("norsu");
            this.taulukko.add("sandels");
        }
        Collections.shuffle(taulukko);
    }

    public void EnumTest(Cards card) {
        this.card = card;
    }
}

   