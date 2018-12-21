package logics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class LogicsTest {

    Players player1 = new Players("first", 1, 0);
    Players player2 = new Players("second", 1, 0);

    public LogicsTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() {
    }

    @Test
    public void cardsExist() {
        Game game = new Game();
        game.fill();
        assertFalse(game.cards.isEmpty());
    }

    @Test
    public void correctAmountOfCards() {
        Game game = new Game();
        game.fill();
        assertEquals(game.cards.size(), 10);
    }

    @Test
    public void correctAmountOfCardsEasy() {
        Game game = new Game();
        game.fillEasy();
        assertFalse(game.cards.isEmpty());
        assertEquals(game.cards.size(), 8);
    }

    @Test
    public void correctAmountOfCardsHard() {
        Game game = new Game();
        game.fillHard();
        assertFalse(game.cards.isEmpty());
        assertEquals(game.cards.size(), 12);
    }

    @Test
    public void p1StartsNewGame() {
        Game game = new Game();
        game.turn = 5;
        game.newGame();
        assertEquals((game.turn), 0);

    }

    @Test
    public void cardsAreEmptyBeforeStart() {
        Game game = new Game();
        assertEquals(game.cards.size(), 0);
    }

    @Test
    public void rightPlayersTurn() {
        Game game = new Game();
        game.fill();
        assertEquals(game.whosTurn(player1, player2), player1);

    }

    @Test
    public void rightPlayersTurn2() {
        Game game = new Game();
        game.fill();
        game.turn++;
        assertEquals(game.whosTurn(player1, player2), player2);

    }

    @Test
    public void gameIsNotOver() {
        Game game = new Game();
        game.fill();
        assertEquals(game.checkGameOver(player1, player2), false);
    }

    @Test
    public void gameIsOver() {
        Game game = new Game();
        game.fillEasy();
        player1.itsAMatch();
        player1.itsAMatch();
        player1.itsAMatch();
        player1.itsAMatch();
        assertEquals(game.checkGameOver(player1, player2), true);
    }

}
