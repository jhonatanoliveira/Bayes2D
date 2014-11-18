/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jhonatanoliveira.bayesball.core.roles;

import com.jhonatanoliveira.bayesball.core.Player;
import com.jhonatanoliveira.bayesball.core.World;
import java.util.HashSet;

/**
 *
 * @author jhonatanoliveira
 */
public class PlayerRole {
    
    private final HashSet<Player> players;

    public PlayerRole() {
        this.players = new HashSet<>();
    }
    
    public void doWhenHalt(World world) {
        
    }
    
    public void doWhenStop(World world) {
        
    }
    
    public void doWhenForceStart(World world) {
        
    }
    
    public void doWhenNormalStart(World world) {
        
    }
    
    public boolean addPlayer(Player p) {
        return this.players.add(p);
    }
    
    public void clear() {
        this.players.clear();
    }

    public HashSet<Player> getPlayers() {
        return players;
    }
    
}
