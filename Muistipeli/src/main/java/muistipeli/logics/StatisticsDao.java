/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.logics;

/**
 *
 * @author halon
 */
import java.util.List;
import muistipeli.players.Players;

public interface StatisticsDao {

    Players findByUsername(String username);

    String addTime(String time, Players fir, Players sec) throws Exception;

    List<Players> getAll();
}
