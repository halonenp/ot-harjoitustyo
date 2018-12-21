/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.dao;

/**
 * Tämä luokka on tekstitiedoston hallintaan
 *
 * @author halon
 */
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import muistipeli.players.Players;

public class FileStatisticsDao implements StatisticsDao {

    public Players player;
    public List<Players> playerList;
    private String filename;

    public FileStatisticsDao(String filename) throws Exception {

        this.filename = filename;
        playerList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                String[] split = scanner.nextLine().split(",");
                player = new Players(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]));
                playerList.add(player);
            }

        } catch (Exception e) {
            FileWriter fw = new FileWriter(new File(filename));
            fw.close();

        }
    }

    /**
     * Tämä metodi kirjoittaa tekstitiedostoon
     *
     * @throws Exception
     */
    public void save() throws Exception {
        try (FileWriter fw = new FileWriter(new File(filename))) {
            for (Players t : playerList) {

                fw.write(
                        t.getName() + "," + t.getPlayedGames() + "," + t.getVictories() + "\n");

            }
        }
    }

    /**
     * Tarkistaa onko pelaaja uusi vai löytyyky nimi jo tekstitiedostosta
     *
     * @param p Players-olio
     * @return palauttaa true jos pelaajaa ei löydy ennestään tekstitiedostosta
     */
    @Override
    public boolean newPlayer(Players p) {
        for (Players s : playerList) {
            if (s.getName().equals(p.getName())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Lisää voiton pelaajalle
     *
     * @param p Players-olio
     * @throws Exception
     */
    @Override
    public void pointForWinner(Players p) throws Exception {
        findByPlayerName(p.getName()).victory();
        save();
    }

    /**
     * Etsii pelaajan liststa nimen perusteella
     *
     * @param name Pelaajan nimi
     * @return Players-olion jolla on sama nimi kuin annetulla parametrilla
     */
    @Override
    public Players findByPlayerName(String name) {
        return playerList.stream()
                .filter(p -> p.getName()
                .equals(name))
                .findFirst()
                .orElse(null);
    }

    /**
     * Lisää Players-oliot listaan jos ei siellä ole jo. Muuten +1 pelattuihin
     * peleihin
     *
     * @param fir Players-olio
     * @param sec Players-olio
     * @throws Exception
     */
    @Override
    public void addPlayer(Players fir, Players sec) throws Exception {
        if (newPlayer(fir)) {
            playerList.add(fir);
        } else {
            findByPlayerName(fir.getName()).playedAGame();
        }
        if (newPlayer(sec)) {
            playerList.add(sec);
        } else {
            findByPlayerName(sec.getName()).playedAGame();
        }
        save();

    }

}
