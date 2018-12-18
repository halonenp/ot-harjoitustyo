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

    public Players(final String n, int playedGames, int victories) {
        this.name = n;
        this.pairs = 0;
        this.victories = victories;
        this.playedGames = playedGames;

    }

    /**
     * setName-metodit asettavat nimet pelaajille, jos nimikenttä on tyhjä, niin
     * asettaa automaattinimen
     *
     * @param n käyttäjän asettama nimi
     */
    public void setName1(final String n) {
        if (n.isEmpty() || n.equals(" ")) {
            this.name = "Pelaaja 1";
        } else {
            this.name = n;
        }
    }

    public void setName2(final String n) {

        if (n.isEmpty() || n.equals(" ")) {
            this.name = "Pelaaja 2";
        } else {
            this.name = n;
        }

    }

    /**
     * Tarkistaa että nimet eivät ole samat
     *
     * @param n player1 nimi
     * @param m player2 nimi
     * @return true jos nimet eroavat
     */
    public boolean namesDiffer(String n, String m) {
        if (!n.equalsIgnoreCase(m)) {
            return true;
        }
        return false;
    }

    public String getName() {
        return this.name;
    }

    public int getIntNumebrOfPairs() {
        return this.pairs;
    }

    public int getVictories() {
        return this.victories;
    }

    public void victory() {
        this.victories++;
    }

    public int getPlayedGames() {
        return this.playedGames;
    }

    public void PlayedAGame() {
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
