/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.dao;

/**
 *
 * @author halon
 */
import muistipeli.players.Players;

public interface StatisticsDao {

    boolean newPlayer(Players player);

    void pointForWinner(Players player) throws Exception;

    Players findByPlayerName(String name);

    void addPlayer(Players fir, Players sec) throws Exception;

}
