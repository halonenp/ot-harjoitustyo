package logics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

    Players player1 = new Players("first");
    Players player2 = new Players("second");

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

    @Test
    public void cardsAreEmptyBeforeStart() {
        Game game = new Game();
        assertEquals(game.taulukko.size(), 0);
    }

    @Test
    public void rightPlayersTurn() {
        Game game = new Game();
        game.fill();
        assertEquals(game.whosTurn(player1, player2), player1);

    }

    @Test
    public void gameIsNotOver() {
        Game game = new Game();
        game.fill();
        assertEquals(game.checkGameOver(player1, player2), false);
    }

//    @Test
//    public void cardsAreTurning() {
//        
//        final Button button = new Button();
//        button.setText("kak");
//        final Button button2 = new Button();
//        button.setText("pis");
//        
//        Game game = new Game();
//        
//        game.fill();
//        game.checkIfPairs(button, button2, player1);
//        game.turnCard(button, 0);
//        assertEquals(button.getText(), !button.getText().equals("***"));
//    }
//    @Test
//    public void gameWinner() {
//        Label winner = new Label(" ");
//        Game game = new Game();
//        game.fill();
//        game.checkWinner(player1, player2, winner);
//        assertEquals(winner.getText().equals(" "), " ");
//    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
