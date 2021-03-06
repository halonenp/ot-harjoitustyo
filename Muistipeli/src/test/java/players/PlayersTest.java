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
        String n = " ";
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
    public void setNameWorks5() {
        Game game = new Game();
        game.fill();
        Players player1 = new Players("", 1, 0);
        String n = "";
        player1.setName2(n);
        assertEquals(player1.getName(), "Pelaaja 2");
    }

    public void setNameWorks6() {
        Game game = new Game();
        game.fill();
        Players player1 = new Players("", 1, 0);
        String n = "";
        player1.setName1(n);
        assertEquals(player1.getName(), "Pelaaja 1");
    }

    @Test
    public void pairFound() {
        Game game = new Game();
        game.fill();
        Players player1 = new Players("pelaaja", 1, 0);
        player1.itsAMatch();
        assertEquals(player1.getIntNumberOfPairs(), 1);
    }

    @Test
    public void namesDiffer() {
        Players player1 = new Players("pelaaja", 1, 0);
        Players player2 = new Players("peluri", 1, 0);
        assertEquals(player1.namesDiffer(player1.getName(), player2.getName()), true);
    }

    @Test
    public void namesDoesntDiffer() {
        Players player1 = new Players("pelaaja", 1, 0);
        Players player2 = new Players("pelaaja", 1, 0);
        assertEquals(player1.namesDiffer(player1.getName(), player2.getName()), false);
    }

    @Test
    public void addsVictory() {
        Players player1 = new Players("pelaaja", 1, 0);
        player1.victory();
        assertEquals(player1.getVictories(), 1);
    }

    @Test
    public void addsPlayedGame() {
        Players player1 = new Players("pelaaja", 1, 0);
        player1.playedAGame();
        assertEquals(player1.getPlayedGames(), 2);
    }

    @Test
    public void StartNewGame() {
        Players player1 = new Players("pelaaja", 1, 0);
        player1.itsAMatch();
        player1.itsAMatch();
        player1.newGame();
        assertEquals(player1.getIntNumberOfPairs(), 0);
    }

    @Test
    public void correctAmountOfPairs() {
        Players player1 = new Players("pelaaja", 1, 0);
        player1.itsAMatch();
        player1.itsAMatch();
        assertEquals(player1.getNumberOfPairs(), "2");
    }

}
