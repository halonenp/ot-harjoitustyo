/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.File;
import java.io.FileWriter;
import muistipeli.dao.FileStatisticsDao;
import muistipeli.dao.StatisticsDao;
import muistipeli.players.Players;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

/**
 *
 * @author halon
 */
public class FileStatisticsDaoTest {

    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();

    File statsFile;
    Players player;
    StatisticsDao statsDao;

    @Before
    public void setUp() throws Exception {
        statsFile = testFolder.newFile("testfile_stats.txt");

        try (FileWriter file = new FileWriter(statsFile.getAbsolutePath())) {
            file.write("Pelaaja 1,1,1\n");
        }
        statsDao = new FileStatisticsDao(statsFile.getAbsolutePath());
    }

    public FileStatisticsDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void findByPlayerNameWorks() throws Exception {
        Players player1 = new Players("Matti", 1, 0);
        Players player2 = new Players("Teppo", 1, 0);
        statsDao.addPlayer(player1, player2);
        assertEquals(statsDao.findByPlayerName("Teppo"), player2);
    }

    @Test
    public void findByPlayerNameWorks2() throws Exception {
        Players player1 = new Players("Matti", 1, 0);
        Players player2 = new Players("Teppo", 1, 0);
        statsDao.addPlayer(player1, player2);
        assertEquals(statsDao.findByPlayerName("Unto"), null);
    }

    @Test
    public void victoryAndPlayedGamesCorrect() throws Exception {
        Players player1 = new Players("Matti", 1, 0);
        Players player2 = new Players("Teppo", 1, 0);
        Players player3 = new Players("Taavi", 1, 0);
        statsDao.addPlayer(player1, player2);
        statsDao.addPlayer(player1, player3);
        statsDao.pointForWinner(player1);
        assertEquals(player1.getVictories(), 1);
        assertEquals(player1.getPlayedGames(), 2);
    }

    @Test
    public void victoryAndPlayedGamesCorrect2() throws Exception {
        Players player1 = new Players("Matti", 1, 0);
        Players player2 = new Players("Teppo", 1, 0);
        Players player3 = new Players("Taavi", 1, 0);
        statsDao.addPlayer(player1, player2);
        statsDao.addPlayer(player3, player2);
        statsDao.pointForWinner(player2);
        assertEquals(player2.getVictories(), 1);
        assertEquals(player2.getPlayedGames(), 2);
    }

    @Test
    public void findByPlay() throws Exception {
        Players player1 = new Players("Matti", 1, 0);
        Players player2 = new Players("Teppo", 1, 0);
        statsDao.addPlayer(player1, player2);
        assertEquals(statsDao.newPlayer(player1), false);
    }

    @After
    public void tearDown() {
        statsFile.delete();
    }

}
