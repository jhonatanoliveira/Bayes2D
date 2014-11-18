/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jhonatanoliveira.bayesball.core;

import java.util.HashSet;

/**
 *
 * @author jhonatanoliveira
 */
public class Team {
    
    HashSet<Player> players;
    TeamsColor color;

    public Team(HashSet<Player> robots, TeamsColor color) {
        this.players = new HashSet<>();
        this.players = robots;
        this.color = color;
    }

    public Team(TeamsColor color) {
        this.players = new HashSet<>();
        this.color = color;
    }
    
    public boolean addPlayer(Player player) {
        return this.players.add(player);
    }

    public HashSet<Player> getPlayers() {
        return players;
    }

    public void setPlayers(HashSet<Player> players) {
        this.players = players;
    }

    public TeamsColor getColor() {
        return color;
    }

    public void setColor(TeamsColor color) {
        this.color = color;
    }
    
    public boolean hasPlayers() {
        return this.players.size() > 0;
    }
}
