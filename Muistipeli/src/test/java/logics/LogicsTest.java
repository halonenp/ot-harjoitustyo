package logics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import muistipeli.logics.Game;
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
public class LogicsTest {

    public LogicsTest() {
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
    public void cardsExist() {
        Game game = new Game();
        game.fill();
        assertFalse(game.taulukko.isEmpty());
    }

    @Test
    public void correctAmountOfCards() {
        Game game = new Game();
        game.fill();
        assertEquals(game.taulukko.size(), 8);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
