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

    public Players(final String n) {
        this.name = n;
        this.pairs = 0;
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

    public String getName() {
        return this.name;
    }

    public int getIntNumebrOfPairs() {
        return this.pairs;
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
