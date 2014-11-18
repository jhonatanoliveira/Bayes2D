/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhonatanoliveira.bayesball.core;

import java.util.Iterator;

/**
 *
 * @author jhonatanoliveira
 */
public class BayesBallWorld extends World{
    
    private BayesBallBn bayesBallBn;

    public BayesBallWorld() {
        this(TeamsColor.YELLOW, World.FIELD_RIGHT_SIDE, "224.5.23.2",10002,"127.0.0.1",20011);
    }

    public BayesBallWorld(TeamsColor teamsColor, int fieldSide, String sslAddress, int sslPort, String grSimAddress, int grSimPort) {
        super(teamsColor, fieldSide, sslAddress, sslPort, grSimAddress, grSimPort);
        this.bayesBallBn = new BayesBallBn();
    }
    
    @Override
    public void thinkAboutPlayersRoles() {
        Team team = null;
        if (this.teamsColor == TeamsColor.BLUE) {team = this.blueTeam;}
        else if (this.teamsColor == TeamsColor.YELLOW) {team = this.yellowTeam;}
        
        for (Player p : team.getPlayers()) {
            this.bayesBallBn.setUp(this, p);
            System.out.println(this.bayesBallBn.playerQuantityCloseToBall());
            if (p.getId() == 5) {
                this.goalKeepers.addPlayer(p);
            } else if (p.getId() == 1) {
                this.bottomDefenders.addPlayer(p);
            } else if (p.getId() == 0) {
                this.bottomDefenders.addPlayer(p);
            } else if (p.getId() == 4) {
                this.bottomDefenders.addPlayer(p);
            } else if (p.getId() == 3) {
                this.bottomDefenders.addPlayer(p);
            } else if (p.getId() == 2) {
                this.ballFollowers.addPlayer(p);
            }
        }
    }
}
