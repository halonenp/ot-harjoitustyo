/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */package muistipeli.logics;

/**
 *
 * @author halon
 */
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import muistipeli.players.Players;

public class StatisticsUusi implements StatisticsDao {

    public Players player;
    public List<Players> times;
    private String filename;

    public StatisticsUusi(String filename) throws Exception { //kirjoittaa vanhan listiin 

        this.filename = filename;
        times = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                String[] split = scanner.nextLine().split(",");
                player = new Players(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]));
                times.add(player);
            }

        } catch (Exception e) {
            FileWriter fw = new FileWriter(new File(filename));
            fw.close();

        }
    }

    public void save() throws Exception { //tallentaa tekstitiedostoon. Muista loopata lista
        try (FileWriter fw = new FileWriter(new File(filename))) { //lisää oliot niin pelittää
            for (Players t : times) {

                fw.write(
                        t.getName() + "," + t.getPlayedGames() + "," + t.getVictories() + "\n");

            }
        }
    }

    public boolean newPlayer(Players p) {
        for (Players s : times) {
            if (s.getName().equals(p.getName())) {
                return false;
            }
        }
        return true;
    }

    public void PointForWinner(Players p) throws Exception {
        findByUsername(p.getName()).victory();
        save();
    }

    @Override
    public Players findByUsername(String username) {
        return times.stream()
                .filter(u -> u.getName()
                .equals(username))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String addTime(String eka, Players fir,
            Players sec) throws Exception {
        if (newPlayer(fir)) {
            times.add(fir);
        } else {
            findByUsername(fir.getName()).PlayedAGame();
        }
        if (newPlayer(sec)) {
            times.add(sec);
        } else {
            findByUsername(sec.getName()).PlayedAGame();
        }
        save();

        return eka;
    }

    @Override
    public List<Players> getAll() {

        return times;
    }

}
