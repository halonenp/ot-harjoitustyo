/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.players;

/**
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

    public void setName(final String n) {
        this.name = n;
    }

    public String getName() {
        return this.name;
    }

    public String getNumberOfPairs() {
        return String.valueOf(this.pairs);
    }

    public void itsAMatch() {
        this.pairs++;
    }

}
