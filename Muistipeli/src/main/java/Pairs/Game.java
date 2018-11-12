/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pairs;

import java.util.ArrayList;

/**
 *
 * @author halon
 */
public class Game {

    Cards card;
    private Cards[][] cards;

    public Game() {
        this.cards = new Cards[2][8];

        for (int j = 0; j < 8; j++) {
            this.cards[1][j] = Cards.AA;
        }
        for (int i = 0; i < 8; i++) {
            this.cards[2][i] = Cards.PIILO;
        }

    }

    public void EnumTest(Cards card) {
        this.card = card;
    }
}
