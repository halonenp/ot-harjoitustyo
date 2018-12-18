/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package players;

import muistipeli.logics.Game;
import muistipeli.players.Players;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author halon
 */
public class PlayersTest {

    public PlayersTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void setNameWorks1() {
        Game game = new Game();
        game.fill();
        Players player1 = new Players("", 1, 0);
        String n = "peluri";
        player1.setName1(n);
        assertEquals(player1.getName(), "peluri");
    }

    @Test
    public void setNameWorks2() {
        Game game = new Game();
        game.fill();
        Players player1 = new Players("", 1, 0);
        String n = "";
        player1.setName1(n);
        assertEquals(player1.getName(), "Pelaaja 1");
    }

    @Test
    public void setNameWorks3() {
        Game game = new Game();
        game.fill();
        Players player1 = new Players("", 1, 0);
        String n = "peluri";
        player1.setName2(n);
        assertEquals(player1.getName(), "peluri");
    }

    @Test
    public void setNameWorks4() {
        Game game = new Game();
        game.fill();
        Players player1 = new Players("", 1, 0);
        String n = " ";
        player1.setName2(n);
        assertEquals(player1.getName(), "Pelaaja 2");
    }

    @Test
    public void pairFound() {
        Game game = new Game();
        game.fill();
        Players player1 = new Players("pelaaja", 1, 0);
        player1.itsAMatch();
        assertEquals(player1.getIntNumebrOfPairs(), 1);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
