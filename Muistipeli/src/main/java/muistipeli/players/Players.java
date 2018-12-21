/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.players;

/**
 * Luokka Pelaajien hallintaan
 *
 * @author halon
 */
public class Players {

    String name;
    int pairs;
    int victories;
    int playedGames;

    public Players(final String name, int playedGames, int victories) {
        this.name = name;
        this.pairs = 0;
        this.victories = victories;
        this.playedGames = playedGames;
    }

    /**
     * setName-metodit asettavat nimet pelaajille, jos nimikenttä on tyhjä, niin
     * asettaa automaattinimen
     *
     * @param name käyttäjän asettama nimi
     */
    public void setName1(final String name) {
        if (name.isEmpty() || name.equals(" ")) {
            this.name = "Pelaaja 1";
        } else {
            this.name = name;
        }
    }

    public void setName2(final String name) {

        if (name.isEmpty() || name.equals(" ")) {
            this.name = "Pelaaja 2";
        } else {
            this.name = name;
        }

    }

    /**
     * Tarkistaa että nimet eivät ole samat
     *
     * @param name1 player1 nimi
     * @param name2 player2 nimi
     * @return true jos nimet eroavat
     */
    public boolean namesDiffer(String name1, String name2) {
        if (!name1.equalsIgnoreCase(name2)) {
            return true;
        }
        return false;
    }

    public String getName() {
        return this.name;
    }

    public int getIntNumberOfPairs() {
        return this.pairs;
    }

    public int getVictories() {
        return this.victories;
    }

    /**
     * Kasvattaa voittoa yhdellä
     */
    public void victory() {
        this.victories++;
    }

    public int getPlayedGames() {
        return this.playedGames;
    }

    public void playedAGame() {
        this.playedGames++;
    }

    public void newGame() {
        this.pairs = 0;
    }

    /**
     * palauttaa pelaajan pistemäärän stringinä
     *
     * @return pelaajan pistemäärän stringinä
     */
    public String getNumberOfPairs() {
        return String.valueOf(this.pairs);
    }

    /**
     * kasvattaa pelaajan pistemäärää yhdellä
     */
    public void itsAMatch() {
        this.pairs++;
    }

}
