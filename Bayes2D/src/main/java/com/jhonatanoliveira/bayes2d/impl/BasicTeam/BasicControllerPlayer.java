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
import com.jhonatanoliveira.bayes2d.impl.BasicTeam.roles.BasicGoalKeeperPlayerRole;

/**
 *
 * @author jhonatanoliveira
 */
public class BasicControllerPlayer extends Bayes2dControllerPlayer {
    
    private final BasicDefenderPlayerRole basicDefenderPlayerRole = new BasicDefenderPlayerRole();
    private final BasicGoalKeeperPlayerRole basicGoalKeeperPlayerRole = new BasicGoalKeeperPlayerRole();
    
    @Override
    public void decidePlayerRole() {
        switch (this.getPlayer().getNumber()) {
                case 1 :
                    this.setPlayerRole(this.basicGoalKeeperPlayerRole);
                    break;
                default :
                    this.setPlayerRole(this.basicDefenderPlayerRole);
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
