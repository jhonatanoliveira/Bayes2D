/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jhonatanoliveira.bayes2d.impl.BasicTeam.roles;

import com.github.robocup_atan.atan.model.enums.Flag;
import com.jhonatanoliveira.bayes2d.core.Bayes2dControllerPlayer;
import com.jhonatanoliveira.bayes2d.impl.BasicTeam.BasicPlayerRole;

/**
 *
 * @author jhonatanoliveira
 */
public class BasicGoalKeeperPlayerRole extends BasicPlayerRole {

    @Override
    public void doWhenBeforeKickOff(Bayes2dControllerPlayer bayes2dPlayer) {
        bayes2dPlayer.getPlayer().move(-50, 0);
    }
    
    @Override
    public void doWhenPlayOn(Bayes2dControllerPlayer bayes2dPlayer) {
        if (bayes2dPlayer.getBallInfo() != null) {
            if (bayes2dPlayer.getBallInfo().getDistance() < 20) {
                System.out.println("Perto da Bola");
                bayes2dPlayer.getPlayer().turn(bayes2dPlayer.getBallInfo().getDirection());
                bayes2dPlayer.getPlayer().dash(100);
                bayes2dPlayer.getPlayer().catchBall(bayes2dPlayer.getBallInfo().getDirection());
                if (bayes2dPlayer.getBallInfo().getDistance() < 5) {
                    bayes2dPlayer.getPlayer().kick(100, 0);
                }
            } else {
                System.out.println("Longe da Bola");
                System.out.println(bayes2dPlayer.getFlagPenaltyOther().getFlag());
                if (bayes2dPlayer.getFlagPenaltyOther().getFlag() == Flag.CENTER) {
                    System.out.println("Vejo o centro do Gol");
                    if (bayes2dPlayer.getFlagPenaltyOther().getDistance() > 10) {
                        System.out.println("Ainda não no centro");
                        bayes2dPlayer.getPlayer().turn(bayes2dPlayer.getFlagPenaltyOther().getDirection());
                        bayes2dPlayer.getPlayer().dash(50);
                    } else {
                        System.out.println("Passei um pouco do centro");
                        bayes2dPlayer.getPlayer().turn(bayes2dPlayer.getFlagPenaltyOther().getDirection());
                        bayes2dPlayer.getPlayer().dash(-50);
                    }
                } else {
                    System.out.println("NAO vejo o centro do Gol");
                    bayes2dPlayer.getPlayer().turn(10);
                }
            }
        } else {
            System.out.println("Sim informações da Bola...");
            bayes2dPlayer.getPlayer().turn(180);
        }
    }
    
}
