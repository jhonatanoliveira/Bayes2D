/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhonatanoliveira.bayesball.core;

import COM.hugin.HAPI.ExceptionHugin;
import com.jhonatanoliveira.bayesball.core.roles.PlayerRoleEnum;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jhonatanoliveira
 */
public class BayesBallWorld extends World{
    
    private BayesBallBn bayesBallBn;

    public BayesBallWorld() throws ExceptionHugin {
        this(TeamsColor.YELLOW, World.FIELD_RIGHT_SIDE, "224.5.23.2",10002,"127.0.0.1",20011);
    }

    public BayesBallWorld(TeamsColor teamsColor, int fieldSide, String sslAddress, int sslPort, String grSimAddress, int grSimPort) throws ExceptionHugin {
        super(teamsColor, fieldSide, sslAddress, sslPort, grSimAddress, grSimPort);
        this.bayesBallBn = new BayesBallBn("rede_bayesiana.net");
    }
    
    @Override
    public void thinkAboutPlayersRoles() {
        Team team = null;
        if (this.teamsColor == TeamsColor.BLUE) {team = this.blueTeam;}
        else if (this.teamsColor == TeamsColor.YELLOW) {team = this.yellowTeam;}
        
        PlayerRoleEnum playerRoleEnum;
        for (Player p : team.getPlayers()) {
            try {
                this.bayesBallBn.setUp(this, p);
                playerRoleEnum = this.bayesBallBn.decidePlayerRole();
                if (playerRoleEnum == PlayerRoleEnum.GoalKeeper) {
                    this.goalKeepers.addPlayer(p);
                } else if (playerRoleEnum == PlayerRoleEnum.Defender) {
                    this.defenders.addPlayer(p);
                } else if (playerRoleEnum == PlayerRoleEnum.BallFollower) {
                    this.ballFollowers.addPlayer(p);
                }
            } catch (ExceptionHugin ex) {
                Logger.getLogger(BayesBallWorld.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
