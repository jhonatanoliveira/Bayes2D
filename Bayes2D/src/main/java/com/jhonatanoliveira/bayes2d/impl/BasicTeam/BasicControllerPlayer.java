/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jhonatanoliveira.bayes2d.impl.BasicTeam;

import com.jhonatanoliveira.bayes2d.impl.BasicTeam.roles.BasicDefenderPlayerRole;
import com.github.robocup_atan.atan.model.enums.PlayMode;
import com.jhonatanoliveira.bayes2d.core.Bayes2dControllerPlayer;
import com.jhonatanoliveira.bayes2d.core.Bayes2dGameSituations;
import com.jhonatanoliveira.bayes2d.core.Bayes2dPlayerRole;

/**
 *
 * @author jhonatanoliveira
 */
public class BasicControllerPlayer extends Bayes2dControllerPlayer {
    
    private BasicDefenderPlayerRole basicDefenderPlayerRole = new BasicDefenderPlayerRole();
//    private BasicGoalKeeperPlayerRole basicGoalKeeperPlayerRole = new BasicGoalKeeperPlayerRole();
    
    @Override
    public void decidePlayerRole() {
        switch (this.getPlayer().getNumber()) {
                case 1 :
                    this.getPlayer().move(-10, 0);
                    break;
                case 2 :
                    this.getPlayer().move(-10, 10);
                    break;
                case 3 :
                    this.getPlayer().move(-10, -10);
                    break;
                case 4 :
                    this.getPlayer().move(-20, 0);
                    break;
                case 5 :
                    this.getPlayer().move(-20, 10);
                    break;
                case 6 :
                    this.getPlayer().move(-20, -10);
                    break;
                case 7 :
                    this.getPlayer().move(-20, 20);
                    break;
                case 8 :
                    this.getPlayer().move(-20, -20);
                    break;
                case 9 :
                    this.getPlayer().move(-30, 0);
                    break;
                case 10 :
                    this.getPlayer().move(-40, 10);
                    break;
                case 11 :
                    this.getPlayer().move(-40, -10);
                    break;
                default :
                    throw new Error("number must be initialized before move");
            }
    }

    @Override
    public void decideGameSituation() {
//        if (this.getPlayMode() == PlayMode.PLAY_ON) {
//            this.setGameSituation(Bayes2dGameSituations.DEFENSE);
//        } else {
//            this.setGameSituation(Bayes2dGameSituations.DEFENSE);
//        }
    }

    @Override
    public void play() {
        PlayMode playMode = this.getPlayMode();
        if (playMode == PlayMode.PLAY_ON) {
            Bayes2dGameSituations gameSituations = this.getGameSituation();
            if (gameSituations == Bayes2dGameSituations.PREPARE_DEFENSE) {
                this.getPlayerRole().doWhenPrepareDefense(this);
            } else if (gameSituations == Bayes2dGameSituations.DEFENSE) {
                this.getPlayerRole().doWhenDefense(this);
            } else if (gameSituations == Bayes2dGameSituations.PREPARE_ATTACK) {
                this.getPlayerRole().doWhenPrepareAttack(this);
            } else if (gameSituations == Bayes2dGameSituations.ATTACK) {
                this.getPlayerRole().doWhenAttack(this);
            } else {
                this.getPlayerRole().doWhenPlayOn(this);
            }
        } else {
            if (playMode == PlayMode.BEFORE_KICK_OFF) {
                this.getPlayerRole().doWhenBeforeKickOff(this);
            }
        }
    }
    
}
