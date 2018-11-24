/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pairs;

import javafx.scene.control.TextField;

/**
 *
 * @author halon
 */
public class Players {

    String name;
    int pairs;

    public Players(String name) {
        this.name = name;
        this.pairs = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
