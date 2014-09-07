/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jhonatanoliveira.bayes2d.impl.BasicTeam.roles;

import com.jhonatanoliveira.bayes2d.core.Bayes2dControllerPlayer;
import com.jhonatanoliveira.bayes2d.impl.BasicTeam.BasicPlayerRole;

/**
 *
 * @author jhonatanoliveira
 */
public class BasicGoalKeeperPlayerRole extends BasicPlayerRole {

    @Override
    public void doWhenBeforeKickOff(Bayes2dControllerPlayer bayes2dPlayer) {
        bayes2dPlayer.getPlayer().move(0, -30);
    }
    
}
